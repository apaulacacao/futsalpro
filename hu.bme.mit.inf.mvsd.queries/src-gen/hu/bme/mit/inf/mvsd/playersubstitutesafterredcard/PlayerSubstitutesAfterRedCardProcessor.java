package hu.bme.mit.inf.mvsd.playersubstitutesafterredcard;

import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.PlayerSubstitutesAfterRedCard pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class PlayerSubstitutesAfterRedCardProcessor implements IMatchProcessor<PlayerSubstitutesAfterRedCardMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSubst the value of pattern parameter subst in the currently processed match 
   * 
   */
  public abstract void process(final Object subst);
  
  @Override
  public void process(final PlayerSubstitutesAfterRedCardMatch match) {
    process(match.getSubst());  				
    
  }
}
