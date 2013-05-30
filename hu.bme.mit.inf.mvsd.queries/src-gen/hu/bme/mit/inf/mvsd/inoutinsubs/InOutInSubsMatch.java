package hu.bme.mit.inf.mvsd.inoutinsubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.inOutInSubs pattern, 
 * to be used in conjunction with {@link InOutInSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InOutInSubsMatcher
 * @see InOutInSubsProcessor
 * 
 */
public abstract class InOutInSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fIn1;
  
  private Object fOut;
  
  private Object fIn2;
  
  private static String[] parameterNames = {"player", "in1", "out", "in2"};
  
  private InOutInSubsMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    this.fPlayer = pPlayer;
    this.fIn1 = pIn1;
    this.fOut = pOut;
    this.fIn2 = pIn2;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("in1".equals(parameterName)) return this.fIn1;
    if ("out".equals(parameterName)) return this.fOut;
    if ("in2".equals(parameterName)) return this.fIn2;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getIn1() {
    return this.fIn1;
    
  }
  
  public Object getOut() {
    return this.fOut;
    
  }
  
  public Object getIn2() {
    return this.fIn2;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("in1".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fIn1 = (java.lang.Object) newValue;
    	return true;
    }
    if ("out".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fOut = (java.lang.Object) newValue;
    	return true;
    }
    if ("in2".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fIn2 = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setIn1(final Object pIn1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fIn1 = pIn1;
    
  }
  
  public void setOut(final Object pOut) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOut = pOut;
    
  }
  
  public void setIn2(final Object pIn2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fIn2 = pIn2;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.inOutInSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return InOutInSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fIn1, fOut, fIn2};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"in1\"=" + prettyPrintValue(fIn1) + ", ");
    result.append("\"out\"=" + prettyPrintValue(fOut) + ", ");
    result.append("\"in2\"=" + prettyPrintValue(fIn2));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fIn1 == null) ? 0 : fIn1.hashCode()); 
    result = prime * result + ((fOut == null) ? 0 : fOut.hashCode()); 
    result = prime * result + ((fIn2 == null) ? 0 : fIn2.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InOutInSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InOutInSubsMatch other = (InOutInSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fIn1 == null) {if (other.fIn1 != null) return false;}
    else if (!fIn1.equals(other.fIn1)) return false;
    if (fOut == null) {if (other.fOut != null) return false;}
    else if (!fOut.equals(other.fOut)) return false;
    if (fIn2 == null) {if (other.fIn2 != null) return false;}
    else if (!fIn2.equals(other.fIn2)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return InOutInSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends InOutInSubsMatch {
    Mutable(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
      super(pPlayer, pIn1, pOut, pIn2);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends InOutInSubsMatch {
    Immutable(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
      super(pPlayer, pIn1, pOut, pIn2);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
