package hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf;

import hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf.TeamFaultCountSecondHalfMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamFaultCountSecondHalfMatcher in a type-safe way.
 * 
 * @see TeamFaultCountSecondHalfMatcher
 * @see TeamFaultCountSecondHalfMatch
 * 
 */
public final class TeamFaultCountSecondHalfMatcherFactory extends BaseGeneratedMatcherFactory<TeamFaultCountSecondHalfMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamFaultCountSecondHalfMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamFaultCountSecondHalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamFaultCountSecondHalfMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultCountSecondHalf";
    
  }
  
  private TeamFaultCountSecondHalfMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamFaultCountSecondHalfMatcherFactory> {
    @Override
    public TeamFaultCountSecondHalfMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamFaultCountSecondHalfMatcherFactory INSTANCE = make();
    
    public static TeamFaultCountSecondHalfMatcherFactory make() {
      try {
      	return new TeamFaultCountSecondHalfMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
