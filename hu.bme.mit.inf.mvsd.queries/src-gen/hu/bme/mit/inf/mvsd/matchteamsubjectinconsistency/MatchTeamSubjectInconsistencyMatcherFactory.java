package hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency;

import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate MatchTeamSubjectInconsistencyMatcher in a type-safe way.
 * 
 * @see MatchTeamSubjectInconsistencyMatcher
 * @see MatchTeamSubjectInconsistencyMatch
 * 
 */
public final class MatchTeamSubjectInconsistencyMatcherFactory extends BaseGeneratedMatcherFactory<MatchTeamSubjectInconsistencyMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MatchTeamSubjectInconsistencyMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MatchTeamSubjectInconsistencyMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new MatchTeamSubjectInconsistencyMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.MatchTeamSubjectInconsistency";
    
  }
  
  private MatchTeamSubjectInconsistencyMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<MatchTeamSubjectInconsistencyMatcherFactory> {
    @Override
    public MatchTeamSubjectInconsistencyMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static MatchTeamSubjectInconsistencyMatcherFactory INSTANCE = make();
    
    public static MatchTeamSubjectInconsistencyMatcherFactory make() {
      try {
      	return new MatchTeamSubjectInconsistencyMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
