package hu.bme.mit.inf.mvsd.teamgoalshalftime;

import hu.bme.mit.inf.mvsd.teamgoalshalftime.TeamGoalsHalfTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalsHalfTimeMatcher in a type-safe way.
 * 
 * @see TeamGoalsHalfTimeMatcher
 * @see TeamGoalsHalfTimeMatch
 * 
 */
public final class TeamGoalsHalfTimeMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalsHalfTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalsHalfTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalsHalfTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalsHalfTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalsHalfTime";
    
  }
  
  private TeamGoalsHalfTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalsHalfTimeMatcherFactory> {
    @Override
    public TeamGoalsHalfTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalsHalfTimeMatcherFactory INSTANCE = make();
    
    public static TeamGoalsHalfTimeMatcherFactory make() {
      try {
      	return new TeamGoalsHalfTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
