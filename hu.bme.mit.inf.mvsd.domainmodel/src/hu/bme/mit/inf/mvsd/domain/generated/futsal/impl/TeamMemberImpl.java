/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.impl;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Team Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl#getLicenceNumber <em>Licence Number</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl#getTeam <em>Team</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TeamMemberImpl extends PersonImpl implements TeamMember {
	/**
	 * The default value of the '{@link #getLicenceNumber() <em>Licence Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenceNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LICENCE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLicenceNumber() <em>Licence Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenceNumber()
	 * @generated
	 * @ordered
	 */
	protected int licenceNumber = LICENCE_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTeam() <em>Team</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam()
	 * @generated
	 * @ordered
	 */
	protected Team team;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FutsalPackage.Literals.TEAM_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLicenceNumber() {
		return licenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenceNumber(int newLicenceNumber) {
		int oldLicenceNumber = licenceNumber;
		licenceNumber = newLicenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM_MEMBER__LICENCE_NUMBER, oldLicenceNumber, licenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getTeam() {
		if (team != null && team.eIsProxy()) {
			InternalEObject oldTeam = (InternalEObject)team;
			team = (Team)eResolveProxy(oldTeam);
			if (team != oldTeam) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.TEAM_MEMBER__TEAM, oldTeam, team));
			}
		}
		return team;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team basicGetTeam() {
		return team;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam(Team newTeam) {
		Team oldTeam = team;
		team = newTeam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.TEAM_MEMBER__TEAM, oldTeam, team));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FutsalPackage.TEAM_MEMBER__LICENCE_NUMBER:
				return getLicenceNumber();
			case FutsalPackage.TEAM_MEMBER__TEAM:
				if (resolve) return getTeam();
				return basicGetTeam();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FutsalPackage.TEAM_MEMBER__LICENCE_NUMBER:
				setLicenceNumber((Integer)newValue);
				return;
			case FutsalPackage.TEAM_MEMBER__TEAM:
				setTeam((Team)newValue);
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
			case FutsalPackage.TEAM_MEMBER__LICENCE_NUMBER:
				setLicenceNumber(LICENCE_NUMBER_EDEFAULT);
				return;
			case FutsalPackage.TEAM_MEMBER__TEAM:
				setTeam((Team)null);
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
			case FutsalPackage.TEAM_MEMBER__LICENCE_NUMBER:
				return licenceNumber != LICENCE_NUMBER_EDEFAULT;
			case FutsalPackage.TEAM_MEMBER__TEAM:
				return team != null;
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
		result.append(" (licenceNumber: ");
		result.append(licenceNumber);
		result.append(')');
		return result.toString();
	}

} //TeamMemberImpl
