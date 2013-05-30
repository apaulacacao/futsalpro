/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getSubstitute <em>Substitute</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getInstead <em>Instead</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getSubstitution()
 * @model
 * @generated
 */
public interface Substitution extends Event {
	/**
	 * Returns the value of the '<em><b>Substitute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substitute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substitute</em>' reference.
	 * @see #setSubstitute(Player)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getSubstitution_Substitute()
	 * @model required="true"
	 * @generated
	 */
	Player getSubstitute();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getSubstitute <em>Substitute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substitute</em>' reference.
	 * @see #getSubstitute()
	 * @generated
	 */
	void setSubstitute(Player value);

	/**
	 * Returns the value of the '<em><b>Instead</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instead</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instead</em>' reference.
	 * @see #setInstead(Player)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getSubstitution_Instead()
	 * @model required="true"
	 * @generated
	 */
	Player getInstead();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getInstead <em>Instead</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instead</em>' reference.
	 * @see #getInstead()
	 * @generated
	 */
	void setInstead(Player value);

} // Substitution
