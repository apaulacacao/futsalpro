/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fault Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage#getFaultType()
 * @model
 * @generated
 */
public enum FaultType implements Enumerator {
	/**
	 * The '<em><b>Penalty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENALTY_VALUE
	 * @generated
	 * @ordered
	 */
	PENALTY(0, "Penalty", "Penalty"),

	/**
	 * The '<em><b>Yellow Card</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YELLOW_CARD_VALUE
	 * @generated
	 * @ordered
	 */
	YELLOW_CARD(1, "YellowCard", "YellowCard"),

	/**
	 * The '<em><b>Red Card</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RED_CARD_VALUE
	 * @generated
	 * @ordered
	 */
	RED_CARD(2, "RedCard", "RedCard");

	/**
	 * The '<em><b>Penalty</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Penalty</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PENALTY
	 * @model name="Penalty"
	 * @generated
	 * @ordered
	 */
	public static final int PENALTY_VALUE = 0;

	/**
	 * The '<em><b>Yellow Card</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Yellow Card</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YELLOW_CARD
	 * @model name="YellowCard"
	 * @generated
	 * @ordered
	 */
	public static final int YELLOW_CARD_VALUE = 1;

	/**
	 * The '<em><b>Red Card</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Red Card</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RED_CARD
	 * @model name="RedCard"
	 * @generated
	 * @ordered
	 */
	public static final int RED_CARD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Fault Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FaultType[] VALUES_ARRAY =
		new FaultType[] {
			PENALTY,
			YELLOW_CARD,
			RED_CARD,
		};

	/**
	 * A public read-only list of all the '<em><b>Fault Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FaultType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fault Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultType get(int value) {
		switch (value) {
			case PENALTY_VALUE: return PENALTY;
			case YELLOW_CARD_VALUE: return YELLOW_CARD;
			case RED_CARD_VALUE: return RED_CARD;
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
	private FaultType(int value, String name, String literal) {
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
	
} //FaultType
