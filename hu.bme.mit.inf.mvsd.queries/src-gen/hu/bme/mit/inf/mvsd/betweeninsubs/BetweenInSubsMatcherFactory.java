package hu.bme.mit.inf.mvsd.betweeninsubs;

import hu.bme.mit.inf.mvsd.betweeninsubs.BetweenInSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate BetweenInSubsMatcher in a type-safe way.
 * 
 * @see BetweenInSubsMatcher
 * @see BetweenInSubsMatch
 * 
 */
public final class BetweenInSubsMatcherFactory extends BaseGeneratedMatcherFactory<BetweenInSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BetweenInSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected BetweenInSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new BetweenInSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.betweenInSubs";
    
  }
  
  private BetweenInSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<BetweenInSubsMatcherFactory> {
    @Override
    public BetweenInSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static BetweenInSubsMatcherFactory INSTANCE = make();
    
    public static BetweenInSubsMatcherFactory make() {
      try {
      	return new BetweenInSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
