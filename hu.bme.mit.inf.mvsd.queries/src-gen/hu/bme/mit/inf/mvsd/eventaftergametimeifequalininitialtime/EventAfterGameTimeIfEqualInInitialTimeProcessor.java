package hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime;

import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.EventAfterGameTimeIfEqualInInitialTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EventAfterGameTimeIfEqualInInitialTimeProcessor implements IMatchProcessor<EventAfterGameTimeIfEqualInInitialTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEvent the value of pattern parameter event in the currently processed match 
   * 
   */
  public abstract void process(final Object event);
  
  @Override
  public void process(final EventAfterGameTimeIfEqualInInitialTimeMatch match) {
    process(match.getEvent());  				
    
  }
}
