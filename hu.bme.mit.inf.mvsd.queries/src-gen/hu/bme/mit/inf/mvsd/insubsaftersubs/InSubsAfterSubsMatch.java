package hu.bme.mit.inf.mvsd.insubsaftersubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.inSubsAfterSubs pattern, 
 * to be used in conjunction with {@link InSubsAfterSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InSubsAfterSubsMatcher
 * @see InSubsAfterSubsProcessor
 * 
 */
public abstract class InSubsAfterSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fSubstitution;
  
  private Object fAfterSubs;
  
  private static String[] parameterNames = {"player", "substitution", "afterSubs"};
  
  private InSubsAfterSubsMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    this.fPlayer = pPlayer;
    this.fSubstitution = pSubstitution;
    this.fAfterSubs = pAfterSubs;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("substitution".equals(parameterName)) return this.fSubstitution;
    if ("afterSubs".equals(parameterName)) return this.fAfterSubs;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getSubstitution() {
    return this.fSubstitution;
    
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
    if ("substitution".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fSubstitution = (java.lang.Object) newValue;
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
  
  public void setSubstitution(final Object pSubstitution) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubstitution = pSubstitution;
    
  }
  
  public void setAfterSubs(final Object pAfterSubs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAfterSubs = pAfterSubs;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.inSubsAfterSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return InSubsAfterSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fSubstitution, fAfterSubs};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"substitution\"=" + prettyPrintValue(fSubstitution) + ", ");
    result.append("\"afterSubs\"=" + prettyPrintValue(fAfterSubs));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fSubstitution == null) ? 0 : fSubstitution.hashCode()); 
    result = prime * result + ((fAfterSubs == null) ? 0 : fAfterSubs.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InSubsAfterSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InSubsAfterSubsMatch other = (InSubsAfterSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fSubstitution == null) {if (other.fSubstitution != null) return false;}
    else if (!fSubstitution.equals(other.fSubstitution)) return false;
    if (fAfterSubs == null) {if (other.fAfterSubs != null) return false;}
    else if (!fAfterSubs.equals(other.fAfterSubs)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return InSubsAfterSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends InSubsAfterSubsMatch {
    Mutable(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
      super(pPlayer, pSubstitution, pAfterSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends InSubsAfterSubsMatch {
    Immutable(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
      super(pPlayer, pSubstitution, pAfterSubs);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
