package hu.bme.mit.inf.mvsd.teamgoals;

import hu.bme.mit.inf.mvsd.teamgoals.TeamGoalsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamGoals pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamGoalsProcessor implements IMatchProcessor<TeamGoalsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pGoal the value of pattern parameter goal in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object goal);
  
  @Override
  public void process(final TeamGoalsMatch match) {
    process(match.getTeam(), match.getGoal());  				
    
  }
}
