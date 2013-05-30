package hu.bme.mit.inf.mvsd.decreasingeventtime;

import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.DecreasingEventTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class DecreasingEventTimeProcessor implements IMatchProcessor<DecreasingEventTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEvent the value of pattern parameter event in the currently processed match 
   * 
   */
  public abstract void process(final Object event);
  
  @Override
  public void process(final DecreasingEventTimeMatch match) {
    process(match.getEvent());  				
    
  }
}
