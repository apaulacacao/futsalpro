package hu.bme.mit.inf.mvsd.teamfaultcountfirsthalf;

import hu.bme.mit.inf.mvsd.teamfaultcountfirsthalf.TeamFaultCountFirstHalfMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamFaultCountFirstHalf pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamFaultCountFirstHalfProcessor implements IMatchProcessor<TeamFaultCountFirstHalfMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pFaultCount the value of pattern parameter faultCount in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Integer faultCount);
  
  @Override
  public void process(final TeamFaultCountFirstHalfMatch match) {
    process(match.getTeam(), match.getFaultCount());  				
    
  }
}
