package hu.bme.mit.inf.mvsd.outsubsafterlastinsubs;

import hu.bme.mit.inf.mvsd.outsubsafterlastinsubs.OutSubsAfterLastInSubsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate OutSubsAfterLastInSubsMatcher in a type-safe way.
 * 
 * @see OutSubsAfterLastInSubsMatcher
 * @see OutSubsAfterLastInSubsMatch
 * 
 */
public final class OutSubsAfterLastInSubsMatcherFactory extends BaseGeneratedMatcherFactory<OutSubsAfterLastInSubsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutSubsAfterLastInSubsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected OutSubsAfterLastInSubsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new OutSubsAfterLastInSubsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.outSubsAfterLastInSubs";
    
  }
  
  private OutSubsAfterLastInSubsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<OutSubsAfterLastInSubsMatcherFactory> {
    @Override
    public OutSubsAfterLastInSubsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static OutSubsAfterLastInSubsMatcherFactory INSTANCE = make();
    
    public static OutSubsAfterLastInSubsMatcherFactory make() {
      try {
      	return new OutSubsAfterLastInSubsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
