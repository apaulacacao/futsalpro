package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.ResourceManager;

class SubstituteHolder
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Player model;
	private Composite composite;
	private Button btnRemove;
	private Combo cmbSubstitute;
	private Team team;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Player substitutePlayer;
	private hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper substituteGoalkeeper;
	private DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerListener;
	private DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperListener;
	private boolean goalkeeper;
	private ScrolledComposite scrolledComposite;
	private Composite compositeTeams;
	private List<SubstituteHolder> substituteHolders;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public boolean isGoalkeeper() {
		return goalkeeper;
	}
	
	public Player getModel() {
		return model;
	}
	
	public SubstituteHolder(InitReport initReport, ScrolledComposite scrolledComposite, Composite compositeTeams, Group container, Button addButton, List<SubstituteHolder> substituteHolders, Team team,
			DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerList,
			DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList)
	{
		parent = initReport;
		this.scrolledComposite = scrolledComposite;
		this.compositeTeams = compositeTeams;
		this.substituteHolders = substituteHolders;
		this.team = team;
		this.playerList = playerList;
		this.goalkeeperList = goalkeeperList;
		
		playerListener = new DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Player>() {

			@Override
			public void listChanged(
					List<hu.bme.mit.inf.mvsd.futsal.core.database.Player> available) {
				calculateItems();
			}

			@Override
			public void reinitialized(
					List<hu.bme.mit.inf.mvsd.futsal.core.database.Player> available) {
				substituteGoalkeeper = null;
				substitutePlayer = null;
				custom = true;
				calculateItems();
			}
		};
		playerList.addListener(playerListener);
		goalkeeperListener = new DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>() {

			@Override
			public void listChanged(List<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> available) {
				calculateItems();
			}

			@Override
			public void reinitialized(
					List<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> available) {
				substituteGoalkeeper = null;
				substitutePlayer = null;
				custom = true;
				calculateItems();
			}
			
		};
		goalkeeperList.addListener(goalkeeperListener);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(2, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
				
		cmbSubstitute = new Combo(composite, SWT.READ_ONLY);
		cmbSubstitute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbSubstitute.getSelectionIndex() == SubstituteHolder.this.playerList.getAvailable().size() + SubstituteHolder.this.goalkeeperList.getAvailable().size() + (valid ? 1 : 0))
					addCustomSubstitute();
				else if (cmbSubstitute.getSelectionIndex() < SubstituteHolder.this.playerList.getAvailable().size())
					addSubstitutePlayer(cmbSubstitute.getSelectionIndex());
				else if (cmbSubstitute.getSelectionIndex() < SubstituteHolder.this.playerList.getAvailable().size() + SubstituteHolder.this.goalkeeperList.getAvailable().size())
					addSubstituteGoalkeeper(cmbSubstitute.getSelectionIndex() - SubstituteHolder.this.playerList.getAvailable().size());
			}
		});
		cmbSubstitute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnRemove = new Button(composite, SWT.NONE);
		btnRemove.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/remove.gif"));
		
		calculateItems();
		
		model = parent.getCore().createPlayer();
		model.setTeam(team);
		try {
			parent.getCore().addSubstitutePlayer(team, model);
		} catch (InvalidOperationException e1) {
			e1.printStackTrace();
		}
		
		composite.moveAbove(addButton);
		
		compositeTeams.layout();
		scrolledComposite.setMinSize(compositeTeams.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	private void calculateItems() {
		int totalSize = playerList.getAvailable().size() + goalkeeperList.getAvailable().size();
		String[] items = new String[totalSize + (valid ? 2 : 1)];
		
		for (int i = 0; i < playerList.getAvailable().size(); ++i)
		{
			items[i] = playerList.getAvailable().get(i).getAccount().getName();
		}
		
		for (int i = 0; i < goalkeeperList.getAvailable().size(); ++i)
		{
			items[i + playerList.getAvailable().size()] = goalkeeperList.getAvailable().get(i).getAccount().getName();
		}
		
		if (valid)
			items[totalSize] = model.getName();
		items[totalSize + (valid ? 1 : 0)] = "<Ideiglenes r\u00E9sztvev\u0151>";
		
		cmbSubstitute.setItems(items);
		if (valid)
			cmbSubstitute.setText(model.getName());
	}

	protected void addSubstitutePlayer(int selectionIndex) {
		if (substitutePlayer != null)
		{
			playerList.deselect(substitutePlayer);
			substitutePlayer = null;
		}
		if (substituteGoalkeeper != null)
		{
			goalkeeperList.deselect(substituteGoalkeeper);
			substituteGoalkeeper = null;
		}
		substitutePlayer = playerList.getAvailable().get(selectionIndex);
		if (model instanceof GoalKeeper)
		{
			team.getSubtituteGoalKeepers().remove(model);
			model = parent.getCore().createPlayer();
			model.setTeam(team);
			try {
				parent.getCore().addSubstitutePlayer(team, model);
			} catch (InvalidOperationException e) {
				e.printStackTrace();
			}
		}
		model.setName(substitutePlayer.getAccount().getName());
		model.setAddress(substitutePlayer.getAccount().getAddress());
		model.setDateOfBirth(substitutePlayer.getAccount().getBirthdate());
		model.setId(substitutePlayer.getAccount().getId());
		model.setLicenceNumber(substitutePlayer.getLicenseNumber());
		model.setSquadNumber(substitutePlayer.getSquadNumber());
		
		valid = true;
		custom = false;
		goalkeeper = false;
		
		playerList.select(substitutePlayer);
		cmbSubstitute.setText(model.getName());
		modelUpdated();
	}
	
	protected void addSubstituteGoalkeeper(int selectionIndex) {
		if (substitutePlayer != null)
		{
			playerList.deselect(substitutePlayer);
			substitutePlayer = null;
		}
		if (substituteGoalkeeper != null)
		{
			goalkeeperList.deselect(substituteGoalkeeper);
			substituteGoalkeeper = null;
		}
		substituteGoalkeeper = goalkeeperList.getAvailable().get(selectionIndex);
		if (!(model instanceof GoalKeeper))
		{
			team.getSubtitutePlayers().remove(model);
			model = parent.getCore().createGoalkeeper();
			model.setTeam(team);
			try {
				parent.getCore().addSubstituteGoalkeeper(team, (GoalKeeper)model);
			} catch (InvalidOperationException e) {
				e.printStackTrace();
			}
		}
		model.setName(substituteGoalkeeper.getAccount().getName());
		model.setAddress(substituteGoalkeeper.getAccount().getAddress());
		model.setDateOfBirth(substituteGoalkeeper.getAccount().getBirthdate());
		model.setId(substituteGoalkeeper.getAccount().getId());
		model.setLicenceNumber(substituteGoalkeeper.getLicenseNumber());
		model.setSquadNumber(substituteGoalkeeper.getSquadNumber());
		
		valid = true;
		custom = false;
		goalkeeper = true;
		
		goalkeeperList.select(substituteGoalkeeper);
		cmbSubstitute.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomSubstitute() {
		if (substitutePlayer != null)
		{
			playerList.deselect(substitutePlayer);
			substitutePlayer = null;
		}
		if (substituteGoalkeeper != null)
		{
			goalkeeperList.deselect(substituteGoalkeeper);
			substituteGoalkeeper = null;
		}
		CustomPlayerDialog dialog = new CustomPlayerDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore(), true, false);
		dialog.setPlayer(model);
		Player player = dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbSubstitute.clearSelection();
			calculateItems();
			cmbSubstitute.update();
			modelUpdated();
		}
		else
		{
			if (!player.getClass().equals(model.getClass()))
			{
				if (player instanceof GoalKeeper)
				{
					team.getSubtitutePlayers().remove(model);
					model = player;
					model.setTeam(team);
					try {
						parent.getCore().addSubstituteGoalkeeper(team, (GoalKeeper)model);
					} catch (InvalidOperationException e) {
						e.printStackTrace();
					}
				}
				else
				{
					team.getSubtituteGoalKeepers().remove(model);
					model = player;
					model.setTeam(team);
					try {
						parent.getCore().addSubstitutePlayer(team, model);
					} catch (InvalidOperationException e) {
						e.printStackTrace();
					}
				}
			}
			
			valid = true;
			custom = true;

			calculateItems();
			cmbSubstitute.setText(model.getName());
			modelUpdated();
		}
	}
	
	List<HolderUpdateListener> listeners = new ArrayList<HolderUpdateListener>();
	
	public void addListener(HolderUpdateListener listener){
		listeners.add(listener);
	}
	
	public void removeListener(HolderUpdateListener listener) {
		listeners.remove(listener);
	}
	
	private void modelUpdated()
	{
		for (HolderUpdateListener listener : listeners) {
			listener.modelUpdated();	
		}
	}

	public void dispose() {
		valid = false;
		modelUpdated();
		listeners.clear();
		SubstituteHolder.this.substituteHolders.remove(SubstituteHolder.this);
		if (model instanceof GoalKeeper)
			SubstituteHolder.this.team.getSubtituteGoalKeepers().remove(model);
		else
			SubstituteHolder.this.team.getSubtitutePlayers().remove(model);
		SubstituteHolder.this.playerList.removeListener(playerListener);
		SubstituteHolder.this.goalkeeperList.removeListener(goalkeeperListener);
		if (substitutePlayer != null)
			SubstituteHolder.this.playerList.deselect(substitutePlayer);
		if (substituteGoalkeeper != null)
			SubstituteHolder.this.goalkeeperList.deselect(substituteGoalkeeper);
		composite.dispose();
		SubstituteHolder.this.compositeTeams.layout();
		SubstituteHolder.this.scrolledComposite.setMinSize(SubstituteHolder.this.compositeTeams.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}