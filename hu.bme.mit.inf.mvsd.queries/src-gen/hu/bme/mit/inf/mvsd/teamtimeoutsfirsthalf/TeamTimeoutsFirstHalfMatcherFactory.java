package hu.bme.mit.inf.mvsd.teamtimeoutsfirsthalf;

import hu.bme.mit.inf.mvsd.teamtimeoutsfirsthalf.TeamTimeoutsFirstHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamTimeoutsFirstHalfMatcher in a type-safe way.
 * 
 * @see TeamTimeoutsFirstHalfMatcher
 * @see TeamTimeoutsFirstHalfMatch
 * 
 */
public final class TeamTimeoutsFirstHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamTimeoutsFirstHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamTimeoutsFirstHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamTimeoutsFirstHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamTimeoutsFirstHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamTimeoutsFirstHalf";
    
  }
  
  private TeamTimeoutsFirstHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamTimeoutsFirstHalfMatcherFactory> {
    @Override
    public TeamTimeoutsFirstHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamTimeoutsFirstHalfMatcherFactory INSTANCE = make();
    
    public static TeamTimeoutsFirstHalfMatcherFactory make() {
      try {
      	return new TeamTimeoutsFirstHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
