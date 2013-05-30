package hu.bme.mit.inf.mvsd.playersubstitutesafterredcard;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatch;
import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatcherFactory;
import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatcher;

public class PlayerSubstitutesAfterRedCardConstraint0 extends Constraint<PlayerSubstitutesAfterRedCardMatch> {

	private PlayerSubstitutesAfterRedCardMatcherFactory matcherFactory;

	public PlayerSubstitutesAfterRedCardConstraint0() throws IncQueryException {
		matcherFactory = PlayerSubstitutesAfterRedCardMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "Player with red card should not come into play";
	}

	@Override
	public EObject getLocationObject(PlayerSubstitutesAfterRedCardMatch signature) {
		Object location = signature.get("subst");
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
	public BaseGeneratedMatcherFactory<PlayerSubstitutesAfterRedCardMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
