package hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.MatchTeamSubjectInconsistency pattern, 
 * to be used in conjunction with {@link MatchTeamSubjectInconsistencyMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MatchTeamSubjectInconsistencyMatcher
 * @see MatchTeamSubjectInconsistencyProcessor
 * 
 */
public abstract class MatchTeamSubjectInconsistencyMatch extends BasePatternMatch {
  private Object fMatch;
  
  private Object fTeam;
  
  private static String[] parameterNames = {"match", "team"};
  
  private MatchTeamSubjectInconsistencyMatch(final Object pMatch, final Object pTeam) {
    this.fMatch = pMatch;
    this.fTeam = pTeam;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("match".equals(parameterName)) return this.fMatch;
    if ("team".equals(parameterName)) return this.fTeam;
    return null;
    
  }
  
  public Object getMatch() {
    return this.fMatch;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("match".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fMatch = (java.lang.Object) newValue;
    	return true;
    }
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setMatch(final Object pMatch) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMatch = pMatch;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.MatchTeamSubjectInconsistency";
    
  }
  
  @Override
  public String[] parameterNames() {
    return MatchTeamSubjectInconsistencyMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMatch, fTeam};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"match\"=" + prettyPrintValue(fMatch) + ", ");
    result.append("\"team\"=" + prettyPrintValue(fTeam));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMatch == null) ? 0 : fMatch.hashCode()); 
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MatchTeamSubjectInconsistencyMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    MatchTeamSubjectInconsistencyMatch other = (MatchTeamSubjectInconsistencyMatch) obj;
    if (fMatch == null) {if (other.fMatch != null) return false;}
    else if (!fMatch.equals(other.fMatch)) return false;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return MatchTeamSubjectInconsistencyMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends MatchTeamSubjectInconsistencyMatch {
    Mutable(final Object pMatch, final Object pTeam) {
      super(pMatch, pTeam);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends MatchTeamSubjectInconsistencyMatch {
    Immutable(final Object pMatch, final Object pTeam) {
      super(pMatch, pTeam);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
