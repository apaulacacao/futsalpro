package hu.bme.mit.inf.mvsd.lastinsubs;

import hu.bme.mit.inf.mvsd.lastinsubs.LastInSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate LastInSubsMatcher in a type-safe way.
 * 
 * @see LastInSubsMatcher
 * @see LastInSubsMatch
 * 
 */
public final class LastInSubsMatcherFactory extends BaseGeneratedMatcherFactory<LastInSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LastInSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LastInSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new LastInSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.lastInSubs";
    
  }
  
  private LastInSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<LastInSubsMatcherFactory> {
    @Override
    public LastInSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static LastInSubsMatcherFactory INSTANCE = make();
    
    public static LastInSubsMatcherFactory make() {
      try {
      	return new LastInSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
