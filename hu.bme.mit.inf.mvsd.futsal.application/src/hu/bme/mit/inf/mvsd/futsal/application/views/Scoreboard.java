package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hu.bme.mit.inf.mvsd.futsal.application.views.Futsal.Screens;
import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.futsal.core.UpdateListener;
import hu.bme.mit.inf.mvsd.futsal.core.ValidationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;

public class Scoreboard extends Composite implements UpdateListener {
	private final class AddGoalListener extends SelectionAdapter {
		private Team team = null;
		private Point playerid = null;
		
		public AddGoalListener(Team team) {
			this.team = team;
		}
		
		public AddGoalListener(int team, int player) {
			this.playerid = new Point(team, player);
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			RegisterGoalDialog dialog = new RegisterGoalDialog(Scoreboard.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore());
			Goal init = getCore().createGoal();
			init.setTime(getCore().getElapsedTime());
			if (team != null)
				init.setScorerTeam(team);
			if (playerid != null)
				init.setPlayer(playerid.x == 1 ? fieldPlayers1.get(playerid.y) : fieldPlayers2.get(playerid.y));
			dialog.setGoal(init);
			Goal goal = dialog.open();
			if (!dialog.isCancelled())
			{
				try {
					getCore().addGoal(goal);
					btnUndo.setEnabled(true);
					updateUi();
				} catch (InvalidOperationException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(getShell());
					mb.setText("Hiba");
					mb.setMessage("Az esemény nem vehetõ fel.\n" + e1.getMessage());
					mb.open();
				}
			}
		}
	}

	private final class AddFaultListener extends SelectionAdapter {
		private Team team = null;
		private Point playerid = null;
		
		public AddFaultListener(Team team) {
			this.team = team;
		}
		
		public AddFaultListener(int team, int player) {
			this.playerid = new Point(team, player);
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			RegisterFaultDialog dialog = new RegisterFaultDialog(Scoreboard.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore());
			Fault init = getCore().createFault();
			init.setTime(getCore().getElapsedTime());
			if (team != null)
				dialog.setTeam(team);
			if (playerid != null)
				init.setPlayer(playerid.x == 1 ? fieldPlayers1.get(playerid.y) : fieldPlayers2.get(playerid.y));
			dialog.setFault(init);
			Fault fault = dialog.open();
			if (!dialog.isCancelled())
			{
				try {
					getCore().addFault(fault);
					btnUndo.setEnabled(true);
					updateUi();
					updateFieldPlayers();
				} catch (InvalidOperationException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(getShell());
					mb.setText("Hiba");
					mb.setMessage("Az esemény nem vehetõ fel.\n" + e1.getMessage());
					mb.open();
				}
			}
		}
	}
	
	private final class AddSubstitutionListener extends SelectionAdapter {
		private Team team = null;
		private Point playerid = null;
		
		public AddSubstitutionListener(Team team) {
			this.team = team;
		}
		
		public AddSubstitutionListener(int team, int player) {
			this.playerid = new Point(team, player);
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			RegisterSubstitutionDialog dialog = new RegisterSubstitutionDialog(Scoreboard.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore());
			Substitution init = getCore().createSubstitution();
			init.setTime(getCore().getElapsedTime());
			if (playerid != null)
				init.setInstead(playerid.x == 1 ? fieldPlayers1.get(playerid.y) : fieldPlayers2.get(playerid.y));
			dialog.setSubstitution(init);
			if (team != null)
				dialog.setTeam(team);
			Substitution substitution = dialog.open();
			if (!dialog.isCancelled())
			{
				try {
					getCore().addSubstitution(substitution);
					btnUndo.setEnabled(true);
					updateUi();
					updateFieldPlayers();
				} catch (InvalidOperationException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(getShell());
					mb.setText("Hiba");
					mb.setMessage("Az esemény nem vehetõ fel. \n" + e1.getMessage());
					mb.open();
				}
			}
		}
	}

	private DataBindingContext m_bindingContext;
	
	private Label[] team1SquadNumbers = new Label[5];
	private Label[] team2SquadNumbers = new Label[5];

	private Label[] team1Names = new Label[5];
	private Label[] team2Names = new Label[5];
	
