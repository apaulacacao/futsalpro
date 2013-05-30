package hu.bme.mit.inf.mvsd.betweenoutsubs;

import hu.bme.mit.inf.mvsd.betweenoutsubs.BetweenOutSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate BetweenOutSubsMatcher in a type-safe way.
 * 
 * @see BetweenOutSubsMatcher
 * @see BetweenOutSubsMatch
 * 
 */
public final class BetweenOutSubsMatcherFactory extends BaseGeneratedMatcherFactory<BetweenOutSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BetweenOutSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected BetweenOutSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new BetweenOutSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.betweenOutSubs";
    
  }
  
  private BetweenOutSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<BetweenOutSubsMatcherFactory> {
    @Override
    public BetweenOutSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static BetweenOutSubsMatcherFactory INSTANCE = make();
    
    public static BetweenOutSubsMatcherFactory make() {
      try {
      	return new BetweenOutSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
