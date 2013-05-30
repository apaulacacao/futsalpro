package hu.bme.mit.inf.mvsd.playerscoresafterredcard;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatch;
import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatcherFactory;
import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatcher;

public class PlayerScoresAfterRedCardConstraint0 extends Constraint<PlayerScoresAfterRedCardMatch> {

	private PlayerScoresAfterRedCardMatcherFactory matcherFactory;

	public PlayerScoresAfterRedCardConstraint0() throws IncQueryException {
		matcherFactory = PlayerScoresAfterRedCardMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "Player with red card should not score goal";
	}

	@Override
	public EObject getLocationObject(PlayerScoresAfterRedCardMatch signature) {
		Object location = signature.get("goal");
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
	public BaseGeneratedMatcherFactory<PlayerScoresAfterRedCardMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
