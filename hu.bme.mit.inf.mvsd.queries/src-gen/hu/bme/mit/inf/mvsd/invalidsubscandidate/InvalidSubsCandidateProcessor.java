package hu.bme.mit.inf.mvsd.invalidsubscandidate;

import hu.bme.mit.inf.mvsd.invalidsubscandidate.InvalidSubsCandidateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.invalidSubsCandidate pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class InvalidSubsCandidateProcessor implements IMatchProcessor<InvalidSubsCandidateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPlayer the value of pattern parameter player in the currently processed match 
   * @param pCurrent the value of pattern parameter current in the currently processed match 
   * @param pCandidate the value of pattern parameter candidate in the currently processed match 
   * 
   */
  public abstract void process(final Object player, final Object current, final Object candidate);
  
  @Override
  public void process(final InvalidSubsCandidateMatch match) {
    process(match.getPlayer(), match.getCurrent(), match.getCandidate());  				
    
  }
}
