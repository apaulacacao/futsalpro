package hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatch;
import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatcherFactory;
import hu.bme.mit.inf.mvsd.matchteamsubjectinconsistency.MatchTeamSubjectInconsistencyMatcher;

public class MatchTeamSubjectInconsistencyConstraint0 extends Constraint<MatchTeamSubjectInconsistencyMatch> {

	private MatchTeamSubjectInconsistencyMatcherFactory matcherFactory;

	public MatchTeamSubjectInconsistencyConstraint0() throws IncQueryException {
		matcherFactory = MatchTeamSubjectInconsistencyMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "The subject of the team is not the containing match!";
	}

	@Override
	public EObject getLocationObject(MatchTeamSubjectInconsistencyMatch signature) {
		Object location = signature.get("team");
		if(location instanceof EObject){
			return (EObject) location;
		}
		return null;
	}
	
	@Override
	public int getSeverity() {
		return ValidationUtil.getSeverity("error");
	}
	
	@Override
	public BaseGeneratedMatcherFactory<MatchTeamSubjectInconsistencyMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
