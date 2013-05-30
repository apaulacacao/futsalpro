/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player#getSquadNumber <em>Squad Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getPlayer()
 * @model
 * @generated
 */
public interface Player extends TeamMember {
	/**
	 * Returns the value of the '<em><b>Squad Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Squad Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Squad Number</em>' attribute.
	 * @see #setSquadNumber(int)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getPlayer_SquadNumber()
	 * @model required="true"
	 * @generated
	 */
	int getSquadNumber();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player#getSquadNumber <em>Squad Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Squad Number</em>' attribute.
	 * @see #getSquadNumber()
	 * @generated
	 */
	void setSquadNumber(int value);

} // Player
