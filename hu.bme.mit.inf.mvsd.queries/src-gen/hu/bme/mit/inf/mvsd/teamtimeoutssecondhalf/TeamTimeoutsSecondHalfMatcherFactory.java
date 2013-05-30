package hu.bme.mit.inf.mvsd.teamtimeoutssecondhalf;

import hu.bme.mit.inf.mvsd.teamtimeoutssecondhalf.TeamTimeoutsSecondHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamTimeoutsSecondHalfMatcher in a type-safe way.
 * 
 * @see TeamTimeoutsSecondHalfMatcher
 * @see TeamTimeoutsSecondHalfMatch
 * 
 */
public final class TeamTimeoutsSecondHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamTimeoutsSecondHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamTimeoutsSecondHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamTimeoutsSecondHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamTimeoutsSecondHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamTimeoutsSecondHalf";
    
  }
  
  private TeamTimeoutsSecondHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamTimeoutsSecondHalfMatcherFactory> {
    @Override
    public TeamTimeoutsSecondHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamTimeoutsSecondHalfMatcherFactory INSTANCE = make();
    
    public static TeamTimeoutsSecondHalfMatcherFactory make() {
      try {
      	return new TeamTimeoutsSecondHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
