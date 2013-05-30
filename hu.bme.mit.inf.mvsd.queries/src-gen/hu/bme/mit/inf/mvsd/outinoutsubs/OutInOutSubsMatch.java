package hu.bme.mit.inf.mvsd.outinoutsubs;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.outInOutSubs pattern, 
 * to be used in conjunction with {@link OutInOutSubsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OutInOutSubsMatcher
 * @see OutInOutSubsProcessor
 * 
 */
public abstract class OutInOutSubsMatch extends BasePatternMatch {
  private Object fPlayer;
  
  private Object fOut1;
  
  private Object fIn;
  
  private Object fOut2;
  
  private static String[] parameterNames = {"player", "out1", "in", "out2"};
  
  private OutInOutSubsMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    this.fPlayer = pPlayer;
    this.fOut1 = pOut1;
    this.fIn = pIn;
    this.fOut2 = pOut2;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("player".equals(parameterName)) return this.fPlayer;
    if ("out1".equals(parameterName)) return this.fOut1;
    if ("in".equals(parameterName)) return this.fIn;
    if ("out2".equals(parameterName)) return this.fOut2;
    return null;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  public Object getOut1() {
    return this.fOut1;
    
  }
  
  public Object getIn() {
    return this.fIn;
    
  }
  
  public Object getOut2() {
    return this.fOut2;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    if ("out1".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fOut1 = (java.lang.Object) newValue;
    	return true;
    }
    if ("in".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fIn = (java.lang.Object) newValue;
    	return true;
    }
    if ("out2".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fOut2 = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  public void setOut1(final Object pOut1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOut1 = pOut1;
    
  }
  
  public void setIn(final Object pIn) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fIn = pIn;
    
  }
  
  public void setOut2(final Object pOut2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOut2 = pOut2;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.outInOutSubs";
    
  }
  
  @Override
  public String[] parameterNames() {
    return OutInOutSubsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPlayer, fOut1, fIn, fOut2};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"player\"=" + prettyPrintValue(fPlayer) + ", ");
    result.append("\"out1\"=" + prettyPrintValue(fOut1) + ", ");
    result.append("\"in\"=" + prettyPrintValue(fIn) + ", ");
    result.append("\"out2\"=" + prettyPrintValue(fOut2));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    result = prime * result + ((fOut1 == null) ? 0 : fOut1.hashCode()); 
    result = prime * result + ((fIn == null) ? 0 : fIn.hashCode()); 
    result = prime * result + ((fOut2 == null) ? 0 : fOut2.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OutInOutSubsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OutInOutSubsMatch other = (OutInOutSubsMatch) obj;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    if (fOut1 == null) {if (other.fOut1 != null) return false;}
    else if (!fOut1.equals(other.fOut1)) return false;
    if (fIn == null) {if (other.fIn != null) return false;}
    else if (!fIn.equals(other.fIn)) return false;
    if (fOut2 == null) {if (other.fOut2 != null) return false;}
    else if (!fOut2.equals(other.fOut2)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return OutInOutSubsMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends OutInOutSubsMatch {
    Mutable(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
      super(pPlayer, pOut1, pIn, pOut2);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends OutInOutSubsMatch {
    Immutable(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
      super(pPlayer, pOut1, pIn, pOut2);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
