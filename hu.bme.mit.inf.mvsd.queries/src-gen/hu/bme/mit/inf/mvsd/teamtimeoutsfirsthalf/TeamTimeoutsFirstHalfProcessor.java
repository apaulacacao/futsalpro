package hu.bme.mit.inf.mvsd.teamtimeoutsfirsthalf;

import hu.bme.mit.inf.mvsd.teamtimeoutsfirsthalf.TeamTimeoutsFirstHalfMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamTimeoutsFirstHalf pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamTimeoutsFirstHalfProcessor implements IMatchProcessor<TeamTimeoutsFirstHalfMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pTimeout the value of pattern parameter timeout in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object timeout);
  
  @Override
  public void process(final TeamTimeoutsFirstHalfMatch match) {
    process(match.getTeam(), match.getTimeout());  				
    
  }
}
