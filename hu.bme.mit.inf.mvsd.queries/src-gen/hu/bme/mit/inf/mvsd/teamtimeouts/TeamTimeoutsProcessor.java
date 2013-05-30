package hu.bme.mit.inf.mvsd.teamtimeouts;

import hu.bme.mit.inf.mvsd.teamtimeouts.TeamTimeoutsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamTimeouts pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamTimeoutsProcessor implements IMatchProcessor<TeamTimeoutsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pTimeout the value of pattern parameter timeout in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object timeout);
  
  @Override
  public void process(final TeamTimeoutsMatch match) {
    process(match.getTeam(), match.getTimeout());  				
    
  }
}
