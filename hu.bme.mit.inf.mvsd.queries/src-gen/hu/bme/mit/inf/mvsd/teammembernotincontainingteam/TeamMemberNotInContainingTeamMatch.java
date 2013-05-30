package hu.bme.mit.inf.mvsd.teammembernotincontainingteam;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamMemberNotInContainingTeam pattern, 
 * to be used in conjunction with {@link TeamMemberNotInContainingTeamMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamMemberNotInContainingTeamMatcher
 * @see TeamMemberNotInContainingTeamProcessor
 * 
 */
public abstract class TeamMemberNotInContainingTeamMatch extends BasePatternMatch {
  private Object fMember;
  
  private static String[] parameterNames = {"member"};
  
  private TeamMemberNotInContainingTeamMatch(final Object pMember) {
    this.fMember = pMember;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("member".equals(parameterName)) return this.fMember;
    return null;
    
  }
  
  public Object getMember() {
    return this.fMember;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("member".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fMember = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setMember(final Object pMember) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMember = pMember;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamMemberNotInContainingTeam";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamMemberNotInContainingTeamMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMember};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"member\"=" + prettyPrintValue(fMember));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMember == null) ? 0 : fMember.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamMemberNotInContainingTeamMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamMemberNotInContainingTeamMatch other = (TeamMemberNotInContainingTeamMatch) obj;
    if (fMember == null) {if (other.fMember != null) return false;}
    else if (!fMember.equals(other.fMember)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamMemberNotInContainingTeamMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamMemberNotInContainingTeamMatch {
    Mutable(final Object pMember) {
      super(pMember);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamMemberNotInContainingTeamMatch {
    Immutable(final Object pMember) {
      super(pMember);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
