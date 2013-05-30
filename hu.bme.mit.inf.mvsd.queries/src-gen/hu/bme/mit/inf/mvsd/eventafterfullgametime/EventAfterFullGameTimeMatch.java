package hu.bme.mit.inf.mvsd.eventafterfullgametime;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.mvsd.EventAfterFullGameTime pattern, 
 * to be used in conjunction with {@link EventAfterFullGameTimeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventAfterFullGameTimeMatcher
 * @see EventAfterFullGameTimeProcessor
 * 
 */
public abstract class EventAfterFullGameTimeMatch extends BasePatternMatch {
  private Object fEvent;
  
  private static String[] parameterNames = {"event"};
  
  private EventAfterFullGameTimeMatch(final Object pEvent) {
    this.fEvent = pEvent;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("event".equals(parameterName)) return this.fEvent;
    return null;
    
  }
  
  public Object getEvent() {
    return this.fEvent;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("event".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fEvent = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEvent(final Object pEvent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEvent = pEvent;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.mvsd.EventAfterFullGameTime";
    
  }
  
  @Override
  public String[] parameterNames() {
    return EventAfterFullGameTimeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEvent};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"event\"=" + prettyPrintValue(fEvent));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEvent == null) ? 0 : fEvent.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventAfterFullGameTimeMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EventAfterFullGameTimeMatch other = (EventAfterFullGameTimeMatch) obj;
    if (fEvent == null) {if (other.fEvent != null) return false;}
    else if (!fEvent.equals(other.fEvent)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EventAfterFullGameTimeMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends EventAfterFullGameTimeMatch {
    Mutable(final Object pEvent) {
      super(pEvent);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends EventAfterFullGameTimeMatch {
    Immutable(final Object pEvent) {
      super(pEvent);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
