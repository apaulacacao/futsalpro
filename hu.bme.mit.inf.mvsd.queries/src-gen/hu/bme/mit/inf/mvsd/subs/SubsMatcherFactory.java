package hu.bme.mit.inf.mvsd.subs;

import hu.bme.mit.inf.mvsd.subs.SubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate SubsMatcher in a type-safe way.
 * 
 * @see SubsMatcher
 * @see SubsMatch
 * 
 */
public final class SubsMatcherFactory extends BaseGeneratedMatcherFactory<SubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected SubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new SubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.subs";
    
  }
  
  private SubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<SubsMatcherFactory> {
    @Override
    public SubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static SubsMatcherFactory INSTANCE = make();
    
    public static SubsMatcherFactory make() {
      try {
      	return new SubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
