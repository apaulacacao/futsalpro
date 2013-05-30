package hu.bme.mit.inf.mvsd.teammembernotincontainingteam;

import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamMemberNotInContainingTeam pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamMemberNotInContainingTeamProcessor implements IMatchProcessor<TeamMemberNotInContainingTeamMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMember the value of pattern parameter member in the currently processed match 
   * 
   */
  public abstract void process(final Object member);
  
  @Override
  public void process(final TeamMemberNotInContainingTeamMatch match) {
    process(match.getMember());  				
    
  }
}
