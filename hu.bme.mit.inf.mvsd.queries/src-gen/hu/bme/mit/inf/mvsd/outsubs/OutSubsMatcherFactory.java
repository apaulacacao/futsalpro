package hu.bme.mit.inf.mvsd.outsubs;

import hu.bme.mit.inf.mvsd.outsubs.OutSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate OutSubsMatcher in a type-safe way.
 * 
 * @see OutSubsMatcher
 * @see OutSubsMatch
 * 
 */
public final class OutSubsMatcherFactory extends BaseGeneratedMatcherFactory<OutSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected OutSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new OutSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.outSubs";
    
  }
  
  private OutSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<OutSubsMatcherFactory> {
    @Override
    public OutSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static OutSubsMatcherFactory INSTANCE = make();
    
    public static OutSubsMatcherFactory make() {
      try {
      	return new OutSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
