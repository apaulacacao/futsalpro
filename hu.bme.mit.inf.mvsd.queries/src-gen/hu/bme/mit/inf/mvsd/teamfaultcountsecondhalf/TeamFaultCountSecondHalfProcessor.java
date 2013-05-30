package hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf;

import hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf.TeamFaultCountSecondHalfMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamFaultCountSecondHalf pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamFaultCountSecondHalfProcessor implements IMatchProcessor<TeamFaultCountSecondHalfMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pFaultCount the value of pattern parameter faultCount in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Integer faultCount);
  
  @Override
  public void process(final TeamFaultCountSecondHalfMatch match) {
    process(match.getTeam(), match.getFaultCount());  				
    
  }
}
