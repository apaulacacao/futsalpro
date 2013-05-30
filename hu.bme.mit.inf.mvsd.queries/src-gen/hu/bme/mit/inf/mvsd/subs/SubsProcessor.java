package hu.bme.mit.inf.mvsd.subs;

import hu.bme.mit.inf.mvsd.subs.SubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.subs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class SubsProcessor implements IMatchProcessor<SubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pSubs the value of pattern parameter subs in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object subs);
  
  @Override
  public void process(final SubsMatch match) {
    process(match.getPlayer(), match.getSubs());  				
    
  }
}
