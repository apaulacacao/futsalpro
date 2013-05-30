package hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatch;
import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatcherFactory;
import hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime.EventAfterGameTimeIfEqualInInitialTimeMatcher;

public class EventAfterGameTimeIfEqualInInitialTimeConstraint0 extends Constraint<EventAfterGameTimeIfEqualInInitialTimeMatch> {

	private EventAfterGameTimeIfEqualInInitialTimeMatcherFactory matcherFactory;

	public EventAfterGameTimeIfEqualInInitialTimeConstraint0() throws IncQueryException {
		matcherFactory = EventAfterGameTimeIfEqualInInitialTimeMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "There should be no events after the initial game time unless it is a tie";
	}

	@Override
	public EObject getLocationObject(EventAfterGameTimeIfEqualInInitialTimeMatch signature) {
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
	public BaseGeneratedMatcherFactory<EventAfterGameTimeIfEqualInInitialTimeMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
