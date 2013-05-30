package hu.bme.mit.inf.mvsd.futsal.core;

import java.awt.Toolkit;

import org.yakindu.scr.scoreboard.IScoreboardStatemachine.SCICallbackListener;
import org.yakindu.scr.scoreboard.IScoreboardStatemachine.SCICallbackOperationCallback;

public class FutsalCallbackListener implements SCICallbackListener, SCICallbackOperationCallback {

	private FutsalCore core;
	
	public FutsalCallbackListener(FutsalCore futsalCore) {
		core = futsalCore;
	}
	
	@Override
	public void onGoalRaised() {
		core.addLastGoal();
	}

	@Override
	public void onFaultRaised() {
		core.addLastFault();
	}

	@Override
	public void onSubstituteRaised() {
		core.addLastSubstitution();
	}

	@Override
	public void onTimeoutRaised() {
		core.addLastTimeout();
	}

	@Override
	public void onRefreshRaised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.updateUi();
		}
	}

	@Override
	public void onEoHalfRaised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.endOfPart(1);
		}
	}

	@Override
	public void onEoFullRaised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.endOfPart(2);
		}
	}

	@Override
	public void onEoExtra1Raised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.endOfPart(3);
		}
	}

	@Override
	public void onEoExtra2Raised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.endOfPart(4);
		}
	}

	@Override
	public void onEoMatchRaised() {
		for (UpdateListener listener : core.updateListeners) {
			listener.endOfPart(5);
		}
	}

	@Override
	public void signal() {
		Toolkit.getDefaultToolkit().beep();
	}

}
