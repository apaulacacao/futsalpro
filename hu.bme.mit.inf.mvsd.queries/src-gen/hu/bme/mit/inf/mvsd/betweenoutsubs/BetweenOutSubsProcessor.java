package hu.bme.mit.inf.mvsd.betweenoutsubs;

import hu.bme.mit.inf.mvsd.betweenoutsubs.BetweenOutSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.betweenOutSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class BetweenOutSubsProcessor implements IMatchProcessor<BetweenOutSubsMatch> {
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
  public void process(final BetweenOutSubsMatch match) {
    process(match.getPlayer(), match.getBefore(), match.getMid(), match.getAfter());  				
    
  }
}
