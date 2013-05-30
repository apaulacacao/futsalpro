package hu.bme.mit.inf.mvsd.teamgoalsinitialtime;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamGoalsInitialTime pattern, 
 * to be used in conjunction with {@link TeamGoalsInitialTimeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamGoalsInitialTimeMatcher
 * @see TeamGoalsInitialTimeProcessor
 * 
 */
public abstract class TeamGoalsInitialTimeMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Object fGoal;
  
  private static String[] parameterNames = {"team", "goal"};
  
  private TeamGoalsInitialTimeMatch(final Object pTeam, final Object pGoal) {
    this.fTeam = pTeam;
    this.fGoal = pGoal;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("goal".equals(parameterName)) return this.fGoal;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Object getGoal() {
    return this.fGoal;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("goal".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fGoal = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setGoal(final Object pGoal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGoal = pGoal;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamGoalsInitialTime";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamGoalsInitialTimeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fGoal};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"goal\"=" + prettyPrintValue(fGoal));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fGoal == null) ? 0 : fGoal.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamGoalsInitialTimeMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamGoalsInitialTimeMatch other = (TeamGoalsInitialTimeMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fGoal == null) {if (other.fGoal != null) return false;}
    else if (!fGoal.equals(other.fGoal)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamGoalsInitialTimeMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamGoalsInitialTimeMatch {
    Mutable(final Object pTeam, final Object pGoal) {
      super(pTeam, pGoal);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamGoalsInitialTimeMatch {
    Immutable(final Object pTeam, final Object pGoal) {
      super(pTeam, pGoal);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
