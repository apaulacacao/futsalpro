package org.yakindu.scr.scoreboard;
import java.util.LinkedList;
import java.util.List;
import org.yakindu.scr.TimeEvent;
import org.yakindu.scr.ITimerService;

public class ScoreboardStatemachine implements IScoreboardStatemachine {

	private final TimeEvent scoreboard_main_region_Working_Watch_TimeOut_time_event_0 = new TimeEvent(
			true, 0);
	private final TimeEvent scoreboard_main_region_Working_Watch_Running_time_event_0 = new TimeEvent(
			true, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class SCITeam1Impl implements SCITeam1 {

		private boolean goal;

		public void raiseGoal() {
			goal = true;
		}

		private boolean fault;

		public void raiseFault() {
			fault = true;
		}

		private boolean timeout;

		public void raiseTimeout() {
			timeout = true;
		}

		private boolean substitute;

		public void raiseSubstitute() {
			substitute = true;
		}

		private int score;

		public int getScore() {
			return score;
		}

		public void setScore(int value) {
			this.score = value;
		}

		private int faults;

		public int getFaults() {
			return faults;
		}

		public void setFaults(int value) {
			this.faults = value;
		}

		private int timeOutsLeft;

		public int getTimeOutsLeft() {
			return timeOutsLeft;
		}

		public void setTimeOutsLeft(int value) {
			this.timeOutsLeft = value;
		}

		public void clearEvents() {
			goal = false;
			fault = false;
			timeout = false;
			substitute = false;
		}

	}

	private SCITeam1Impl sCITeam1;
	private final class SCITeam2Impl implements SCITeam2 {

		private boolean goal;

		public void raiseGoal() {
			goal = true;
		}

		private boolean fault;

		public void raiseFault() {
			fault = true;
		}

		private boolean timeout;

		public void raiseTimeout() {
			timeout = true;
		}

		private boolean substitute;

		public void raiseSubstitute() {
			substitute = true;
		}

		private int score;

		public int getScore() {
			return score;
		}

		public void setScore(int value) {
			this.score = value;
		}

		private int faults;

		public int getFaults() {
			return faults;
		}

		public void setFaults(int value) {
			this.faults = value;
		}

		private int timeOutsLeft;

		public int getTimeOutsLeft() {
			return timeOutsLeft;
		}

		public void setTimeOutsLeft(int value) {
			this.timeOutsLeft = value;
		}

		public void clearEvents() {
			goal = false;
			fault = false;
			timeout = false;
			substitute = false;
		}

	}

	private SCITeam2Impl sCITeam2;
	private final class SCICallbackImpl implements SCICallback {

		private List<SCICallbackListener> listeners = new LinkedList<SCICallbackListener>();

		public List<SCICallbackListener> getListeners() {
			return listeners;
		}

		private SCICallbackOperationCallback operationCallback;

		public void setSCICallbackOperationCallback(
				SCICallbackOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private boolean goal;

		public boolean isRaisedGoal() {
			return goal;
		}

		private void raiseGoal() {
			goal = true;
			for (SCICallbackListener listener : listeners) {
				listener.onGoalRaised();
			}
		}

		private boolean fault;

		public boolean isRaisedFault() {
			return fault;
		}

		private void raiseFault() {
			fault = true;
			for (SCICallbackListener listener : listeners) {
				listener.onFaultRaised();
			}
		}

		private boolean substitute;

		public boolean isRaisedSubstitute() {
			return substitute;
		}

		private void raiseSubstitute() {
			substitute = true;
			for (SCICallbackListener listener : listeners) {
				listener.onSubstituteRaised();
			}
		}

		private boolean timeout;

		public boolean isRaisedTimeout() {
			return timeout;
		}

		private void raiseTimeout() {
			timeout = true;
			for (SCICallbackListener listener : listeners) {
				listener.onTimeoutRaised();
			}
		}

		private boolean refresh;

		public boolean isRaisedRefresh() {
			return refresh;
		}

		private void raiseRefresh() {
			refresh = true;
			for (SCICallbackListener listener : listeners) {
				listener.onRefreshRaised();
			}
		}

		private boolean eoHalf;

		public boolean isRaisedEoHalf() {
			return eoHalf;
		}

		private void raiseEoHalf() {
			eoHalf = true;
			for (SCICallbackListener listener : listeners) {
				listener.onEoHalfRaised();
			}
		}

		private boolean eoFull;

		public boolean isRaisedEoFull() {
			return eoFull;
		}

		private void raiseEoFull() {
			eoFull = true;
			for (SCICallbackListener listener : listeners) {
				listener.onEoFullRaised();
			}
		}

		private boolean eoExtra1;

		public boolean isRaisedEoExtra1() {
			return eoExtra1;
		}

		private void raiseEoExtra1() {
			eoExtra1 = true;
			for (SCICallbackListener listener : listeners) {
				listener.onEoExtra1Raised();
			}
		}

		private boolean eoExtra2;

		public boolean isRaisedEoExtra2() {
			return eoExtra2;
		}

		private void raiseEoExtra2() {
			eoExtra2 = true;
			for (SCICallbackListener listener : listeners) {
				listener.onEoExtra2Raised();
			}
		}

		private boolean eoMatch;

		public boolean isRaisedEoMatch() {
			return eoMatch;
		}

		private void raiseEoMatch() {
			eoMatch = true;
			for (SCICallbackListener listener : listeners) {
				listener.onEoMatchRaised();
			}
		}

		public void clearEvents() {
		}

		public void clearOutEvents() {
			goal = false;
			fault = false;
			substitute = false;
			timeout = false;
			refresh = false;
			eoHalf = false;
			eoFull = false;
			eoExtra1 = false;
			eoExtra2 = false;
			eoMatch = false;
		}
	}

	private SCICallbackImpl sCICallback;
	private final class SCIWatchImpl implements SCIWatch {

		private boolean start;

		public void raiseStart() {
			start = true;
		}

		private boolean stop;

		public void raiseStop() {
			stop = true;
		}

		private boolean set;

		private int setValue;

		public void raiseSet(int value) {
			set = true;
			setValue = value;
		}

		private int getSetValue() {
			if (!set)
				throw new IllegalStateException(
						"Illegal event value acces. Event Set is not raised!");
			return setValue;
		}

		private boolean reset;

		public void raiseReset() {
			reset = true;
		}

		private boolean abort;

		public void raiseAbort() {
			abort = true;
		}

		private boolean end;

		public void raiseEnd() {
			end = true;
		}

		private int time;

		public int getTime() {
			return time;
		}

		public void setTime(int value) {
			this.time = value;
		}

		private int timeout;

		public int getTimeout() {
			return timeout;
		}

		public void setTimeout(int value) {
			this.timeout = value;
		}

		public void clearEvents() {
			start = false;
			stop = false;
			set = false;
			reset = false;
			abort = false;
			end = false;
		}

	}

	private SCIWatchImpl sCIWatch;

	public enum State {
		main_region_Init, main_region_Working, main_region_Working_Match_FirstHalf, main_region_Working_Match_SecondHalf, main_region_Working_Match_FirstExtra, main_region_Working_Match_SecondExtra, main_region_Working_Match_EndOfMatch, main_region_Working_Events_Listening, main_region_Working_Events_Goal, main_region_Working_Events_Substitute, main_region_Working_Events_Fault, main_region_Working_Watch_TimeOut, main_region_Working_Watch_Running, main_region_Working_Watch_Stopped, main_region_Finished, main_region__final_, $NullState$
	};

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public ScoreboardStatemachine() {

		sCITeam1 = new SCITeam1Impl();
		sCITeam2 = new SCITeam2Impl();
		sCICallback = new SCICallbackImpl();
		sCIWatch = new SCIWatchImpl();

		scoreboard_main_region_Working_Watch_TimeOut_time_event_0
				.setStatemachine(this);
		scoreboard_main_region_Working_Watch_Running_time_event_0
				.setStatemachine(this);
	}

	public void init() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCITeam1.score = 0;

		sCITeam1.faults = 0;

		sCITeam1.timeOutsLeft = 1;

		sCITeam2.score = 0;

		sCITeam2.faults = 0;

		sCITeam2.timeOutsLeft = 1;

		sCIWatch.time = 0;

		sCIWatch.timeout = 60;
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = timerService.getSystemTimeMillis();
		entryAction();

		sCITeam1.faults = 0;

		sCITeam1.score = 0;

		sCITeam1.timeOutsLeft = 1;

		sCITeam2.faults = 0;

		sCITeam2.score = 0;

		sCITeam2.timeOutsLeft = 1;

		sCIWatch.time = 0;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Init :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Working_Match_FirstHalf :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Working_Match_SecondHalf :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Working_Match_FirstExtra :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Working_Match_SecondExtra :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Working_Match_EndOfMatch :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Finished :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region__final_ :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_Working_Events_Listening :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Working_Events_Goal :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Working_Events_Substitute :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Working_Events_Fault :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case main_region_Working_Watch_TimeOut :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;

				getTimerService()
						.resetTimer(
								scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
				break;

			case main_region_Working_Watch_Running :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;

				getTimerService()
						.resetTimer(
								scoreboard_main_region_Working_Watch_Running_time_event_0);
				break;

			case main_region_Working_Watch_Stopped :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCITeam1.clearEvents();
		sCITeam2.clearEvents();
		sCICallback.clearEvents();
		sCIWatch.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
		sCICallback.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_Init :
				return stateVector[0] == State.main_region_Init;
			case main_region_Working :
				return stateVector[0].ordinal() >= State.main_region_Working
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_Working_Watch_Stopped
								.ordinal();
			case main_region_Working_Match_FirstHalf :
				return stateVector[0] == State.main_region_Working_Match_FirstHalf;
			case main_region_Working_Match_SecondHalf :
				return stateVector[0] == State.main_region_Working_Match_SecondHalf;
			case main_region_Working_Match_FirstExtra :
				return stateVector[0] == State.main_region_Working_Match_FirstExtra;
			case main_region_Working_Match_SecondExtra :
				return stateVector[0] == State.main_region_Working_Match_SecondExtra;
			case main_region_Working_Match_EndOfMatch :
				return stateVector[0] == State.main_region_Working_Match_EndOfMatch;
			case main_region_Working_Events_Listening :
				return stateVector[1] == State.main_region_Working_Events_Listening;
			case main_region_Working_Events_Goal :
				return stateVector[1] == State.main_region_Working_Events_Goal;
			case main_region_Working_Events_Substitute :
				return stateVector[1] == State.main_region_Working_Events_Substitute;
			case main_region_Working_Events_Fault :
				return stateVector[1] == State.main_region_Working_Events_Fault;
			case main_region_Working_Watch_TimeOut :
				return stateVector[2] == State.main_region_Working_Watch_TimeOut;
			case main_region_Working_Watch_Running :
				return stateVector[2] == State.main_region_Working_Watch_Running;
			case main_region_Working_Watch_Stopped :
				return stateVector[2] == State.main_region_Working_Watch_Stopped;
			case main_region_Finished :
				return stateVector[0] == State.main_region_Finished;
			case main_region__final_ :
				return stateVector[0] == State.main_region__final_;
			default :
				return false;
		}
	}

	public void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}

