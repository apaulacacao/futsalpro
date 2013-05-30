package hu.bme.mit.inf.mvsd.insubsafterlastoutsubs;

import hu.bme.mit.inf.mvsd.insubsafterlastoutsubs.InSubsAfterLastOutSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.inSubsAfterLastOutSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class InSubsAfterLastOutSubsProcessor implements IMatchProcessor<InSubsAfterLastOutSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object substitution);
  
  @Override
  public void process(final InSubsAfterLastOutSubsMatch match) {
    process(match.getPlayer(), match.getSubstitution());  				
    
  }
}
