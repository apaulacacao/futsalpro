package hu.bme.mit.inf.mvsd.betweeninsubs;

import hu.bme.mit.inf.mvsd.betweeninsubs.BetweenInSubsMatch;
import hu.bme.mit.inf.mvsd.betweeninsubs.BetweenInSubsMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.betweenInSubs pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern betweenInSubs(player : Player, before : Substitution, mid : Substitution, after : Substitution) {
 * 	find inSubs(player, before);
 * 	find inSubs(player, mid);
 * 	find inSubs(player, after);
 * 	Substitution.time(before, befTime);
 * 	Substitution.time(mid, midTime);
 * 	Substitution.time(after, aftTime);
 * 	check(befTime {@literal <} midTime);
 * 	check(midTime {@literal <} aftTime);
 * 	check(befTime {@literal <} aftTime);
 * }
 * </pre></code>
 * 
 * @see BetweenInSubsMatch
 * @see BetweenInSubsMatcherFactory
 * @see BetweenInSubsProcessor
 * 
 */
public class BetweenInSubsMatcher extends BaseGeneratedMatcher<BetweenInSubsMatch> {
  private final static int POSITION_PLAYER = 0;
  
  private final static int POSITION_BEFORE = 1;
  
  private final static int POSITION_MID = 2;
  
  private final static int POSITION_AFTER = 3;
  
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
  public BetweenInSubsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BetweenInSubsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return matches represented as a BetweenInSubsMatch object.
   * 
   */
  public Collection<BetweenInSubsMatch> getAllMatches(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return rawGetAllMatches(new Object[]{pPlayer, pBefore, pMid, pAfter});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return a match represented as a BetweenInSubsMatch object, or null if no match is found.
   * 
   */
  public BetweenInSubsMatch getOneArbitraryMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return rawGetOneArbitraryMatch(new Object[]{pPlayer, pBefore, pMid, pAfter});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return rawHasMatch(new Object[]{pPlayer, pBefore, pMid, pAfter});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return rawCountMatches(new Object[]{pPlayer, pBefore, pMid, pAfter});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter, final IMatchProcessor<? super BetweenInSubsMatch> processor) {
    rawForEachMatch(new Object[]{pPlayer, pBefore, pMid, pAfter}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter, final IMatchProcessor<? super BetweenInSubsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPlayer, pBefore, pMid, pAfter}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<BetweenInSubsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPlayer, pBefore, pMid, pAfter});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pBefore the fixed value of pattern parameter before, or null if not bound.
   * @param pMid the fixed value of pattern parameter mid, or null if not bound.
   * @param pAfter the fixed value of pattern parameter after, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BetweenInSubsMatch newMatch(final Object pPlayer, final Object pBefore, final Object pMid, final Object pAfter) {
    return new BetweenInSubsMatch.Immutable(pPlayer, pBefore, pMid, pAfter);
    
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
  public Set<Object> getAllValuesOfplayer(final BetweenInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfplayer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer(final Object pBefore, final Object pMid, final Object pAfter) {
    return rawAccumulateAllValuesOfplayer(new Object[]{null, pBefore, pMid, pAfter});
  }
  
  /**
   * Retrieve the set of values that occur in matches for before.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfbefore(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_BEFORE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for before.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfbefore() {
    return rawAccumulateAllValuesOfbefore(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for before.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfbefore(final BetweenInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfbefore(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for before.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfbefore(final Object pPlayer, final Object pMid, final Object pAfter) {
    return rawAccumulateAllValuesOfbefore(new Object[]{pPlayer, null, pMid, pAfter});
  }
  
  /**
   * Retrieve the set of values that occur in matches for mid.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfmid(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_MID, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for mid.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfmid() {
    return rawAccumulateAllValuesOfmid(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mid.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfmid(final BetweenInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfmid(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for mid.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfmid(final Object pPlayer, final Object pBefore, final Object pAfter) {
    return rawAccumulateAllValuesOfmid(new Object[]{pPlayer, pBefore, null, pAfter});
  }
  
  /**
   * Retrieve the set of values that occur in matches for after.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfafter(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_AFTER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for after.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafter() {
    return rawAccumulateAllValuesOfafter(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for after.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafter(final BetweenInSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfafter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for after.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafter(final Object pPlayer, final Object pBefore, final Object pMid) {
    return rawAccumulateAllValuesOfafter(new Object[]{pPlayer, pBefore, pMid, null});
  }
  
  @Override
  protected BetweenInSubsMatch tupleToMatch(final Tuple t) {
    try {
    	return new BetweenInSubsMatch.Immutable((java.lang.Object) t.get(POSITION_PLAYER), (java.lang.Object) t.get(POSITION_BEFORE), (java.lang.Object) t.get(POSITION_MID), (java.lang.Object) t.get(POSITION_AFTER));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BetweenInSubsMatch arrayToMatch(final Object[] match) {
    try {
    	return new BetweenInSubsMatch.Immutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_BEFORE], (java.lang.Object) match[POSITION_MID], (java.lang.Object) match[POSITION_AFTER]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected BetweenInSubsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new BetweenInSubsMatch.Mutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_BEFORE], (java.lang.Object) match[POSITION_MID], (java.lang.Object) match[POSITION_AFTER]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<BetweenInSubsMatcher> factory() throws IncQueryException {
    return BetweenInSubsMatcherFactory.instance();
  }
}
