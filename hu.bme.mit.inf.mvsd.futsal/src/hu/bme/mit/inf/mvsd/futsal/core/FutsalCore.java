package hu.bme.mit.inf.mvsd.futsal.core;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Event;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl;
import hu.bme.mit.inf.mvsd.futsal.reportgeneration.HtmlGenerator;
import hu.bme.mit.inf.mvsd.futsal.reportgeneration.LatexGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.plaf.multi.MultiPanelUI;
import javax.xml.soap.SOAPException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.scr.TimerService;
import org.yakindu.scr.scoreboard.ScoreboardStatemachine;
import org.yakindu.scr.scoreboard.ScoreboardStatemachine.State;

public class FutsalCore implements FutsalServiceInterface {
	private Match match = null;
	private FutsalFactory factory;
	private Queue<Goal> goals = new LinkedList<Goal>();
	private Queue<Substitution> substitutions = new LinkedList<Substitution>();
	private Queue<Fault> faults = new LinkedList<Fault>();
	private TimeOut lastTimeout = null;
	List<UpdateListener> updateListeners = new ArrayList<UpdateListener>();

	private String htmlReport = "";
	private boolean htmlSent = false;
	private String htmlId;
	private String latexReport = "";
	private boolean latexSent = false;
	private String latexId;
	
	private ScoreboardStatemachine statemachine = null;

	private TimerTask timerTask;
	private Timer timer = new Timer();
	private ResourceSet resSet;

	@Override
	public Match initMatch() {
		FutsalPackage.eINSTANCE.eClass();
		factory = FutsalFactory.eINSTANCE;
		
		FutsalPackageImpl.init();
		match = factory.createMatch();
		match.setTeam1(factory.createTeam());
		match.setTeam2(factory.createTeam());
		match.getTeam1().setSubject(match);
		match.getTeam2().setSubject(match);
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("jzk", new XMIResourceFactoryImpl());
		
		resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI("match/jzk.jzk"));
		resource.getContents().add(match);
		
		statemachine = new ScoreboardStatemachine();
		statemachine.setTimerService(new TimerService());
		FutsalCallbackListener listener = new FutsalCallbackListener(this);
		statemachine.getSCICallback().getListeners().add(listener);
		statemachine.getSCICallback().setSCICallbackOperationCallback(listener);
		statemachine.enter();

		timerTask = new TimerTask() {
			@Override
			public void run() {
				statemachine.runCycle();
			}
		};

