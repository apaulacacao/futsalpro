package hu.bme.mit.inf.mvsd.teamtimeouts;

import hu.bme.mit.inf.mvsd.teamtimeouts.TeamTimeoutsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamTimeoutsMatcher in a type-safe way.
 * 
 * @see TeamTimeoutsMatcher
 * @see TeamTimeoutsMatch
 * 
 */
public final class TeamTimeoutsMatcherFactory extends BaseGeneratedMatcherFactory<TeamTimeoutsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamTimeoutsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamTimeoutsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamTimeoutsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamTimeouts";
    
  }
  
  private TeamTimeoutsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamTimeoutsMatcherFactory> {
    @Override
    public TeamTimeoutsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamTimeoutsMatcherFactory INSTANCE = make();
    
    public static TeamTimeoutsMatcherFactory make() {
      try {
      	return new TeamTimeoutsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
