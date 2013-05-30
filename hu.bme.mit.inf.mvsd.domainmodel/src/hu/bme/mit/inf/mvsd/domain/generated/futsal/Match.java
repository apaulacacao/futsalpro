/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getDate <em>Date</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam1 <em>Team1</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam2 <em>Team2</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee1 <em>Referee1</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee2 <em>Referee2</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee3 <em>Referee3</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSupervisor <em>Supervisor</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLocation <em>Location</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getEvents <em>Events</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLastEvent <em>Last Event</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getChanmpionship <em>Chanmpionship</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getRound <em>Round</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSection <em>Section</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getAgeGroup <em>Age Group</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCategory <em>Category</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSeason <em>Season</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch()
 * @model
 * @generated
 */
public interface Match extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Team1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team1</em>' containment reference.
	 * @see #setTeam1(Team)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Team1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Team getTeam1();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam1 <em>Team1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team1</em>' containment reference.
	 * @see #getTeam1()
	 * @generated
	 */
	void setTeam1(Team value);

	/**
	 * Returns the value of the '<em><b>Team2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team2</em>' containment reference.
	 * @see #setTeam2(Team)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Team2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Team getTeam2();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam2 <em>Team2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team2</em>' containment reference.
	 * @see #getTeam2()
	 * @generated
	 */
	void setTeam2(Team value);

	/**
	 * Returns the value of the '<em><b>Referee1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referee1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referee1</em>' containment reference.
	 * @see #setReferee1(Referee)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Referee1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Referee getReferee1();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee1 <em>Referee1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referee1</em>' containment reference.
	 * @see #getReferee1()
	 * @generated
	 */
	void setReferee1(Referee value);

	/**
	 * Returns the value of the '<em><b>Referee2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referee2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referee2</em>' containment reference.
	 * @see #setReferee2(Referee)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Referee2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Referee getReferee2();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee2 <em>Referee2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referee2</em>' containment reference.
	 * @see #getReferee2()
	 * @generated
	 */
	void setReferee2(Referee value);

	/**
	 * Returns the value of the '<em><b>Referee3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referee3</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referee3</em>' containment reference.
	 * @see #setReferee3(Referee)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Referee3()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Referee getReferee3();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee3 <em>Referee3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referee3</em>' containment reference.
	 * @see #getReferee3()
	 * @generated
	 */
	void setReferee3(Referee value);

	/**
	 * Returns the value of the '<em><b>Supervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supervisor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supervisor</em>' containment reference.
	 * @see #setSupervisor(Supervisor)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Supervisor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Supervisor getSupervisor();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSupervisor <em>Supervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supervisor</em>' containment reference.
	 * @see #getSupervisor()
	 * @generated
	 */
	void setSupervisor(Supervisor value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Pitch)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Location()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pitch getLocation();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Pitch value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>First Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Event</em>' reference.
	 * @see #setFirstEvent(Event)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_FirstEvent()
	 * @model
	 * @generated
	 */
	Event getFirstEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getFirstEvent <em>First Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Event</em>' reference.
	 * @see #getFirstEvent()
	 * @generated
	 */
	void setFirstEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Last Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Event</em>' reference.
	 * @see #setLastEvent(Event)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_LastEvent()
	 * @model
	 * @generated
	 */
	Event getLastEvent();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLastEvent <em>Last Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Event</em>' reference.
	 * @see #getLastEvent()
	 * @generated
	 */
	void setLastEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Chanmpionship</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chanmpionship</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chanmpionship</em>' attribute.
	 * @see #setChanmpionship(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Chanmpionship()
	 * @model required="true"
	 * @generated
	 */
	String getChanmpionship();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getChanmpionship <em>Chanmpionship</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chanmpionship</em>' attribute.
	 * @see #getChanmpionship()
	 * @generated
	 */
	void setChanmpionship(String value);

	/**
	 * Returns the value of the '<em><b>Round</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round</em>' attribute.
	 * @see #setRound(int)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Round()
	 * @model
	 * @generated
	 */
	int getRound();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getRound <em>Round</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round</em>' attribute.
	 * @see #getRound()
	 * @generated
	 */
	void setRound(int value);

	/**
	 * Returns the value of the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' attribute.
	 * @see #setSection(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Section()
	 * @model
	 * @generated
	 */
	String getSection();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSection <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' attribute.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(String value);

	/**
	 * Returns the value of the '<em><b>Age Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age Group</em>' attribute.
	 * @see #setAgeGroup(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_AgeGroup()
	 * @model
	 * @generated
	 */
	String getAgeGroup();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getAgeGroup <em>Age Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age Group</em>' attribute.
	 * @see #getAgeGroup()
	 * @generated
	 */
	void setAgeGroup(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Category()
	 * @model
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Season</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Season</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Season</em>' attribute.
	 * @see #setSeason(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Season()
	 * @model
	 * @generated
	 */
	String getSeason();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSeason <em>Season</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Season</em>' attribute.
	 * @see #getSeason()
	 * @generated
	 */
	void setSeason(String value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getMatch_Code()
	 * @model
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

} // Match
