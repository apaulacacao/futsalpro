package hu.bme.mit.inf.mvsd.inoutinsubs;

import hu.bme.mit.inf.mvsd.inoutinsubs.InOutInSubsMatch;
import hu.bme.mit.inf.mvsd.inoutinsubs.InOutInSubsMatcherFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatcherFactory;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.inOutInSubs pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern inOutInSubs(player : Player, in1 : Substitution, out : Substitution, in2 : Substitution){
 * 	find inSubs(player, in1);
 * 	find outSubs(player, out);
 * 	find inSubs(player, in2);
 * 	Substitution.time(in1, inTime1);
 * 	Substitution.time(in2, inTime2);
 * 	Substitution.time(out, outTime);
 * 	check(inTime1 {@literal <} inTime2);
 * 	check(inTime1 {@literal <} outTime);
 * 	check(outTime {@literal <} inTime2);
 * }
 * </pre></code>
 * 
 * @see InOutInSubsMatch
 * @see InOutInSubsMatcherFactory
 * @see InOutInSubsProcessor
 * 
 */
public class InOutInSubsMatcher extends BaseGeneratedMatcher<InOutInSubsMatch> {
  private final static int POSITION_PLAYER = 0;
  
  private final static int POSITION_IN1 = 1;
  
  private final static int POSITION_OUT = 2;
  
  private final static int POSITION_IN2 = 3;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a lightweight reference is created.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public InOutInSubsMatcher(final Notifier emfRoot) throws IncQueryException {
    this(EngineManager.getInstance().getIncQueryEngine(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a lightweight reference is created.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public InOutInSubsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return matches represented as a InOutInSubsMatch object.
   * 
   */
  public Collection<InOutInSubsMatch> getAllMatches(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return rawGetAllMatches(new Object[]{pPlayer, pIn1, pOut, pIn2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return a match represented as a InOutInSubsMatch object, or null if no match is found.
   * 
   */
  public InOutInSubsMatch getOneArbitraryMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return rawGetOneArbitraryMatch(new Object[]{pPlayer, pIn1, pOut, pIn2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return rawHasMatch(new Object[]{pPlayer, pIn1, pOut, pIn2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return rawCountMatches(new Object[]{pPlayer, pIn1, pOut, pIn2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2, final IMatchProcessor<? super InOutInSubsMatch> processor) {
    rawForEachMatch(new Object[]{pPlayer, pIn1, pOut, pIn2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2, final IMatchProcessor<? super InOutInSubsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPlayer, pIn1, pOut, pIn2}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<InOutInSubsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPlayer, pIn1, pOut, pIn2});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pIn1 the fixed value of pattern parameter in1, or null if not bound.
   * @param pOut the fixed value of pattern parameter out, or null if not bound.
   * @param pIn2 the fixed value of pattern parameter in2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InOutInSubsMatch newMatch(final Object pPlayer, final Object pIn1, final Object pOut, final Object pIn2) {
    return new InOutInSubsMatch.Immutable(pPlayer, pIn1, pOut, pIn2);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfplayer(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_PLAYER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer() {
    return rawAccumulateAllValuesOfplayer(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer(final InOutInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfplayer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer(final Object pIn1, final Object pOut, final Object pIn2) {
    return rawAccumulateAllValuesOfplayer(new Object[]{null, pIn1, pOut, pIn2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for in1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfin1(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_IN1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for in1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin1() {
    return rawAccumulateAllValuesOfin1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin1(final InOutInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfin1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin1(final Object pPlayer, final Object pOut, final Object pIn2) {
    return rawAccumulateAllValuesOfin1(new Object[]{pPlayer, null, pOut, pIn2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for out.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfout(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_OUT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for out.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout() {
    return rawAccumulateAllValuesOfout(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout(final InOutInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfout(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout(final Object pPlayer, final Object pIn1, final Object pIn2) {
    return rawAccumulateAllValuesOfout(new Object[]{pPlayer, pIn1, null, pIn2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for in2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfin2(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_IN2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for in2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin2() {
    return rawAccumulateAllValuesOfin2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin2(final InOutInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfin2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin2(final Object pPlayer, final Object pIn1, final Object pOut) {
    return rawAccumulateAllValuesOfin2(new Object[]{pPlayer, pIn1, pOut, null});
  }
  
  @Override
  protected InOutInSubsMatch tupleToMatch(final Tuple t) {
    try {
    	return new InOutInSubsMatch.Immutable((java.lang.Object) t.get(POSITION_PLAYER), (java.lang.Object) t.get(POSITION_IN1), (java.lang.Object) t.get(POSITION_OUT), (java.lang.Object) t.get(POSITION_IN2));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected InOutInSubsMatch arrayToMatch(final Object[] match) {
    try {
    	return new InOutInSubsMatch.Immutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_IN1], (java.lang.Object) match[POSITION_OUT], (java.lang.Object) match[POSITION_IN2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected InOutInSubsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new InOutInSubsMatch.Mutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_IN1], (java.lang.Object) match[POSITION_OUT], (java.lang.Object) match[POSITION_IN2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<InOutInSubsMatcher> factory() throws IncQueryException {
    return InOutInSubsMatcherFactory.instance();
  }
}
