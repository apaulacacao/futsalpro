/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getPlayer <em>Player</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getScorerTeam <em>Scorer Team</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends Event {
	/**
	 * Returns the value of the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Player</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' reference.
	 * @see #setPlayer(Player)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getGoal_Player()
	 * @model required="true"
	 * @generated
	 */
	Player getPlayer();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getPlayer <em>Player</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' reference.
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(Player value);

	/**
	 * Returns the value of the '<em><b>Scorer Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scorer Team</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scorer Team</em>' reference.
	 * @see #setScorerTeam(Team)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getGoal_ScorerTeam()
	 * @model required="true"
	 * @generated
	 */
	Team getScorerTeam();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getScorerTeam <em>Scorer Team</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scorer Team</em>' reference.
	 * @see #getScorerTeam()
	 * @generated
	 */
	void setScorerTeam(Team value);

} // Goal
