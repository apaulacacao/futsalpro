package hu.bme.mit.inf.mvsd.lastinsubs;

import hu.bme.mit.inf.mvsd.lastinsubs.LastInSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.lastInSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class LastInSubsProcessor implements IMatchProcessor<LastInSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object substitution);
  
  @Override
  public void process(final LastInSubsMatch match) {
    process(match.getPlayer(), match.getSubstitution());  				
    
  }
}