		timer.scheduleAtFixedRate(timerTask, 0, 100);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return match;
	}

	@Override
	public Match getMatch() {
		return match;
	}

	@Override
	public Player createPlayer() {
		return factory.createPlayer();
	}

	@Override
	public GoalKeeper createGoalkeeper() {
		return factory.createGoalKeeper();
	}

	@Override
	public Crew createCrew() {
		return factory.createCrew();
	}

	@Override
	public Referee createReferee() {
		return factory.createReferee();
	}

	@Override
	public Supervisor createSupervisor() {
		return factory.createSupervisor();
	}
	
	@Override
	public Pitch createPitch() {
		return factory.createPitch();
	};

	@Override
	public void addFieldPlayer(Team team, Player player) throws InvalidOperationException {
		team.getFieldPlayers().add(player);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			team.getFieldPlayers().remove(player);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void addSubstitutePlayer(Team team, Player player) throws InvalidOperationException {
		team.getSubtitutePlayers().add(player);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			team.getSubtitutePlayers().remove(player);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void setGoalkeeper(Team team, GoalKeeper goalkeeper) throws InvalidOperationException {
		GoalKeeper temp = team.getGoalKeeper();
		team.setGoalKeeper(goalkeeper);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			team.setGoalKeeper(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void addSubstituteGoalkeeper(Team team, GoalKeeper goalkeeper) throws InvalidOperationException {
		team.getSubtituteGoalKeepers().add(goalkeeper);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			team.getSubtituteGoalKeepers().remove(goalkeeper);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void addCrew(Team team, Crew crew) throws InvalidOperationException {
		team.getBench().add(crew);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			team.getBench().remove(crew);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void setReferee1(Referee referee) throws InvalidOperationException {
		Referee temp = match.getReferee1();
		match.setReferee1(referee);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			match.setReferee1(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void setReferee2(Referee referee) throws InvalidOperationException {
		Referee temp = match.getReferee2();
		match.setReferee2(referee);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			match.setReferee2(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void setReferee3(Referee referee) throws InvalidOperationException {
		Referee temp = match.getReferee3();
		match.setReferee3(referee);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			match.setReferee3(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public void setSupervisor(Supervisor supervisor) throws InvalidOperationException {
		Supervisor temp = match.getSupervisor();
		match.setSupervisor(supervisor);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			match.setSupervisor(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}
	
	@Override
	public void setPitch(Pitch pitch) throws InvalidOperationException {
		Pitch temp = match.getLocation();
		match.setLocation(pitch);
		try {
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			match.setLocation(temp);
			throw new InvalidOperationException(e.getMessage(), e);
		}
	}

	@Override
	public int getElapsedTime() {
		return statemachine.getSCIWatch().getTime();
	}
	
	@Override
	public int getTimeoutLeft() {
		return statemachine.getSCIWatch().getTimeout();
	}

	@Override
	public void setTime(int time) throws InvalidOperationException {
		if (time < 0 || time > 50 * 60)
			throw new InvalidOperationException("Az idõnek 50 percen belül kell lennie.");
		if (statemachine.isStateActive(State.main_region_Working_Watch_Stopped)) {
			statemachine.getSCIWatch().setTime(time);
			statemachine.runCycle();

			removeEventsAfterTime(time);
			updateYakinduVariables();
		} else
			throw new InvalidOperationException("Az órát le kell állítani átállítás elõtt.");
	}

	private void removeEventsAfterTime(int time) {
		if (match.getFirstEvent() != null) { // ha van esemény
			if (match.getFirstEvent().getTime() > time) { // ha minden eseményt
															// vissza kell vonni
				match.getEvents().clear();
				match.setFirstEvent(null);
				match.setLastEvent(null);
			} else { // különben az utolsó valamennyi visszavonása
				Event currentEvent = match.getLastEvent();
				while (currentEvent.getTime() > time) {
					currentEvent = currentEvent.getPrevious();
					match.getEvents().remove(currentEvent.getNext());
				}
				currentEvent.setNext(null);
				match.setLastEvent(currentEvent);
			}
		}
	}

	private void updateYakinduVariables() {
		Team team1 = match.getTeam1();
		Team team2 = match.getTeam2();
		int halftime = getHalftime();

		statemachine.getSCITeam1().setScore(QueryHelper.calculateScore(team1, false));
		statemachine.getSCITeam2().setScore(QueryHelper.calculateScore(team2, false));

		statemachine.getSCITeam1().setTimeOutsLeft(QueryHelper.calculateTimeoutsLeft(team1, halftime));
		statemachine.getSCITeam2().setTimeOutsLeft(QueryHelper.calculateTimeoutsLeft(team2, halftime));

		statemachine.getSCITeam1().setFaults(QueryHelper.calculateTeamFaultCount(team1, halftime));
		statemachine.getSCITeam2().setFaults(QueryHelper.calculateTeamFaultCount(team2, halftime));
		statemachine.runCycle();
	}

	@Override
	public boolean isTimeout() {
		return statemachine.isStateActive(State.main_region_Working_Watch_TimeOut);
	}

	@Override
	public int getRemainingTimeout(Team team) {
		int timeoutsLeft;
		if (team.equals(match.getTeam1())) {
			timeoutsLeft = statemachine.getSCITeam1().getTimeOutsLeft();
		} else
			timeoutsLeft = statemachine.getSCITeam2().getTimeOutsLeft();
		return timeoutsLeft;
	}

	@Override
	public int getHalftime() {
		int halftime;
		if (statemachine.isStateActive(State.main_region_Init))
			halftime = 0;
		else if (statemachine.isStateActive(State.main_region_Working_Match_FirstHalf))
			halftime = 1;
		else if (statemachine.isStateActive(State.main_region_Working_Match_SecondHalf))
			halftime = 2;
		else if (statemachine.isStateActive(State.main_region_Working_Match_FirstExtra))
			halftime = 3;
		else if (statemachine.isStateActive(State.main_region_Working_Match_SecondExtra))
			halftime = 4;
		else
			halftime = 5;
		return halftime;
	}

	@Override
	public int getHalftimeScore(Team team) {
		return QueryHelper.calculateScore(team, true);
	}

	@Override
	public int getScore(Team team) {
		int score;
		if (team.equals(match.getTeam1()))
			score = statemachine.getSCITeam1().getScore();
		else
			score = statemachine.getSCITeam2().getScore();
		return score;
	}

	@Override
	public int getFaultCount(Team team) {
		int faults;
		if (team.equals(match.getTeam1()))
			faults = statemachine.getSCITeam1().getFaults();
		else
			faults = statemachine.getSCITeam2().getFaults();
		return faults;
	}

	@Override
	public int getSubstitutionCount(Team team) {
		return QueryHelper.calculateTeamSubstitutions(team);
	}

	@Override
	public List<Player> getFieldPlayers(Team team) {
		return QueryHelper.getFieldPlayers(team);
	}

	@Override
	public Goal createGoal() {
		return factory.createGoal();
	}

	@Override
	public void addGoal(Goal goal) throws InvalidOperationException {
		checkEventTime(goal);
		try {
			addEventToModel(goal);
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			throw new InvalidOperationException(e.getMessage(), e);
		} finally {
			removeEventFromModel(goal);
		}
		goals.add(goal);

		if (goal.getScorerTeam().equals(match.getTeam1()))
			statemachine.getSCITeam1().raiseGoal();
		else
			statemachine.getSCITeam2().raiseGoal();
		statemachine.runCycle();
	}

	protected void addLastGoal() {
		addEventToModel(goals.poll());
	}

	@Override
	public Substitution createSubstitution() {
		return factory.createSubstitution();
	}

	@Override
	public void addSubstitution(Substitution substitution) throws InvalidOperationException {
		checkEventTime(substitution);
		try {
			List<Player> fieldPlayersBefore = QueryHelper.getFieldPlayers(substitution.getInstead().getTeam());
			addEventToModel(substitution);
			QueryHelper.validateIncQueryAll(match);
			List<Player> fieldPlayersAfter = QueryHelper.getFieldPlayers(substitution.getInstead().getTeam());
			if (fieldPlayersAfter.size() != 5)
				throw new InvalidOperationException("Ezek a játékosok nem cserélhetõk le.");
			boolean same = true;
			for (Player player : fieldPlayersAfter) {
				if (!fieldPlayersBefore.contains(player))
					same = false;
			}
			if (same)
				throw new InvalidOperationException("Ezek a játékosok nem cserélhetõk le.");
		} catch (ValidationException e) {
			throw new InvalidOperationException(e.getMessage(), e);
		} finally {
			removeEventFromModel(substitution);
		}
		substitutions.add(substitution);
		if (substitution.getSubstitute().getTeam().equals(match.getTeam1()))
			statemachine.getSCITeam1().raiseSubstitute();
		else
			statemachine.getSCITeam2().raiseSubstitute();
		statemachine.runCycle();
	}

	protected void addLastSubstitution() {
		addEventToModel(substitutions.poll());
	}

	@Override
	public Fault createFault() {
		return factory.createFault();
	}

	@Override
	public void addFault(Fault fault) throws InvalidOperationException {
		checkEventTime(fault);
		try {
			addEventToModel(fault);
			QueryHelper.validateIncQueryAll(match);
		} catch (ValidationException e) {
			throw new InvalidOperationException(e.getMessage(), e);
		} finally {
			removeEventFromModel(fault);
		}
		faults.add(fault);
		if (fault.getPlayer().getTeam().equals(match.getTeam1()))
			statemachine.getSCITeam1().raiseFault();
		else
			statemachine.getSCITeam2().raiseFault();
		statemachine.runCycle();
	}

	protected void addLastFault() {
		addEventToModel(faults.poll());
	}

	@Override
	public void requestTimeout(Team team) {
		TimeOut timeout = factory.createTimeOut();
		timeout.setTime(statemachine.getSCIWatch().getTime());
		timeout.setTeam(team);
		lastTimeout = timeout;
		if (team.equals(match.getTeam1()))
			statemachine.getSCITeam1().raiseTimeout();
		else
			statemachine.getSCITeam2().raiseTimeout();
		statemachine.runCycle();
	}

	protected void addLastTimeout() {
		addEventToModel(lastTimeout);
	}

	@Override
	public void undoLastEvent() {
		if (match.getLastEvent() == null)
			return;
		Event lastEvent = match.getLastEvent();
		Event preLastEvent = lastEvent.getPrevious();
		match.setLastEvent(preLastEvent);
		if (preLastEvent != null)
			preLastEvent.setNext(null);
		else
			match.setFirstEvent(null);
		match.getEvents().remove(lastEvent);
		updateYakinduVariables();
	}
	
	private void removeEventFromModel(Event event) {
		if (match.getFirstEvent().equals(event)) {
			if (match.getLastEvent().equals(event)) {
				match.setFirstEvent(null);
				match.setLastEvent(null);
			} else {
				match.setFirstEvent(event.getNext());
				event.getNext().setPrevious(null);
			}
		} else if (match.getLastEvent().equals(event)) {
			match.setLastEvent(event.getPrevious());
			event.getPrevious().setNext(null);
		} else {
			event.getPrevious().setNext(event.getNext());
			event.getNext().setPrevious(event.getPrevious());
		}
		match.getEvents().remove(event);
	}

	@Override
	public void addUpdateListener(UpdateListener listener) {
		updateListeners.add(listener);
	}

	@Override
	public void removeUpdateListener(UpdateListener listener) {
		updateListeners.remove(listener);
	}

	@Override
	public void finishMatch() {
		statemachine.getSCIWatch().raiseEnd();
		statemachine.runCycle();
	}

	@Override
	public boolean validateMatch() throws ValidationException {
		QueryHelper.validateIncQueryAll(match);
		return true;
	}

	@Override
	public String generateHtmlReport() {
		htmlReport = new HtmlGenerator().generateHtml(match).toString();
		return htmlReport;
	}

	@Override
	public String generateLatexReport() {
		latexReport = new LatexGenerator().generateLatex(match).toString();
		return latexReport;
	}

	@Override
	public String getHtmlReport() {
		if (htmlReport.equals(""))
			return generateHtmlReport();
		else
			return htmlReport;
	}

	@Override
	public String getLatexReport() {
		if (latexReport.equals(""))
			return generateLatexReport();
		else
			return latexReport;
	}

	@Override
	public boolean sendHtmlReport() throws IOException {
		htmlId = postRequest("http://10.40.200.94:8080/documentconverter/html", getHtmlReport(), null);
		htmlSent = true;
		return true;
	}

	@Override
	public boolean sendLatexReport() throws IOException  {
		latexId = postRequest("http://10.40.200.94:8080/documentconverter/tex", getLatexReport(), "UTF-8");
		latexSent = true;
		return true;
	}
	
	private String postRequest(String url, String content, String charset) throws ClientProtocolException, IOException
	{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		
		HttpEntity entity = new StringEntity(content, charset == null ? Charset.defaultCharset().displayName() : charset);
		
		post.setEntity(entity);
		
		ResponseHandler<String> handler = new BasicResponseHandler();

		return client.execute(post, handler);
	}
	
	private HttpResponse getRequest(String url) throws ClientProtocolException, IOException
	{
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		
		return client.execute(get);
	}

	private void checkEventTime(Event event) throws InvalidOperationException {
		if (event.getTime() < 0 || event.getTime() > getElapsedTime())
			throw new InvalidOperationException("Nem lehet jövõbeli eseményt rogzíteni.");
	}

	private void addEventToModel(Event event) {
		match.getEvents().add(event);
		addEventToList(event);
	}

	private void addEventToList(Event event) {
		// ha üres a lista
		if (match.getFirstEvent() == null) {
			match.setFirstEvent(event);
			match.setLastEvent(event);
		} else
		// ha a végére kell beszúrni
		if (match.getLastEvent().getTime() <= event.getTime()) {
			event.setPrevious(match.getLastEvent());
			match.getLastEvent().setNext(event);
			match.setLastEvent(event);
		} else
		// ha az elejére kell beszúrni
		if (match.getFirstEvent().getTime() > event.getTime()) {
			match.getFirstEvent().setPrevious(event);
			event.setNext(match.getFirstEvent());
			match.setFirstEvent(event);
		} else { // ha a közepére kell beszúrni
			Event currentEvent = match.getFirstEvent();
			while (currentEvent.getTime() <= event.getTime()) {
				currentEvent = currentEvent.getNext();
			}
			currentEvent.getPrevious().setNext(event);
			event.setPrevious(currentEvent.getPrevious());
			event.setNext(currentEvent);
			currentEvent.setPrevious(event);
		}
	}

	@Override
	public void startTime() {
		statemachine.getSCIWatch().raiseStart();
		statemachine.runCycle();
	}

	@Override
	public void stopTime() {
		statemachine.getSCIWatch().raiseStop();
		statemachine.runCycle();
	}

	@Override
	public List<Player> getAllPlayers(Team team) {
		if (team == null)
		{
			List<Player> allPlayers1 = QueryHelper.getAllPlayers(getMatch().getTeam1());
			List<Player> allPlayers2 = QueryHelper.getAllPlayers(getMatch().getTeam2());
			ArrayList<Player> ret = new ArrayList<Player>();
			ret.addAll(allPlayers1);
			ret.addAll(allPlayers2);
			return ret;
		}
		else
		{
			return QueryHelper.getAllPlayers(team);
		}
	}

	@Override
	public void saveHtmlReport(String path) throws IOException {
		PrintWriter writer = new PrintWriter(path);
		writer.print(getHtmlReport());
		writer.close();
	}

	@Override
	public void savePdfReport(String path) throws IOException {
		InputStream content = getRequest("http://10.40.200.94:8080/documentconverter/pdf/" + latexId).getEntity().getContent();
		FileOutputStream output = new FileOutputStream(path);
		
		int read = 0;
		byte[] buffer = new byte[1024];
		
		while((read = content.read(buffer)) != -1) {
			output.write(buffer, 0, read);
		}
		
		output.close();
	}

	@Override
	public String getHtmlUrl() {
		if (htmlSent)
			return "http://10.40.200.94:8080/documentconverter/html/" + htmlId;
		else
			return null;
	}

	@Override
	public String getPdfUrl() {
		if (latexSent)
			return "http://10.40.200.94:8080/documentconverter/pdf/" + latexId;
		else
			return null;
	}

}
