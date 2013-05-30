/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getLicenceNumber <em>Licence Number</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getTeam <em>Team</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeamMember()
 * @model abstract="true"
 * @generated
 */
public interface TeamMember extends Person {
	/**
	 * Returns the value of the '<em><b>Licence Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Licence Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Licence Number</em>' attribute.
	 * @see #setLicenceNumber(int)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeamMember_LicenceNumber()
	 * @model id="true" required="true"
	 * @generated
	 */
	int getLicenceNumber();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getLicenceNumber <em>Licence Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Licence Number</em>' attribute.
	 * @see #getLicenceNumber()
	 * @generated
	 */
	void setLicenceNumber(int value);

	/**
	 * Returns the value of the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team</em>' reference.
	 * @see #setTeam(Team)
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getTeamMember_Team()
	 * @model required="true"
	 * @generated
	 */
	Team getTeam();

	/**
	 * Sets the value of the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getTeam <em>Team</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team</em>' reference.
	 * @see #getTeam()
	 * @generated
	 */
	void setTeam(Team value);

} // TeamMember
