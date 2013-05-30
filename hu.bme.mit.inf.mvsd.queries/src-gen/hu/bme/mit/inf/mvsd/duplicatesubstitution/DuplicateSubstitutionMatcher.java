package hu.bme.mit.inf.mvsd.duplicatesubstitution;

import hu.bme.mit.inf.mvsd.duplicatesubstitution.DuplicateSubstitutionMatch;
import hu.bme.mit.inf.mvsd.duplicatesubstitution.DuplicateSubstitutionMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.DuplicateSubstitution pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * //pattern DuplicateSubstitution(substitution : Substitution) {
 * //	Substitution.substitute(substitution, player);
 * //	find invalidSubsCandidate(player, _, substitution);
 * //} or {
 * //	Substitution.instead(substitution, player);
 * //	find invalidSubsCandidate(player, _, substitution);
 * //}
 * 
 * pattern DuplicateSubstitution(substitution : Substitution) {
 * 	Substitution.substitute(substitution, player);
 * 	find inSubs(player, candidate);
 * 	neg find betweenInSubs(player, candidate, _, substitution);
 * 	find inOutInSubs(player, candidate, _, substitution);
 * } or {
 * 	Substitution.substitute(substitution, player);
 * 	find outSubs(player, candidate);
 * 	neg find betweenOutSubs(player, candidate, _, substitution);
 * 	find outInOutSubs(player, candidate, _, substitution);
 * }
 * </pre></code>
 * 
 * @see DuplicateSubstitutionMatch
 * @see DuplicateSubstitutionMatcherFactory
 * @see DuplicateSubstitutionProcessor
 * 
 */
public class DuplicateSubstitutionMatcher extends BaseGeneratedMatcher<DuplicateSubstitutionMatch> {
  private final static int POSITION_SUBSTITUTION = 0;
  
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
  public DuplicateSubstitutionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public DuplicateSubstitutionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return matches represented as a DuplicateSubstitutionMatch object.
   * 
   */
  public Collection<DuplicateSubstitutionMatch> getAllMatches(final Object pSubstitution) {
    return rawGetAllMatches(new Object[]{pSubstitution});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return a match represented as a DuplicateSubstitutionMatch object, or null if no match is found.
   * 
   */
  public DuplicateSubstitutionMatch getOneArbitraryMatch(final Object pSubstitution) {
    return rawGetOneArbitraryMatch(new Object[]{pSubstitution});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pSubstitution) {
    return rawHasMatch(new Object[]{pSubstitution});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pSubstitution) {
    return rawCountMatches(new Object[]{pSubstitution});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pSubstitution, final IMatchProcessor<? super DuplicateSubstitutionMatch> processor) {
    rawForEachMatch(new Object[]{pSubstitution}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pSubstitution, final IMatchProcessor<? super DuplicateSubstitutionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSubstitution}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<DuplicateSubstitutionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pSubstitution) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSubstitution});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubstitution the fixed value of pattern parameter substitution, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public DuplicateSubstitutionMatch newMatch(final Object pSubstitution) {
    return new DuplicateSubstitutionMatch.Immutable(pSubstitution);
    
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
  
  @Override
  protected DuplicateSubstitutionMatch tupleToMatch(final Tuple t) {
    try {
    	return new DuplicateSubstitutionMatch.Immutable((java.lang.Object) t.get(POSITION_SUBSTITUTION));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected DuplicateSubstitutionMatch arrayToMatch(final Object[] match) {
    try {
    	return new DuplicateSubstitutionMatch.Immutable((java.lang.Object) match[POSITION_SUBSTITUTION]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected DuplicateSubstitutionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new DuplicateSubstitutionMatch.Mutable((java.lang.Object) match[POSITION_SUBSTITUTION]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<DuplicateSubstitutionMatcher> factory() throws IncQueryException {
    return DuplicateSubstitutionMatcherFactory.instance();
  }
}
