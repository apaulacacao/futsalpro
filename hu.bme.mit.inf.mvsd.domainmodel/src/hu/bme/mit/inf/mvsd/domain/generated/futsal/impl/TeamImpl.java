/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.impl;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getGoalKeeper <em>Goal Keeper</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getFieldPlayers <em>Field Players</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getSubtitutePlayers <em>Subtitute Players</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getSubtituteGoalKeepers <em>Subtitute Goal Keepers</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getCaptain <em>Captain</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getBench <em>Bench</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TeamImpl extends EObjectImpl implements Team {
	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected Match subject;

	/**
	 * The cached value of the '{@link #getGoalKeeper() <em>Goal Keeper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalKeeper()
	 * @generated
	 * @ordered
	 */
	protected GoalKeeper goalKeeper;

	/**
	 * The cached value of the '{@link #getFieldPlayers() <em>Field Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldPlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Player> fieldPlayers;

	/**
	 * The cached value of the '{@link #getSubtitutePlayers() <em>Subtitute Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtitutePlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Player> subtitutePlayers;

	/**
	 * The cached value of the '{@link #getSubtituteGoalKeepers() <em>Subtitute Goal Keepers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtituteGoalKeepers()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalKeeper> subtituteGoalKeepers;

	/**
	 * The cached value of the '{@link #getCaptain() <em>Captain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaptain()
	 * @generated
	 * @ordered
	 */
	protected Player captain;

	/**
	 * The cached value of the '{@link #getBench() <em>Bench</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBench()
	 * @generated
	 * @ordered
	 */
	protected EList<Crew> bench;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FutsalPackage.Literals.TEAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getSubject() {
		if (subject != null && subject.eIsProxy()) {
			InternalEObject oldSubject = (InternalEObject)subject;
			subject = (Match)eResolveProxy(oldSubject);
			if (subject != oldSubject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.TEAM__SUBJECT, oldSubject, subject));
			}
		}
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match basicGetSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(Match newSubject) {
		Match oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM__SUBJECT, oldSubject, subject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalKeeper getGoalKeeper() {
		return goalKeeper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoalKeeper(GoalKeeper newGoalKeeper, NotificationChain msgs) {
		GoalKeeper oldGoalKeeper = goalKeeper;
		goalKeeper = newGoalKeeper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM__GOAL_KEEPER, oldGoalKeeper, newGoalKeeper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoalKeeper(GoalKeeper newGoalKeeper) {
		if (newGoalKeeper != goalKeeper) {
			NotificationChain msgs = null;
			if (goalKeeper != null)
				msgs = ((InternalEObject)goalKeeper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.TEAM__GOAL_KEEPER, null, msgs);
			if (newGoalKeeper != null)
				msgs = ((InternalEObject)newGoalKeeper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.TEAM__GOAL_KEEPER, null, msgs);
			msgs = basicSetGoalKeeper(newGoalKeeper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM__GOAL_KEEPER, newGoalKeeper, newGoalKeeper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Player> getFieldPlayers() {
		if (fieldPlayers == null) {
			fieldPlayers = new EObjectContainmentEList<Player>(Player.class, this, FutsalPackage.TEAM__FIELD_PLAYERS);
		}
		return fieldPlayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Player> getSubtitutePlayers() {
		if (subtitutePlayers == null) {
			subtitutePlayers = new EObjectContainmentEList<Player>(Player.class, this, FutsalPackage.TEAM__SUBTITUTE_PLAYERS);
		}
		return subtitutePlayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalKeeper> getSubtituteGoalKeepers() {
		if (subtituteGoalKeepers == null) {
			subtituteGoalKeepers = new EObjectContainmentEList<GoalKeeper>(GoalKeeper.class, this, FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS);
		}
		return subtituteGoalKeepers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getCaptain() {
		if (captain != null && captain.eIsProxy()) {
			InternalEObject oldCaptain = (InternalEObject)captain;
			captain = (Player)eResolveProxy(oldCaptain);
			if (captain != oldCaptain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.TEAM__CAPTAIN, oldCaptain, captain));
			}
		}
		return captain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetCaptain() {
		return captain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaptain(Player newCaptain) {
		Player oldCaptain = captain;
		captain = newCaptain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM__CAPTAIN, oldCaptain, captain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Crew> getBench() {
		if (bench == null) {
			bench = new EObjectContainmentEList<Crew>(Crew.class, this, FutsalPackage.TEAM__BENCH);
		}
		return bench;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FutsalPackage.TEAM__GOAL_KEEPER:
				return basicSetGoalKeeper(null, msgs);
			case FutsalPackage.TEAM__FIELD_PLAYERS:
				return ((InternalEList<?>)getFieldPlayers()).basicRemove(otherEnd, msgs);
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
				return ((InternalEList<?>)getSubtitutePlayers()).basicRemove(otherEnd, msgs);
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
				return ((InternalEList<?>)getSubtituteGoalKeepers()).basicRemove(otherEnd, msgs);
			case FutsalPackage.TEAM__BENCH:
				return ((InternalEList<?>)getBench()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FutsalPackage.TEAM__SUBJECT:
				if (resolve) return getSubject();
				return basicGetSubject();
			case FutsalPackage.TEAM__GOAL_KEEPER:
				return getGoalKeeper();
			case FutsalPackage.TEAM__FIELD_PLAYERS:
				return getFieldPlayers();
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
				return getSubtitutePlayers();
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
				return getSubtituteGoalKeepers();
			case FutsalPackage.TEAM__CAPTAIN:
				if (resolve) return getCaptain();
				return basicGetCaptain();
			case FutsalPackage.TEAM__BENCH:
				return getBench();
			case FutsalPackage.TEAM__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FutsalPackage.TEAM__SUBJECT:
				setSubject((Match)newValue);
				return;
			case FutsalPackage.TEAM__GOAL_KEEPER:
				setGoalKeeper((GoalKeeper)newValue);
				return;
			case FutsalPackage.TEAM__FIELD_PLAYERS:
				getFieldPlayers().clear();
				getFieldPlayers().addAll((Collection<? extends Player>)newValue);
				return;
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
				getSubtitutePlayers().clear();
				getSubtitutePlayers().addAll((Collection<? extends Player>)newValue);
				return;
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
				getSubtituteGoalKeepers().clear();
				getSubtituteGoalKeepers().addAll((Collection<? extends GoalKeeper>)newValue);
				return;
			case FutsalPackage.TEAM__CAPTAIN:
				setCaptain((Player)newValue);
				return;
			case FutsalPackage.TEAM__BENCH:
				getBench().clear();
				getBench().addAll((Collection<? extends Crew>)newValue);
				return;
			case FutsalPackage.TEAM__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FutsalPackage.TEAM__SUBJECT:
				setSubject((Match)null);
				return;
			case FutsalPackage.TEAM__GOAL_KEEPER:
				setGoalKeeper((GoalKeeper)null);
				return;
			case FutsalPackage.TEAM__FIELD_PLAYERS:
				getFieldPlayers().clear();
				return;
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
				getSubtitutePlayers().clear();
				return;
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
				getSubtituteGoalKeepers().clear();
				return;
			case FutsalPackage.TEAM__CAPTAIN:
				setCaptain((Player)null);
				return;
			case FutsalPackage.TEAM__BENCH:
				getBench().clear();
				return;
			case FutsalPackage.TEAM__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FutsalPackage.TEAM__SUBJECT:
				return subject != null;
			case FutsalPackage.TEAM__GOAL_KEEPER:
				return goalKeeper != null;
			case FutsalPackage.TEAM__FIELD_PLAYERS:
				return fieldPlayers != null && !fieldPlayers.isEmpty();
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
				return subtitutePlayers != null && !subtitutePlayers.isEmpty();
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
				return subtituteGoalKeepers != null && !subtituteGoalKeepers.isEmpty();
			case FutsalPackage.TEAM__CAPTAIN:
				return captain != null;
			case FutsalPackage.TEAM__BENCH:
				return bench != null && !bench.isEmpty();
			case FutsalPackage.TEAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TeamImpl
