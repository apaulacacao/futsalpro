package hu.bme.mit.inf.mvsd.teamfaultssecondhalf;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamFaultsSecondHalf pattern, 
 * to be used in conjunction with {@link TeamFaultsSecondHalfMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamFaultsSecondHalfMatcher
 * @see TeamFaultsSecondHalfProcessor
 * 
 */
public abstract class TeamFaultsSecondHalfMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Object fFault;
  
  private static String[] parameterNames = {"team", "fault"};
  
  private TeamFaultsSecondHalfMatch(final Object pTeam, final Object pFault) {
    this.fTeam = pTeam;
    this.fFault = pFault;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("fault".equals(parameterName)) return this.fFault;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Object getFault() {
    return this.fFault;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("fault".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fFault = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setFault(final Object pFault) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFault = pFault;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultsSecondHalf";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamFaultsSecondHalfMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fFault};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"fault\"=" + prettyPrintValue(fFault));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fFault == null) ? 0 : fFault.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamFaultsSecondHalfMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamFaultsSecondHalfMatch other = (TeamFaultsSecondHalfMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fFault == null) {if (other.fFault != null) return false;}
    else if (!fFault.equals(other.fFault)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamFaultsSecondHalfMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamFaultsSecondHalfMatch {
    Mutable(final Object pTeam, final Object pFault) {
      super(pTeam, pFault);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamFaultsSecondHalfMatch {
    Immutable(final Object pTeam, final Object pFault) {
      super(pTeam, pFault);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
