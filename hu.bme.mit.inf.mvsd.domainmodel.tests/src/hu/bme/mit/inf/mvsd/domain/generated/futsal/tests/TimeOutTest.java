/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.tests;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Time Out</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimeOutTest extends EventTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TimeOutTest.class);
	}

	/**
	 * Constructs a new Time Out test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeOutTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Time Out test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TimeOut getFixture() {
		return (TimeOut)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FutsalFactory.eINSTANCE.createTimeOut());
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

} //TimeOutTest
