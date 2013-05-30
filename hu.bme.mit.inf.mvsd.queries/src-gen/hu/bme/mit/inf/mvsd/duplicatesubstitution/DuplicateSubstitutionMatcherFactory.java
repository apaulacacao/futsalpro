package hu.bme.mit.inf.mvsd.duplicatesubstitution;

import hu.bme.mit.inf.mvsd.duplicatesubstitution.DuplicateSubstitutionMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate DuplicateSubstitutionMatcher in a type-safe way.
 * 
 * @see DuplicateSubstitutionMatcher
 * @see DuplicateSubstitutionMatch
 * 
 */
public final class DuplicateSubstitutionMatcherFactory extends BaseGeneratedMatcherFactory<DuplicateSubstitutionMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static DuplicateSubstitutionMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected DuplicateSubstitutionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new DuplicateSubstitutionMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.DuplicateSubstitution";
    
  }
  
  private DuplicateSubstitutionMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<DuplicateSubstitutionMatcherFactory> {
    @Override
    public DuplicateSubstitutionMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static DuplicateSubstitutionMatcherFactory INSTANCE = make();
    
    public static DuplicateSubstitutionMatcherFactory make() {
      try {
      	return new DuplicateSubstitutionMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
