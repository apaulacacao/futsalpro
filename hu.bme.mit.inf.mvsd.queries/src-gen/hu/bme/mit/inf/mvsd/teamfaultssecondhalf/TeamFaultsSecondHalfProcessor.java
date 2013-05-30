package hu.bme.mit.inf.mvsd.teamfaultssecondhalf;

import hu.bme.mit.inf.mvsd.teamfaultssecondhalf.TeamFaultsSecondHalfMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamFaultsSecondHalf pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamFaultsSecondHalfProcessor implements IMatchProcessor<TeamFaultsSecondHalfMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pFault the value of pattern parameter fault in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object fault);
  
  @Override
  public void process(final TeamFaultsSecondHalfMatch match) {
    process(match.getTeam(), match.getFault());  				
    
  }
}
