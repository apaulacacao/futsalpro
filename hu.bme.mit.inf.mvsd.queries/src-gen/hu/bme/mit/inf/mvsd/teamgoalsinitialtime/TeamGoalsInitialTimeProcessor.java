package hu.bme.mit.inf.mvsd.teamgoalsinitialtime;

import hu.bme.mit.inf.mvsd.teamgoalsinitialtime.TeamGoalsInitialTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamGoalsInitialTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamGoalsInitialTimeProcessor implements IMatchProcessor<TeamGoalsInitialTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pGoal the value of pattern parameter goal in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object goal);
  
  @Override
  public void process(final TeamGoalsInitialTimeMatch match) {
    process(match.getTeam(), match.getGoal());  				
    
  }
}
