package hu.bme.mit.inf.mvsd.subs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.subs pattern, 
 * to be used in conjunction with {@link SubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SubsMatcher
 * @see SubsProcessor
 * 
 */
public abstract class SubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fSubs;
  
  private static String[] parameterNames = {"player", "subs"};
  
  private SubsMatch(final Object pPlayer, final Object pSubs) {
    this.fPlayer = pPlayer;
    this.fSubs = pSubs;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("subs".equals(parameterName)) return this.fSubs;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getSubs() {
    return this.fSubs;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("subs".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fSubs = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setSubs(final Object pSubs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubs = pSubs;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.subs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return SubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fSubs};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"subs\"=" + prettyPrintValue(fSubs));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fSubs == null) ? 0 : fSubs.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SubsMatch other = (SubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fSubs == null) {if (other.fSubs != null) return false;}
    else if (!fSubs.equals(other.fSubs)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return SubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends SubsMatch {
    Mutable(final Object pPlayer, final Object pSubs) {
      super(pPlayer, pSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends SubsMatch {
    Immutable(final Object pPlayer, final Object pSubs) {
      super(pPlayer, pSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
