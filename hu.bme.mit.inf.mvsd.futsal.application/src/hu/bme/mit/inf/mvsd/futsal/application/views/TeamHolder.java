package hu.bme.mit.inf.mvsd.futsal.application.views;


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

class TeamHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Team>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Team model;
	private Composite composite;
	private Combo cmbTeam;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Team> teamList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Team team;
	private int teamIndex;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public Team getModel() {
		return model;
	}
	
	public TeamHolder(InitReport initReport, Composite compositeTeams, Team team, int teamIndex, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Team> teamList)
	{
		parent = initReport;
		this.teamIndex = teamIndex;
		this.teamList = teamList;
		
		teamList.addListener(this);
		
		composite = new Composite(compositeTeams, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
				
		cmbTeam = new Combo(composite, SWT.READ_ONLY);
		cmbTeam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbTeam.getSelectionIndex() == TeamHolder.this.teamList.getAvailable().size() + (valid ? 1 : 0))
					addCustomTeam();
				else if (cmbTeam.getSelectionIndex() < TeamHolder.this.teamList.getAvailable().size())
					addTeam(cmbTeam.getSelectionIndex());
			}
		});
		cmbTeam.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = team;
	}

	private void calculateItems() {
		String[] items = new String[teamList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < teamList.getAvailable().size(); ++i)
		{
			items[i] = teamList.getAvailable().get(i).getName();
		}
		
		if (valid)
			items[teamList.getAvailable().size()] = model.getName();
		items[teamList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes csapat>";
		
		cmbTeam.setItems(items);
		if (valid)
			cmbTeam.setText(model.getName());
	}

	protected void addTeam(int selectionIndex) {
		if (team != null)
			teamList.deselect(team);
		team = teamList.getAvailable().get(selectionIndex);
		model.setName(team.getName());
		valid = true;
		custom = false;

		teamList.select(team);
		cmbTeam.setText(model.getName());
		
		parent.fillDropDownLists(teamIndex, team == null ? -1 : team.getId());
		modelUpdated();
	}

	protected void addCustomTeam() {
		hu.bme.mit.inf.mvsd.futsal.core.database.Team temp = team;
		String tempName = model.getName();
		if (team != null)
		{
			teamList.deselect(team);
			team = null;
		}
		CustomTeamDialog dialog = new CustomTeamDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore());
		dialog.setTeam(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			model.setName(tempName);
			team = temp;
			if (team != null)
			{
				teamList.select(team);
			}
			if (model.getName() != null)
			{
				cmbTeam.setText(model.getName());
			}
			else
			{
				cmbTeam.clearSelection();
				calculateItems();
				cmbTeam.update();
			}
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbTeam.setText(model.getName());
			parent.fillDropDownLists(teamIndex, team == null ? -1 : team.getId());
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Team> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Team> available) {
		team = null;
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