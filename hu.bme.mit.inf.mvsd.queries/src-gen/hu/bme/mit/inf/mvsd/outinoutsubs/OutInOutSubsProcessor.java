package hu.bme.mit.inf.mvsd.outinoutsubs;

import hu.bme.mit.inf.mvsd.outinoutsubs.OutInOutSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.outInOutSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class OutInOutSubsProcessor implements IMatchProcessor<OutInOutSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pOut1 the value of pattern parameter out1 in the currently processed match 
   * @param pIn the value of pattern parameter in in the currently processed match 
   * @param pOut2 the value of pattern parameter out2 in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object out1, final Object in, final Object out2);
  
  @Override
  public void process(final OutInOutSubsMatch match) {
    process(match.getPlayer(), match.getOut1(), match.getIn(), match.getOut2());  				
    
  }
}
