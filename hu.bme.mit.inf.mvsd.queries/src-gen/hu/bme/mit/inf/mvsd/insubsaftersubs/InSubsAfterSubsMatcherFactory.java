package hu.bme.mit.inf.mvsd.insubsaftersubs;

import hu.bme.mit.inf.mvsd.insubsaftersubs.InSubsAfterSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate InSubsAfterSubsMatcher in a type-safe way.
 * 
 * @see InSubsAfterSubsMatcher
 * @see InSubsAfterSubsMatch
 * 
 */
public final class InSubsAfterSubsMatcherFactory extends BaseGeneratedMatcherFactory<InSubsAfterSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InSubsAfterSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected InSubsAfterSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new InSubsAfterSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.inSubsAfterSubs";
    
  }
  
  private InSubsAfterSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<InSubsAfterSubsMatcherFactory> {
    @Override
    public InSubsAfterSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static InSubsAfterSubsMatcherFactory INSTANCE = make();
    
    public static InSubsAfterSubsMatcherFactory make() {
      try {
      	return new InSubsAfterSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
