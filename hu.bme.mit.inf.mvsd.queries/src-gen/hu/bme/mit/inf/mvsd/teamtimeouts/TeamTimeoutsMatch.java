package hu.bme.mit.inf.mvsd.teamtimeouts;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamTimeouts pattern, 
 * to be used in conjunction with {@link TeamTimeoutsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamTimeoutsMatcher
 * @see TeamTimeoutsProcessor
 * 
 */
public abstract class TeamTimeoutsMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Object fTimeout;
  
  private static String[] parameterNames = {"team", "timeout"};
  
  private TeamTimeoutsMatch(final Object pTeam, final Object pTimeout) {
    this.fTeam = pTeam;
    this.fTimeout = pTimeout;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("timeout".equals(parameterName)) return this.fTimeout;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Object getTimeout() {
    return this.fTimeout;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("timeout".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTimeout = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setTimeout(final Object pTimeout) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTimeout = pTimeout;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamTimeouts";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamTimeoutsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fTimeout};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"timeout\"=" + prettyPrintValue(fTimeout));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fTimeout == null) ? 0 : fTimeout.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamTimeoutsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamTimeoutsMatch other = (TeamTimeoutsMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fTimeout == null) {if (other.fTimeout != null) return false;}
    else if (!fTimeout.equals(other.fTimeout)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamTimeoutsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamTimeoutsMatch {
    Mutable(final Object pTeam, final Object pTimeout) {
      super(pTeam, pTimeout);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamTimeoutsMatch {
    Immutable(final Object pTeam, final Object pTimeout) {
      super(pTeam, pTimeout);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
