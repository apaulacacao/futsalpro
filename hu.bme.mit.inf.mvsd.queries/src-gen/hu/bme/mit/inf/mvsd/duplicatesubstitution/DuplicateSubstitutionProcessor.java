package hu.bme.mit.inf.mvsd.duplicatesubstitution;

import hu.bme.mit.inf.mvsd.duplicatesubstitution.DuplicateSubstitutionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.mvsd.DuplicateSubstitution pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class DuplicateSubstitutionProcessor implements IMatchProcessor<DuplicateSubstitutionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSubstitution the value of pattern parameter substitution in the currently processed match 
   * 
   */
  public abstract void process(final Object substitution);
  
  @Override
  public void process(final DuplicateSubstitutionMatch match) {
    process(match.getSubstitution());  				
    
  }
}
