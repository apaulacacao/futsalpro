package hu.bme.mit.inf.mvsd.decreasingeventtime;

import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate DecreasingEventTimeMatcher in a type-safe way.
 * 
 * @see DecreasingEventTimeMatcher
 * @see DecreasingEventTimeMatch
 * 
 */
public final class DecreasingEventTimeMatcherFactory extends BaseGeneratedMatcherFactory<DecreasingEventTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static DecreasingEventTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected DecreasingEventTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new DecreasingEventTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.DecreasingEventTime";
    
  }
  
  private DecreasingEventTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<DecreasingEventTimeMatcherFactory> {
    @Override
    public DecreasingEventTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static DecreasingEventTimeMatcherFactory INSTANCE = make();
    
    public static DecreasingEventTimeMatcherFactory make() {
      try {
      	return new DecreasingEventTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
