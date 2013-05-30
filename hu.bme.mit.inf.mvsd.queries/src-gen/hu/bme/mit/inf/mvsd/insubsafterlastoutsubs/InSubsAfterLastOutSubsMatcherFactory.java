package hu.bme.mit.inf.mvsd.insubsafterlastoutsubs;

import hu.bme.mit.inf.mvsd.insubsafterlastoutsubs.InSubsAfterLastOutSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate InSubsAfterLastOutSubsMatcher in a type-safe way.
 * 
 * @see InSubsAfterLastOutSubsMatcher
 * @see InSubsAfterLastOutSubsMatch
 * 
 */
public final class InSubsAfterLastOutSubsMatcherFactory extends BaseGeneratedMatcherFactory<InSubsAfterLastOutSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InSubsAfterLastOutSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected InSubsAfterLastOutSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new InSubsAfterLastOutSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.inSubsAfterLastOutSubs";
    
  }
  
  private InSubsAfterLastOutSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<InSubsAfterLastOutSubsMatcherFactory> {
    @Override
    public InSubsAfterLastOutSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static InSubsAfterLastOutSubsMatcherFactory INSTANCE = make();
    
    public static InSubsAfterLastOutSubsMatcherFactory make() {
      try {
      	return new InSubsAfterLastOutSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
