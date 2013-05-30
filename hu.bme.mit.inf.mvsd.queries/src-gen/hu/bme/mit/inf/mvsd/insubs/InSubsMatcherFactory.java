package hu.bme.mit.inf.mvsd.insubs;

import hu.bme.mit.inf.mvsd.insubs.InSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate InSubsMatcher in a type-safe way.
 * 
 * @see InSubsMatcher
 * @see InSubsMatch
 * 
 */
public final class InSubsMatcherFactory extends BaseGeneratedMatcherFactory<InSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected InSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new InSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.inSubs";
    
  }
  
  private InSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<InSubsMatcherFactory> {
    @Override
    public InSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static InSubsMatcherFactory INSTANCE = make();
    
    public static InSubsMatcherFactory make() {
      try {
      	return new InSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
