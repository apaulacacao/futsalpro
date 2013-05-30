package hu.bme.mit.inf.mvsd.teamsubstitutions;

import hu.bme.mit.inf.mvsd.teamsubstitutions.TeamSubstitutionsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamSubstitutions pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamSubstitutionsProcessor implements IMatchProcessor<TeamSubstitutionsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pSubst the value of pattern parameter subst in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object subst);
  
  @Override
  public void process(final TeamSubstitutionsMatch match) {
    process(match.getTeam(), match.getSubst());  				
    
  }
}
