package hu.bme.mit.inf.mvsd.lastoutsubs;

import hu.bme.mit.inf.mvsd.lastoutsubs.LastOutSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.lastOutSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class LastOutSubsProcessor implements IMatchProcessor<LastOutSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object substitution);
  
  @Override
  public void process(final LastOutSubsMatch match) {
    process(match.getPlayer(), match.getSubstitution());  				
    
  }
}
