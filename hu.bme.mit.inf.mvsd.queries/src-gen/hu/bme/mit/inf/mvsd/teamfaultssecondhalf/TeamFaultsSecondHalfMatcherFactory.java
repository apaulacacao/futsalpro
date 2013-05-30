package hu.bme.mit.inf.mvsd.teamfaultssecondhalf;

import hu.bme.mit.inf.mvsd.teamfaultssecondhalf.TeamFaultsSecondHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamFaultsSecondHalfMatcher in a type-safe way.
 * 
 * @see TeamFaultsSecondHalfMatcher
 * @see TeamFaultsSecondHalfMatch
 * 
 */
public final class TeamFaultsSecondHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamFaultsSecondHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamFaultsSecondHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamFaultsSecondHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamFaultsSecondHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultsSecondHalf";
    
  }
  
  private TeamFaultsSecondHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamFaultsSecondHalfMatcherFactory> {
    @Override
    public TeamFaultsSecondHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamFaultsSecondHalfMatcherFactory INSTANCE = make();
    
    public static TeamFaultsSecondHalfMatcherFactory make() {
      try {
      	return new TeamFaultsSecondHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
