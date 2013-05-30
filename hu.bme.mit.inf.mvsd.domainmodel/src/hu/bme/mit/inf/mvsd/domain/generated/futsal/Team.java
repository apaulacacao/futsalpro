/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubject <em>Subject</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getGoalKeeper <em>Goal Keeper</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getFieldPlayers <em>Field Players</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtitutePlayers <em>Subtitute Players</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtituteGoalKeepers <em>Subtitute Goal Keepers</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getCaptain <em>Captain</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getBench <em>Bench</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam()
 * @model
 * @generated
 */
public interface Team extends EObject {
	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference.
	 * @see #setSubject(Match)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_Subject()
	 * @model required="true"
	 * @generated
	 */
	Match getSubject();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubject <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(Match value);

	/**
	 * Returns the value of the '<em><b>Goal Keeper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal Keeper</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal Keeper</em>' containment reference.
	 * @see #setGoalKeeper(GoalKeeper)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_GoalKeeper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GoalKeeper getGoalKeeper();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getGoalKeeper <em>Goal Keeper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal Keeper</em>' containment reference.
	 * @see #getGoalKeeper()
	 * @generated
	 */
	void setGoalKeeper(GoalKeeper value);

	/**
	 * Returns the value of the '<em><b>Field Players</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Players</em>' containment reference list.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_FieldPlayers()
	 * @model containment="true" lower="4" upper="4"
	 * @generated
	 */
	EList<Player> getFieldPlayers();

	/**
	 * Returns the value of the '<em><b>Subtitute Players</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtitute Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtitute Players</em>' containment reference list.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_SubtitutePlayers()
	 * @model containment="true" upper="7"
	 * @generated
	 */
	EList<Player> getSubtitutePlayers();

	/**
	 * Returns the value of the '<em><b>Subtitute Goal Keepers</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtitute Goal Keepers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtitute Goal Keepers</em>' containment reference list.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_SubtituteGoalKeepers()
	 * @model containment="true" upper="7"
	 * @generated
	 */
	EList<GoalKeeper> getSubtituteGoalKeepers();

	/**
	 * Returns the value of the '<em><b>Captain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Captain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Captain</em>' reference.
	 * @see #setCaptain(Player)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_Captain()
	 * @model required="true"
	 * @generated
	 */
	Player getCaptain();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getCaptain <em>Captain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Captain</em>' reference.
	 * @see #getCaptain()
	 * @generated
	 */
	void setCaptain(Player value);

	/**
	 * Returns the value of the '<em><b>Bench</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bench</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bench</em>' containment reference list.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_Bench()
	 * @model containment="true"
	 * @generated
	 */
	EList<Crew> getBench();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeam_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Team
