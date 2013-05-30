package hu.bme.mit.inf.mvsd.teamfaultsfirsthalf;

import hu.bme.mit.inf.mvsd.teamfaultsfirsthalf.TeamFaultsFirstHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamFaultsFirstHalfMatcher in a type-safe way.
 * 
 * @see TeamFaultsFirstHalfMatcher
 * @see TeamFaultsFirstHalfMatch
 * 
 */
public final class TeamFaultsFirstHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamFaultsFirstHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamFaultsFirstHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamFaultsFirstHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamFaultsFirstHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultsFirstHalf";
    
  }
  
  private TeamFaultsFirstHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamFaultsFirstHalfMatcherFactory> {
    @Override
    public TeamFaultsFirstHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamFaultsFirstHalfMatcherFactory INSTANCE = make();
    
    public static TeamFaultsFirstHalfMatcherFactory make() {
      try {
      	return new TeamFaultsFirstHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
