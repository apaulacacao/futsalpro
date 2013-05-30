package hu.bme.mit.inf.mvsd.outsubsaftersubs;

import hu.bme.mit.inf.mvsd.outsubsaftersubs.OutSubsAfterSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.outSubsAfterSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class OutSubsAfterSubsProcessor implements IMatchProcessor<OutSubsAfterSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pBeforeSubs the value of pattern parameter beforeSubs in the currently processed match 
   * @param pAfterSubs the value of pattern parameter afterSubs in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object beforeSubs, final Object afterSubs);
  
  @Override
  public void process(final OutSubsAfterSubsMatch match) {
    process(match.getPlayer(), match.getBeforeSubs(), match.getAfterSubs());  				
    
  }
}
