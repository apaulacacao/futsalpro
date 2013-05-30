package hu.bme.mit.inf.mvsd.playerscoresafterredcard;

import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.PlayerScoresAfterRedCard pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class PlayerScoresAfterRedCardProcessor implements IMatchProcessor<PlayerScoresAfterRedCardMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pGoal the value of pattern parameter goal in the currently processed match 
   * 
   */
  public abstract void process(final Object goal);
  
  @Override
  public void process(final PlayerScoresAfterRedCardMatch match) {
    process(match.getGoal());  				
    
  }
}
