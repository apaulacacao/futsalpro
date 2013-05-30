package hu.bme.mit.inf.mvsd.teamgoalcountinitialtime;

import hu.bme.mit.inf.mvsd.teamgoalcountinitialtime.TeamGoalCountInitialTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalCountInitialTimeMatcher in a type-safe way.
 * 
 * @see TeamGoalCountInitialTimeMatcher
 * @see TeamGoalCountInitialTimeMatch
 * 
 */
public final class TeamGoalCountInitialTimeMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalCountInitialTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalCountInitialTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalCountInitialTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalCountInitialTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalCountInitialTime";
    
  }
  
  private TeamGoalCountInitialTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalCountInitialTimeMatcherFactory> {
    @Override
    public TeamGoalCountInitialTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalCountInitialTimeMatcherFactory INSTANCE = make();
    
    public static TeamGoalCountInitialTimeMatcherFactory make() {
      try {
      	return new TeamGoalCountInitialTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
