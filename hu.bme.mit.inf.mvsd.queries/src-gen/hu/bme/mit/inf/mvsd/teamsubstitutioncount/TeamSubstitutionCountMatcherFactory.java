package hu.bme.mit.inf.mvsd.teamsubstitutioncount;

import hu.bme.mit.inf.mvsd.teamsubstitutioncount.TeamSubstitutionCountMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamSubstitutionCountMatcher in a type-safe way.
 * 
 * @see TeamSubstitutionCountMatcher
 * @see TeamSubstitutionCountMatch
 * 
 */
public final class TeamSubstitutionCountMatcherFactory extends BaseGeneratedMatcherFactory<TeamSubstitutionCountMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamSubstitutionCountMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamSubstitutionCountMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamSubstitutionCountMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamSubstitutionCount";
    
  }
  
  private TeamSubstitutionCountMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamSubstitutionCountMatcherFactory> {
    @Override
    public TeamSubstitutionCountMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamSubstitutionCountMatcherFactory INSTANCE = make();
    
    public static TeamSubstitutionCountMatcherFactory make() {
      try {
      	return new TeamSubstitutionCountMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
