package hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamFaultCountSecondHalf pattern, 
 * to be used in conjunction with {@link TeamFaultCountSecondHalfMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamFaultCountSecondHalfMatcher
 * @see TeamFaultCountSecondHalfProcessor
 * 
 */
public abstract class TeamFaultCountSecondHalfMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Integer fFaultCount;
  
  private static String[] parameterNames = {"team", "faultCount"};
  
  private TeamFaultCountSecondHalfMatch(final Object pTeam, final Integer pFaultCount) {
    this.fTeam = pTeam;
    this.fFaultCount = pFaultCount;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("faultCount".equals(parameterName)) return this.fFaultCount;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Integer getFaultCount() {
    return this.fFaultCount;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("faultCount".equals(parameterName) ) {
    	this.fFaultCount = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setFaultCount(final Integer pFaultCount) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFaultCount = pFaultCount;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamFaultCountSecondHalf";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamFaultCountSecondHalfMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fFaultCount};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"faultCount\"=" + prettyPrintValue(fFaultCount));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fFaultCount == null) ? 0 : fFaultCount.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamFaultCountSecondHalfMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamFaultCountSecondHalfMatch other = (TeamFaultCountSecondHalfMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fFaultCount == null) {if (other.fFaultCount != null) return false;}
    else if (!fFaultCount.equals(other.fFaultCount)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamFaultCountSecondHalfMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamFaultCountSecondHalfMatch {
    Mutable(final Object pTeam, final Integer pFaultCount) {
      super(pTeam, pFaultCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamFaultCountSecondHalfMatch {
    Immutable(final Object pTeam, final Integer pFaultCount) {
      super(pTeam, pFaultCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
