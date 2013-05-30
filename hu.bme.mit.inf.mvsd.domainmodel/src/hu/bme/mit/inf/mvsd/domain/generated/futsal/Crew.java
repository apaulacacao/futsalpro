/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Crew</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getCrew()
 * @model
 * @generated
 */
public interface Crew extends TeamMember {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole
	 * @see #setRole(CrewRole)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getCrew_Role()
	 * @model required="true"
	 * @generated
	 */
	CrewRole getRole();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole
	 * @see #getRole()
	 * @generated
	 */
	void setRole(CrewRole value);

} // Crew
