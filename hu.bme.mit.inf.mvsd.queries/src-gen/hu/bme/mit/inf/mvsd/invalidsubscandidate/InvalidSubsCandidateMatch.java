package hu.bme.mit.inf.mvsd.invalidsubscandidate;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.invalidSubsCandidate pattern, 
 * to be used in conjunction with {@link InvalidSubsCandidateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InvalidSubsCandidateMatcher
 * @see InvalidSubsCandidateProcessor
 * 
 */
public abstract class InvalidSubsCandidateMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fCurrent;
  
  private Object fCandidate;
  
  private static String[] parameterNames = {"player", "current", "candidate"};
  
  private InvalidSubsCandidateMatch(final Object pPlayer, final Object pCurrent, final Object pCandidate) {
    this.fPlayer = pPlayer;
    this.fCurrent = pCurrent;
    this.fCandidate = pCandidate;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("current".equals(parameterName)) return this.fCurrent;
    if ("candidate".equals(parameterName)) return this.fCandidate;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getCurrent() {
    return this.fCurrent;
    
  }
  
  public Object getCandidate() {
    return this.fCandidate;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("current".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fCurrent = (java.lang.Object) newValue;
    	return true;
    }
    if ("candidate".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fCandidate = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setCurrent(final Object pCurrent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCurrent = pCurrent;
    
  }
  
  public void setCandidate(final Object pCandidate) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCandidate = pCandidate;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.invalidSubsCandidate";
    
  }
  
  @Override
  public String[] parameterNames() {
    return InvalidSubsCandidateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fCurrent, fCandidate};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"current\"=" + prettyPrintValue(fCurrent) + ", ");
    result.append("\"candidate\"=" + prettyPrintValue(fCandidate));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fCurrent == null) ? 0 : fCurrent.hashCode()); 
    result = prime * result + ((fCandidate == null) ? 0 : fCandidate.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InvalidSubsCandidateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InvalidSubsCandidateMatch other = (InvalidSubsCandidateMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fCurrent == null) {if (other.fCurrent != null) return false;}
    else if (!fCurrent.equals(other.fCurrent)) return false;
    if (fCandidate == null) {if (other.fCandidate != null) return false;}
    else if (!fCandidate.equals(other.fCandidate)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return InvalidSubsCandidateMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends InvalidSubsCandidateMatch {
    Mutable(final Object pPlayer, final Object pCurrent, final Object pCandidate) {
      super(pPlayer, pCurrent, pCandidate);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends InvalidSubsCandidateMatch {
    Immutable(final Object pPlayer, final Object pCurrent, final Object pCandidate) {
      super(pPlayer, pCurrent, pCandidate);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
