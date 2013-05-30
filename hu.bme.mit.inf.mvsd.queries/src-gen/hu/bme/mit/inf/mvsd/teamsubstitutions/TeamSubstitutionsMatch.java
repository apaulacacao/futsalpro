package hu.bme.mit.inf.mvsd.teamsubstitutions;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.TeamSubstitutions pattern, 
 * to be used in conjunction with {@link TeamSubstitutionsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TeamSubstitutionsMatcher
 * @see TeamSubstitutionsProcessor
 * 
 */
public abstract class TeamSubstitutionsMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Object fSubst;
  
  private static String[] parameterNames = {"team", "subst"};
  
  private TeamSubstitutionsMatch(final Object pTeam, final Object pSubst) {
    this.fTeam = pTeam;
    this.fSubst = pSubst;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("subst".equals(parameterName)) return this.fSubst;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Object getSubst() {
    return this.fSubst;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("subst".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fSubst = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setSubst(final Object pSubst) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubst = pSubst;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.TeamSubstitutions";
    
  }
  
  @Override
  public String[] parameterNames() {
    return TeamSubstitutionsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fSubst};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"subst\"=" + prettyPrintValue(fSubst));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fSubst == null) ? 0 : fSubst.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TeamSubstitutionsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TeamSubstitutionsMatch other = (TeamSubstitutionsMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fSubst == null) {if (other.fSubst != null) return false;}
    else if (!fSubst.equals(other.fSubst)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TeamSubstitutionsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends TeamSubstitutionsMatch {
    Mutable(final Object pTeam, final Object pSubst) {
      super(pTeam, pSubst);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends TeamSubstitutionsMatch {
    Immutable(final Object pTeam, final Object pSubst) {
      super(pTeam, pSubst);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
