package hu.bme.mit.inf.mvsd.teamgoalcount;

import hu.bme.mit.inf.mvsd.teamgoalcount.TeamGoalCountMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamGoalCountMatcher in a type-safe way.
 * 
 * @see TeamGoalCountMatcher
 * @see TeamGoalCountMatch
 * 
 */
public final class TeamGoalCountMatcherFactory extends BaseGeneratedMatcherFactory<TeamGoalCountMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamGoalCountMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamGoalCountMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamGoalCountMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalCount";
    
  }
  
  private TeamGoalCountMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamGoalCountMatcherFactory> {
    @Override
    public TeamGoalCountMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamGoalCountMatcherFactory INSTANCE = make();
    
    public static TeamGoalCountMatcherFactory make() {
      try {
      	return new TeamGoalCountMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
