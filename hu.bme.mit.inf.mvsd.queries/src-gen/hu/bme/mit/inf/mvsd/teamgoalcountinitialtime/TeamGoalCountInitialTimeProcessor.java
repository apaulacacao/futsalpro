package hu.bme.mit.inf.mvsd.teamgoalcountinitialtime;

import hu.bme.mit.inf.mvsd.teamgoalcountinitialtime.TeamGoalCountInitialTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamGoalCountInitialTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamGoalCountInitialTimeProcessor implements IMatchProcessor<TeamGoalCountInitialTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pGoalCount the value of pattern parameter goalCount in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Integer goalCount);
  
  @Override
  public void process(final TeamGoalCountInitialTimeMatch match) {
    process(match.getTeam(), match.getGoalCount());  				
    
  }
}
