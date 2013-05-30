package hu.bme.mit.inf.mvsd.allplayers;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.allPlayers pattern, 
 * to be used in conjunction with {@link AllPlayersMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AllPlayersMatcher
 * @see AllPlayersProcessor
 * 
 */
public abstract class AllPlayersMatch extends BasePatternMatch {
  private Object fTeam;
  
  private Object fPlayer;
  
  private static String[] parameterNames = {"team", "player"};
  
  private AllPlayersMatch(final Object pTeam, final Object pPlayer) {
    this.fTeam = pTeam;
    this.fPlayer = pPlayer;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("team".equals(parameterName)) return this.fTeam;
    if ("player".equals(parameterName)) return this.fPlayer;
    return null;
    
  }
  
  public Object getTeam() {
    return this.fTeam;
    
  }
  
  public Object getPlayer() {
    return this.fPlayer;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("team".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fTeam = (java.lang.Object) newValue;
    	return true;
    }
    if ("player".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fPlayer = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setTeam(final Object pTeam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTeam = pTeam;
    
  }
  
  public void setPlayer(final Object pPlayer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPlayer = pPlayer;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.allPlayers";
    
  }
  
  @Override
  public String[] parameterNames() {
    return AllPlayersMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTeam, fPlayer};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"team\"=" + prettyPrintValue(fTeam) + ", ");
    result.append("\"player\"=" + prettyPrintValue(fPlayer));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTeam == null) ? 0 : fTeam.hashCode()); 
    result = prime * result + ((fPlayer == null) ? 0 : fPlayer.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AllPlayersMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AllPlayersMatch other = (AllPlayersMatch) obj;
    if (fTeam == null) {if (other.fTeam != null) return false;}
    else if (!fTeam.equals(other.fTeam)) return false;
    if (fPlayer == null) {if (other.fPlayer != null) return false;}
    else if (!fPlayer.equals(other.fPlayer)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return AllPlayersMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends AllPlayersMatch {
    Mutable(final Object pTeam, final Object pPlayer) {
      super(pTeam, pPlayer);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends AllPlayersMatch {
    Immutable(final Object pTeam, final Object pPlayer) {
      super(pTeam, pPlayer);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
