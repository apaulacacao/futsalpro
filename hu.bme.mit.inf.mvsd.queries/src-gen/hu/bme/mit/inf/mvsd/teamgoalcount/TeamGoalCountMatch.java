package hu.bme.mit.inf.mvsd.teamgoalcount;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamGoalCount pattern, 
 * to be used in conjunction with {@link TeamGoalCountMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamGoalCountMatcher
 * @see TeamGoalCountProcessor
 * 
 */
public abstract class TeamGoalCountMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Integer fGoalCount;
  
  private static String[] parameterNames = {"team", "goalCount"};
  
  private TeamGoalCountMatch(final Object pTeam, final Integer pGoalCount) {
    this.fTeam = pTeam;
    this.fGoalCount = pGoalCount;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("goalCount".equals(parameterName)) return this.fGoalCount;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Integer getGoalCount() {
    return this.fGoalCount;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("goalCount".equals(parameterName) ) {
    	this.fGoalCount = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setGoalCount(final Integer pGoalCount) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGoalCount = pGoalCount;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalCount";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamGoalCountMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fGoalCount};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"goalCount\"=" + prettyPrintValue(fGoalCount));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fGoalCount == null) ? 0 : fGoalCount.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamGoalCountMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamGoalCountMatch other = (TeamGoalCountMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fGoalCount == null) {if (other.fGoalCount != null) return false;}
    else if (!fGoalCount.equals(other.fGoalCount)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamGoalCountMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamGoalCountMatch {
    Mutable(final Object pTeam, final Integer pGoalCount) {
      super(pTeam, pGoalCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamGoalCountMatch {
    Immutable(final Object pTeam, final Integer pGoalCount) {
      super(pTeam, pGoalCount);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
