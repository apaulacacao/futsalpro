package hu.bme.mit.inf.mvsd.decreasingeventtime;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatch;
import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatcherFactory;
import hu.bme.mit.inf.mvsd.decreasingeventtime.DecreasingEventTimeMatcher;

public class DecreasingEventTimeConstraint0 extends Constraint<DecreasingEventTimeMatch> {

	private DecreasingEventTimeMatcherFactory matcherFactory;

	public DecreasingEventTimeConstraint0() throws IncQueryException {
		matcherFactory = DecreasingEventTimeMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "Event times should be monotone increasing";
	}

	@Override
	public EObject getLocationObject(DecreasingEventTimeMatch signature) {
		Object location = signature.get("event");
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
	public BaseGeneratedMatcherFactory<DecreasingEventTimeMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
