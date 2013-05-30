package hu.bme.mit.inf.mvsd.teamfaults;

import hu.bme.mit.inf.mvsd.teamfaults.TeamFaultsMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamFaultsMatcher in a type-safe way.
 * 
 * @see TeamFaultsMatcher
 * @see TeamFaultsMatch
 * 
 */
public final class TeamFaultsMatcherFactory extends BaseGeneratedMatcherFactory<TeamFaultsMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamFaultsMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamFaultsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamFaultsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaults";
    
  }
  
  private TeamFaultsMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamFaultsMatcherFactory> {
    @Override
    public TeamFaultsMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamFaultsMatcherFactory INSTANCE = make();
    
    public static TeamFaultsMatcherFactory make() {
      try {
      	return new TeamFaultsMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
