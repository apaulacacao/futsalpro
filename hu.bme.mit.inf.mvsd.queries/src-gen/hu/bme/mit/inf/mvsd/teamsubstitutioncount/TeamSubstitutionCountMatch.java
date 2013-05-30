package hu.bme.mit.inf.mvsd.teamsubstitutioncount;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamSubstitutionCount pattern, 
 * to be used in conjunction with {@link TeamSubstitutionCountMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamSubstitutionCountMatcher
 * @see TeamSubstitutionCountProcessor
 * 
 */
public abstract class TeamSubstitutionCountMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Integer fSubsCount;
  
  private static String[] parameterNames = {"team", "subsCount"};
  
  private TeamSubstitutionCountMatch(final Object pTeam, final Integer pSubsCount) {
    this.fTeam = pTeam;
    this.fSubsCount = pSubsCount;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("subsCount".equals(parameterName)) return this.fSubsCount;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Integer getSubsCount() {
    return this.fSubsCount;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("subsCount".equals(parameterName) ) {
    	this.fSubsCount = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setSubsCount(final Integer pSubsCount) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubsCount = pSubsCount;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamSubstitutionCount";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamSubstitutionCountMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fSubsCount};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"subsCount\"=" + prettyPrintValue(fSubsCount));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fSubsCount == null) ? 0 : fSubsCount.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamSubstitutionCountMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamSubstitutionCountMatch other = (TeamSubstitutionCountMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fSubsCount == null) {if (other.fSubsCount != null) return false;}
    else if (!fSubsCount.equals(other.fSubsCount)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamSubstitutionCountMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamSubstitutionCountMatch {
    Mutable(final Object pTeam, final Integer pSubsCount) {
      super(pTeam, pSubsCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamSubstitutionCountMatch {
    Immutable(final Object pTeam, final Integer pSubsCount) {
      super(pTeam, pSubsCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