	public ITimerService getTimerService() {
		return timerService;
	}

	public void onTimeEventRaised(TimeEvent timeEvent) {
		timeEvents[timeEvent.getIndex()] = true;
	}

	public SCITeam1 getSCITeam1() {
		return sCITeam1;
	}
	public SCITeam2 getSCITeam2() {
		return sCITeam2;
	}
	public SCICallback getSCICallback() {
		return sCICallback;
	}
	public SCIWatch getSCIWatch() {
		return sCIWatch;
	}

	/* Entry action for statechart 'scoreboard'. */
	private void entryAction() {
	}

	/* Exit action for state 'scoreboard'. */
	private void exitAction() {
	}

	/* The reactions of state Init. */
	private void reactMain_region_Init() {
		if (true) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Working_Match_FirstHalf;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Working_Events_Listening;

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Working_Watch_Stopped;
		}
	}

	/* The reactions of state FirstHalf. */
	private void reactMain_region_Working_Match_FirstHalf() {
		if (sCIWatch.reset) {
			switch (stateVector[0]) {
				case main_region_Working_Match_FirstHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_FirstExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_EndOfMatch :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_Working_Events_Listening :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Goal :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Substitute :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Fault :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case main_region_Working_Watch_TimeOut :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
					break;

				case main_region_Working_Watch_Running :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_Running_time_event_0);
					break;

				case main_region_Working_Watch_Stopped :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			sCITeam1.faults = 0;

			sCITeam1.score = 0;

			sCITeam1.timeOutsLeft = 1;

			sCITeam2.faults = 0;

			sCITeam2.score = 0;

			sCITeam2.timeOutsLeft = 1;

			sCIWatch.time = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Init;
		} else {
			if (sCIWatch.abort) {
				switch (stateVector[0]) {
					case main_region_Working_Match_FirstHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_FirstExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_EndOfMatch :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case main_region_Working_Events_Listening :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Goal :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Substitute :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Fault :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[2]) {
					case main_region_Working_Watch_TimeOut :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
						break;

					case main_region_Working_Watch_Running :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_Running_time_event_0);
						break;

					case main_region_Working_Watch_Stopped :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Finished;
			} else {
				if (sCIWatch.time >= 20 * 60) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIWatch.raiseStop();

					sCICallback.raiseEoHalf();

					sCITeam1.faults = 0;

					sCITeam2.faults = 0;

					sCITeam1.timeOutsLeft = 1;

					sCITeam2.timeOutsLeft = 1;

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Working_Match_SecondHalf;
				}
			}
		}
	}

	/* The reactions of state SecondHalf. */
	private void reactMain_region_Working_Match_SecondHalf() {
		if (sCIWatch.reset) {
			switch (stateVector[0]) {
				case main_region_Working_Match_FirstHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_FirstExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_EndOfMatch :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_Working_Events_Listening :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Goal :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Substitute :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Fault :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case main_region_Working_Watch_TimeOut :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
					break;

				case main_region_Working_Watch_Running :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_Running_time_event_0);
					break;

				case main_region_Working_Watch_Stopped :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			sCITeam1.faults = 0;

			sCITeam1.score = 0;

			sCITeam1.timeOutsLeft = 1;

			sCITeam2.faults = 0;

			sCITeam2.score = 0;

			sCITeam2.timeOutsLeft = 1;

			sCIWatch.time = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Init;
		} else {
			if (sCIWatch.abort) {
				switch (stateVector[0]) {
					case main_region_Working_Match_FirstHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_FirstExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_EndOfMatch :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case main_region_Working_Events_Listening :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Goal :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Substitute :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Fault :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[2]) {
					case main_region_Working_Watch_TimeOut :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
						break;

					case main_region_Working_Watch_Running :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_Running_time_event_0);
						break;

					case main_region_Working_Watch_Stopped :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Finished;
			} else {
				if (sCIWatch.time >= 40 * 60) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIWatch.raiseStop();

					sCICallback.raiseEoFull();

					if (sCITeam1.score != sCITeam2.score) {
						sCICallback.raiseEoMatch();

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Working_Match_EndOfMatch;
					} else {
						if (true) {
							sCITeam1.timeOutsLeft = 0;

							sCITeam2.timeOutsLeft = 0;

							nextStateIndex = 0;
							stateVector[0] = State.main_region_Working_Match_FirstExtra;
						}
					}
				} else {
					if (sCIWatch.time < 20 * 60) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Working_Match_FirstHalf;
					}
				}
			}
		}
	}

	/* The reactions of state FirstExtra. */
	private void reactMain_region_Working_Match_FirstExtra() {
		if (sCIWatch.reset) {
			switch (stateVector[0]) {
				case main_region_Working_Match_FirstHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_FirstExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_EndOfMatch :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_Working_Events_Listening :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Goal :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Substitute :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Fault :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case main_region_Working_Watch_TimeOut :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
					break;

				case main_region_Working_Watch_Running :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_Running_time_event_0);
					break;

				case main_region_Working_Watch_Stopped :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			sCITeam1.faults = 0;

			sCITeam1.score = 0;

			sCITeam1.timeOutsLeft = 1;

			sCITeam2.faults = 0;

			sCITeam2.score = 0;

			sCITeam2.timeOutsLeft = 1;

			sCIWatch.time = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Init;
		} else {
			if (sCIWatch.abort) {
				switch (stateVector[0]) {
					case main_region_Working_Match_FirstHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_FirstExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_EndOfMatch :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case main_region_Working_Events_Listening :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Goal :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Substitute :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Fault :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[2]) {
					case main_region_Working_Watch_TimeOut :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
						break;

					case main_region_Working_Watch_Running :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_Running_time_event_0);
						break;

					case main_region_Working_Watch_Stopped :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Finished;
			} else {
				if (sCIWatch.time >= 45 * 60) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIWatch.raiseStop();

					sCICallback.raiseEoExtra1();

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Working_Match_SecondExtra;
				} else {
					if (sCIWatch.time < 40 * 60) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Working_Match_SecondHalf;
					}
				}
			}
		}
	}

	/* The reactions of state SecondExtra. */
	private void reactMain_region_Working_Match_SecondExtra() {
		if (sCIWatch.reset) {
			switch (stateVector[0]) {
				case main_region_Working_Match_FirstHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_FirstExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_EndOfMatch :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_Working_Events_Listening :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Goal :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Substitute :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Fault :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case main_region_Working_Watch_TimeOut :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
					break;

				case main_region_Working_Watch_Running :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_Running_time_event_0);
					break;

				case main_region_Working_Watch_Stopped :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			sCITeam1.faults = 0;

			sCITeam1.score = 0;

			sCITeam1.timeOutsLeft = 1;

			sCITeam2.faults = 0;

			sCITeam2.score = 0;

			sCITeam2.timeOutsLeft = 1;

			sCIWatch.time = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Init;
		} else {
			if (sCIWatch.abort) {
				switch (stateVector[0]) {
					case main_region_Working_Match_FirstHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_FirstExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_EndOfMatch :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case main_region_Working_Events_Listening :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Goal :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Substitute :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Fault :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[2]) {
					case main_region_Working_Watch_TimeOut :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
						break;

					case main_region_Working_Watch_Running :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_Running_time_event_0);
						break;

					case main_region_Working_Watch_Stopped :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Finished;
			} else {
				if (sCIWatch.time >= 50 * 60) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIWatch.raiseStop();

					sCICallback.raiseEoExtra2();

					sCICallback.raiseEoMatch();

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Working_Match_EndOfMatch;
				} else {
					if (sCIWatch.time < 45 * 60) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Working_Match_FirstExtra;
					}
				}
			}
		}
	}

	/* The reactions of state EndOfMatch. */
	private void reactMain_region_Working_Match_EndOfMatch() {
		if (sCIWatch.reset) {
			switch (stateVector[0]) {
				case main_region_Working_Match_FirstHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondHalf :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_FirstExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_SecondExtra :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Working_Match_EndOfMatch :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_Working_Events_Listening :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Goal :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Substitute :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_Working_Events_Fault :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[2]) {
				case main_region_Working_Watch_TimeOut :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
					break;

				case main_region_Working_Watch_Running :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					getTimerService()
							.resetTimer(
									scoreboard_main_region_Working_Watch_Running_time_event_0);
					break;

				case main_region_Working_Watch_Stopped :
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;
					break;

				default :
					break;
			}

			sCITeam1.faults = 0;

			sCITeam1.score = 0;

			sCITeam1.timeOutsLeft = 1;

			sCITeam2.faults = 0;

			sCITeam2.score = 0;

			sCITeam2.timeOutsLeft = 1;

			sCIWatch.time = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Init;
		} else {
			if (sCIWatch.abort) {
				switch (stateVector[0]) {
					case main_region_Working_Match_FirstHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondHalf :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_FirstExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_SecondExtra :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_Working_Match_EndOfMatch :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case main_region_Working_Events_Listening :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Goal :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Substitute :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case main_region_Working_Events_Fault :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[2]) {
					case main_region_Working_Watch_TimeOut :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
						break;

					case main_region_Working_Watch_Running :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						getTimerService()
								.resetTimer(
										scoreboard_main_region_Working_Watch_Running_time_event_0);
						break;

					case main_region_Working_Watch_Stopped :
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Finished;
			} else {
				if (sCIWatch.end) {
					switch (stateVector[0]) {
						case main_region_Working_Match_FirstHalf :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case main_region_Working_Match_SecondHalf :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case main_region_Working_Match_FirstExtra :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case main_region_Working_Match_SecondExtra :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case main_region_Working_Match_EndOfMatch :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default :
							break;
					}

					switch (stateVector[1]) {
						case main_region_Working_Events_Listening :
							nextStateIndex = 1;
							stateVector[1] = State.$NullState$;
							break;

						case main_region_Working_Events_Goal :
							nextStateIndex = 1;
							stateVector[1] = State.$NullState$;
							break;

						case main_region_Working_Events_Substitute :
							nextStateIndex = 1;
							stateVector[1] = State.$NullState$;
							break;

						case main_region_Working_Events_Fault :
							nextStateIndex = 1;
							stateVector[1] = State.$NullState$;
							break;

						default :
							break;
					}

					switch (stateVector[2]) {
						case main_region_Working_Watch_TimeOut :
							nextStateIndex = 2;
							stateVector[2] = State.$NullState$;

							getTimerService()
									.resetTimer(
											scoreboard_main_region_Working_Watch_TimeOut_time_event_0);
							break;

						case main_region_Working_Watch_Running :
							nextStateIndex = 2;
							stateVector[2] = State.$NullState$;

							getTimerService()
									.resetTimer(
											scoreboard_main_region_Working_Watch_Running_time_event_0);
							break;

						case main_region_Working_Watch_Stopped :
							nextStateIndex = 2;
							stateVector[2] = State.$NullState$;
							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Finished;
				} else {
					if (sCIWatch.set && sCIWatch.time < 50 * 60) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.main_region_Working_Match_SecondExtra;
					}
				}
			}
		}
	}

	/* The reactions of state Listening. */
	private void reactMain_region_Working_Events_Listening() {
		if (sCITeam1.goal) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCITeam1.score += 1;

			sCICallback.raiseGoal();

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Working_Events_Goal;
		} else {
			if (sCITeam2.goal) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				sCITeam2.score += 1;

				sCICallback.raiseGoal();

				nextStateIndex = 1;
				stateVector[1] = State.main_region_Working_Events_Goal;
			} else {
				if (sCITeam2.substitute) {
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;

					sCICallback.raiseSubstitute();

					nextStateIndex = 1;
					stateVector[1] = State.main_region_Working_Events_Substitute;
				} else {
					if (sCITeam1.substitute) {
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;

						sCICallback.raiseSubstitute();

						nextStateIndex = 1;
						stateVector[1] = State.main_region_Working_Events_Substitute;
					} else {
						if (sCITeam2.fault) {
							nextStateIndex = 1;
							stateVector[1] = State.$NullState$;

							sCITeam2.faults += 1;

							if (sCITeam2.faults == 5) {
								sCICallback.operationCallback.signal();

								sCICallback.raiseFault();

								nextStateIndex = 1;
								stateVector[1] = State.main_region_Working_Events_Fault;
							} else {
								if (true) {
									sCICallback.raiseFault();

									nextStateIndex = 1;
									stateVector[1] = State.main_region_Working_Events_Fault;
								}
							}
						} else {
							if (sCITeam1.fault) {
								nextStateIndex = 1;
								stateVector[1] = State.$NullState$;

								sCITeam1.faults += 1;

								if (sCITeam1.faults == 5) {
									sCICallback.operationCallback.signal();

									sCICallback.raiseFault();

									nextStateIndex = 1;
									stateVector[1] = State.main_region_Working_Events_Fault;
								} else {
									if (true) {
										sCICallback.raiseFault();

										nextStateIndex = 1;
										stateVector[1] = State.main_region_Working_Events_Fault;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/* The reactions of state Goal. */
	private void reactMain_region_Working_Events_Goal() {
		if (true) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Working_Events_Listening;
		}
	}

	/* The reactions of state Substitute. */
	private void reactMain_region_Working_Events_Substitute() {
		if (true) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Working_Events_Listening;
		}
	}

	/* The reactions of state Fault. */
	private void reactMain_region_Working_Events_Fault() {
		if (true) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Working_Events_Listening;
		}
	}

	/* The reactions of state TimeOut. */
	private void reactMain_region_Working_Watch_TimeOut() {
		if (sCIWatch.timeout == 0) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			getTimerService().resetTimer(
					scoreboard_main_region_Working_Watch_TimeOut_time_event_0);

			sCICallback.operationCallback.signal();

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Working_Watch_Stopped;
		} else {
			if (timeEvents[scoreboard_main_region_Working_Watch_TimeOut_time_event_0
					.getIndex()]) {
				sCIWatch.timeout -= 1;

				sCICallback.raiseRefresh();
			}
		}
	}

	/* The reactions of state Running. */
	private void reactMain_region_Working_Watch_Running() {
		if (sCIWatch.stop) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			getTimerService().resetTimer(
					scoreboard_main_region_Working_Watch_Running_time_event_0);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Working_Watch_Stopped;
		} else {
			if (timeEvents[scoreboard_main_region_Working_Watch_Running_time_event_0
					.getIndex()]) {
				sCIWatch.time += 1;

				sCICallback.raiseRefresh();
			}
		}
	}

	/* The reactions of state Stopped. */
	private void reactMain_region_Working_Watch_Stopped() {
		if (sCIWatch.start
				&& !isStateActive(State.main_region_Working_Match_EndOfMatch)) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			getTimerService().setTimer(
					scoreboard_main_region_Working_Watch_Running_time_event_0,
					1 * 1000, cycleStartTime);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Working_Watch_Running;
		} else {
			if (sCIWatch.set) {
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;

				sCIWatch.time = sCIWatch.setValue;

				nextStateIndex = 2;
				stateVector[2] = State.main_region_Working_Watch_Stopped;
			} else {
				if (sCITeam1.timeout && sCITeam1.timeOutsLeft > 0) {
					nextStateIndex = 2;
					stateVector[2] = State.$NullState$;

					sCITeam1.timeOutsLeft -= 1;

					getTimerService()
							.setTimer(
									scoreboard_main_region_Working_Watch_TimeOut_time_event_0,
									1 * 1000, cycleStartTime);

					sCICallback.raiseTimeout();

					sCIWatch.timeout = 60;

					sCICallback.raiseRefresh();

					nextStateIndex = 2;
					stateVector[2] = State.main_region_Working_Watch_TimeOut;
				} else {
					if (sCITeam2.timeout && sCITeam2.timeOutsLeft > 0) {
						nextStateIndex = 2;
						stateVector[2] = State.$NullState$;

						sCITeam2.timeOutsLeft -= 1;

						getTimerService()
								.setTimer(
										scoreboard_main_region_Working_Watch_TimeOut_time_event_0,
										1 * 1000, cycleStartTime);

						sCICallback.raiseTimeout();

						sCIWatch.timeout = 60;

						sCICallback.raiseRefresh();

						nextStateIndex = 2;
						stateVector[2] = State.main_region_Working_Watch_TimeOut;
					}
				}
			}
		}
	}

	/* The reactions of state Finished. */
	private void reactMain_region_Finished() {
		if (true) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region__final_;
		}
	}

	/* The reactions of state null. */
	private void reactMain_region__final_0() {
	}

	public void runCycle() {

		cycleStartTime = timerService.getSystemTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Init :
					reactMain_region_Init();
					break;
				case main_region_Working_Match_FirstHalf :
					reactMain_region_Working_Match_FirstHalf();
					break;
				case main_region_Working_Match_SecondHalf :
					reactMain_region_Working_Match_SecondHalf();
					break;
				case main_region_Working_Match_FirstExtra :
					reactMain_region_Working_Match_FirstExtra();
					break;
				case main_region_Working_Match_SecondExtra :
					reactMain_region_Working_Match_SecondExtra();
					break;
				case main_region_Working_Match_EndOfMatch :
					reactMain_region_Working_Match_EndOfMatch();
					break;
				case main_region_Working_Events_Listening :
					reactMain_region_Working_Events_Listening();
					break;
				case main_region_Working_Events_Goal :
					reactMain_region_Working_Events_Goal();
					break;
				case main_region_Working_Events_Substitute :
					reactMain_region_Working_Events_Substitute();
					break;
				case main_region_Working_Events_Fault :
					reactMain_region_Working_Events_Fault();
					break;
				case main_region_Working_Watch_TimeOut :
					reactMain_region_Working_Watch_TimeOut();
					break;
				case main_region_Working_Watch_Running :
					reactMain_region_Working_Watch_Running();
					break;
				case main_region_Working_Watch_Stopped :
					reactMain_region_Working_Watch_Stopped();
					break;
				case main_region_Finished :
					reactMain_region_Finished();
					break;
				case main_region__final_ :
					reactMain_region__final_0();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
