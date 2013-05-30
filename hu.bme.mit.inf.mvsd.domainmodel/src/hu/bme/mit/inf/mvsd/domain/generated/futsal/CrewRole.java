/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Crew Role</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getCrewRole()
 * @model
 * @generated
 */
public enum CrewRole implements Enumerator {
	/**
	 * The '<em><b>Coach</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COACH_VALUE
	 * @generated
	 * @ordered
	 */
	COACH(0, "Coach", "Coach"),

	/**
	 * The '<em><b>Manager</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	MANAGER(1, "Manager", "Manager"),

	/**
	 * The '<em><b>Medic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIC_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIC(2, "Medic", "Medic"),

	/**
	 * The '<em><b>Masseur</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSEUR_VALUE
	 * @generated
	 * @ordered
	 */
	MASSEUR(3, "Masseur", "Masseur"),

	/**
	 * The '<em><b>Technical Manager</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TECHNICAL_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	TECHNICAL_MANAGER(4, "TechnicalManager", "TechnicalManager"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(5, "Other", "Other");

	/**
	 * The '<em><b>Coach</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Coach</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COACH
	 * @model name="Coach"
	 * @generated
	 * @ordered
	 */
	public static final int COACH_VALUE = 0;

	/**
	 * The '<em><b>Manager</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Manager</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANAGER
	 * @model name="Manager"
	 * @generated
	 * @ordered
	 */
	public static final int MANAGER_VALUE = 1;

	/**
	 * The '<em><b>Medic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Medic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDIC
	 * @model name="Medic"
	 * @generated
	 * @ordered
	 */
	public static final int MEDIC_VALUE = 2;

	/**
	 * The '<em><b>Masseur</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Masseur</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSEUR
	 * @model name="Masseur"
	 * @generated
	 * @ordered
	 */
	public static final int MASSEUR_VALUE = 3;

	/**
	 * The '<em><b>Technical Manager</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Technical Manager</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TECHNICAL_MANAGER
	 * @model name="TechnicalManager"
	 * @generated
	 * @ordered
	 */
	public static final int TECHNICAL_MANAGER_VALUE = 4;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 5;

	/**
	 * An array of all the '<em><b>Crew Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CrewRole[] VALUES_ARRAY =
		new CrewRole[] {
			COACH,
			MANAGER,
			MEDIC,
			MASSEUR,
			TECHNICAL_MANAGER,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Crew Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CrewRole> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Crew Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CrewRole get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CrewRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Crew Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CrewRole getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CrewRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Crew Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CrewRole get(int value) {
		switch (value) {
			case COACH_VALUE: return COACH;
			case MANAGER_VALUE: return MANAGER;
			case MEDIC_VALUE: return MEDIC;
			case MASSEUR_VALUE: return MASSEUR;
			case TECHNICAL_MANAGER_VALUE: return TECHNICAL_MANAGER;
			case OTHER_VALUE: return OTHER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CrewRole(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CrewRole
