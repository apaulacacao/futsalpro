package hu.bme.mit.inf.mvsd.teamgoalcounthalftime;

import hu.bme.mit.inf.mvsd.teamgoalcounthalftime.TeamGoalCountHalftimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalCountHalftimeMatcher in a type-safe way.
 * 
 * @see TeamGoalCountHalftimeMatcher
 * @see TeamGoalCountHalftimeMatch
 * 
 */
public final class TeamGoalCountHalftimeMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalCountHalftimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalCountHalftimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalCountHalftimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalCountHalftimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalCountHalftime";
    
  }
  
  private TeamGoalCountHalftimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalCountHalftimeMatcherFactory> {
    @Override
    public TeamGoalCountHalftimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalCountHalftimeMatcherFactory INSTANCE = make();
    
    public static TeamGoalCountHalftimeMatcherFactory make() {
      try {
      	return new TeamGoalCountHalftimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
