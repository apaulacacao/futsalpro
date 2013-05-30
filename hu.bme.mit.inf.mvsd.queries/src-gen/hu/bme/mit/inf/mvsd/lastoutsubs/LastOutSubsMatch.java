package hu.bme.mit.inf.mvsd.lastoutsubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.lastOutSubs pattern, 
 * to be used in conjunction with {@link LastOutSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LastOutSubsMatcher
 * @see LastOutSubsProcessor
 * 
 */
public abstract class LastOutSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fSubstitution;
  
  private static String[] parameterNames = {"player", "substitution"};
  
  private LastOutSubsMatch(final Object pPlayer, final Object pSubstitution) {
    this.fPlayer = pPlayer;
    this.fSubstitution = pSubstitution;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("substitution".equals(parameterName)) return this.fSubstitution;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getSubstitution() {
    return this.fSubstitution;
    
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
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.lastOutSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return LastOutSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fSubstitution};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"substitution\"=" + prettyPrintValue(fSubstitution));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fSubstitution == null) ? 0 : fSubstitution.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LastOutSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    LastOutSubsMatch other = (LastOutSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fSubstitution == null) {if (other.fSubstitution != null) return false;}
    else if (!fSubstitution.equals(other.fSubstitution)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return LastOutSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends LastOutSubsMatch {
    Mutable(final Object pPlayer, final Object pSubstitution) {
      super(pPlayer, pSubstitution);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends LastOutSubsMatch {
    Immutable(final Object pPlayer, final Object pSubstitution) {
      super(pPlayer, pSubstitution);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
