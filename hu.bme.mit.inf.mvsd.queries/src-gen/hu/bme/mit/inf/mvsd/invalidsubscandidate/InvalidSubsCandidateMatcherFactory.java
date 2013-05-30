package hu.bme.mit.inf.mvsd.invalidsubscandidate;

import hu.bme.mit.inf.mvsd.invalidsubscandidate.InvalidSubsCandidateMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate InvalidSubsCandidateMatcher in a type-safe way.
 * 
 * @see InvalidSubsCandidateMatcher
 * @see InvalidSubsCandidateMatch
 * 
 */
public final class InvalidSubsCandidateMatcherFactory extends BaseGeneratedMatcherFactory<InvalidSubsCandidateMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InvalidSubsCandidateMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected InvalidSubsCandidateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new InvalidSubsCandidateMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.invalidSubsCandidate";
    
  }
  
  private InvalidSubsCandidateMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<InvalidSubsCandidateMatcherFactory> {
    @Override
    public InvalidSubsCandidateMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static InvalidSubsCandidateMatcherFactory INSTANCE = make();
    
    public static InvalidSubsCandidateMatcherFactory make() {
      try {
      	return new InvalidSubsCandidateMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
