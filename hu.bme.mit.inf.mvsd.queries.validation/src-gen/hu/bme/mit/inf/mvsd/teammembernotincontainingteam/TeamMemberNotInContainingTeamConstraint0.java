package hu.bme.mit.inf.mvsd.teammembernotincontainingteam;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatch;
import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatcherFactory;
import hu.bme.mit.inf.mvsd.teammembernotincontainingteam.TeamMemberNotInContainingTeamMatcher;

public class TeamMemberNotInContainingTeamConstraint0 extends Constraint<TeamMemberNotInContainingTeamMatch> {

	private TeamMemberNotInContainingTeamMatcherFactory matcherFactory;

	public TeamMemberNotInContainingTeamConstraint0() throws IncQueryException {
		matcherFactory = TeamMemberNotInContainingTeamMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "The team member is not assigned to the containing team";
	}

	@Override
	public EObject getLocationObject(TeamMemberNotInContainingTeamMatch signature) {
		Object location = signature.get("member");
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
	public BaseGeneratedMatcherFactory<TeamMemberNotInContainingTeamMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
