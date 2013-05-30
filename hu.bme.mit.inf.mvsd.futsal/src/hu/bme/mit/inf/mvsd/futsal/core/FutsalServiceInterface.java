package hu.bme.mit.inf.mvsd.futsal.core;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.xml.soap.SOAPException;

import org.apache.http.client.ClientProtocolException;


import hu.bme.mit.inf.mvsd.domain.generated.futsal.*;

public interface FutsalServiceInterface {
	
	/**
	 * Creates a match and two contained teams
	 * @return The created match
	 */
	Match initMatch();
	
	/**
	 * @return The previously initialized match or null
	 */
	Match getMatch();
	
	/**
	 * Creates a player
	 * @return The created player
	 */
	Player createPlayer();
	GoalKeeper createGoalkeeper();
	Crew createCrew();
	
	Referee createReferee();
	Supervisor createSupervisor();
	
	Pitch createPitch();
	
	//////////////////////////////////////////////////////////////////////
	
	void addFieldPlayer(Team team, Player player) throws InvalidOperationException;
	void addSubstitutePlayer(Team team, Player player) throws InvalidOperationException;
	void setGoalkeeper(Team team, GoalKeeper goalkeeper) throws InvalidOperationException;
	void addSubstituteGoalkeeper(Team team, GoalKeeper goalkeeper) throws InvalidOperationException;
	void addCrew(Team team, Crew crew) throws InvalidOperationException;
	
	void setReferee1(Referee referee) throws InvalidOperationException;
	void setReferee2(Referee referee) throws InvalidOperationException;
	void setReferee3(Referee referee) throws InvalidOperationException;
	void setSupervisor(Supervisor supervisor) throws InvalidOperationException;
	
	void setPitch(Pitch pitch) throws InvalidOperationException;
	
	/*
	 * TODO: getPitches
	 * TODO: getReferees
	 * TODO: getSupervisors
	 * TODO: getTeams
	 * TODO: getPlayers(Team team)
	 * TODO: getGoalkeeper(Team team)
	 * TODO: getCrew(Team team)
	 */
	
	
	////////////////////////////////////Yakindus dolgok///////////////////

	void startTime();
	void stopTime();
	
	int getElapsedTime();
	void setTime(int seconds) throws InvalidOperationException;

	boolean isTimeout();
	int getTimeoutLeft();
	int getRemainingTimeout(Team team);
	
	int getHalftime();
	int getHalftimeScore(Team team);
	int getScore(Team team);
	
	int getFaultCount(Team team);
	int getSubstitutionCount(Team team);
	
	List<Player> getFieldPlayers(Team team);
	
	////////////////////////////////események/////////////////////////////
	
	Goal createGoal();
	void addGoal(Goal goal) throws InvalidOperationException; // hozzáadás meccshez(+láncolt lista) + yakindu frissítés
	
	Substitution createSubstitution();
	void addSubstitution(Substitution substitution) throws InvalidOperationException;
	
	Fault createFault();
	void addFault(Fault fault) throws InvalidOperationException;
	
	void requestTimeout(Team team); // Ha szabad, és le is menti
	
	void undoLastEvent(); // láncolt lista+törlés
	
	// általában update + yakindu állítgatás

	//////////////////////////////////////////////////////////////////////
	
	void addUpdateListener(UpdateListener listener);
	void removeUpdateListener(UpdateListener listener);
	
	//////////////////////////////////////////////////////////////////////
	
	void finishMatch();
	
	boolean validateMatch() throws ValidationException;
	String generateHtmlReport();
	String generateLatexReport();
	
	String getHtmlReport();
	String getLatexReport();
	
	boolean sendHtmlReport() throws IOException;
	boolean sendLatexReport() throws IOException;
	
	String getHtmlUrl();
	String getPdfUrl();

	/**
	 * Return all players of team including field players, goalkeepers and substitudes.
	 * If team is null, return the players of both teams.
	 * @param team
	 * @return
	 */
	List<Player> getAllPlayers(Team team);

	void saveHtmlReport(String path) throws IOException;
	void savePdfReport(String path) throws IOException;
}
