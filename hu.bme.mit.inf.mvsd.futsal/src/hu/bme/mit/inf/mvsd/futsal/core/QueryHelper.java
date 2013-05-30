package hu.bme.mit.inf.mvsd.futsal.core;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;
import hu.bme.mit.inf.mvsd.allplayers.AllPlayersMatcher;
import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatcher;
import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatcher;
import hu.bme.mit.inf.mvsd.duplicatesubstitution.DuplicateSubstitutionMatcher;
import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatcher;
import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatcher;
import hu.bme.mit.inf.mvsd.fieldplayers.FieldPlayersMatcher;
import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatcher;
import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatcher;
import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatcher;
import hu.bme.mit.inf.mvsd.teamfaultcountfirsthalf.TeamFaultCountFirstHalfMatcher;
import hu.bme.mit.inf.mvsd.teamfaultcountsecondhalf.TeamFaultCountSecondHalfMatcher;
import hu.bme.mit.inf.mvsd.teamgoalcount.TeamGoalCountMatcher;
import hu.bme.mit.inf.mvsd.teamgoalcounthalftime.TeamGoalCountHalftimeMatcher;
import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatcher;
import hu.bme.mit.inf.mvsd.teamsubstitutioncount.TeamSubstitutionCountMatcher;
import hu.bme.mit.inf.mvsd.teamtimeoutsfirsthalf.TeamTimeoutsFirstHalfMatcher;
import hu.bme.mit.inf.mvsd.teamtimeoutssecondhalf.TeamTimeoutsSecondHalfMatcher;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class QueryHelper {

	public static List<Player> getAllPlayers(Team team)
	{
		Resource resource = team.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				AllPlayersMatcher matcher = new AllPlayersMatcher(engine);
				ArrayList<Player> ret = new ArrayList<Player>();
				for (Object match : matcher.getAllValuesOfplayer(team)) {
					ret.add((Player)match);
				}
				return ret;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<Player>();
	}
	
	public static List<Player> getFieldPlayers(Team team)
	{
		Resource resource = team.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				FieldPlayersMatcher matcher = new FieldPlayersMatcher(engine);
				ArrayList<Player> ret = new ArrayList<Player>();
				for (Object match : matcher.getAllValuesOfplayer(team)) {
					ret.add((Player)match);
				}
				return ret;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<Player>();
	}
	
	public static int calculateScore(Team team, boolean halfTimeOnly) {
		Resource resource = team.eResource();
		int goalCount = 0;
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);

				if (halfTimeOnly) {
					// TeamGoalsHalfTimeMatcher matcher = new
					// TeamGoalsHalfTimeMatcher(engine);
					// goalCount = matcher.countMatches(team, null);

					TeamGoalCountHalftimeMatcher matcher = new TeamGoalCountHalftimeMatcher(engine);
					goalCount = matcher.getOneArbitraryMatch(team, null).getGoalCount();
				} else {
					// TeamGoalsMatcher matcher = new TeamGoalsMatcher(engine);
					// goalCount = matcher.countMatches(team, null);

					TeamGoalCountMatcher matcher = new TeamGoalCountMatcher(engine);
					goalCount = matcher.getOneArbitraryMatch(team, null).getGoalCount();
				}

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return goalCount;

	}

	public static int calculateTimeoutsLeft(Team team, int halftime) {
		if (halftime > 2 || halftime < 1)
			return 0;

		Resource resource = team.eResource();
		int timeoutsLeft = 0;

		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);

				if (halftime == 1) {
					TeamTimeoutsFirstHalfMatcher matcher = new TeamTimeoutsFirstHalfMatcher(engine);
					timeoutsLeft = 1 - matcher.countMatches();
				} else {
					TeamTimeoutsSecondHalfMatcher matcher = new TeamTimeoutsSecondHalfMatcher(engine);
					timeoutsLeft = 1 - matcher.countMatches();
				}

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}

		return timeoutsLeft;
	}

	public static int calculateTeamFaultCount(Team team, int halftime) {
		if (halftime < 1)
			return 0;

		Resource resource = team.eResource();
		int teamFaultCount = 0;

		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);

				if (halftime == 1) {
					TeamFaultCountFirstHalfMatcher matcher = new TeamFaultCountFirstHalfMatcher(engine);
					teamFaultCount = matcher.getOneArbitraryMatch(team, null).getFaultCount();
				} else {
					TeamFaultCountSecondHalfMatcher matcher = new TeamFaultCountSecondHalfMatcher(engine);
					teamFaultCount = matcher.getOneArbitraryMatch(team, null).getFaultCount();
				}

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}

		return teamFaultCount;
	}

	public static int calculateTeamSubstitutions(Team team) {
		Resource resource = team.eResource();
		int teamSubsCount = 0;

		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);

				TeamSubstitutionCountMatcher matcher = new TeamSubstitutionCountMatcher(engine);
				teamSubsCount = matcher.getOneArbitraryMatch(team, null).getSubsCount();

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return teamSubsCount;
	}

	public static boolean validateDuplicateSubstitution(Match match) throws ValidationException {
		boolean isValid = true;

		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				DuplicateSubstitutionMatcher matcher = new DuplicateSubstitutionMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Ugyanazt a játékost nem lehet kétszer lecserélni, vagy pályára küldeni.");
		return isValid;
	}
	
	public static boolean validateCaptainIsInOtherTeam(Match match) throws ValidationException {
		boolean isValid = true;

		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				CaptainIsInOtherTeamMatcher matcher = new CaptainIsInOtherTeamMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("A csapatkapitány nem játszhat a másik csapatban.");
		return isValid;
	}

	public static boolean validateDecreasingEventTime(Match match) throws ValidationException{
		boolean isValid = true;

		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				DecreasingEventTimeMatcher matcher = new DecreasingEventTimeMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Az események nem sorrendben kerültek feljegyzésre.");
		return isValid;
	}
	
	public static boolean validateEventAfterFullGametime(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				EventAfterFullGameTimeMatcher matcher = new EventAfterFullGameTimeMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Nem történhet esemény a játék befejezte után. A játék a rendes játékidõvel véget ér(t).");
		return isValid;
	}
	
	public static boolean validateEventAfterGameTimeIfEqualInInitialTime(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				EventAfterGameTimeIfEqualInInitialTimeMatcher matcher = new EventAfterGameTimeIfEqualInInitialTimeMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Nem történhet esemény a játék befejezte után. A játék a hosszabításokkal együtt véget ér(t).");
		return isValid;
	}
	
	public static boolean validateMatchTeamSubjectInconsistency(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				MatchTeamSubjectInconsistencyMatcher matcher = new MatchTeamSubjectInconsistencyMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Inconsistency in match-team relationship");
		return isValid;
	}
	
	public static boolean validatePlayerScoresAfterRedCard(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				PlayerScoresAfterRedCardMatcher matcher = new PlayerScoresAfterRedCardMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Piros lap után senki nem rúghat gólt.");
		return isValid;
	}
	
	public static boolean validatePlayerSubstitutesAfterRedCard(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				PlayerSubstitutesAfterRedCardMatcher matcher = new PlayerSubstitutesAfterRedCardMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("Piros lap után nem cserélhetõ vissza a kiállított játékos.");
		return isValid;
	}
	
	public static boolean validateTeamMemberNotInContainingTeam(Match match) throws ValidationException{
		boolean isValid = true;
		
		Resource resource = match.eResource();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				TeamMemberNotInContainingTeamMatcher matcher = new TeamMemberNotInContainingTeamMatcher(engine);
				if (matcher.countMatches() > 0)
					isValid = false;
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		if (isValid == false) throw new ValidationException("A csapat tagja nincs regisztrálva a csapatban.");
		return isValid;
	}
	
	public static boolean validateIncQueryAll(Match match) throws ValidationException{
		//validateDuplicateSubstitution(match);
		validateCaptainIsInOtherTeam(match);
		validateDecreasingEventTime(match);
		validateEventAfterFullGametime(match);
		validateEventAfterGameTimeIfEqualInInitialTime(match);
		validateMatchTeamSubjectInconsistency(match);
		validatePlayerScoresAfterRedCard(match);
		validatePlayerSubstitutesAfterRedCard(match);
		validateTeamMemberNotInContainingTeam(match);
		return true;
	}

}
