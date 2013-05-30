package hu.bme.mit.inf.mvsd.captainisinotherteam;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatch;
import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatcherFactory;
import hu.bme.mit.inf.mvsd.captainisinotherteam.CaptainIsInOtherTeamMatcher;

public class CaptainIsInOtherTeamConstraint0 extends Constraint<CaptainIsInOtherTeamMatch> {

	private CaptainIsInOtherTeamMatcherFactory matcherFactory;

	public CaptainIsInOtherTeamConstraint0() throws IncQueryException {
		matcherFactory = CaptainIsInOtherTeamMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "The captain of a team should be a member of the team";
	}

	@Override
	public EObject getLocationObject(CaptainIsInOtherTeamMatch signature) {
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
	public BaseGeneratedMatcherFactory<CaptainIsInOtherTeamMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
