package hu.bme.mit.inf.mvsd.teamgoalsinitialtime;

import hu.bme.mit.inf.mvsd.teamgoalsinitialtime.TeamGoalsInitialTimeMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalsInitialTimeMatcher in a type-safe way.
 * 
 * @see TeamGoalsInitialTimeMatcher
 * @see TeamGoalsInitialTimeMatch
 * 
 */
public final class TeamGoalsInitialTimeMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalsInitialTimeMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalsInitialTimeMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalsInitialTimeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalsInitialTimeMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalsInitialTime";
    
  }
  
  private TeamGoalsInitialTimeMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalsInitialTimeMatcherFactory> {
    @Override
    public TeamGoalsInitialTimeMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalsInitialTimeMatcherFactory INSTANCE = make();
    
    public static TeamGoalsInitialTimeMatcherFactory make() {
      try {
      	return new TeamGoalsInitialTimeMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
