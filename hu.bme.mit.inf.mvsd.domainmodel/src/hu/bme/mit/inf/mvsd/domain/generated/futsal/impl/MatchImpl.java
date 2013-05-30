/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.impl;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Event;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.Collection;
import java.util.Date;

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
 * An implementation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getDate <em>Date</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getTeam1 <em>Team1</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getTeam2 <em>Team2</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getReferee1 <em>Referee1</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getReferee2 <em>Referee2</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getReferee3 <em>Referee3</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getSupervisor <em>Supervisor</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getLastEvent <em>Last Event</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getChanmpionship <em>Chanmpionship</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getRound <em>Round</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getSection <em>Section</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getAgeGroup <em>Age Group</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getSeason <em>Season</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchImpl extends EObjectImpl implements Match {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTeam1() <em>Team1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam1()
	 * @generated
	 * @ordered
	 */
	protected Team team1;

	/**
	 * The cached value of the '{@link #getTeam2() <em>Team2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam2()
	 * @generated
	 * @ordered
	 */
	protected Team team2;

	/**
	 * The cached value of the '{@link #getReferee1() <em>Referee1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferee1()
	 * @generated
	 * @ordered
	 */
	protected Referee referee1;

	/**
	 * The cached value of the '{@link #getReferee2() <em>Referee2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferee2()
	 * @generated
	 * @ordered
	 */
	protected Referee referee2;

	/**
	 * The cached value of the '{@link #getReferee3() <em>Referee3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferee3()
	 * @generated
	 * @ordered
	 */
	protected Referee referee3;

	/**
	 * The cached value of the '{@link #getSupervisor() <em>Supervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupervisor()
	 * @generated
	 * @ordered
	 */
	protected Supervisor supervisor;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Pitch location;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getFirstEvent() <em>First Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstEvent()
	 * @generated
	 * @ordered
	 */
	protected Event firstEvent;

	/**
	 * The cached value of the '{@link #getLastEvent() <em>Last Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastEvent()
	 * @generated
	 * @ordered
	 */
	protected Event lastEvent;

	/**
	 * The default value of the '{@link #getChanmpionship() <em>Chanmpionship</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChanmpionship()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANMPIONSHIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChanmpionship() <em>Chanmpionship</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChanmpionship()
	 * @generated
	 * @ordered
	 */
	protected String chanmpionship = CHANMPIONSHIP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRound() <em>Round</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRound()
	 * @generated
	 * @ordered
	 */
	protected static final int ROUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRound() <em>Round</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRound()
	 * @generated
	 * @ordered
	 */
	protected int round = ROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected static final String SECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected String section = SECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgeGroup() <em>Age Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgeGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String AGE_GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgeGroup() <em>Age Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgeGroup()
	 * @generated
	 * @ordered
	 */
	protected String ageGroup = AGE_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeason() <em>Season</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeason()
	 * @generated
	 * @ordered
	 */
	protected static final String SEASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeason() <em>Season</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeason()
	 * @generated
	 * @ordered
	 */
	protected String season = SEASON_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected int code = CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FutsalPackage.Literals.MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTeam1(Team newTeam1, NotificationChain msgs) {
		Team oldTeam1 = team1;
		team1 = newTeam1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__TEAM1, oldTeam1, newTeam1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam1(Team newTeam1) {
		if (newTeam1 != team1) {
			NotificationChain msgs = null;
			if (team1 != null)
				msgs = ((InternalEObject)team1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__TEAM1, null, msgs);
			if (newTeam1 != null)
				msgs = ((InternalEObject)newTeam1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__TEAM1, null, msgs);
			msgs = basicSetTeam1(newTeam1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__TEAM1, newTeam1, newTeam1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTeam2(Team newTeam2, NotificationChain msgs) {
		Team oldTeam2 = team2;
		team2 = newTeam2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__TEAM2, oldTeam2, newTeam2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam2(Team newTeam2) {
		if (newTeam2 != team2) {
			NotificationChain msgs = null;
			if (team2 != null)
				msgs = ((InternalEObject)team2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__TEAM2, null, msgs);
			if (newTeam2 != null)
				msgs = ((InternalEObject)newTeam2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__TEAM2, null, msgs);
			msgs = basicSetTeam2(newTeam2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__TEAM2, newTeam2, newTeam2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referee getReferee1() {
		return referee1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferee1(Referee newReferee1, NotificationChain msgs) {
		Referee oldReferee1 = referee1;
		referee1 = newReferee1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE1, oldReferee1, newReferee1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferee1(Referee newReferee1) {
		if (newReferee1 != referee1) {
			NotificationChain msgs = null;
			if (referee1 != null)
				msgs = ((InternalEObject)referee1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE1, null, msgs);
			if (newReferee1 != null)
				msgs = ((InternalEObject)newReferee1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE1, null, msgs);
			msgs = basicSetReferee1(newReferee1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE1, newReferee1, newReferee1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referee getReferee2() {
		return referee2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferee2(Referee newReferee2, NotificationChain msgs) {
		Referee oldReferee2 = referee2;
		referee2 = newReferee2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE2, oldReferee2, newReferee2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferee2(Referee newReferee2) {
		if (newReferee2 != referee2) {
			NotificationChain msgs = null;
			if (referee2 != null)
				msgs = ((InternalEObject)referee2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE2, null, msgs);
			if (newReferee2 != null)
				msgs = ((InternalEObject)newReferee2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE2, null, msgs);
			msgs = basicSetReferee2(newReferee2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE2, newReferee2, newReferee2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referee getReferee3() {
		return referee3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferee3(Referee newReferee3, NotificationChain msgs) {
		Referee oldReferee3 = referee3;
		referee3 = newReferee3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE3, oldReferee3, newReferee3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferee3(Referee newReferee3) {
		if (newReferee3 != referee3) {
			NotificationChain msgs = null;
			if (referee3 != null)
				msgs = ((InternalEObject)referee3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE3, null, msgs);
			if (newReferee3 != null)
				msgs = ((InternalEObject)newReferee3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__REFEREE3, null, msgs);
			msgs = basicSetReferee3(newReferee3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__REFEREE3, newReferee3, newReferee3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supervisor getSupervisor() {
		return supervisor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupervisor(Supervisor newSupervisor, NotificationChain msgs) {
		Supervisor oldSupervisor = supervisor;
		supervisor = newSupervisor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__SUPERVISOR, oldSupervisor, newSupervisor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupervisor(Supervisor newSupervisor) {
		if (newSupervisor != supervisor) {
			NotificationChain msgs = null;
			if (supervisor != null)
				msgs = ((InternalEObject)supervisor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__SUPERVISOR, null, msgs);
			if (newSupervisor != null)
				msgs = ((InternalEObject)newSupervisor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__SUPERVISOR, null, msgs);
			msgs = basicSetSupervisor(newSupervisor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__SUPERVISOR, newSupervisor, newSupervisor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pitch getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Pitch newLocation, NotificationChain msgs) {
		Pitch oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Pitch newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FutsalPackage.MATCH__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<Event>(Event.class, this, FutsalPackage.MATCH__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getFirstEvent() {
		if (firstEvent != null && firstEvent.eIsProxy()) {
			InternalEObject oldFirstEvent = (InternalEObject)firstEvent;
			firstEvent = (Event)eResolveProxy(oldFirstEvent);
			if (firstEvent != oldFirstEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.MATCH__FIRST_EVENT, oldFirstEvent, firstEvent));
			}
		}
		return firstEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetFirstEvent() {
		return firstEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstEvent(Event newFirstEvent) {
		Event oldFirstEvent = firstEvent;
		firstEvent = newFirstEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__FIRST_EVENT, oldFirstEvent, firstEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getLastEvent() {
		if (lastEvent != null && lastEvent.eIsProxy()) {
			InternalEObject oldLastEvent = (InternalEObject)lastEvent;
			lastEvent = (Event)eResolveProxy(oldLastEvent);
			if (lastEvent != oldLastEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.MATCH__LAST_EVENT, oldLastEvent, lastEvent));
			}
		}
		return lastEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetLastEvent() {
		return lastEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastEvent(Event newLastEvent) {
		Event oldLastEvent = lastEvent;
		lastEvent = newLastEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__LAST_EVENT, oldLastEvent, lastEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChanmpionship() {
		return chanmpionship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChanmpionship(String newChanmpionship) {
		String oldChanmpionship = chanmpionship;
		chanmpionship = newChanmpionship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__CHANMPIONSHIP, oldChanmpionship, chanmpionship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRound() {
		return round;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRound(int newRound) {
		int oldRound = round;
		round = newRound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__ROUND, oldRound, round));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSection() {
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(String newSection) {
		String oldSection = section;
		section = newSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__SECTION, oldSection, section));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgeGroup() {
		return ageGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgeGroup(String newAgeGroup) {
		String oldAgeGroup = ageGroup;
		ageGroup = newAgeGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__AGE_GROUP, oldAgeGroup, ageGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeason() {
		return season;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeason(String newSeason) {
		String oldSeason = season;
		season = newSeason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__SEASON, oldSeason, season));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(int newCode) {
		int oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.MATCH__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FutsalPackage.MATCH__TEAM1:
				return basicSetTeam1(null, msgs);
			case FutsalPackage.MATCH__TEAM2:
				return basicSetTeam2(null, msgs);
			case FutsalPackage.MATCH__REFEREE1:
				return basicSetReferee1(null, msgs);
			case FutsalPackage.MATCH__REFEREE2:
				return basicSetReferee2(null, msgs);
			case FutsalPackage.MATCH__REFEREE3:
				return basicSetReferee3(null, msgs);
			case FutsalPackage.MATCH__SUPERVISOR:
				return basicSetSupervisor(null, msgs);
			case FutsalPackage.MATCH__LOCATION:
				return basicSetLocation(null, msgs);
			case FutsalPackage.MATCH__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
			case FutsalPackage.MATCH__DATE:
				return getDate();
			case FutsalPackage.MATCH__TEAM1:
				return getTeam1();
			case FutsalPackage.MATCH__TEAM2:
				return getTeam2();
			case FutsalPackage.MATCH__REFEREE1:
				return getReferee1();
			case FutsalPackage.MATCH__REFEREE2:
				return getReferee2();
			case FutsalPackage.MATCH__REFEREE3:
				return getReferee3();
			case FutsalPackage.MATCH__SUPERVISOR:
				return getSupervisor();
			case FutsalPackage.MATCH__LOCATION:
				return getLocation();
			case FutsalPackage.MATCH__EVENTS:
				return getEvents();
			case FutsalPackage.MATCH__FIRST_EVENT:
				if (resolve) return getFirstEvent();
				return basicGetFirstEvent();
			case FutsalPackage.MATCH__LAST_EVENT:
				if (resolve) return getLastEvent();
				return basicGetLastEvent();
			case FutsalPackage.MATCH__CHANMPIONSHIP:
				return getChanmpionship();
			case FutsalPackage.MATCH__ROUND:
				return getRound();
			case FutsalPackage.MATCH__SECTION:
				return getSection();
			case FutsalPackage.MATCH__AGE_GROUP:
				return getAgeGroup();
			case FutsalPackage.MATCH__CATEGORY:
				return getCategory();
			case FutsalPackage.MATCH__SEASON:
				return getSeason();
			case FutsalPackage.MATCH__CODE:
				return getCode();
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
			case FutsalPackage.MATCH__DATE:
				setDate((Date)newValue);
				return;
			case FutsalPackage.MATCH__TEAM1:
				setTeam1((Team)newValue);
				return;
			case FutsalPackage.MATCH__TEAM2:
				setTeam2((Team)newValue);
				return;
			case FutsalPackage.MATCH__REFEREE1:
				setReferee1((Referee)newValue);
				return;
			case FutsalPackage.MATCH__REFEREE2:
				setReferee2((Referee)newValue);
				return;
			case FutsalPackage.MATCH__REFEREE3:
				setReferee3((Referee)newValue);
				return;
			case FutsalPackage.MATCH__SUPERVISOR:
				setSupervisor((Supervisor)newValue);
				return;
			case FutsalPackage.MATCH__LOCATION:
				setLocation((Pitch)newValue);
				return;
			case FutsalPackage.MATCH__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case FutsalPackage.MATCH__FIRST_EVENT:
				setFirstEvent((Event)newValue);
				return;
			case FutsalPackage.MATCH__LAST_EVENT:
				setLastEvent((Event)newValue);
				return;
			case FutsalPackage.MATCH__CHANMPIONSHIP:
				setChanmpionship((String)newValue);
				return;
			case FutsalPackage.MATCH__ROUND:
				setRound((Integer)newValue);
				return;
			case FutsalPackage.MATCH__SECTION:
				setSection((String)newValue);
				return;
			case FutsalPackage.MATCH__AGE_GROUP:
				setAgeGroup((String)newValue);
				return;
			case FutsalPackage.MATCH__CATEGORY:
				setCategory((String)newValue);
				return;
			case FutsalPackage.MATCH__SEASON:
				setSeason((String)newValue);
				return;
			case FutsalPackage.MATCH__CODE:
				setCode((Integer)newValue);
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
			case FutsalPackage.MATCH__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case FutsalPackage.MATCH__TEAM1:
				setTeam1((Team)null);
				return;
			case FutsalPackage.MATCH__TEAM2:
				setTeam2((Team)null);
				return;
			case FutsalPackage.MATCH__REFEREE1:
				setReferee1((Referee)null);
				return;
			case FutsalPackage.MATCH__REFEREE2:
				setReferee2((Referee)null);
				return;
			case FutsalPackage.MATCH__REFEREE3:
				setReferee3((Referee)null);
				return;
			case FutsalPackage.MATCH__SUPERVISOR:
				setSupervisor((Supervisor)null);
				return;
			case FutsalPackage.MATCH__LOCATION:
				setLocation((Pitch)null);
				return;
			case FutsalPackage.MATCH__EVENTS:
				getEvents().clear();
				return;
			case FutsalPackage.MATCH__FIRST_EVENT:
				setFirstEvent((Event)null);
				return;
			case FutsalPackage.MATCH__LAST_EVENT:
				setLastEvent((Event)null);
				return;
			case FutsalPackage.MATCH__CHANMPIONSHIP:
				setChanmpionship(CHANMPIONSHIP_EDEFAULT);
				return;
			case FutsalPackage.MATCH__ROUND:
				setRound(ROUND_EDEFAULT);
				return;
			case FutsalPackage.MATCH__SECTION:
				setSection(SECTION_EDEFAULT);
				return;
			case FutsalPackage.MATCH__AGE_GROUP:
				setAgeGroup(AGE_GROUP_EDEFAULT);
				return;
			case FutsalPackage.MATCH__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case FutsalPackage.MATCH__SEASON:
				setSeason(SEASON_EDEFAULT);
				return;
			case FutsalPackage.MATCH__CODE:
				setCode(CODE_EDEFAULT);
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
			case FutsalPackage.MATCH__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case FutsalPackage.MATCH__TEAM1:
				return team1 != null;
			case FutsalPackage.MATCH__TEAM2:
				return team2 != null;
			case FutsalPackage.MATCH__REFEREE1:
				return referee1 != null;
			case FutsalPackage.MATCH__REFEREE2:
				return referee2 != null;
			case FutsalPackage.MATCH__REFEREE3:
				return referee3 != null;
			case FutsalPackage.MATCH__SUPERVISOR:
				return supervisor != null;
			case FutsalPackage.MATCH__LOCATION:
				return location != null;
			case FutsalPackage.MATCH__EVENTS:
				return events != null && !events.isEmpty();
			case FutsalPackage.MATCH__FIRST_EVENT:
				return firstEvent != null;
			case FutsalPackage.MATCH__LAST_EVENT:
				return lastEvent != null;
			case FutsalPackage.MATCH__CHANMPIONSHIP:
				return CHANMPIONSHIP_EDEFAULT == null ? chanmpionship != null : !CHANMPIONSHIP_EDEFAULT.equals(chanmpionship);
			case FutsalPackage.MATCH__ROUND:
				return round != ROUND_EDEFAULT;
			case FutsalPackage.MATCH__SECTION:
				return SECTION_EDEFAULT == null ? section != null : !SECTION_EDEFAULT.equals(section);
			case FutsalPackage.MATCH__AGE_GROUP:
				return AGE_GROUP_EDEFAULT == null ? ageGroup != null : !AGE_GROUP_EDEFAULT.equals(ageGroup);
			case FutsalPackage.MATCH__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case FutsalPackage.MATCH__SEASON:
				return SEASON_EDEFAULT == null ? season != null : !SEASON_EDEFAULT.equals(season);
			case FutsalPackage.MATCH__CODE:
				return code != CODE_EDEFAULT;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", chanmpionship: ");
		result.append(chanmpionship);
		result.append(", round: ");
		result.append(round);
		result.append(", section: ");
		result.append(section);
		result.append(", ageGroup: ");
		result.append(ageGroup);
		result.append(", category: ");
		result.append(category);
		result.append(", season: ");
		result.append(season);
		result.append(", code: ");
		result.append(code);
		result.append(')');
		return result.toString();
	}

} //MatchImpl
