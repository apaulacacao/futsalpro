package hu.bme.mit.inf.mvsd.eventafterfullgametime;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatch;
import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatcherFactory;
import hu.bme.mit.inf.mvsd.eventafterfullgametime.EventAfterFullGameTimeMatcher;

public class EventAfterFullGameTimeConstraint0 extends Constraint<EventAfterFullGameTimeMatch> {

	private EventAfterFullGameTimeMatcherFactory matcherFactory;

	public EventAfterFullGameTimeConstraint0() throws IncQueryException {
		matcherFactory = EventAfterFullGameTimeMatcherFactory.instance();
	}

	@Override
	public String getMessage() {
		return "There should be no events after the extra times";
	}

	@Override
	public EObject getLocationObject(EventAfterFullGameTimeMatch signature) {
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
	public BaseGeneratedMatcherFactory<EventAfterFullGameTimeMatcher> getMatcherFactory() {
		return matcherFactory;
	}
}
