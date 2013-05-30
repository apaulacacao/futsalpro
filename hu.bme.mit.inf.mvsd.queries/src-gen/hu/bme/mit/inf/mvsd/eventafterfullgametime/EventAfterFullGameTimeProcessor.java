package hu.bme.mit.inf.mvsd.eventafterfullgametime;

import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.EventAfterFullGameTime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EventAfterFullGameTimeProcessor implements IMatchProcessor<EventAfterFullGameTimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEvent the value of pattern parameter event in the currently processed match 
   * 
   */
  public abstract void process(final Object event);
  
  @Override
  public void process(final EventAfterFullGameTimeMatch match) {
    process(match.getEvent());  				
    
  }
}
