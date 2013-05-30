package hu.bme.mit.inf.mvsd.outsubsaftersubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.outSubsAfterSubs pattern, 
 * to be used in conjunction with {@link OutSubsAfterSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OutSubsAfterSubsMatcher
 * @see OutSubsAfterSubsProcessor
 * 
 */
public abstract class OutSubsAfterSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fBeforeSubs;
  
  private Object fAfterSubs;
  
  private static String[] parameterNames = {"player", "beforeSubs", "afterSubs"};
  
  private OutSubsAfterSubsMatch(final Object pPlayer, final Object pBeforeSubs, final Object pAfterSubs) {
    this.fPlayer = pPlayer;
    this.fBeforeSubs = pBeforeSubs;
    this.fAfterSubs = pAfterSubs;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("beforeSubs".equals(parameterName)) return this.fBeforeSubs;
    if ("afterSubs".equals(parameterName)) return this.fAfterSubs;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getBeforeSubs() {
    return this.fBeforeSubs;
    
  }
  
  public Object getAfterSubs() {
    return this.fAfterSubs;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("beforeSubs".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fBeforeSubs = (java.lang.Object) newValue;
    	return true;
    }
    if ("afterSubs".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fAfterSubs = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setBeforeSubs(final Object pBeforeSubs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBeforeSubs = pBeforeSubs;
    
  }
  
  public void setAfterSubs(final Object pAfterSubs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAfterSubs = pAfterSubs;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.outSubsAfterSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return OutSubsAfterSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fBeforeSubs, fAfterSubs};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"beforeSubs\"=" + prettyPrintValue(fBeforeSubs) + ", ");
    result.append("\"afterSubs\"=" + prettyPrintValue(fAfterSubs));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fBeforeSubs == null) ? 0 : fBeforeSubs.hashCode()); 
    result = prime * result + ((fAfterSubs == null) ? 0 : fAfterSubs.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OutSubsAfterSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OutSubsAfterSubsMatch other = (OutSubsAfterSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fBeforeSubs == null) {if (other.fBeforeSubs != null) return false;}
    else if (!fBeforeSubs.equals(other.fBeforeSubs)) return false;
    if (fAfterSubs == null) {if (other.fAfterSubs != null) return false;}
    else if (!fAfterSubs.equals(other.fAfterSubs)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return OutSubsAfterSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends OutSubsAfterSubsMatch {
    Mutable(final Object pPlayer, final Object pBeforeSubs, final Object pAfterSubs) {
      super(pPlayer, pBeforeSubs, pAfterSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends OutSubsAfterSubsMatch {
    Immutable(final Object pPlayer, final Object pBeforeSubs, final Object pAfterSubs) {
      super(pPlayer, pBeforeSubs, pAfterSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
