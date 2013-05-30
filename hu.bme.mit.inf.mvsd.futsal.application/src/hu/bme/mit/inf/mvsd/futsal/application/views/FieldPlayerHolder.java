package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

class FieldPlayerHolder
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Player model;
	private Composite composite;
	private Combo cmbFieldPlayer;
	private Team team;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerList;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Player fieldPlayer;
	private hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper fieldGoalkeeper;
	private DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerListener;
	private DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperListener;
	private boolean goalkeeper;
	
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
	
	public FieldPlayerHolder(InitReport initReport, Group container, Team team,
			DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Player> playerList,
			DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList)
	{
		parent = initReport;
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
				fieldGoalkeeper = null;
				fieldPlayer = null;
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
				fieldGoalkeeper = null;
				fieldPlayer = null;
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
				
		cmbFieldPlayer = new Combo(composite, SWT.READ_ONLY);
		cmbFieldPlayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbFieldPlayer.getSelectionIndex() == FieldPlayerHolder.this.playerList.getAvailable().size() + FieldPlayerHolder.this.goalkeeperList.getAvailable().size() + (valid ? 1 : 0))
					addCustomFieldPlayer();
				else if (cmbFieldPlayer.getSelectionIndex() < FieldPlayerHolder.this.playerList.getAvailable().size())
					addFieldPlayer(cmbFieldPlayer.getSelectionIndex());
				else if (cmbFieldPlayer.getSelectionIndex() < FieldPlayerHolder.this.playerList.getAvailable().size() + FieldPlayerHolder.this.goalkeeperList.getAvailable().size())
					addFieldGoalkeeper(cmbFieldPlayer.getSelectionIndex() - FieldPlayerHolder.this.playerList.getAvailable().size());
			}
		});
		cmbFieldPlayer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = parent.getCore().createPlayer();
		model.setTeam(team);
		try {
			parent.getCore().addFieldPlayer(team, model);
		} catch (InvalidOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		cmbFieldPlayer.setItems(items);
		if (valid)
			cmbFieldPlayer.setText(model.getName());
	}

	protected void addFieldPlayer(int selectionIndex) {
		if (fieldPlayer != null)
		{
			playerList.deselect(fieldPlayer);
			fieldPlayer = null;
		}
		if (fieldGoalkeeper != null)
		{
			goalkeeperList.deselect(fieldGoalkeeper);
			fieldGoalkeeper = null;
		}
		fieldPlayer = playerList.getAvailable().get(selectionIndex);
		if (model instanceof GoalKeeper)
		{
			team.getFieldPlayers().remove(model);
			model = parent.getCore().createPlayer();
			model.setTeam(team);
			try {
				parent.getCore().addFieldPlayer(team, model);
			} catch (InvalidOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.setName(fieldPlayer.getAccount().getName());
		model.setAddress(fieldPlayer.getAccount().getAddress());
		model.setDateOfBirth(fieldPlayer.getAccount().getBirthdate());
		model.setId(fieldPlayer.getAccount().getId());
		model.setLicenceNumber(fieldPlayer.getLicenseNumber());
		model.setSquadNumber(fieldPlayer.getSquadNumber());
		
		valid = true;
		custom = false;
		goalkeeper = false;
		
		playerList.select(fieldPlayer);
		cmbFieldPlayer.setText(model.getName());
		modelUpdated();
	}
	
	protected void addFieldGoalkeeper(int selectionIndex) {
		if (fieldPlayer != null)
		{
			playerList.deselect(fieldPlayer);
			fieldPlayer = null;
		}
		if (fieldGoalkeeper != null)
		{
			goalkeeperList.deselect(fieldGoalkeeper);
			fieldGoalkeeper = null;
		}
		fieldGoalkeeper = goalkeeperList.getAvailable().get(selectionIndex);
		if (!(model instanceof GoalKeeper))
		{
			team.getFieldPlayers().remove(model);
			model = parent.getCore().createGoalkeeper();
			model.setTeam(team);
			try {
				parent.getCore().addFieldPlayer(team, model);
			} catch (InvalidOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.setName(fieldGoalkeeper.getAccount().getName());
		model.setAddress(fieldGoalkeeper.getAccount().getAddress());
		model.setDateOfBirth(fieldGoalkeeper.getAccount().getBirthdate());
		model.setId(fieldGoalkeeper.getAccount().getId());
		model.setLicenceNumber(fieldGoalkeeper.getLicenseNumber());
		model.setSquadNumber(fieldGoalkeeper.getSquadNumber());
		
		valid = true;
		custom = false;
		goalkeeper = true;
		
		goalkeeperList.select(fieldGoalkeeper);
		cmbFieldPlayer.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomFieldPlayer() {
		if (fieldPlayer != null)
		{
			playerList.deselect(fieldPlayer);
			fieldPlayer = null;
		}
		if (fieldGoalkeeper != null)
		{
			goalkeeperList.deselect(fieldGoalkeeper);
			fieldGoalkeeper = null;
		}
		CustomPlayerDialog dialog = new CustomPlayerDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore(), true, false);
		dialog.setPlayer(model);
		Player player = dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbFieldPlayer.clearSelection();
			calculateItems();
			cmbFieldPlayer.update();
			modelUpdated();
		}
		else
		{
			if (!player.getClass().equals(model.getClass()))
			{
				if (player instanceof GoalKeeper)
				{
					team.getFieldPlayers().remove(model);
					model = player;
					model.setTeam(team);
					try {
						parent.getCore().addFieldPlayer(team, model);
					} catch (InvalidOperationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					team.getFieldPlayers().remove(model);
					model = player;
					model.setTeam(team);
					try {
						parent.getCore().addFieldPlayer(team, model);
					} catch (InvalidOperationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			valid = true;
			custom = true;

			calculateItems();
			cmbFieldPlayer.setText(model.getName());
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
}