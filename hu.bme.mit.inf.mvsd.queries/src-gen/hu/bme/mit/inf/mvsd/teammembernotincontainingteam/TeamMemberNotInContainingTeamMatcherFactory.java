package hu.bme.mit.inf.mvsd.teammembernotincontainingteam;

import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate TeamMemberNotInContainingTeamMatcher in a type-safe way.
 * 
 * @see TeamMemberNotInContainingTeamMatcher
 * @see TeamMemberNotInContainingTeamMatch
 * 
 */
public final class TeamMemberNotInContainingTeamMatcherFactory extends BaseGeneratedMatcherFactory<TeamMemberNotInContainingTeamMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeamMemberNotInContainingTeamMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeamMemberNotInContainingTeamMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new TeamMemberNotInContainingTeamMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamMemberNotInContainingTeam";
    
  }
  
  private TeamMemberNotInContainingTeamMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<TeamMemberNotInContainingTeamMatcherFactory> {
    @Override
    public TeamMemberNotInContainingTeamMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static TeamMemberNotInContainingTeamMatcherFactory INSTANCE = make();
    
    public static TeamMemberNotInContainingTeamMatcherFactory make() {
      try {
      	return new TeamMemberNotInContainingTeamMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
