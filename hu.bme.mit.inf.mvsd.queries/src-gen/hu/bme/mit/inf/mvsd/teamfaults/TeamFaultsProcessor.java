package hu.bme.mit.inf.mvsd.teamfaults;

import hu.bme.mit.inf.mvsd.teamfaults.TeamFaultsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamFaults pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamFaultsProcessor implements IMatchProcessor<TeamFaultsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pFault the value of pattern parameter fault in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object fault);
  
  @Override
  public void process(final TeamFaultsMatch match) {
    process(match.getTeam(), match.getFault());  				
    
  }
}
