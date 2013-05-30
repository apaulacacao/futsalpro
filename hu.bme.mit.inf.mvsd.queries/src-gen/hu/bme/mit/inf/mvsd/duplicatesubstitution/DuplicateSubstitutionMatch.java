package hu.bme.mit.inf.mvsd.duplicatesubstitution;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.DuplicateSubstitution pattern, 
 * to be used in conjunction with {@link DuplicateSubstitutionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DuplicateSubstitutionMatcher
 * @see DuplicateSubstitutionProcessor
 * 
 */
public abstract class DuplicateSubstitutionMatch extends BasePatternMatch {
  private Object fSubstitution;
  
  private static String[] parameterNames = {"substitution"};
  
  private DuplicateSubstitutionMatch(final Object pSubstitution) {
    this.fSubstitution = pSubstitution;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("substitution".equals(parameterName)) return this.fSubstitution;
    return null;
    
  }
  
  public Object getSubstitution() {
    return this.fSubstitution;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("substitution".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fSubstitution = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSubstitution(final Object pSubstitution) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubstitution = pSubstitution;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.DuplicateSubstitution";
    
  }
  
  @Override
  public String[] parameterNames() {
    return DuplicateSubstitutionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSubstitution};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"substitution\"=" + prettyPrintValue(fSubstitution));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubstitution == null) ? 0 : fSubstitution.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DuplicateSubstitutionMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    DuplicateSubstitutionMatch other = (DuplicateSubstitutionMatch) obj;
    if (fSubstitution == null) {if (other.fSubstitution != null) return false;}
    else if (!fSubstitution.equals(other.fSubstitution)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return DuplicateSubstitutionMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends DuplicateSubstitutionMatch {
    Mutable(final Object pSubstitution) {
      super(pSubstitution);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends DuplicateSubstitutionMatch {
    Immutable(final Object pSubstitution) {
      super(pSubstitution);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
