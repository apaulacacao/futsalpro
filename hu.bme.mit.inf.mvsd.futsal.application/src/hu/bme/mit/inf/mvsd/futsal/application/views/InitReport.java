package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.application.views.Futsal.Screens;
import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.futsal.core.ValidationException;
import hu.bme.mit.inf.mvsd.futsal.core.database.DatabaseManager;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

public class InitReport extends Composite {
	private DataBindingContext m_bindingContext;
	private Text txtChampionship;
	
	private ArrayList<CrewHolder> crewHolders = new ArrayList<CrewHolder>();
	private ArrayList<SubstituteHolder> substituteHolders1 = new ArrayList<SubstituteHolder>();
	private ArrayList<SubstituteHolder> substituteHolders2 = new ArrayList<SubstituteHolder>();
	private ArrayList<GoalkeeperHolder> goalkeeperHolders1 = new ArrayList<GoalkeeperHolder>();
	private ArrayList<GoalkeeperHolder> goalkeeperHolders2 = new ArrayList<GoalkeeperHolder>();
	private ArrayList<FieldPlayerHolder> fieldPlayerHolders1 = new ArrayList<FieldPlayerHolder>();
	private ArrayList<FieldPlayerHolder> fieldPlayerHolders2 = new ArrayList<FieldPlayerHolder>();
	private ArrayList<RefereeHolder> refereeHolders = new ArrayList<RefereeHolder>();
	private ArrayList<SupervisorHolder> supervisorHolders = new ArrayList<SupervisorHolder>();
	private ArrayList<PitchHolder> pitchHolders = new ArrayList<PitchHolder>();
	private ArrayList<TeamHolder> teamHolders = new ArrayList<TeamHolder>();
	private CaptainHolder captainHolder1;
	private CaptainHolder captainHolder2;
	
	
	public Match getMatch()
	{
		return mainWindow.getCore().getMatch();
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public InitReport(Composite parent, int style, Futsal mainWindow) {
		super(parent, SWT.NONE);

		this.mainWindow = mainWindow;

		initBusinessLayer();
		initDropDownLists();

		setLayout(new GridLayout(2, true));

		Group grpChampionship = new Group(this, SWT.NONE);
		GridLayout gl_grpChampionship = new GridLayout(4, false);
		grpChampionship.setLayout(gl_grpChampionship);
		GridData gd_grpChampionship = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_grpChampionship.heightHint = 138;
		grpChampionship.setLayoutData(gd_grpChampionship);
		grpChampionship.setText("Bajnoks\u00E1g");

		Label lblChampionship = new Label(grpChampionship, SWT.NONE);
		lblChampionship.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblChampionship.setText("Bajnoks\u00E1g:");

		txtChampionship = new Text(grpChampionship, SWT.BORDER);
		txtChampionship.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 3, 1));

		Label lblSeason = new Label(grpChampionship, SWT.NONE);
		lblSeason.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblSeason.setText("\u00C9vad:");

		cmbSeason = new Combo(grpChampionship, SWT.NONE);
		cmbSeason.setItems(new String[] { "2010/2011", "2011/2012",
				"2012/2013", "2013/2014", "2014/2015", "2015/2016",
				"2016/2017", "2017/2018", "2018/2019", "2019/2020" });
		cmbSeason.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Label lblCode = new Label(grpChampionship, SWT.NONE);
		lblCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblCode.setText("M\u00E9rk\u0151z\u00E9sk\u00F3d:");

		spnCode = new Spinner(grpChampionship, SWT.BORDER);
		spnCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		spnCode.setMaximum(999999);

