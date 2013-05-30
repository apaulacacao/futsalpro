package hu.bme.mit.inf.mvsd.captainisinotherteam;

import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate CaptainIsInOtherTeamMatcher in a type-safe way.
 * 
 * @see CaptainIsInOtherTeamMatcher
 * @see CaptainIsInOtherTeamMatch
 * 
 */
public final class CaptainIsInOtherTeamMatcherFactory extends BaseGeneratedMatcherFactory<CaptainIsInOtherTeamMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CaptainIsInOtherTeamMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected CaptainIsInOtherTeamMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new CaptainIsInOtherTeamMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.CaptainIsInOtherTeam";
    
  }
  
  private CaptainIsInOtherTeamMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<CaptainIsInOtherTeamMatcherFactory> {
    @Override
    public CaptainIsInOtherTeamMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static CaptainIsInOtherTeamMatcherFactory INSTANCE = make();
    
    public static CaptainIsInOtherTeamMatcherFactory make() {
      try {
      	return new CaptainIsInOtherTeamMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
