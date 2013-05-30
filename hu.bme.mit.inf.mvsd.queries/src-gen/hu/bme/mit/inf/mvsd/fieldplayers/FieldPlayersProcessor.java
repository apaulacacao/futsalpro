package hu.bme.mit.inf.mvsd.fieldplayers;

import hu.bme.mit.inf.mvsd.fieldplayers.FieldPlayersMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.fieldPlayers pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class FieldPlayersProcessor implements IMatchProcessor<FieldPlayersMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTeam the value of pattern parameter team in the currently processed match 
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * 
   */
  public abstract void process(final Object team, final Object player);
  
  @Override
  public void process(final FieldPlayersMatch match) {
    process(match.getTeam(), match.getPlayer());  				
    
  }
}
