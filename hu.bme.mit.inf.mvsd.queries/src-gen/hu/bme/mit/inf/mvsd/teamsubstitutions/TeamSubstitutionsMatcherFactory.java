package hu.bme.mit.inf.mvsd.teamsubstitutions;

import hu.bme.mit.inf.mvsd.teamsubstitutions.TeamSubstitutionsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamSubstitutionsMatcher in a type-safe way.
 * 
 * @see TeamSubstitutionsMatcher
 * @see TeamSubstitutionsMatch
 * 
 */
public final class TeamSubstitutionsMatcherFactory extends BaseGeneratedMatcherFactory<TeamSubstitutionsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamSubstitutionsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamSubstitutionsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamSubstitutionsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamSubstitutions";
    
  }
  
  private TeamSubstitutionsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamSubstitutionsMatcherFactory> {
    @Override
    public TeamSubstitutionsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamSubstitutionsMatcherFactory INSTANCE = make();
    
    public static TeamSubstitutionsMatcherFactory make() {
      try {
      	return new TeamSubstitutionsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
