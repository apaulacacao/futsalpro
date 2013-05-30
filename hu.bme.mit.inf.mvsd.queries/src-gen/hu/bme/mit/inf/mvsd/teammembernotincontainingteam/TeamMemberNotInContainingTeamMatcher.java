package hu.bme.mit.inf.mvsd.teammembernotincontainingteam;

import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatch;
import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatcherFactory;
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
 * Generated pattern matcher API of the hu.bme.mit.inf.mvsd.TeamMemberNotInContainingTeam pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Constraint(message="The team member is not assigned to the containing team", location=member, severity="error")
 * pattern TeamMemberNotInContainingTeam(member: TeamMember){
 * 	Team.bench(team, member);
 * 	TeamMember.team(member, otherTeam);
 * 	team != otherTeam;
 * } or {
 * 	Team.goalKeeper(team, member);
 * 	TeamMember.team(member, otherTeam);
 * 	team != otherTeam;
 * } or {
 * 	Team.fieldPlayers(team, member);
 * 	TeamMember.team(member, otherTeam);
 * 	team != otherTeam;
 * } or {
 * 	Team.subtitutePlayers(team, member);
 * 	TeamMember.team(member, otherTeam);
 * 	team != otherTeam;
 * } or {
 * 	Team.subtituteGoalKeepers(team, member);
 * 	TeamMember.team(member, otherTeam);
 * 	team != otherTeam;
 * }
 * </pre></code>
 * 
 * @see TeamMemberNotInContainingTeamMatch
 * @see TeamMemberNotInContainingTeamMatcherFactory
 * @see TeamMemberNotInContainingTeamProcessor
 * 
 */
public class TeamMemberNotInContainingTeamMatcher extends BaseGeneratedMatcher<TeamMemberNotInContainingTeamMatch> {
  private final static int POSITION_MEMBER = 0;
  
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
  public TeamMemberNotInContainingTeamMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TeamMemberNotInContainingTeamMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, factory());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return matches represented as a TeamMemberNotInContainingTeamMatch object.
   * 
   */
  public Collection<TeamMemberNotInContainingTeamMatch> getAllMatches(final Object pMember) {
    return rawGetAllMatches(new Object[]{pMember});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return a match represented as a TeamMemberNotInContainingTeamMatch object, or null if no match is found.
   * 
   */
  public TeamMemberNotInContainingTeamMatch getOneArbitraryMatch(final Object pMember) {
    return rawGetOneArbitraryMatch(new Object[]{pMember});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pMember) {
    return rawHasMatch(new Object[]{pMember});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pMember) {
    return rawCountMatches(new Object[]{pMember});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pMember, final IMatchProcessor<? super TeamMemberNotInContainingTeamMatch> processor) {
    rawForEachMatch(new Object[]{pMember}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pMember, final IMatchProcessor<? super TeamMemberNotInContainingTeamMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMember}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the delta monitor.
   * 
   */
  public DeltaMonitor<TeamMemberNotInContainingTeamMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Object pMember) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pMember});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TeamMemberNotInContainingTeamMatch newMatch(final Object pMember) {
    return new TeamMemberNotInContainingTeamMatch.Immutable(pMember);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfmember(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_MEMBER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfmember() {
    return rawAccumulateAllValuesOfmember(emptyArray());
  }
  
  @Override
  protected TeamMemberNotInContainingTeamMatch tupleToMatch(final Tuple t) {
    try {
    	return new TeamMemberNotInContainingTeamMatch.Immutable((java.lang.Object) t.get(POSITION_MEMBER));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TeamMemberNotInContainingTeamMatch arrayToMatch(final Object[] match) {
    try {
    	return new TeamMemberNotInContainingTeamMatch.Immutable((java.lang.Object) match[POSITION_MEMBER]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TeamMemberNotInContainingTeamMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new TeamMemberNotInContainingTeamMatch.Mutable((java.lang.Object) match[POSITION_MEMBER]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the factory of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IMatcherFactory<TeamMemberNotInContainingTeamMatcher> factory() throws IncQueryException {
    return TeamMemberNotInContainingTeamMatcherFactory.instance();
  }
}