		Label lblDate = new Label(grpChampionship, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblDate.setText("D\u00E1tum:");

		dtDate = new DateTime(grpChampionship, SWT.BORDER
				| SWT.DROP_DOWN);
		dtDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label lblTime = new Label(grpChampionship, SWT.NONE);
		lblTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblTime.setText("Id\u0151pont:");

		dtTime = new DateTime(grpChampionship, SWT.BORDER
				| SWT.DROP_DOWN | SWT.TIME);
		dtTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				0, 1));

		Label lblSection = new Label(grpChampionship, SWT.NONE);
		lblSection.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblSection.setText("Szak\u00E1g:");

		cmbSection = new Combo(grpChampionship, SWT.NONE);
		cmbSection.setItems(new String[] { "f\u00E9rfi futsal",
				"n\u0151i futsal" });
		cmbSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblRound = new Label(grpChampionship, SWT.NONE);
		lblRound.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblRound.setText("Fordul\u00F3:");

		spnRound = new Spinner(grpChampionship, SWT.BORDER);
		spnRound.setMinimum(1);
		spnRound.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		Label lblCategory = new Label(grpChampionship, SWT.NONE);
		lblCategory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblCategory.setText("T\u00EDpus:");

		cmbCategory = new Combo(grpChampionship, SWT.NONE);
		cmbCategory.setItems(new String[] { "bajnoki", "bar\u00E1ts\u00E1gos",
				"kupa" });
		cmbCategory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblAgeGroup = new Label(grpChampionship, SWT.NONE);
		lblAgeGroup.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblAgeGroup.setText("Koroszt\u00E1ly:");

		cmbAgeGroup = new Combo(grpChampionship, SWT.NONE);
		cmbAgeGroup.setItems(new String[] { "feln\u0151tt", "U-19", "U-17",
				"U-15", "U-13", "U-11" });
		cmbAgeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group grpLocationAndStaff = new Group(this, SWT.NONE);
		grpLocationAndStaff.setLayout(new GridLayout(2, false));
		GridData gd_grpLocationAndStaff = new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 1);
		gd_grpLocationAndStaff.heightHint = 149;
		grpLocationAndStaff.setLayoutData(gd_grpLocationAndStaff);
		grpLocationAndStaff.setText("Helysz\u00EDn \u00E9s szem\u00E9lyzet");

		Label lblLocation = new Label(grpLocationAndStaff, SWT.NONE);
		lblLocation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLocation.setText("Helysz\u00EDn:");

		pitchHolders.add(new PitchHolder(this, grpLocationAndStaff, pitchList));

		Label lblReferee = new Label(grpLocationAndStaff, SWT.NONE);
		lblReferee.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblReferee.setText("J\u00E1t\u00E9kvezet\u0151:");

		refereeHolders.add(new RefereeHolder(this, grpLocationAndStaff, 1, refereeList));

		Label lblAssistants = new Label(grpLocationAndStaff, SWT.NONE);
		lblAssistants.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblAssistants.setText("Asszisztensek:");

		refereeHolders.add(new RefereeHolder(this, grpLocationAndStaff, 2, refereeList));
		
		new Label(grpLocationAndStaff, SWT.NONE);

		refereeHolders.add(new RefereeHolder(this, grpLocationAndStaff, 3, refereeList));

		Label lblSupervisor = new Label(grpLocationAndStaff, SWT.NONE);
		lblSupervisor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblSupervisor.setText("Fel\u00FCgyel\u0151:");

		supervisorHolders.add(new SupervisorHolder(this, grpLocationAndStaff, supervisorList));

		grpTeams = new Group(this, SWT.NONE);
		grpTeams.setLayout(new GridLayout(1, false));
		grpTeams.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 2, 1));
		grpTeams.setText("Csapatok");

		scrolledComposite = new ScrolledComposite(grpTeams,
				SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		compositeTeams = new Composite(scrolledComposite, SWT.NONE);
		compositeTeams.setLayout(new GridLayout(2, true));

		teamHolders.add(new TeamHolder(this, compositeTeams, getTeam1(), 1, teamList));
		teamHolders.add(new TeamHolder(this, compositeTeams, getTeam2(), 2, teamList));

		Group grpFieldPlayers1 = new Group(compositeTeams, SWT.NONE);
		grpFieldPlayers1.setLayout(new GridLayout(1, false));
		grpFieldPlayers1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpFieldPlayers1.setSize(338, 82);
		grpFieldPlayers1.setText("Kezd\u0151j\u00E1t\u00E9kosok");

		for (int i = 0; i < 4; ++i)
		{
			fieldPlayerHolders1.add(new FieldPlayerHolder(this, grpFieldPlayers1, getTeam1(), team1PlayerList, team1GoalkeeperList));
		}

		Group grpFieldPlayers2 = new Group(compositeTeams, SWT.NONE);
		grpFieldPlayers2.setLayout(new GridLayout(1, false));
		grpFieldPlayers2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpFieldPlayers2.setSize(338, 82);
		grpFieldPlayers2.setText("Kezd\u0151j\u00E1t\u00E9kosok");

		for (int i = 0; i < 4; ++i)
		{
			fieldPlayerHolders2.add(new FieldPlayerHolder(this, grpFieldPlayers2, getTeam2(), team2PlayerList, team2GoalkeeperList));
		}

		Group grpGoalkeeper1 = new Group(compositeTeams, SWT.NONE);
		grpGoalkeeper1.setLayout(new GridLayout(1, false));
		GridData gd_grpGoalkeeper1 = new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1);
		gd_grpGoalkeeper1.heightHint = 34;
		grpGoalkeeper1.setLayoutData(gd_grpGoalkeeper1);
		grpGoalkeeper1.setSize(338, 62);
		grpGoalkeeper1.setText("Kapus");

		goalkeeperHolders1.add(new GoalkeeperHolder(this, grpGoalkeeper1, getTeam1(), team1GoalkeeperList));

		Group grpGoalkeeper2 = new Group(compositeTeams, SWT.NONE);
		grpGoalkeeper2.setLayout(new GridLayout(1, false));
		GridData gd_grpGoalkeeper2 = new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1);
		gd_grpGoalkeeper2.heightHint = 34;
		grpGoalkeeper2.setLayoutData(gd_grpGoalkeeper2);
		grpGoalkeeper2.setSize(338, 62);
		grpGoalkeeper2.setText("Kapus");

		goalkeeperHolders2.add(new GoalkeeperHolder(this, grpGoalkeeper2, getTeam2(), team2GoalkeeperList));

		grpSubstitutes1 = new Group(compositeTeams, SWT.NONE);
		grpSubstitutes1.setLayout(new GridLayout(2, false));
		grpSubstitutes1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1));
		grpSubstitutes1.setSize(70, 82);
		grpSubstitutes1.setText("Csere");
		
		btnTeam1NewSubstitute = new Button(grpSubstitutes1, SWT.NONE);
		btnTeam1NewSubstitute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SubstituteHolder substituteHolder = new SubstituteHolder(InitReport.this, scrolledComposite, compositeTeams, grpSubstitutes1, btnTeam1NewSubstitute, substituteHolders1, getTeam1(), team1PlayerList, team1GoalkeeperList);
				substituteHolder.addListener(captainHolder1);
				substituteHolders1.add(substituteHolder);
			}
		});
		btnTeam1NewSubstitute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		btnTeam1NewSubstitute.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));

		grpSubstitutes2 = new Group(compositeTeams, SWT.NONE);
		grpSubstitutes2.setLayout(new GridLayout(2, false));
		grpSubstitutes2.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1));
		grpSubstitutes2.setSize(70, 82);
		grpSubstitutes2.setText("Csere");
		
		btnTeam2NewSubstitute = new Button(grpSubstitutes2, SWT.NONE);
		btnTeam2NewSubstitute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SubstituteHolder substituteHolder = new SubstituteHolder(InitReport.this, scrolledComposite, compositeTeams, grpSubstitutes2, btnTeam2NewSubstitute, substituteHolders2, getTeam2(), team2PlayerList, team2GoalkeeperList);
				substituteHolder.addListener(captainHolder2);
				substituteHolders2.add(substituteHolder);
			}
		});
		btnTeam2NewSubstitute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		btnTeam2NewSubstitute.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));

		Group grpCaptain1 = new Group(compositeTeams, SWT.NONE);
		grpCaptain1.setLayout(new GridLayout(1, false));
		GridData gd_grpCaptain1 = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_grpCaptain1.heightHint = 41;
		grpCaptain1.setLayoutData(gd_grpCaptain1);
		grpCaptain1.setText("Csapatkapit\u00E1ny");

		captainHolder1 = new CaptainHolder(this, grpCaptain1, getTeam1(), fieldPlayerHolders1, goalkeeperHolders1, substituteHolders1);

		Group grpCaptain2 = new Group(compositeTeams, SWT.NONE);
		grpCaptain2.setLayout(new GridLayout(1, false));
		GridData gd_grpCaptain2 = new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1);
		gd_grpCaptain2.heightHint = 41;
		grpCaptain2.setLayoutData(gd_grpCaptain2);
		grpCaptain2.setText("Csapatkapit\u00E1ny");

		captainHolder2 = new CaptainHolder(this, grpCaptain2, getTeam2(), fieldPlayerHolders2, goalkeeperHolders2, substituteHolders2);

		grpCrew1 = new Group(compositeTeams, SWT.NONE);
		grpCrew1.setLayout(new GridLayout(1, false));
		grpCrew1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				true, 1, 1));
		grpCrew1.setText("Kispad");
		
		btnTeam1NewCrew = new Button(grpCrew1, SWT.NONE);
		btnTeam1NewCrew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				crewHolders.add(new CrewHolder(InitReport.this, scrolledComposite, compositeTeams, grpCrew1, btnTeam1NewCrew, crewHolders, getTeam1(), team1CrewList));
			}
		});
		btnTeam1NewCrew.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		btnTeam1NewCrew.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));

		grpCrew2 = new Group(compositeTeams, SWT.NONE);
		grpCrew2.setLayout(new GridLayout(2, false));
		grpCrew2.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				true, 1, 1));
		grpCrew2.setText("Kispad");
		
		btnTeam2NewCrew = new Button(grpCrew2, SWT.NONE);
		btnTeam2NewCrew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				crewHolders.add(new CrewHolder(InitReport.this, scrolledComposite, compositeTeams, grpCrew2, btnTeam2NewCrew, crewHolders, getTeam2(), team2CrewList));
			}
		});
		btnTeam2NewCrew.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		btnTeam2NewCrew.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		
		scrolledComposite.setContent(compositeTeams);
		scrolledComposite.setMinSize(compositeTeams.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		Button btnStart = new Button(this, SWT.CENTER);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				beginMatch();
			}
		});
		btnStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		btnStart.setText("Ind\u00EDt\u00E1s");
		
		m_bindingContext = initDataBindings();
		setMatchDefaults();
	}
	
	private void setMatchDefaults()
	{
		txtChampionship.setText("Barátságos mérkõzés");
		getMatch().setDate(new Date());
		getMatch().setCode(0);
		getMatch().setRound(1);
		cmbSeason.select(2);
		cmbSection.select(0);
		cmbCategory.select(1);
		cmbAgeGroup.select(0);
	}

	public FutsalServiceInterface getCore() {
		return mainWindow.getCore();
	}
	
	public DatabaseManager getDb()	{
		return mainWindow.getDb();
	}

	private void initBusinessLayer() {
		this.mainWindow.getCore().initMatch();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private Futsal mainWindow;
	private Combo cmbSeason;
	private Spinner spnCode;
	private DateTime dtDate;
	private DateTime dtTime;
	private Combo cmbSection;
	private Spinner spnRound;
	private Combo cmbCategory;
	private Combo cmbAgeGroup;
	private Button btnTeam1NewCrew;
	private Group grpCrew1;
	private Group grpTeams;
	private Composite compositeTeams;
	private ScrolledComposite scrolledComposite;
	
	private Team getTeam2() {
		return getMatch().getTeam2();
	}

	private Team getTeam1() {
		return getMatch().getTeam1();
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtChampionshipObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtChampionship);
		IObservableValue matchchanmpionshipMainWindowgetCoreObserveValue = PojoProperties.value("match.chanmpionship").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextTxtChampionshipObserveWidget, matchchanmpionshipMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeTextCmbSeasonObserveWidget = WidgetProperties.text().observe(cmbSeason);
		IObservableValue matchseasonMainWindowgetCoreObserveValue = PojoProperties.value("match.season").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextCmbSeasonObserveWidget, matchseasonMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnCodeObserveWidget = WidgetProperties.selection().observe(spnCode);
		IObservableValue matchcodeMainWindowgetCoreObserveValue = PojoProperties.value("match.code").observe(mainWindow.getCore());
		bindingContext.bindValue(observeSelectionSpnCodeObserveWidget, matchcodeMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeSelectionDtDateObserveWidget = WidgetProperties.selection().observe(dtDate);
		IObservableValue matchdatedateMainWindowgetCoreObserveValue = PojoProperties.value("match.date.date").observe(mainWindow.getCore());
		bindingContext.bindValue(observeSelectionDtDateObserveWidget, matchdatedateMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeSelectionDtTimeObserveWidget = WidgetProperties.selection().observe(dtTime);
		IObservableValue matchdatetimeMainWindowgetCoreObserveValue = PojoProperties.value("match.date.time").observe(mainWindow.getCore());
		bindingContext.bindValue(observeSelectionDtTimeObserveWidget, matchdatetimeMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeTextCmbSectionObserveWidget = WidgetProperties.text().observe(cmbSection);
		IObservableValue matchsectionMainWindowgetCoreObserveValue = PojoProperties.value("match.section").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextCmbSectionObserveWidget, matchsectionMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnRoundObserveWidget = WidgetProperties.selection().observe(spnRound);
		IObservableValue matchroundMainWindowgetCoreObserveValue = PojoProperties.value("match.round").observe(mainWindow.getCore());
		bindingContext.bindValue(observeSelectionSpnRoundObserveWidget, matchroundMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeTextCmbCategoryObserveWidget = WidgetProperties.text().observe(cmbCategory);
		IObservableValue matchcategoryMainWindowgetCoreObserveValue = PojoProperties.value("match.category").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextCmbCategoryObserveWidget, matchcategoryMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeTextCmbAgeGroupObserveWidget = WidgetProperties.text().observe(cmbAgeGroup);
		IObservableValue matchageGroupMainWindowgetCoreObserveValue = PojoProperties.value("match.ageGroup").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextCmbAgeGroupObserveWidget, matchageGroupMainWindowgetCoreObserveValue, null, null);
		//
		return bindingContext;
	}
	
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> team1CrewList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> team2CrewList;
	
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> team1PlayerList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> team2PlayerList;
	
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> team1GoalkeeperList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> team2GoalkeeperList;
	
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Team> teamList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Referee> refereeList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor> supervisorList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch> pitchList;
	
	private void initDropDownLists()
	{
		team1CrewList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.Crew>());
		team2CrewList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.Crew>());
		
		team1PlayerList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.Player>());
		team2PlayerList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.Player>());
		
		team1GoalkeeperList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>());
		team2GoalkeeperList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>(new ArrayList<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>());
		
		teamList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Team>(getDb().getTeams());
		refereeList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Referee>(getDb().getReferees());
		supervisorList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor>(getDb().getSupervisors());
		pitchList = new DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch>(getDb().getPitches());
	}
	
	void fillDropDownLists(int teamIndex, int teamId)
	{
		switch (teamIndex) {
		case 1:
			fillDropDownLists1(teamId);
			break;
		case 2:
			fillDropDownLists2(teamId);
			break;
		default:
			break;
		}
	}
	
	private void fillDropDownLists1(int teamId) {
		team1PlayerList.reinitialize(getDb().getPlayers(teamId));
		team1GoalkeeperList.reinitialize(getDb().getGoalkeepers(teamId));
		team1CrewList.reinitialize(getDb().getCrew(teamId));
	}
	
	private void fillDropDownLists2(int teamId) {
		team2PlayerList.reinitialize(getDb().getPlayers(teamId));
		team2GoalkeeperList.reinitialize(getDb().getGoalkeepers(teamId));
		team2CrewList.reinitialize(getDb().getCrew(teamId));
	}
	
	private void beginMatch() {
		if (validateInputs())
		{
			try {
				if (getCore().validateMatch())
				{
					InitReport.this.mainWindow.setScreen(Screens.Scoreboard);
				}
			} catch (ValidationException e) {
				e.printStackTrace();
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("A jegyzõkönyv hibás!");
				mb.open();
			}
		}
	}

	private boolean validateInputs() {
		for (PitchHolder pitchHolder : pitchHolders) {
			if (!pitchHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("Nincs megadva a helyszín.");
				mb.open();
				return false;
			}
		}
		for (TeamHolder teamHolder : teamHolders) {
			if (!teamHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("Az egyik csapat nincs beállítva.");
				mb.open();
				return false;
			}
		}
		for (FieldPlayerHolder fieldPlayerHolder : fieldPlayerHolders1) {
			if (!fieldPlayerHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("A \"" + getTeam1().getName() + "\" csapat egyik játékosa nincs beállítva.");
				mb.open();
				return false;
			}
		}
		for (FieldPlayerHolder fieldPlayerHolder : fieldPlayerHolders2) {
			if (!fieldPlayerHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("A \"" + getTeam2().getName() + "\" csapat egyik játékosa nincs beállítva.");
				mb.open();
				return false;
			}
		}
		for (GoalkeeperHolder goalkeeperHolder : goalkeeperHolders1) {
			if (!goalkeeperHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("A \"" + getTeam1().getName() + "\" csapat kapusa nincs beállítva.");
				mb.open();
				return false;
			}
		}
		for (GoalkeeperHolder goalkeeperHolder : goalkeeperHolders2) {
			if (!goalkeeperHolder.isValid())
			{
				MessageBox mb = new MessageBox(getShell());
				mb.setText("Hiba");
				mb.setMessage("A \"" + getTeam2().getName() + "\" csapat kapusa nincs beállítva.");
				mb.open();
				return false;
			}
		}
		if (!captainHolder1.isValid())
		{
			MessageBox mb = new MessageBox(getShell());
			mb.setText("Hiba");
			mb.setMessage("A \"" + getTeam1().getName() + "\" csapat kapitánya nincs beállítva.");
			mb.open();
			return false;
		}
		if (!captainHolder2.isValid())
		{
			MessageBox mb = new MessageBox(getShell());
			mb.setText("Hiba");
			mb.setMessage("A \"" + getTeam2().getName() + "\" csapat kapitánya nincs beállítva.");
			mb.open();
			return false;
		}
		ArrayList<SubstituteHolder> substituteHolderList = new ArrayList<SubstituteHolder>();
		substituteHolderList.addAll(substituteHolders1);
		substituteHolderList.addAll(substituteHolders2);
		for (SubstituteHolder substituteHolder : substituteHolderList) {
			if (!substituteHolder.isValid())
			{
				substituteHolder.dispose();
			}
		}
		ArrayList<CrewHolder> crewHolderList = new ArrayList<CrewHolder>();
		crewHolderList.addAll(crewHolders);
		for (CrewHolder crewHolder : crewHolderList) {
			if (!crewHolder.isValid())
			{
				crewHolder.dispose();
			}
		}
		return true;
	}

	private Button btnTeam2NewCrew;
	private Group grpCrew2;
	private Button btnTeam1NewSubstitute;
	private Group grpSubstitutes1;
	private Group grpSubstitutes2;
	private Button btnTeam2NewSubstitute;
	
}
