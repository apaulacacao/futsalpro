package hu.bme.mit.inf.mvsd.inoutinsubs;

import hu.bme.mit.inf.mvsd.inoutinsubs.InOutInSubsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.inOutInSubs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class InOutInSubsProcessor implements IMatchProcessor<InOutInSubsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pIn1 the value of pattern parameter in1 in the currently processed match 
   * @param pOut the value of pattern parameter out in the currently processed match 
   * @param pIn2 the value of pattern parameter in2 in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object in1, final Object out, final Object in2);
  
  @Override
  public void process(final InOutInSubsMatch match) {
    process(match.getPlayer(), match.getIn1(), match.getOut(), match.getIn2());  				
    
  }
}
