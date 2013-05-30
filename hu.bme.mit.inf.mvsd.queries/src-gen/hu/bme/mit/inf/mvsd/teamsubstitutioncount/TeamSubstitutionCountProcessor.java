package hu.bme.mit.inf.mvsd.teamsubstitutioncount;

import hu.bme.mit.inf.mvsd.teamsubstitutioncount.TeamSubstitutionCountMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamSubstitutionCount pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamSubstitutionCountProcessor implements IMatchProcessor<TeamSubstitutionCountMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pSubsCount the value of pattern parameter subsCount in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Integer subsCount);
  
  @Override
  public void process(final TeamSubstitutionCountMatch match) {
    process(match.getTeam(), match.getSubsCount());  				
    
  }
}
