package hu.bme.mit.inf.mvsd.teamgoals;

import hu.bme.mit.inf.mvsd.teamgoals.TeamGoalsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalsMatcher in a type-safe way.
 * 
 * @see TeamGoalsMatcher
 * @see TeamGoalsMatch
 * 
 */
public final class TeamGoalsMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoals";
    
  }
  
  private TeamGoalsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalsMatcherFactory> {
    @Override
    public TeamGoalsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalsMatcherFactory INSTANCE = make();
    
    public static TeamGoalsMatcherFactory make() {
      try {
      	return new TeamGoalsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
