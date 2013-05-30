package hu.bme.mit.inf.mvsd.betweeninsubs;

import hu.bme.mit.inf.mvsd.betweeninsubs.BetweenInSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.betweenInSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class BetweenInSubsProcessor implements IMatchProcessor<BetweenInSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pBefore the value of pattern parameter before in the currently processed match 
   * @param pMid the value of pattern parameter mid in the currently processed match 
   * @param pAfter the value of pattern parameter after in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object before, final Object mid, final Object after);
  
  @Override
  public void process(final BetweenInSubsMatch match) {
    process(match.getPlayer(), match.getBefore(), match.getMid(), match.getAfter());  				
    
  }
}
