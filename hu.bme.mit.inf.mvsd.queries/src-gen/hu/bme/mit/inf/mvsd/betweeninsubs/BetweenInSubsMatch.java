package hu.bme.mit.inf.mvsd.betweeninsubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.betweenInSubs pattern, 
 * to be used in conjunction with {@link BetweenInSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BetweenInSubsMatcher
 * @see BetweenInSubsProcessor
 * 
 */
public abstract class BetweenInSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fBefore;
  
  private Object fMid;
  
  private Object fAfter;
  
  private static String[] parameterNames = {"player", "before", "mid", "after"};
  
  private BetweenInSubsMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    this.fPlayer = pPlayer;
    this.fBefore = pBefore;
    this.fMid = pMid;
    this.fAfter = pAfter;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("before".equals(parameterName)) return this.fBefore;
    if ("mid".equals(parameterName)) return this.fMid;
    if ("after".equals(parameterName)) return this.fAfter;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getBefore() {
    return this.fBefore;
    
  }
  
  public Object getMid() {
    return this.fMid;
    
  }
  
  public Object getAfter() {
    return this.fAfter;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("before".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fBefore = (java.lang.Object) newValue;
    	return true;
    }
    if ("mid".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fMid = (java.lang.Object) newValue;
    	return true;
    }
    if ("after".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fAfter = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setBefore(final Object pBefore) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBefore = pBefore;
    
  }
  
  public void setMid(final Object pMid) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMid = pMid;
    
  }
  
  public void setAfter(final Object pAfter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAfter = pAfter;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.betweenInSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return BetweenInSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fBefore, fMid, fAfter};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"before\"=" + prettyPrintValue(fBefore) + ", ");
    result.append("\"mid\"=" + prettyPrintValue(fMid) + ", ");
    result.append("\"after\"=" + prettyPrintValue(fAfter));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fBefore == null) ? 0 : fBefore.hashCode()); 
    result = prime * result + ((fMid == null) ? 0 : fMid.hashCode()); 
    result = prime * result + ((fAfter == null) ? 0 : fAfter.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BetweenInSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BetweenInSubsMatch other = (BetweenInSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fBefore == null) {if (other.fBefore != null) return false;}
    else if (!fBefore.equals(other.fBefore)) return false;
    if (fMid == null) {if (other.fMid != null) return false;}
    else if (!fMid.equals(other.fMid)) return false;
    if (fAfter == null) {if (other.fAfter != null) return false;}
    else if (!fAfter.equals(other.fAfter)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return BetweenInSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends BetweenInSubsMatch {
    Mutable(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
      super(pPlayer, pBefore, pMid, pAfter);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends BetweenInSubsMatch {
    Immutable(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
      super(pPlayer, pBefore, pMid, pAfter);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
