package hu.bme.mit.inf.mvsd.outsubsafterlastinsubs;

import hu.bme.mit.inf.mvsd.outsubsafterlastinsubs.OutSubsAfterLastInSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.outSubsAfterLastInSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class OutSubsAfterLastInSubsProcessor implements IMatchProcessor<OutSubsAfterLastInSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object substitution);
  
  @Override
  public void process(final OutSubsAfterLastInSubsMatch match) {
    process(match.getPlayer(), match.getSubstitution());  				
    
  }
}
