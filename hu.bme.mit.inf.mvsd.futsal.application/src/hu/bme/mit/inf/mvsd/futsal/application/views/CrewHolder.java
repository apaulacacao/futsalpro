package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole;
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

class CrewHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Crew>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Crew model;
	private Composite composite;
	private Button btnRemove;
	private Combo cmbCrew;
	private Team team;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> crewList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Crew crew;
	private ScrolledComposite scrolledComposite;
	private Composite compositeTeams;
	private List<CrewHolder> crewHolders;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public Crew getModel() {
		return model;
	}
	
	public CrewHolder(InitReport initReport, ScrolledComposite scrolledComposite, Composite compositeTeams, Group container, Button addButton, List<CrewHolder> crewHolders, Team team, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> crewList)
	{
		parent = initReport;
		this.compositeTeams = compositeTeams;
		this.scrolledComposite = scrolledComposite;
		this.crewHolders = crewHolders;
		this.team = team;
		this.crewList = crewList;
		
		crewList.addListener(this);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(2, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
				
		cmbCrew = new Combo(composite, SWT.READ_ONLY);
		cmbCrew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbCrew.getSelectionIndex() == CrewHolder.this.crewList.getAvailable().size() + (valid ? 1 : 0))
					addCustomCrew();
				else if (cmbCrew.getSelectionIndex() < CrewHolder.this.crewList.getAvailable().size())
					addCrew(cmbCrew.getSelectionIndex());
			}
		});
		cmbCrew.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnRemove = new Button(composite, SWT.NONE);
		btnRemove.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage("hu.bme.mit.inf.mvsd.futsal.application", "icons/remove.gif"));
		
		calculateItems();
		
		model = parent.getCore().createCrew();
		model.setTeam(team);
		try {
			parent.getCore().addCrew(team, model);
		} catch (InvalidOperationException e1) {
			e1.printStackTrace();
		}
		
		composite.moveAbove(addButton);
		
		compositeTeams.layout();
		scrolledComposite.setMinSize(compositeTeams.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	private void calculateItems() {
		String[] items = new String[crewList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < crewList.getAvailable().size(); ++i)
		{
			items[i] = crewList.getAvailable().get(i).getAccount().getName() + " (" + roleToString(crewList.getAvailable().get(i).getRole().getId()) + ")";
		}
		
		if (valid)
			items[crewList.getAvailable().size()] = model.getName() + " (" + roleToString(model.getRole()) + ")";
		items[crewList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes r\u00E9sztvev\u0151>";
		
		cmbCrew.setItems(items);
		if (valid)
			cmbCrew.setText(model.getName() + " (" + roleToString(model.getRole()) + ")");
	}

	private String roleToString(CrewRole role) {
		String ret;
		switch (role) {
		case COACH:
			ret = "edzõ";
			break;
		case MANAGER:
			ret = "vezetõ edzõ";
			break;
		case MASSEUR:
			ret = "gyúró";
			break;
		case MEDIC:
			ret = "orvos";
			break;
		case OTHER:
			ret = "egyéb";
			break;
		case TECHNICAL_MANAGER:
			ret = "technikai vezetõ";
			break;
		default:
			ret = "";
			break;
		}
		return ret;
	}
	
	private String roleToString(int role) {
		String ret;
		switch (role) {
		case 0:
			ret = "edzõ";
			break;
		case 1:
			ret = "vezetõ edzõ";
			break;
		case 3:
			ret = "gyúró";
			break;
		case 2:
			ret = "orvos";
			break;
		case 5:
			ret = "egyéb";
			break;
		case 4:
			ret = "technikai vezetõ";
			break;
		default:
			ret = "";
			break;
		}
		return ret;
	}

	protected void addCrew(int selectionIndex) {
		if (crew != null)
			crewList.deselect(crew);
		crew = crewList.getAvailable().get(selectionIndex);
		model.setName(crew.getAccount().getName());
		model.setAddress(crew.getAccount().getAddress());
		model.setDateOfBirth(crew.getAccount().getBirthdate());
		model.setId(crew.getAccount().getId());
		model.setLicenceNumber(crew.getLicenseNumber());
		model.setRole(CrewRole.get(crew.getRole().getId()));
		
		valid = true;
		custom = false;
		
		crewList.select(crew);
		cmbCrew.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomCrew() {
		if (crew != null)
		{
			crewList.deselect(crew);
			crew = null;
		}
		CustomCrewDialog dialog = new CustomCrewDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore());
		dialog.setCrew(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbCrew.clearSelection();
			calculateItems();
			cmbCrew.update();
			modelUpdated();
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbCrew.setText(model.getName() + " (" + roleToString(model.getRole()) + ")");
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Crew> available) {
		crew = null;
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

	public void dispose() {
		valid = false;
		modelUpdated();
		listeners.clear();
		CrewHolder.this.crewHolders.remove(CrewHolder.this);
		CrewHolder.this.team.getBench().remove(model);
		CrewHolder.this.crewList.removeListener(CrewHolder.this);
		if (crew != null)
			CrewHolder.this.crewList.deselect(crew);
		composite.dispose();
		CrewHolder.this.compositeTeams.layout();
		CrewHolder.this.scrolledComposite.setMinSize(CrewHolder.this.compositeTeams.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}