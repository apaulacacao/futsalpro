package hu.bme.mit.inf.mvsd.insubsaftersubs;

import hu.bme.mit.inf.mvsd.insubsaftersubs.InSubsAfterSubsMatch;
import hu.bme.mit.inf.mvsd.insubsaftersubs.InSubsAfterSubsMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.inSubsAfterSubs pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern inSubsAfterSubs(player : Player, substitution : Substitution, afterSubs : Substitution){
 * 	find inSubs(player, substitution);
 * 	find inSubs(player, afterSubs);
 * 	Substitution.time(substitution, subsTime);
 * 	Substitution.time(afterSubs, time);
 * 	check(subsTime {@literal >} time);
 * } or {
 * 	find inSubs(player, substitution);
 * 	find outSubs(player, afterSubs);
 * 	Substitution.time(substitution, subsTime);
 * 	Substitution.time(afterSubs, time);
 * 	check(subsTime {@literal >} time);
 * }
 * </pre></code>
 * 
 * @see InSubsAfterSubsMatch
 * @see InSubsAfterSubsMatcherFactory
 * @see InSubsAfterSubsProcessor
 * 
 */
public class InSubsAfterSubsMatcher extends BaseGeneratedMatcher<InSubsAfterSubsMatch> {
  private final static int POSITION_PLAYER = 0;
  
  private final static int POSITION_SUBSTITUTION = 1;
  
  private final static int POSITION_AFTERSUBS = 2;
  
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
  public InSubsAfterSubsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InSubsAfterSubsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return matches represented as a InSubsAfterSubsMatch object.
   * 
   */
  public Collection<InSubsAfterSubsMatch> getAllMatches(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return rawGetAllMatches(new Object[]{pPlayer, pSubstitution, pAfterSubs});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return a match represented as a InSubsAfterSubsMatch object, or null if no match is found.
   * 
   */
  public InSubsAfterSubsMatch getOneArbitraryMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return rawGetOneArbitraryMatch(new Object[]{pPlayer, pSubstitution, pAfterSubs});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return rawHasMatch(new Object[]{pPlayer, pSubstitution, pAfterSubs});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return rawCountMatches(new Object[]{pPlayer, pSubstitution, pAfterSubs});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs, final IMatchProcessor<? super InSubsAfterSubsMatch> processor) {
    rawForEachMatch(new Object[]{pPlayer, pSubstitution, pAfterSubs}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs, final IMatchProcessor<? super InSubsAfterSubsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPlayer, pSubstitution, pAfterSubs}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<InSubsAfterSubsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPlayer, pSubstitution, pAfterSubs});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param pAfterSubs the fixed value of pattern parameter afterSubs, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InSubsAfterSubsMatch newMatch(final Object pPlayer, final Object pSubstitution, final Object pAfterSubs) {
    return new InSubsAfterSubsMatch.Immutable(pPlayer, pSubstitution, pAfterSubs);
    
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
  public Set<Object> getAllValuesOfplayer(final InSubsAfterSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfplayer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer(final Object pSubstitution, final Object pAfterSubs) {
    return rawAccumulateAllValuesOfplayer(new Object[]{null, pSubstitution, pAfterSubs});
  }
  
  /**
   * Retrieve the set of values that occur in matches for substitution.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfsubstitution(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_SUBSTITUTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for substitution.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfsubstitution() {
    return rawAccumulateAllValuesOfsubstitution(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for substitution.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfsubstitution(final InSubsAfterSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfsubstitution(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for substitution.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfsubstitution(final Object pPlayer, final Object pAfterSubs) {
    return rawAccumulateAllValuesOfsubstitution(new Object[]{pPlayer, null, pAfterSubs});
  }
  
  /**
   * Retrieve the set of values that occur in matches for afterSubs.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfafterSubs(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_AFTERSUBS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for afterSubs.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafterSubs() {
    return rawAccumulateAllValuesOfafterSubs(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for afterSubs.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafterSubs(final InSubsAfterSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfafterSubs(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for afterSubs.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfafterSubs(final Object pPlayer, final Object pSubstitution) {
    return rawAccumulateAllValuesOfafterSubs(new Object[]{pPlayer, pSubstitution, null});
  }
  
  @Override
  protected InSubsAfterSubsMatch tupleToMatch(final Tuple t) {
    try {
    	return new InSubsAfterSubsMatch.Immutable((java.lang.Object) t.get(POSITION_PLAYER), (java.lang.Object) t.get(POSITION_SUBSTITUTION), (java.lang.Object) t.get(POSITION_AFTERSUBS));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected InSubsAfterSubsMatch arrayToMatch(final Object[] match) {
    try {
    	return new InSubsAfterSubsMatch.Immutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_SUBSTITUTION], (java.lang.Object) match[POSITION_AFTERSUBS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected InSubsAfterSubsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new InSubsAfterSubsMatch.Mutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_SUBSTITUTION], (java.lang.Object) match[POSITION_AFTERSUBS]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<InSubsAfterSubsMatcher> factory() throws IncQueryException {
    return InSubsAfterSubsMatcherFactory.instance();
  }
}
