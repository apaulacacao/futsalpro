package hu.bme.mit.inf.mvsd.teamgoalshalftime;

import hu.bme.mit.inf.mvsd.teamgoalshalftime.TeamGoalsHalfTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamGoalsHalfTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamGoalsHalfTimeProcessor implements IMatchProcessor<TeamGoalsHalfTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pGoal the value of pattern parameter goal in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object goal);
  
  @Override
  public void process(final TeamGoalsHalfTimeMatch match) {
    process(match.getTeam(), match.getGoal());  				
    
  }
}
