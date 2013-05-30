package hu.bme.mit.inf.mvsd.captainisinotherteam;

import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.CaptainIsInOtherTeam pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class CaptainIsInOtherTeamProcessor implements IMatchProcessor<CaptainIsInOtherTeamMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * 
   */
  public abstract void process(final Object team);
  
  @Override
  public void process(final CaptainIsInOtherTeamMatch match) {
    process(match.getTeam());  				
    
  }
}
