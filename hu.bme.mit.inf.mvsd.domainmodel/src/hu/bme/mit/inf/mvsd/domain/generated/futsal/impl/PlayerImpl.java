/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.impl;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PlayerImpl#getSquadNumber <em>Squad Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlayerImpl extends TeamMemberImpl implements Player {
	/**
	 * The default value of the '{@link #getSquadNumber() <em>Squad Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSquadNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SQUAD_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSquadNumber() <em>Squad Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSquadNumber()
	 * @generated
	 * @ordered
	 */
	protected int squadNumber = SQUAD_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FutsalPackage.Literals.PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSquadNumber() {
		return squadNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSquadNumber(int newSquadNumber) {
		int oldSquadNumber = squadNumber;
		squadNumber = newSquadNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.PLAYER__SQUAD_NUMBER, oldSquadNumber, squadNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FutsalPackage.PLAYER__SQUAD_NUMBER:
				return getSquadNumber();
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
			case FutsalPackage.PLAYER__SQUAD_NUMBER:
				setSquadNumber((Integer)newValue);
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
			case FutsalPackage.PLAYER__SQUAD_NUMBER:
				setSquadNumber(SQUAD_NUMBER_EDEFAULT);
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
			case FutsalPackage.PLAYER__SQUAD_NUMBER:
				return squadNumber != SQUAD_NUMBER_EDEFAULT;
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
		result.append(" (squadNumber: ");
		result.append(squadNumber);
		result.append(')');
		return result.toString();
	}

} //PlayerImpl
