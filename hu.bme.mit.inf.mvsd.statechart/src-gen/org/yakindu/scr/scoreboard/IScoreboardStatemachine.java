package org.yakindu.scr.scoreboard;
import java.util.List;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimedStatemachine;

public interface IScoreboardStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface SCITeam1 {
		public void raiseGoal();
		public void raiseFault();
		public void raiseTimeout();
		public void raiseSubstitute();
		public int getScore();
		public void setScore(int value);
		public int getFaults();
		public void setFaults(int value);
		public int getTimeOutsLeft();
		public void setTimeOutsLeft(int value);

	}

	public SCITeam1 getSCITeam1();

	public interface SCITeam2 {
		public void raiseGoal();
		public void raiseFault();
		public void raiseTimeout();
		public void raiseSubstitute();
		public int getScore();
		public void setScore(int value);
		public int getFaults();
		public void setFaults(int value);
		public int getTimeOutsLeft();
		public void setTimeOutsLeft(int value);

	}

	public SCITeam2 getSCITeam2();

	public interface SCICallback {
		public boolean isRaisedGoal();
		public boolean isRaisedFault();
		public boolean isRaisedSubstitute();
		public boolean isRaisedTimeout();
		public boolean isRaisedRefresh();
		public boolean isRaisedEoHalf();
		public boolean isRaisedEoFull();
		public boolean isRaisedEoExtra1();
		public boolean isRaisedEoExtra2();
		public boolean isRaisedEoMatch();
		public List<SCICallbackListener> getListeners();

		public void setSCICallbackOperationCallback(
				SCICallbackOperationCallback operationCallback);
	}

	public interface SCICallbackListener {
		public void onGoalRaised();
		public void onFaultRaised();
		public void onSubstituteRaised();
		public void onTimeoutRaised();
		public void onRefreshRaised();
		public void onEoHalfRaised();
		public void onEoFullRaised();
		public void onEoExtra1Raised();
		public void onEoExtra2Raised();
		public void onEoMatchRaised();
	}

	public interface SCICallbackOperationCallback {
		public void signal();
	}

	public SCICallback getSCICallback();

	public interface SCIWatch {
		public void raiseStart();
		public void raiseStop();
		public void raiseSet(int value);
		public void raiseReset();
		public void raiseAbort();
		public void raiseEnd();
		public int getTime();
		public void setTime(int value);
		public int getTimeout();
		public void setTimeout(int value);

	}

	public SCIWatch getSCIWatch();

}
