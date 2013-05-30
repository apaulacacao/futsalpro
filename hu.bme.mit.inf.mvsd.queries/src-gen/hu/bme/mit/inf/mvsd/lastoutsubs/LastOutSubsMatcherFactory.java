package hu.bme.mit.inf.mvsd.lastoutsubs;

import hu.bme.mit.inf.mvsd.lastoutsubs.LastOutSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate LastOutSubsMatcher in a type-safe way.
 * 
 * @see LastOutSubsMatcher
 * @see LastOutSubsMatch
 * 
 */
public final class LastOutSubsMatcherFactory extends BaseGeneratedMatcherFactory<LastOutSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LastOutSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected LastOutSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new LastOutSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.lastOutSubs";
    
  }
  
  private LastOutSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<LastOutSubsMatcherFactory> {
    @Override
    public LastOutSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static LastOutSubsMatcherFactory INSTANCE = make();
    
    public static LastOutSubsMatcherFactory make() {
      try {
      	return new LastOutSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
