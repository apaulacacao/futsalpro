/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory
 * @model kind="package"
 * @generated
 */
public interface FutsalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "futsal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://futsal/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "futsal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FutsalPackage eINSTANCE = hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getMatch()
	 * @generated
	 */
	int MATCH = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__DATE = 0;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__TEAM1 = 1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__TEAM2 = 2;

	/**
	 * The feature id for the '<em><b>Referee1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__REFEREE1 = 3;

	/**
	 * The feature id for the '<em><b>Referee2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__REFEREE2 = 4;

	/**
	 * The feature id for the '<em><b>Referee3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__REFEREE3 = 5;

	/**
	 * The feature id for the '<em><b>Supervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__SUPERVISOR = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__LOCATION = 7;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__EVENTS = 8;

	/**
	 * The feature id for the '<em><b>First Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__FIRST_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Last Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__LAST_EVENT = 10;

	/**
	 * The feature id for the '<em><b>Chanmpionship</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__CHANMPIONSHIP = 11;

	/**
	 * The feature id for the '<em><b>Round</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__ROUND = 12;

	/**
	 * The feature id for the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__SECTION = 13;

	/**
	 * The feature id for the '<em><b>Age Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__AGE_GROUP = 14;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__CATEGORY = 15;

	/**
	 * The feature id for the '<em><b>Season</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__SEASON = 16;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__CODE = 17;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PitchImpl <em>Pitch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PitchImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPitch()
	 * @generated
	 */
	int PITCH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCH__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Pitch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl <em>Team</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTeam()
	 * @generated
	 */
	int TEAM = 2;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__SUBJECT = 0;

	/**
	 * The feature id for the '<em><b>Goal Keeper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__GOAL_KEEPER = 1;

	/**
	 * The feature id for the '<em><b>Field Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__FIELD_PLAYERS = 2;

	/**
	 * The feature id for the '<em><b>Subtitute Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__SUBTITUTE_PLAYERS = 3;

	/**
	 * The feature id for the '<em><b>Subtitute Goal Keepers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__SUBTITUTE_GOAL_KEEPERS = 4;

	/**
	 * The feature id for the '<em><b>Captain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__CAPTAIN = 5;

	/**
	 * The feature id for the '<em><b>Bench</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__BENCH = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__NAME = 7;

	/**
	 * The number of structural features of the '<em>Team</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PersonImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 1;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__DATE_OF_BIRTH = 2;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ADDRESS = 3;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.OfficialImpl <em>Official</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.OfficialImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getOfficial()
	 * @generated
	 */
	int OFFICIAL = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL__ID = PERSON__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL__NAME = PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL__DATE_OF_BIRTH = PERSON__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL__ADDRESS = PERSON__ADDRESS;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL__IDENTIFIER = PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Official</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFICIAL_FEATURE_COUNT = PERSON_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.RefereeImpl <em>Referee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.RefereeImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getReferee()
	 * @generated
	 */
	int REFEREE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE__ID = OFFICIAL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE__NAME = OFFICIAL__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE__DATE_OF_BIRTH = OFFICIAL__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE__ADDRESS = OFFICIAL__ADDRESS;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE__IDENTIFIER = OFFICIAL__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Referee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFEREE_FEATURE_COUNT = OFFICIAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SupervisorImpl <em>Supervisor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SupervisorImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getSupervisor()
	 * @generated
	 */
	int SUPERVISOR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR__ID = OFFICIAL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR__NAME = OFFICIAL__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR__DATE_OF_BIRTH = OFFICIAL__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR__ADDRESS = OFFICIAL__ADDRESS;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR__IDENTIFIER = OFFICIAL__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Supervisor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_FEATURE_COUNT = OFFICIAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl <em>Team Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTeamMember()
	 * @generated
	 */
	int TEAM_MEMBER = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__ID = PERSON__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__NAME = PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__DATE_OF_BIRTH = PERSON__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__ADDRESS = PERSON__ADDRESS;

	/**
	 * The feature id for the '<em><b>Licence Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__LICENCE_NUMBER = PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER__TEAM = PERSON_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Team Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_MEMBER_FEATURE_COUNT = PERSON_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PlayerImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__ID = TEAM_MEMBER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = TEAM_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__DATE_OF_BIRTH = TEAM_MEMBER__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__ADDRESS = TEAM_MEMBER__ADDRESS;

	/**
	 * The feature id for the '<em><b>Licence Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__LICENCE_NUMBER = TEAM_MEMBER__LICENCE_NUMBER;

	/**
	 * The feature id for the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__TEAM = TEAM_MEMBER__TEAM;

	/**
	 * The feature id for the '<em><b>Squad Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__SQUAD_NUMBER = TEAM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = TEAM_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalKeeperImpl <em>Goal Keeper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalKeeperImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getGoalKeeper()
	 * @generated
	 */
	int GOAL_KEEPER = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__ID = PLAYER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__NAME = PLAYER__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__DATE_OF_BIRTH = PLAYER__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__ADDRESS = PLAYER__ADDRESS;

	/**
	 * The feature id for the '<em><b>Licence Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__LICENCE_NUMBER = PLAYER__LICENCE_NUMBER;

	/**
	 * The feature id for the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__TEAM = PLAYER__TEAM;

	/**
	 * The feature id for the '<em><b>Squad Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER__SQUAD_NUMBER = PLAYER__SQUAD_NUMBER;

	/**
	 * The number of structural features of the '<em>Goal Keeper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_KEEPER_FEATURE_COUNT = PLAYER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.CrewImpl <em>Crew</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.CrewImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getCrew()
	 * @generated
	 */
	int CREW = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__ID = TEAM_MEMBER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__NAME = TEAM_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__DATE_OF_BIRTH = TEAM_MEMBER__DATE_OF_BIRTH;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__ADDRESS = TEAM_MEMBER__ADDRESS;

	/**
	 * The feature id for the '<em><b>Licence Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__LICENCE_NUMBER = TEAM_MEMBER__LICENCE_NUMBER;

	/**
	 * The feature id for the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__TEAM = TEAM_MEMBER__TEAM;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW__ROLE = TEAM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Crew</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREW_FEATURE_COUNT = TEAM_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.EventImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 11;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PREVIOUS = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NEXT = 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 12;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__TIME = EVENT__TIME;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PREVIOUS = EVENT__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NEXT = EVENT__NEXT;

	/**
	 * The feature id for the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PLAYER = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scorer Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SCORER_TEAM = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FaultImpl <em>Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FaultImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getFault()
	 * @generated
	 */
	int FAULT = 13;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__TIME = EVENT__TIME;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__PREVIOUS = EVENT__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__NEXT = EVENT__NEXT;

	/**
	 * The feature id for the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__PLAYER = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__TYPE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TimeOutImpl <em>Time Out</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TimeOutImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTimeOut()
	 * @generated
	 */
	int TIME_OUT = 14;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_OUT__TIME = EVENT__TIME;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_OUT__PREVIOUS = EVENT__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_OUT__NEXT = EVENT__NEXT;

	/**
	 * The feature id for the '<em><b>Team</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_OUT__TEAM = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Out</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_OUT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl <em>Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getSubstitution()
	 * @generated
	 */
	int SUBSTITUTION = 15;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__TIME = EVENT__TIME;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__PREVIOUS = EVENT__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__NEXT = EVENT__NEXT;

	/**
	 * The feature id for the '<em><b>Substitute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__SUBSTITUTE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instead</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__INSTEAD = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole <em>Crew Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getCrewRole()
	 * @generated
	 */
	int CREW_ROLE = 16;

	/**
	 * The meta object id for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType <em>Fault Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getFaultType()
	 * @generated
	 */
	int FAULT_TYPE = 17;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match
	 * @generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getDate()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Date();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam1 <em>Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Team1</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam1()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Team1();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam2 <em>Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Team2</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getTeam2()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Team2();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee1 <em>Referee1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referee1</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee1()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Referee1();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee2 <em>Referee2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referee2</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee2()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Referee2();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee3 <em>Referee3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referee3</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getReferee3()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Referee3();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSupervisor <em>Supervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Supervisor</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSupervisor()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Supervisor();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLocation()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Location();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getEvents()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Events();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getFirstEvent <em>First Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>First Event</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getFirstEvent()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_FirstEvent();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLastEvent <em>Last Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Event</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getLastEvent()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_LastEvent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getChanmpionship <em>Chanmpionship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chanmpionship</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getChanmpionship()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Chanmpionship();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getRound <em>Round</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Round</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getRound()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Round();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSection()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Section();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getAgeGroup <em>Age Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age Group</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getAgeGroup()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_AgeGroup();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCategory()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Category();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSeason <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Season</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getSeason()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Season();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Match#getCode()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Code();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch <em>Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pitch</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch
	 * @generated
	 */
	EClass getPitch();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch#getName()
	 * @see #getPitch()
	 * @generated
	 */
	EAttribute getPitch_Name();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch#getAddress()
	 * @see #getPitch()
	 * @generated
	 */
	EAttribute getPitch_Address();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team
	 * @generated
	 */
	EClass getTeam();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subject</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubject()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_Subject();

	/**
	 * Returns the meta object for the containment reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getGoalKeeper <em>Goal Keeper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Keeper</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getGoalKeeper()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_GoalKeeper();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getFieldPlayers <em>Field Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field Players</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getFieldPlayers()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_FieldPlayers();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtitutePlayers <em>Subtitute Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subtitute Players</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtitutePlayers()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_SubtitutePlayers();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtituteGoalKeepers <em>Subtitute Goal Keepers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subtitute Goal Keepers</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getSubtituteGoalKeepers()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_SubtituteGoalKeepers();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getCaptain <em>Captain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Captain</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getCaptain()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_Captain();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getBench <em>Bench</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bench</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getBench()
	 * @see #getTeam()
	 * @generated
	 */
	EReference getTeam_Bench();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Team#getName()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_Name();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Id();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getDateOfBirth <em>Date Of Birth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Of Birth</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getDateOfBirth()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_DateOfBirth();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Person#getAddress()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Address();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Official <em>Official</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Official</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Official
	 * @generated
	 */
	EClass getOfficial();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Official#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Official#getIdentifier()
	 * @see #getOfficial()
	 * @generated
	 */
	EAttribute getOfficial_Identifier();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee <em>Referee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referee</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee
	 * @generated
	 */
	EClass getReferee();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor <em>Supervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supervisor</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor
	 * @generated
	 */
	EClass getSupervisor();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember <em>Team Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team Member</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember
	 * @generated
	 */
	EClass getTeamMember();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getLicenceNumber <em>Licence Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Licence Number</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getLicenceNumber()
	 * @see #getTeamMember()
	 * @generated
	 */
	EAttribute getTeamMember_LicenceNumber();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getTeam <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.TeamMember#getTeam()
	 * @see #getTeamMember()
	 * @generated
	 */
	EReference getTeamMember_Team();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Player#getSquadNumber <em>Squad Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Squad Number</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Player#getSquadNumber()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_SquadNumber();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper <em>Goal Keeper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Keeper</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper
	 * @generated
	 */
	EClass getGoalKeeper();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew <em>Crew</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crew</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew
	 * @generated
	 */
	EClass getCrew();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew#getRole()
	 * @see #getCrew()
	 * @generated
	 */
	EAttribute getCrew_Role();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getTime()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Time();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getPrevious <em>Previous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getPrevious()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Previous();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Event#getNext()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Next();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Player</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getPlayer()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Player();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getScorerTeam <em>Scorer Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scorer Team</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal#getScorerTeam()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_ScorerTeam();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault
	 * @generated
	 */
	EClass getFault();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Player</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault#getPlayer()
	 * @see #getFault()
	 * @generated
	 */
	EReference getFault_Player();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault#getType()
	 * @see #getFault()
	 * @generated
	 */
	EAttribute getFault_Type();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut <em>Time Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Out</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut
	 * @generated
	 */
	EClass getTimeOut();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut#getTeam <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut#getTeam()
	 * @see #getTimeOut()
	 * @generated
	 */
	EReference getTimeOut_Team();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution <em>Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substitution</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution
	 * @generated
	 */
	EClass getSubstitution();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getSubstitute <em>Substitute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Substitute</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getSubstitute()
	 * @see #getSubstitution()
	 * @generated
	 */
	EReference getSubstitution_Substitute();

	/**
	 * Returns the meta object for the reference '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getInstead <em>Instead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instead</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution#getInstead()
	 * @see #getSubstitution()
	 * @generated
	 */
	EReference getSubstitution_Instead();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole <em>Crew Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Crew Role</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole
	 * @generated
	 */
	EEnum getCrewRole();

	/**
	 * Returns the meta object for enum '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType <em>Fault Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Type</em>'.
	 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType
	 * @generated
	 */
	EEnum getFaultType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FutsalFactory getFutsalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.MatchImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getMatch()
		 * @generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__DATE = eINSTANCE.getMatch_Date();

		/**
		 * The meta object literal for the '<em><b>Team1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__TEAM1 = eINSTANCE.getMatch_Team1();

		/**
		 * The meta object literal for the '<em><b>Team2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__TEAM2 = eINSTANCE.getMatch_Team2();

		/**
		 * The meta object literal for the '<em><b>Referee1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__REFEREE1 = eINSTANCE.getMatch_Referee1();

		/**
		 * The meta object literal for the '<em><b>Referee2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__REFEREE2 = eINSTANCE.getMatch_Referee2();

		/**
		 * The meta object literal for the '<em><b>Referee3</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__REFEREE3 = eINSTANCE.getMatch_Referee3();

		/**
		 * The meta object literal for the '<em><b>Supervisor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__SUPERVISOR = eINSTANCE.getMatch_Supervisor();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__LOCATION = eINSTANCE.getMatch_Location();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__EVENTS = eINSTANCE.getMatch_Events();

		/**
		 * The meta object literal for the '<em><b>First Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__FIRST_EVENT = eINSTANCE.getMatch_FirstEvent();

		/**
		 * The meta object literal for the '<em><b>Last Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__LAST_EVENT = eINSTANCE.getMatch_LastEvent();

		/**
		 * The meta object literal for the '<em><b>Chanmpionship</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__CHANMPIONSHIP = eINSTANCE.getMatch_Chanmpionship();

		/**
		 * The meta object literal for the '<em><b>Round</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__ROUND = eINSTANCE.getMatch_Round();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__SECTION = eINSTANCE.getMatch_Section();

		/**
		 * The meta object literal for the '<em><b>Age Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__AGE_GROUP = eINSTANCE.getMatch_AgeGroup();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__CATEGORY = eINSTANCE.getMatch_Category();

		/**
		 * The meta object literal for the '<em><b>Season</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__SEASON = eINSTANCE.getMatch_Season();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__CODE = eINSTANCE.getMatch_Code();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PitchImpl <em>Pitch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PitchImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPitch()
		 * @generated
		 */
		EClass PITCH = eINSTANCE.getPitch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCH__NAME = eINSTANCE.getPitch_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCH__ADDRESS = eINSTANCE.getPitch_Address();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl <em>Team</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTeam()
		 * @generated
		 */
		EClass TEAM = eINSTANCE.getTeam();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__SUBJECT = eINSTANCE.getTeam_Subject();

		/**
		 * The meta object literal for the '<em><b>Goal Keeper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__GOAL_KEEPER = eINSTANCE.getTeam_GoalKeeper();

		/**
		 * The meta object literal for the '<em><b>Field Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__FIELD_PLAYERS = eINSTANCE.getTeam_FieldPlayers();

		/**
		 * The meta object literal for the '<em><b>Subtitute Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__SUBTITUTE_PLAYERS = eINSTANCE.getTeam_SubtitutePlayers();

		/**
		 * The meta object literal for the '<em><b>Subtitute Goal Keepers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__SUBTITUTE_GOAL_KEEPERS = eINSTANCE.getTeam_SubtituteGoalKeepers();

		/**
		 * The meta object literal for the '<em><b>Captain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__CAPTAIN = eINSTANCE.getTeam_Captain();

		/**
		 * The meta object literal for the '<em><b>Bench</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM__BENCH = eINSTANCE.getTeam_Bench();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__NAME = eINSTANCE.getTeam_Name();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PersonImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ID = eINSTANCE.getPerson_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Date Of Birth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__DATE_OF_BIRTH = eINSTANCE.getPerson_DateOfBirth();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ADDRESS = eINSTANCE.getPerson_Address();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.OfficialImpl <em>Official</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.OfficialImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getOfficial()
		 * @generated
		 */
		EClass OFFICIAL = eINSTANCE.getOfficial();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFICIAL__IDENTIFIER = eINSTANCE.getOfficial_Identifier();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.RefereeImpl <em>Referee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.RefereeImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getReferee()
		 * @generated
		 */
		EClass REFEREE = eINSTANCE.getReferee();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SupervisorImpl <em>Supervisor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SupervisorImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getSupervisor()
		 * @generated
		 */
		EClass SUPERVISOR = eINSTANCE.getSupervisor();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl <em>Team Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TeamMemberImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTeamMember()
		 * @generated
		 */
		EClass TEAM_MEMBER = eINSTANCE.getTeamMember();

		/**
		 * The meta object literal for the '<em><b>Licence Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_MEMBER__LICENCE_NUMBER = eINSTANCE.getTeamMember_LicenceNumber();

		/**
		 * The meta object literal for the '<em><b>Team</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_MEMBER__TEAM = eINSTANCE.getTeamMember_Team();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.PlayerImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Squad Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__SQUAD_NUMBER = eINSTANCE.getPlayer_SquadNumber();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalKeeperImpl <em>Goal Keeper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalKeeperImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getGoalKeeper()
		 * @generated
		 */
		EClass GOAL_KEEPER = eINSTANCE.getGoalKeeper();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.CrewImpl <em>Crew</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.CrewImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getCrew()
		 * @generated
		 */
		EClass CREW = eINSTANCE.getCrew();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREW__ROLE = eINSTANCE.getCrew_Role();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.EventImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIME = eINSTANCE.getEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Previous</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PREVIOUS = eINSTANCE.getEvent_Previous();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__NEXT = eINSTANCE.getEvent_Next();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.GoalImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__PLAYER = eINSTANCE.getGoal_Player();

		/**
		 * The meta object literal for the '<em><b>Scorer Team</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__SCORER_TEAM = eINSTANCE.getGoal_ScorerTeam();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FaultImpl <em>Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FaultImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getFault()
		 * @generated
		 */
		EClass FAULT = eINSTANCE.getFault();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT__PLAYER = eINSTANCE.getFault_Player();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT__TYPE = eINSTANCE.getFault_Type();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TimeOutImpl <em>Time Out</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.TimeOutImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getTimeOut()
		 * @generated
		 */
		EClass TIME_OUT = eINSTANCE.getTimeOut();

		/**
		 * The meta object literal for the '<em><b>Team</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_OUT__TEAM = eINSTANCE.getTimeOut_Team();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl <em>Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.SubstitutionImpl
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getSubstitution()
		 * @generated
		 */
		EClass SUBSTITUTION = eINSTANCE.getSubstitution();

		/**
		 * The meta object literal for the '<em><b>Substitute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTITUTION__SUBSTITUTE = eINSTANCE.getSubstitution_Substitute();

		/**
		 * The meta object literal for the '<em><b>Instead</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTITUTION__INSTEAD = eINSTANCE.getSubstitution_Instead();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole <em>Crew Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getCrewRole()
		 * @generated
		 */
		EEnum CREW_ROLE = eINSTANCE.getCrewRole();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType <em>Fault Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType
		 * @see hu.bme.mit.inf.mvsd.domain.generated.futsal.impl.FutsalPackageImpl#getFaultType()
		 * @generated
		 */
		EEnum FAULT_TYPE = eINSTANCE.getFaultType();

	}

} //FutsalPackage
