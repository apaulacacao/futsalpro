package hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency;

import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.MatchTeamSubjectInconsistency pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class MatchTeamSubjectInconsistencyProcessor implements IMatchProcessor<MatchTeamSubjectInconsistencyMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMatch the value of pattern parameter match in the currently processed match 
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * 
   */
  public abstract void process(final Object match, final Object team);
  
  @Override
  public void process(final MatchTeamSubjectInconsistencyMatch match) {
    process(match.getMatch(), match.getTeam());  				
    
  }
}
