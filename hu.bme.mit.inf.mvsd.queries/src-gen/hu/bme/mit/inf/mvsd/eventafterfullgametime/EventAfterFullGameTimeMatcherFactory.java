package hu.bme.mit.inf.mvsd.eventafterfullgametime;

import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EventAfterFullGameTimeMatcher in a type-safe way.
 * 
 * @see EventAfterFullGameTimeMatcher
 * @see EventAfterFullGameTimeMatch
 * 
 */
public final class EventAfterFullGameTimeMatcherFactory extends BaseGeneratedMatcherFactory<EventAfterFullGameTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventAfterFullGameTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventAfterFullGameTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EventAfterFullGameTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.EventAfterFullGameTime";
    
  }
  
  private EventAfterFullGameTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EventAfterFullGameTimeMatcherFactory> {
    @Override
    public EventAfterFullGameTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventAfterFullGameTimeMatcherFactory INSTANCE = make();
    
    public static EventAfterFullGameTimeMatcherFactory make() {
      try {
      	return new EventAfterFullGameTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
