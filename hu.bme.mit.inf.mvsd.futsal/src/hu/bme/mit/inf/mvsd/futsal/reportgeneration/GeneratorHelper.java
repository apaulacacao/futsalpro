package hu.bme.mit.inf.mvsd.futsal.reportgeneration;

import hu.bme.mit.inf.mvsd.futsal.core.QueryHelper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;
import hu.bme.mit.inf.mvsd.teamfaults.TeamFaultsMatch;
import hu.bme.mit.inf.mvsd.teamfaults.TeamFaultsMatcher;
import hu.bme.mit.inf.mvsd.teamgoals.TeamGoalsMatch;
import hu.bme.mit.inf.mvsd.teamgoals.TeamGoalsMatcher;
import hu.bme.mit.inf.mvsd.teamsubstitutions.TeamSubstitutionsMatch;
import hu.bme.mit.inf.mvsd.teamsubstitutions.TeamSubstitutionsMatcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class GeneratorHelper extends QueryHelper {

	public static void writeHtmlFile(String path, String content) throws IOException {
		File f = new File(path);
		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
		FileWriter fstream = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fstream);
		bw.write(content);
		bw.close();
	}

	public static String roleToString(CrewRole role) {
		String ret;
		switch (role) {
		case COACH:
			ret = "edzõ";
			break;
		case MANAGER:
			ret = "vezetõedzõ";
			break;
		case MASSEUR:
			ret = "gyúró";
			break;
		case MEDIC:
			ret = "orvos";
			break;
		case OTHER:
			ret = "egyéb";
			break;
		case TECHNICAL_MANAGER:
			ret = "technikai vezetõ";
			break;
		default:
			ret = "egyéb";
			break;
		}
		return ret;
	}

	public static String faultToString(FaultType type) {
		String ret;
		switch (type) {
		case PENALTY:
			ret = "büntetõ";
			break;
		case RED_CARD:
			ret = "piros lap";
			break;
		case YELLOW_CARD:
			ret = "sárga lap";
			break;
		default:
			ret = "";
			break;
		}
		return ret;
	}

	public static Goal[] goalsOf(Team team) {
		Resource resource = team.eResource();
		ArrayList<Goal> goals = new ArrayList<Goal>();

		if (resource != null) {
			IncQueryEngine engine;
			try {
				ArrayList<TeamGoalsMatch> teamGoalsMatches = new ArrayList<TeamGoalsMatch>();
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				TeamGoalsMatcher matcher = new TeamGoalsMatcher(engine);
				teamGoalsMatches = (ArrayList<TeamGoalsMatch>) matcher.getAllMatches(team, null);

				Comparator<TeamGoalsMatch> comparator = new Comparator<TeamGoalsMatch>() {
					public int compare(TeamGoalsMatch m1, TeamGoalsMatch m2) {
						return ((Goal) m1.getGoal()).getTime() - ((Goal) m2.getGoal()).getTime();
					}
				};

				Collections.sort(teamGoalsMatches, comparator);

				for (TeamGoalsMatch teamGoalsMatch : teamGoalsMatches) {
					goals.add((Goal) teamGoalsMatch.getGoal());
				}
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}
		return goals.toArray(new Goal[0]);
	}

	public static Fault[] faultsOf(Team team) {
		Resource resource = team.eResource();
		ArrayList<Fault> faults = new ArrayList<>();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				ArrayList<TeamFaultsMatch> teamFaultsMatches = new ArrayList<>();
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				TeamFaultsMatcher matcher = new TeamFaultsMatcher(engine);
				teamFaultsMatches = (ArrayList<TeamFaultsMatch>) matcher.getAllMatches(team, null);

				Comparator<TeamFaultsMatch> comparator = new Comparator<TeamFaultsMatch>() {
					public int compare(TeamFaultsMatch m1, TeamFaultsMatch m2) {
						return ((Fault) m1.getFault()).getTime() - ((Fault) m2.getFault()).getTime();
					}
				};

				Collections.sort(teamFaultsMatches, comparator);

				for (TeamFaultsMatch teamFaultsMatch : teamFaultsMatches) {
					faults.add((Fault) teamFaultsMatch.getFault());
				}
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}

		return faults.toArray(new Fault[0]);
	}

	public static Substitution[] substitutionsOf(Team team) {
		Resource resource = team.eResource();
		ArrayList<Substitution> substitutions = new ArrayList<>();
		if (resource != null) {
			IncQueryEngine engine;
			try {
				ArrayList<TeamSubstitutionsMatch> teamSubstitutionMatches = new ArrayList<>();
				engine = EngineManager.getInstance().getIncQueryEngine(resource);
				TeamSubstitutionsMatcher matcher = new TeamSubstitutionsMatcher(engine);
				teamSubstitutionMatches = (ArrayList<TeamSubstitutionsMatch>) matcher.getAllMatches(team, null);

				Comparator<TeamSubstitutionsMatch> comparator = new Comparator<TeamSubstitutionsMatch>() {
					public int compare(TeamSubstitutionsMatch m1, TeamSubstitutionsMatch m2) {
						return ((Substitution) m1.getSubst()).getTime() - ((Substitution) m2.getSubst()).getTime();
					}
				};

				Collections.sort(teamSubstitutionMatches, comparator);

				for (TeamSubstitutionsMatch teamSubstitutionsMatch : teamSubstitutionMatches) {
					substitutions.add((Substitution) teamSubstitutionsMatch.getSubst());
				}
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}

		return substitutions.toArray(new Substitution[0]);
	}
	
	public static String timeToString(int elapsedTime, boolean padFirst) {
		String ret = (elapsedTime/60 < 10 && padFirst ? "0" : "") + String.valueOf(elapsedTime/60);
		ret += ":";
		ret += (elapsedTime%60 < 10 ? "0" : "") + String.valueOf(elapsedTime%60);
		return ret;
	}
	
	public static String generatePositiveAdverb()
	{
		String[] words = new String[] {
				"fantasztikus ",
				"elképesztõ ",
				"csodálatos ",
				"eget rengetõ ",
				"hihetetlen ",
				"",
				"",
				"",
				"",
				""
		};
		
		Random r = new Random(new Date().getTime());
		return words[r.nextInt(words.length)];
	}
	
	public static String generateNegativeAdverb(boolean brutal)
	{
		String[] words = new String[] {
				"csúnyán ",
				"sunyin ",
				"alattomosan ",
				"véletlenül ",
				"",
				"",
				"",
				"",
				""
		};
		
		String[] brutalwords = new String[] {
				"sportszerûtlenül ",
				"brutálisan ",
				"durván ",
				"keményen ",
				"",
				"",
				"",
				"",
				""
		};
		
		Random r = new Random(new Date().getTime());
		return brutal ? brutalwords[r.nextInt(brutalwords.length)] : words[r.nextInt(words.length)];
	}
}
