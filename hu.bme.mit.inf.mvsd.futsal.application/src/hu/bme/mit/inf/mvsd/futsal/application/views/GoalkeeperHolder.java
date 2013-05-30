package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
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

class GoalkeeperHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private GoalKeeper model;
	private Composite composite;
	private Combo cmbGoalkeeper;
	private Team team;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper goalkeeper;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public GoalKeeper getModel() {
		return model;
	}
	
	public GoalkeeperHolder(InitReport initReport, Group container, Team team, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> goalkeeperList)
	{
		parent = initReport;
		this.team = team;
		this.goalkeeperList = goalkeeperList;
		
		goalkeeperList.addListener(this);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
				
		cmbGoalkeeper = new Combo(composite, SWT.READ_ONLY);
		cmbGoalkeeper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbGoalkeeper.getSelectionIndex() == GoalkeeperHolder.this.goalkeeperList.getAvailable().size() + (valid ? 1 : 0))
					addCustomGoalkeeper();
				else if (cmbGoalkeeper.getSelectionIndex() < GoalkeeperHolder.this.goalkeeperList.getAvailable().size())
					addGoalkeeper(cmbGoalkeeper.getSelectionIndex());
			}
		});
		cmbGoalkeeper.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = parent.getCore().createGoalkeeper();
		model.setTeam(team);
		try {
			parent.getCore().setGoalkeeper(team, model);
		} catch (InvalidOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void calculateItems() {
		String[] items = new String[goalkeeperList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < goalkeeperList.getAvailable().size(); ++i)
		{
			items[i] = goalkeeperList.getAvailable().get(i).getAccount().getName();
		}
		
		if (valid)
			items[goalkeeperList.getAvailable().size()] = model.getName();
		items[goalkeeperList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes r\u00E9sztvev\u0151>";
		
		cmbGoalkeeper.setItems(items);
		if (valid)
			cmbGoalkeeper.setText(model.getName());
	}

	protected void addGoalkeeper(int selectionIndex) {
		if (goalkeeper != null)
			goalkeeperList.deselect(goalkeeper);
		goalkeeper = goalkeeperList.getAvailable().get(selectionIndex);
		model.setName(goalkeeper.getAccount().getName());
		model.setAddress(goalkeeper.getAccount().getAddress());
		model.setDateOfBirth(goalkeeper.getAccount().getBirthdate());
		model.setId(goalkeeper.getAccount().getId());
		model.setLicenceNumber(goalkeeper.getLicenseNumber());
		model.setSquadNumber(goalkeeper.getSquadNumber());
		
		valid = true;
		custom = false;
		
		goalkeeperList.select(goalkeeper);
		cmbGoalkeeper.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomGoalkeeper() {
		if (goalkeeper != null)
		{
			goalkeeperList.deselect(goalkeeper);
			goalkeeper = null;
		}
		CustomPlayerDialog dialog = new CustomPlayerDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore(), false, true);
		dialog.setPlayer(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbGoalkeeper.clearSelection();
			calculateItems();
			cmbGoalkeeper.update();
			modelUpdated();
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbGoalkeeper.setText(model.getName());
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.GoalKeeper> available) {
		goalkeeper = null;
		custom = true;
		calculateItems();
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