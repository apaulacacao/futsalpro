package hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime;

import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate EventAfterGameTimeIfEqualInInitialTimeMatcher in a type-safe way.
 * 
 * @see EventAfterGameTimeIfEqualInInitialTimeMatcher
 * @see EventAfterGameTimeIfEqualInInitialTimeMatch
 * 
 */
public final class EventAfterGameTimeIfEqualInInitialTimeMatcherFactory extends BaseGeneratedMatcherFactory<EventAfterGameTimeIfEqualInInitialTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventAfterGameTimeIfEqualInInitialTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EventAfterGameTimeIfEqualInInitialTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new EventAfterGameTimeIfEqualInInitialTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.EventAfterGameTimeIfEqualInInitialTime";
    
  }
  
  private EventAfterGameTimeIfEqualInInitialTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<EventAfterGameTimeIfEqualInInitialTimeMatcherFactory> {
    @Override
    public EventAfterGameTimeIfEqualInInitialTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static EventAfterGameTimeIfEqualInInitialTimeMatcherFactory INSTANCE = make();
    
    public static EventAfterGameTimeIfEqualInInitialTimeMatcherFactory make() {
      try {
      	return new EventAfterGameTimeIfEqualInInitialTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