	private Button[] team1Goals = new Button[5];
	private Button[] team2Goals = new Button[5];
	
	private Button[] team1Faults = new Button[5];
	private Button[] team2Faults = new Button[5];
	
	private Button[] team1Substitudes = new Button[5];
	private Button[] team2Substitudes = new Button[5];
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Scoreboard(Composite parent, int style, Futsal mainWindow) {
		super(parent, style);
		
		this.mainWindow = mainWindow;
		getCore().addUpdateListener(this);
		
		setLayout(new GridLayout(7, false));
		
		Composite compositeTeam1 = new Composite(this, SWT.NONE);
		compositeTeam1.setBackground(SWTResourceManager.getColor(229, 53, 48));
		compositeTeam1.setLayout(new GridLayout(1, false));
		GridData gd_compositeTeam1 = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_compositeTeam1.heightHint = 36;
		compositeTeam1.setLayoutData(gd_compositeTeam1);
		
		lblTeam1 = new Label(compositeTeam1, SWT.CENTER);
		lblTeam1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblTeam1.setText("Team1");
		lblTeam1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTeam1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTeam1.setBackground(SWTResourceManager.getColor(229, 53, 48));
		lblTeam1.setAlignment(SWT.CENTER);
		
		btnResetTime = new Button(this, SWT.NONE);
		btnResetTime.setEnabled(false);
		btnResetTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SetTimeDialog dialog = new SetTimeDialog(Scoreboard.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore());
				int time = dialog.open();
				if (!dialog.isCancelled())
				{
					try {
						getCore().setTime(time);
						changeToCountdown();
						updateUi();
					} catch (InvalidOperationException e1) {
						e1.printStackTrace();
						MessageBox mb = new MessageBox(getShell());
						mb.setText("Hiba");
						mb.setMessage("A megadott idõpontra (" + time/60/60 + ":" + time/60%60 + ":" + time%60 + ") nem állítható az óra.\n" + e1.getMessage());
						mb.open();
					}
				}
			}
		});
		btnResetTime.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		btnResetTime.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/reset.gif"));
		
		btnStartMatch = new Button(this, SWT.NONE);
		btnStartMatch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				changeToCountdown();
				enableButtons();
				getCore().startTime();
				updateUi();
			}
		});
		btnStartMatch.setForeground(SWTResourceManager.getColor(0, 51, 255));
		btnStartMatch.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		gd_btnStartMatch = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_btnStartMatch.widthHint = 100;
		btnStartMatch.setLayoutData(gd_btnStartMatch);
		btnStartMatch.setText("Start");
		
		btnElapsedTime = new Button(this, SWT.TOGGLE);
		btnElapsedTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnElapsedTime.getSelection()) {
					getCore().stopTime();
					btnResetTime.setEnabled(true);
					btnTimeout1.setEnabled(true);
					btnTimeout2.setEnabled(true);
					updateUi();
				} else {
					getCore().startTime();
					btnResetTime.setEnabled(false);
					btnTimeout1.setEnabled(false);
					btnTimeout2.setEnabled(false);
					updateUi();
				}
			}
		});
		btnElapsedTime.setForeground(SWTResourceManager.getColor(0, 51, 255));
		btnElapsedTime.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		gd_btnElapsedTime = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_btnElapsedTime.widthHint = 100;
		gd_btnElapsedTime.exclude = true;
		btnElapsedTime.setLayoutData(gd_btnElapsedTime);
		btnElapsedTime.setText("00:00");
		btnElapsedTime.setVisible(false);
		
		btnEndMatch = new Button(this, SWT.NONE);
		btnEndMatch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getCore().validateMatch();
					getCore().finishMatch();
					getCore().generateHtmlReport();
					getCore().removeUpdateListener(Scoreboard.this);
					Scoreboard.this.mainWindow.setScreen(Screens.Results);
				} catch (ValidationException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(getShell());
					mb.setText("Hiba");
					mb.setMessage("A mérkõzés jegyzõkönyve nem állítható elõ, mert ellentmondásos adatok kerültek bele.\n" + e1.getMessage());
					mb.open();
				}
			}
		});
		btnEndMatch.setForeground(SWTResourceManager.getColor(0, 51, 255));
		btnEndMatch.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		gd_btnEndMatch = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_btnEndMatch.widthHint = 100;
		gd_btnEndMatch.exclude = true;
		btnEndMatch.setLayoutData(gd_btnEndMatch);
		btnEndMatch.setText("V\u00E9ge");
		btnEndMatch.setVisible(false);
		
		btnUndo = new Button(this, SWT.NONE);
		btnUndo.setEnabled(false);
		btnUndo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getCore().undoLastEvent();
				if (getMatch().getFirstEvent() == null)
					btnUndo.setEnabled(false);
				updateUi();
				updateFieldPlayers();
			}
		});
		btnUndo.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		btnUndo.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/undo.gif"));
		
		Composite compositeTeam2 = new Composite(this, SWT.NONE);
		compositeTeam2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		compositeTeam2.setBackground(SWTResourceManager.getColor(229, 53, 48));
		compositeTeam2.setLayout(new GridLayout(1, false));
		
		lblTeam2 = new Label(compositeTeam2, SWT.CENTER);
		lblTeam2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		lblTeam2.setText("Team1");
		lblTeam2.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTeam2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTeam2.setBackground(SWTResourceManager.getColor(229, 53, 48));
		lblTeam2.setAlignment(SWT.CENTER);
		new Label(this, SWT.NONE);
		
		lblScore1 = new Label(this, SWT.NONE);
		lblScore1.setAlignment(SWT.CENTER);
		lblScore1.setFont(SWTResourceManager.getFont("Segoe UI", 99, SWT.BOLD));
		lblScore1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 3));
		lblScore1.setText("0");
		
		lblHalfScore1 = new Label(this, SWT.NONE);
		lblHalfScore1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblHalfScore1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblHalfScore1.setAlignment(SWT.CENTER);
		lblHalfScore1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblHalfScore1.setText("0");
		
		lblHalfSeparator = new Label(this, SWT.NONE);
		lblHalfSeparator.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblHalfSeparator.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblHalfSeparator.setAlignment(SWT.CENTER);
		lblHalfSeparator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblHalfSeparator.setText(":");
		
		lblHalfScore2 = new Label(this, SWT.NONE);
		lblHalfScore2.setText("0");
		lblHalfScore2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblHalfScore2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblHalfScore2.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblHalfScore2.setAlignment(SWT.CENTER);
		
		lblScore2 = new Label(this, SWT.NONE);
		lblScore2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 3));
		lblScore2.setText("0");
		lblScore2.setFont(SWTResourceManager.getFont("Segoe UI", 99, SWT.BOLD));
		lblScore2.setAlignment(SWT.CENTER);
		new Label(this, SWT.NONE);
		
		btnGoal1 = new Button(this, SWT.NONE);
		btnGoal1.setEnabled(false);
		btnGoal1.addSelectionListener(new AddGoalListener(getTeam1()));
		btnGoal1.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		new Label(this, SWT.NONE);
		
		Label lblScoreSeparator = new Label(this, SWT.NONE);
		lblScoreSeparator.setFont(SWTResourceManager.getFont("Segoe UI", 45, SWT.BOLD));
		lblScoreSeparator.setAlignment(SWT.CENTER);
		lblScoreSeparator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
		lblScoreSeparator.setText(":");
		new Label(this, SWT.NONE);
		
		btnGoal2 = new Button(this, SWT.NONE);
		btnGoal2.setEnabled(false);
		btnGoal2.addSelectionListener(new AddGoalListener(getTeam2()));
		btnGoal2.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		new Label(this, SWT.NONE);
		
		lblTimeoutLeft = new Label(this, SWT.NONE);
		lblTimeoutLeft.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblTimeoutLeft.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTimeoutLeft.setAlignment(SWT.CENTER);
		lblTimeoutLeft.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		lblTimeoutLeft.setText("0:59");
		new Label(this, SWT.NONE);
		
		btnTimeout1 = new Button(this, SWT.NONE);
		btnTimeout1.setEnabled(false);
		btnTimeout1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnElapsedTime.getVisible())
				{
					getCore().requestTimeout(getTeam1());
					btnUndo.setEnabled(true);
					updateUi();
				}
			}
		});
		btnTimeout1.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		lblRemainingTimeouts1 = new Label(this, SWT.NONE);
		lblRemainingTimeouts1.setAlignment(SWT.CENTER);
		lblRemainingTimeouts1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblRemainingTimeouts1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblRemainingTimeouts1.setText("0");
		
		Label lblTimeout = new Label(this, SWT.NONE);
		lblTimeout.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTimeout.setAlignment(SWT.CENTER);
		lblTimeout.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		lblTimeout.setText("Lehets\u00E9ges id\u0151k\u00E9r\u00E9sek");
		
		lblRemainingTimeouts2 = new Label(this, SWT.NONE);
		lblRemainingTimeouts2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblRemainingTimeouts2.setText("0");
		lblRemainingTimeouts2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblRemainingTimeouts2.setAlignment(SWT.CENTER);
		
		btnTimeout2 = new Button(this, SWT.NONE);
		btnTimeout2.setEnabled(false);
		btnTimeout2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnElapsedTime.getVisible())
				{
					getCore().requestTimeout(getTeam2());
					btnUndo.setEnabled(true);
					updateUi();
				}
			}
		});
		btnTimeout2.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		btnFault1 = new Button(this, SWT.NONE);
		btnFault1.setEnabled(false);
		btnFault1.addSelectionListener(new AddFaultListener(getTeam1()));
		btnFault1.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		lblFaults1 = new Label(this, SWT.NONE);
		lblFaults1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblFaults1.setText("0");
		lblFaults1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblFaults1.setAlignment(SWT.CENTER);
		
		Label lblFaults = new Label(this, SWT.NONE);
		lblFaults.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		lblFaults.setText("Szab\u00E1lytalans\u00E1gok");
		lblFaults.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblFaults.setAlignment(SWT.CENTER);
		
		lblFaults2 = new Label(this, SWT.NONE);
		lblFaults2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblFaults2.setText("0");
		lblFaults2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblFaults2.setAlignment(SWT.CENTER);
		
		btnFault2 = new Button(this, SWT.NONE);
		btnFault2.setEnabled(false);
		btnFault2.addSelectionListener(new AddFaultListener(getTeam2()));
		btnFault2.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		btnSubstitution1 = new Button(this, SWT.NONE);
		btnSubstitution1.setEnabled(false);
		btnSubstitution1.addSelectionListener(new AddSubstitutionListener(getTeam1()));
		btnSubstitution1.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		lblSubstitutions1 = new Label(this, SWT.NONE);
		lblSubstitutions1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSubstitutions1.setText("0");
		lblSubstitutions1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblSubstitutions1.setAlignment(SWT.CENTER);
		
		Label lblSubstitutions = new Label(this, SWT.NONE);
		lblSubstitutions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		lblSubstitutions.setText("Cser\u00E9k");
		lblSubstitutions.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSubstitutions.setAlignment(SWT.CENTER);
		
		lblSubstitutions2 = new Label(this, SWT.NONE);
		lblSubstitutions2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSubstitutions2.setText("0");
		lblSubstitutions2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblSubstitutions2.setAlignment(SWT.CENTER);
		
		btnSubstitution2 = new Button(this, SWT.NONE);
		btnSubstitution2.setEnabled(false);
		btnSubstitution2.addSelectionListener(new AddSubstitutionListener(getTeam2()));
		btnSubstitution2.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
		
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		SashForm sashPlayers = new SashForm(this, SWT.BORDER);
		sashPlayers.setSashWidth(0);
		GridData gd_sashPlayers = new GridData(SWT.FILL, SWT.TOP, true, false, 7, 1);
		gd_sashPlayers.heightHint = 160;
		sashPlayers.setLayoutData(gd_sashPlayers);
		
		Composite compositePlayers1 = new Composite(sashPlayers, SWT.NONE);
		compositePlayers1.setBackground(SWTResourceManager.getColor(229, 53, 48));
		compositePlayers1.setLayout(new GridLayout(6, false));
		
		for (int i = 0; i < 5; ++i)
		{
			Label lblSquad = new Label(compositePlayers1, SWT.NONE);
			lblSquad.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
			lblSquad.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lblSquad.setBackground(SWTResourceManager.getColor(229, 53, 48));
			GridData gd_lblSquad = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblSquad.widthHint = 20;
			lblSquad.setLayoutData(gd_lblSquad);
			lblSquad.setAlignment(SWT.CENTER);
			
			team1SquadNumbers[i] = lblSquad;
			
			if (i == 0)
			{
				Label separator = new Label(compositePlayers1, SWT.SEPARATOR | SWT.VERTICAL);
				separator.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 5));
			}
			
			Label lblName = new Label(compositePlayers1, SWT.NONE);
			lblName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
			lblName.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lblName.setBackground(SWTResourceManager.getColor(229, 53, 48));
			lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			team1Names[i] = lblName;
			
			Button btnGoal = new Button(compositePlayers1, SWT.NONE);
			btnGoal.setEnabled(false);
			btnGoal.addSelectionListener(new AddGoalListener(1, i));
			btnGoal.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
			team1Goals[i] = btnGoal;
			
			Button btnFault = new Button(compositePlayers1, SWT.NONE);
			btnFault.setEnabled(false);
			btnFault.addSelectionListener(new AddFaultListener(1, i));
			btnFault.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/fault.gif"));
			team1Faults[i] = btnFault;
			
			Button btnSubstitute = new Button(compositePlayers1, SWT.NONE);
			btnSubstitute.setEnabled(false);
			btnSubstitute.addSelectionListener(new AddSubstitutionListener(1, i));
			btnSubstitute.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/substitute.gif"));
			team1Substitudes[i] = btnSubstitute;
		}
		
		//Team 2
		
		Composite compositePlayers2 = new Composite(sashPlayers, SWT.NONE);
		compositePlayers2.setBackground(SWTResourceManager.getColor(229, 53, 48));
		compositePlayers2.setLayout(new GridLayout(6, false));
		
		for (int i = 0; i < 5; ++i)
		{
			Label lblSquad = new Label(compositePlayers2, SWT.NONE);
			lblSquad.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
			lblSquad.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lblSquad.setBackground(SWTResourceManager.getColor(229, 53, 48));
			GridData gd_lblSquad = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_lblSquad.widthHint = 20;
			lblSquad.setLayoutData(gd_lblSquad);
			lblSquad.setAlignment(SWT.CENTER);
			
			team2SquadNumbers[i] = lblSquad;
			
			if (i == 0)
			{
				Label separator = new Label(compositePlayers2, SWT.SEPARATOR | SWT.VERTICAL);
				separator.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 5));
			}
			
			Label lblName = new Label(compositePlayers2, SWT.NONE);
			lblName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
			lblName.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lblName.setBackground(SWTResourceManager.getColor(229, 53, 48));
			lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			team2Names[i] = lblName;
			
			Button btnGoal = new Button(compositePlayers2, SWT.NONE);
			btnGoal.setEnabled(false);
			btnGoal.addSelectionListener(new AddGoalListener(2, i));
			btnGoal.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/add.gif"));
			team2Goals[i] = btnGoal;
			
			Button btnFault = new Button(compositePlayers2, SWT.NONE);
			btnFault.setEnabled(false);
			btnFault.addSelectionListener(new AddFaultListener(2, i));
			btnFault.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/fault.gif"));
			team2Faults[i] = btnFault;
			
			Button btnSubstitute = new Button(compositePlayers2, SWT.NONE);
			btnSubstitute.setEnabled(false);
			btnSubstitute.addSelectionListener(new AddSubstitutionListener(2, i));
			btnSubstitute.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/substitute.gif"));
			team2Substitudes[i] = btnSubstitute;
		}
		
		m_bindingContext = initDataBindings();
		
		updateUi();
		updateFieldPlayers();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private Futsal mainWindow;
	private Label lblTeam1;
	private Label lblTeam2;
	private Button btnElapsedTime;
	private Label lblScore1;
	private Label lblHalfScore1;
	private Label lblHalfSeparator;
	private Label lblHalfScore2;
	private Label lblScore2;
	private Label lblTimeoutLeft;
	private Label lblRemainingTimeouts1;
	private Label lblRemainingTimeouts2;
	private Label lblFaults1;
	private Label lblFaults2;
	private Label lblSubstitutions1;
	private Label lblSubstitutions2;

	private Button btnStartMatch;

	private Button btnEndMatch;

	private GridData gd_btnStartMatch;

	private GridData gd_btnElapsedTime;

	private GridData gd_btnEndMatch;

	private List<Player> fieldPlayers1;

	private List<Player> fieldPlayers2;

	private Button btnResetTime;

	private Button btnTimeout1;

	private Button btnTimeout2;

	private Button btnGoal1;

	private Button btnGoal2;

	private Button btnFault1;

	private Button btnFault2;

	private Button btnSubstitution2;

	private Button btnSubstitution1;

	private Button btnUndo;
	
	private Futsal getMainWindow() {
		return mainWindow;
	}

	private void setMainWindow(Futsal mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextLblTeam1ObserveWidget = WidgetProperties.text().observe(lblTeam1);
		IObservableValue matchteam1nameMainWindowgetCoreObserveValue = PojoProperties.value("match.team1.name").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextLblTeam1ObserveWidget, matchteam1nameMainWindowgetCoreObserveValue, null, null);
		//
		IObservableValue observeTextLblTeam2ObserveWidget = WidgetProperties.text().observe(lblTeam2);
		IObservableValue matchteam2nameMainWindowgetCoreObserveValue = PojoProperties.value("match.team2.name").observe(mainWindow.getCore());
		bindingContext.bindValue(observeTextLblTeam2ObserveWidget, matchteam2nameMainWindowgetCoreObserveValue, null, null);
		//
		return bindingContext;
	}

	@Override
	public void updateUi() {
		mainWindow.getDisplay().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				btnElapsedTime.setText(timeToString(getCore().getElapsedTime(), true));
				
				boolean afterHalf = getCore().getHalftime() > 1;
				lblHalfScore1.setText(String.valueOf(getCore().getHalftimeScore(getTeam1())));
				lblHalfScore2.setText(String.valueOf(getCore().getHalftimeScore(getTeam2())));
				lblHalfScore1.setVisible(afterHalf);
				lblHalfScore2.setVisible(afterHalf);
				lblHalfSeparator.setVisible(afterHalf);
				lblHalfSeparator.setVisible(afterHalf);
				
				lblScore1.setText(String.valueOf(getCore().getScore(getTeam1())));
				lblScore2.setText(String.valueOf(getCore().getScore(getTeam2())));
				
				lblTimeoutLeft.setText(timeToString(getCore().getTimeoutLeft(), false));
				lblTimeoutLeft.setVisible(getCore().isTimeout());
				if (getCore().isTimeout())
					btnElapsedTime.setEnabled(false);
				if (getCore().getTimeoutLeft() == 0)
					btnElapsedTime.setEnabled(true);
				
				lblRemainingTimeouts1.setText(String.valueOf(getCore().getRemainingTimeout(getTeam1())));
				if (getCore().getRemainingTimeout(getTeam1()) == 0)
					lblRemainingTimeouts1.setForeground(SWTResourceManager.getColor(255, 0, 0));
				else
					lblRemainingTimeouts1.setForeground(SWTResourceManager.getColor(0, 0, 0));
				lblRemainingTimeouts2.setText(String.valueOf(getCore().getRemainingTimeout(getTeam2())));
				if (getCore().getRemainingTimeout(getTeam2()) == 0)
					lblRemainingTimeouts2.setForeground(SWTResourceManager.getColor(255, 0, 0));
				else
					lblRemainingTimeouts2.setForeground(SWTResourceManager.getColor(0, 0, 0));
				
				lblFaults1.setText(String.valueOf(getCore().getFaultCount(getTeam1())));
				if (getCore().getFaultCount(getTeam1()) >= 5)
					lblFaults1.setForeground(SWTResourceManager.getColor(255, 0, 0));
				else
					lblFaults1.setForeground(SWTResourceManager.getColor(0, 0, 0));
				lblFaults2.setText(String.valueOf(getCore().getFaultCount(getTeam2())));
				if (getCore().getFaultCount(getTeam2()) >= 5)
					lblFaults2.setForeground(SWTResourceManager.getColor(255, 0, 0));
				else
					lblFaults2.setForeground(SWTResourceManager.getColor(0, 0, 0));
				
				lblSubstitutions1.setText(String.valueOf(getCore().getSubstitutionCount(getTeam1())));
				lblSubstitutions2.setText(String.valueOf(getCore().getSubstitutionCount(getTeam2())));
			}
		});
	}
	
	private void updateFieldPlayers()
	{
		fieldPlayers1 = getCore().getFieldPlayers(getTeam1());
		fieldPlayers2 = getCore().getFieldPlayers(getTeam2());
		
		Comparator<Player> playerComparator = new Comparator<Player>() {

			@Override
			public int compare(Player player1, Player player2) {
				// TODO Auto-generated method stub
				return Integer.compare(player1.getSquadNumber(), player2.getSquadNumber());
			}
		};
		
		Collections.sort(fieldPlayers1, playerComparator);
		Collections.sort(fieldPlayers2, playerComparator);
		
		for (int i = 0; i < 5; ++i)
		{
			team1SquadNumbers[i].setText(String.valueOf(fieldPlayers1.get(i).getSquadNumber()));
			team2SquadNumbers[i].setText(String.valueOf(fieldPlayers2.get(i).getSquadNumber()));
			
			team1Names[i].setText(String.valueOf(fieldPlayers1.get(i).getName()));
			team2Names[i].setText(String.valueOf(fieldPlayers2.get(i).getName()));
		}
	}
	
	private void enableButtons() {
		btnGoal1.setEnabled(true);
		btnGoal2.setEnabled(true);
		btnFault1.setEnabled(true);
		btnFault2.setEnabled(true);
		btnSubstitution1.setEnabled(true);
		btnSubstitution2.setEnabled(true);
		
		for (Button btn : team1Goals) {
			btn.setEnabled(true);
		}
		for (Button btn : team2Goals) {
			btn.setEnabled(true);
		}
		for (Button btn : team1Faults) {
			btn.setEnabled(true);
		}
		for (Button btn : team2Faults) {
			btn.setEnabled(true);
		}
		for (Button btn : team1Substitudes) {
			btn.setEnabled(true);
		}
		for (Button btn : team2Substitudes) {
			btn.setEnabled(true);
		}
	}
	
	private void changeToCountdown()
	{
		btnStartMatch.setVisible(false);
		gd_btnStartMatch.exclude = true;
		btnEndMatch.setVisible(false);
		gd_btnEndMatch.exclude = true;
		btnElapsedTime.setVisible(true);
		gd_btnElapsedTime.exclude = false;
		this.layout();
	}
	
	private void changeToEnd()
	{
		btnStartMatch.setVisible(false);
		gd_btnStartMatch.exclude = true;
		btnElapsedTime.setVisible(false);
		gd_btnElapsedTime.exclude = true;
		btnEndMatch.setVisible(true);
		gd_btnEndMatch.exclude = false;
		this.layout();
	}

	private Team getTeam2() {
		return getMatch().getTeam2();
	}

	private Team getTeam1() {
		return getMatch().getTeam1();
	}

	private Match getMatch() {
		return getCore().getMatch();
	}

	private String timeToString(int elapsedTime, boolean padFirst) {
		String ret = (elapsedTime/60 < 10 && padFirst ? "0" : "") + String.valueOf(elapsedTime/60);
		ret += ":";
		ret += (elapsedTime%60 < 10 ? "0" : "") + String.valueOf(elapsedTime%60);
		return ret;
	}

	private FutsalServiceInterface getCore() {
		return mainWindow.getCore();
	}

	@Override
	public void endOfPart(int i) {
		if (i == 5)
		{
			mainWindow.getDisplay().asyncExec(new Runnable() {
			
				@Override
				public void run() {
					btnElapsedTime.setSelection(true);
					changeToEnd();
				}
			});
		}
		else
		{
			mainWindow.getDisplay().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					btnElapsedTime.setSelection(true);
				}
			});
		}
	}
}
