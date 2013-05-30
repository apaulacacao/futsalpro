/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.tests;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Crew</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CrewTest extends TeamMemberTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CrewTest.class);
	}

	/**
	 * Constructs a new Crew test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Crew test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Crew getFixture() {
		return (Crew)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FutsalFactory.eINSTANCE.createCrew());
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

} //CrewTest
