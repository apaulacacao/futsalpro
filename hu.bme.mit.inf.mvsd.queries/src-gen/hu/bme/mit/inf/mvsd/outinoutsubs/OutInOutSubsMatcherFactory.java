package hu.bme.mit.inf.mvsd.outinoutsubs;

import hu.bme.mit.inf.mvsd.outinoutsubs.OutInOutSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate OutInOutSubsMatcher in a type-safe way.
 * 
 * @see OutInOutSubsMatcher
 * @see OutInOutSubsMatch
 * 
 */
public final class OutInOutSubsMatcherFactory extends BaseGeneratedMatcherFactory<OutInOutSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutInOutSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected OutInOutSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new OutInOutSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.outInOutSubs";
    
  }
  
  private OutInOutSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<OutInOutSubsMatcherFactory> {
    @Override
    public OutInOutSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static OutInOutSubsMatcherFactory INSTANCE = make();
    
    public static OutInOutSubsMatcherFactory make() {
      try {
      	return new OutInOutSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
