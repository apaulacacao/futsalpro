package hu.bme.mit.inf.mvsd.allplayers;

import hu.bme.mit.inf.mvsd.allplayers.AllPlayersMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.allPlayers pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class AllPlayersProcessor implements IMatchProcessor<AllPlayersMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object player);
  
  @Override
  public void process(final AllPlayersMatch match) {
    process(match.getTeam(), match.getPlayer());  				
    
  }
}
