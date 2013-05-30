package hu.bme.mit.inf.mvsd.insubsaftersubs;

import hu.bme.mit.inf.mvsd.insubsaftersubs.InSubsAfterSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.inSubsAfterSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class InSubsAfterSubsProcessor implements IMatchProcessor<InSubsAfterSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * @param pAfterSubs the value of pattern parameter afterSubs in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object substitution, final Object afterSubs);
  
  @Override
  public void process(final InSubsAfterSubsMatch match) {
    process(match.getPlayer(), match.getSubstitution(), match.getAfterSubs());  				
    
  }
}
