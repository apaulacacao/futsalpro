package hu.bme.mit.inf.mvsd.teamfaultcountfirsthalf;

import hu.bme.mit.inf.mvsd.teamfaultcountfirsthalf.TeamFaultCountFirstHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamFaultCountFirstHalfMatcher in a type-safe way.
 * 
 * @see TeamFaultCountFirstHalfMatcher
 * @see TeamFaultCountFirstHalfMatch
 * 
 */
public final class TeamFaultCountFirstHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamFaultCountFirstHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamFaultCountFirstHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamFaultCountFirstHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamFaultCountFirstHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultCountFirstHalf";
    
  }
  
  private TeamFaultCountFirstHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamFaultCountFirstHalfMatcherFactory> {
    @Override
    public TeamFaultCountFirstHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamFaultCountFirstHalfMatcherFactory INSTANCE = make();
    
    public static TeamFaultCountFirstHalfMatcherFactory make() {
      try {
      	return new TeamFaultCountFirstHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
