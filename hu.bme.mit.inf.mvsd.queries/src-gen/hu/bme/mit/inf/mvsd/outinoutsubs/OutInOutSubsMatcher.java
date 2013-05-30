package hu.bme.mit.inf.mvsd.outinoutsubs;

import hu.bme.mit.inf.mvsd.outinoutsubs.OutInOutSubsMatch;
import hu.bme.mit.inf.mvsd.outinoutsubs.OutInOutSubsMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.outInOutSubs pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern outInOutSubs(player : Player, out1 : Substitution, in : Substitution, out2 : Substitution){
 * 	find outSubs(player, out1);
 * 	find inSubs(player, in);
 * 	find outSubs(player, out2);
 * 	Substitution.time(out1, outTime1);
 * 	Substitution.time(out2, outTime2);
 * 	Substitution.time(in, inTime);
 * 	check(outTime1 {@literal <} outTime2);
 * 	check(outTime1 {@literal <} inTime);
 * 	check(inTime {@literal <} outTime2);
 * }
 * </pre></code>
 * 
 * @see OutInOutSubsMatch
 * @see OutInOutSubsMatcherFactory
 * @see OutInOutSubsProcessor
 * 
 */
public class OutInOutSubsMatcher extends BaseGeneratedMatcher<OutInOutSubsMatch> {
  private final static int POSITION_PLAYER = 0;
  
  private final static int POSITION_OUT1 = 1;
  
  private final static int POSITION_IN = 2;
  
  private final static int POSITION_OUT2 = 3;
  
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
  public OutInOutSubsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OutInOutSubsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return matches represented as a OutInOutSubsMatch object.
   * 
   */
  public Collection<OutInOutSubsMatch> getAllMatches(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return rawGetAllMatches(new Object[]{pPlayer, pOut1, pIn, pOut2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return a match represented as a OutInOutSubsMatch object, or null if no match is found.
   * 
   */
  public OutInOutSubsMatch getOneArbitraryMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return rawGetOneArbitraryMatch(new Object[]{pPlayer, pOut1, pIn, pOut2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return rawHasMatch(new Object[]{pPlayer, pOut1, pIn, pOut2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return rawCountMatches(new Object[]{pPlayer, pOut1, pIn, pOut2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2, final IMatchProcessor<? super OutInOutSubsMatch> processor) {
    rawForEachMatch(new Object[]{pPlayer, pOut1, pIn, pOut2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2, final IMatchProcessor<? super OutInOutSubsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPlayer, pOut1, pIn, pOut2}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<OutInOutSubsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPlayer, pOut1, pIn, pOut2});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPlayer the fixed value of pattern parameter player, or null if not bound.
   * @param pOut1 the fixed value of pattern parameter out1, or null if not bound.
   * @param pIn the fixed value of pattern parameter in, or null if not bound.
   * @param pOut2 the fixed value of pattern parameter out2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OutInOutSubsMatch newMatch(final Object pPlayer, final Object pOut1, final Object pIn, final Object pOut2) {
    return new OutInOutSubsMatch.Immutable(pPlayer, pOut1, pIn, pOut2);
    
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
  public Set<Object> getAllValuesOfplayer(final OutInOutSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfplayer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for player.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfplayer(final Object pOut1, final Object pIn, final Object pOut2) {
    return rawAccumulateAllValuesOfplayer(new Object[]{null, pOut1, pIn, pOut2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for out1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfout1(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_OUT1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for out1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout1() {
    return rawAccumulateAllValuesOfout1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout1(final OutInOutSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfout1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout1(final Object pPlayer, final Object pIn, final Object pOut2) {
    return rawAccumulateAllValuesOfout1(new Object[]{pPlayer, null, pIn, pOut2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for in.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfin(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_IN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for in.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin() {
    return rawAccumulateAllValuesOfin(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin(final OutInOutSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfin(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for in.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfin(final Object pPlayer, final Object pOut1, final Object pOut2) {
    return rawAccumulateAllValuesOfin(new Object[]{pPlayer, pOut1, null, pOut2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for out2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfout2(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_OUT2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for out2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout2() {
    return rawAccumulateAllValuesOfout2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout2(final OutInOutSubsMatch partialMatch) {
    return rawAccumulateAllValuesOfout2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for out2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfout2(final Object pPlayer, final Object pOut1, final Object pIn) {
    return rawAccumulateAllValuesOfout2(new Object[]{pPlayer, pOut1, pIn, null});
  }
  
  @Override
  protected OutInOutSubsMatch tupleToMatch(final Tuple t) {
    try {
    	return new OutInOutSubsMatch.Immutable((java.lang.Object) t.get(POSITION_PLAYER), (java.lang.Object) t.get(POSITION_OUT1), (java.lang.Object) t.get(POSITION_IN), (java.lang.Object) t.get(POSITION_OUT2));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected OutInOutSubsMatch arrayToMatch(final Object[] match) {
    try {
    	return new OutInOutSubsMatch.Immutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_OUT1], (java.lang.Object) match[POSITION_IN], (java.lang.Object) match[POSITION_OUT2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected OutInOutSubsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new OutInOutSubsMatch.Mutable((java.lang.Object) match[POSITION_PLAYER], (java.lang.Object) match[POSITION_OUT1], (java.lang.Object) match[POSITION_IN], (java.lang.Object) match[POSITION_OUT2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<OutInOutSubsMatcher> factory() throws IncQueryException {
    return OutInOutSubsMatcherFactory.instance();
  }
}
