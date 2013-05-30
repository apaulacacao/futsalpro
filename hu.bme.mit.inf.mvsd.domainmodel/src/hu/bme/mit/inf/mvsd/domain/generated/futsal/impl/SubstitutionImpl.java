/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.impl;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl#getSubstitute <em>Substitute</em>}</li>
 *   <li>{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl#getInstead <em>Instead</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstitutionImpl extends EventImpl implements Substitution {
	/**
	 * The cached value of the '{@link #getSubstitute() <em>Substitute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstitute()
	 * @generated
	 * @ordered
	 */
	protected Player substitute;

	/**
	 * The cached value of the '{@link #getInstead() <em>Instead</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstead()
	 * @generated
	 * @ordered
	 */
	protected Player instead;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FutsalPackage.Literals.SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getSubstitute() {
		if (substitute != null && substitute.eIsProxy()) {
			InternalEObject oldSubstitute = (InternalEObject)substitute;
			substitute = (Player)eResolveProxy(oldSubstitute);
			if (substitute != oldSubstitute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.SUBSTITUTION__SUBSTITUTE, oldSubstitute, substitute));
			}
		}
		return substitute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetSubstitute() {
		return substitute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstitute(Player newSubstitute) {
		Player oldSubstitute = substitute;
		substitute = newSubstitute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.SUBSTITUTION__SUBSTITUTE, oldSubstitute, substitute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getInstead() {
		if (instead != null && instead.eIsProxy()) {
			InternalEObject oldInstead = (InternalEObject)instead;
			instead = (Player)eResolveProxy(oldInstead);
			if (instead != oldInstead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FutsalPackage.SUBSTITUTION__INSTEAD, oldInstead, instead));
			}
		}
		return instead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetInstead() {
		return instead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstead(Player newInstead) {
		Player oldInstead = instead;
		instead = newInstead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FutsalPackage.SUBSTITUTION__INSTEAD, oldInstead, instead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FutsalPackage.SUBSTITUTION__SUBSTITUTE:
				if (resolve) return getSubstitute();
				return basicGetSubstitute();
			case FutsalPackage.SUBSTITUTION__INSTEAD:
				if (resolve) return getInstead();
				return basicGetInstead();
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
			case FutsalPackage.SUBSTITUTION__SUBSTITUTE:
				setSubstitute((Player)newValue);
				return;
			case FutsalPackage.SUBSTITUTION__INSTEAD:
				setInstead((Player)newValue);
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
			case FutsalPackage.SUBSTITUTION__SUBSTITUTE:
				setSubstitute((Player)null);
				return;
			case FutsalPackage.SUBSTITUTION__INSTEAD:
				setInstead((Player)null);
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
			case FutsalPackage.SUBSTITUTION__SUBSTITUTE:
				return substitute != null;
			case FutsalPackage.SUBSTITUTION__INSTEAD:
				return instead != null;
		}
		return super.eIsSet(featureID);
	}

} //SubstitutionImpl
