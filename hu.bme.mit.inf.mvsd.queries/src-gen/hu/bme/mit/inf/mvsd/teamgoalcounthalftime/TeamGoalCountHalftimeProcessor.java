package hu.bme.mit.inf.mvsd.teamgoalcounthalftime;

import hu.bme.mit.inf.mvsd.teamgoalcounthalftime.TeamGoalCountHalftimeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.TeamGoalCountHalftime pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TeamGoalCountHalftimeProcessor implements IMatchProcessor<TeamGoalCountHalftimeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pGoalCount the value of pattern parameter goalCount in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Integer goalCount);
  
  @Override
  public void process(final TeamGoalCountHalftimeMatch match) {
    process(match.getTeam(), match.getGoalCount());  				
    
  }
}
