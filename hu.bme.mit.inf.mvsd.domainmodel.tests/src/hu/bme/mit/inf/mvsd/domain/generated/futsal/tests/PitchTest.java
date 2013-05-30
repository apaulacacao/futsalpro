/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.tests;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pitch</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PitchTest extends TestCase {

	/**
	 * The fixture for this Pitch test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Pitch fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PitchTest.class);
	}

	/**
	 * Constructs a new Pitch test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PitchTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pitch test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Pitch fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pitch test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Pitch getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FutsalFactory.eINSTANCE.createPitch());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PitchTest
