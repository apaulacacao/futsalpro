package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor;

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

class SupervisorHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Supervisor model;
	private Composite composite;
	private Combo cmbSupervisor;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor> supervisorList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor supervisor;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public Supervisor getModel() {
		return model;
	}
	
	public SupervisorHolder(InitReport initReport, Group container, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor> supervisorList)
	{
		parent = initReport;
		this.supervisorList = supervisorList;
		
		supervisorList.addListener(this);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
				
		cmbSupervisor = new Combo(composite, SWT.READ_ONLY);
		cmbSupervisor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbSupervisor.getSelectionIndex() == SupervisorHolder.this.supervisorList.getAvailable().size() + (valid ? 1 : 0))
					addCustomSupervisor();
				else if (cmbSupervisor.getSelectionIndex() < SupervisorHolder.this.supervisorList.getAvailable().size())
					addSupervisor(cmbSupervisor.getSelectionIndex());
			}
		});
		cmbSupervisor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = parent.getCore().createSupervisor();
		try {
			parent.getCore().setSupervisor(model);
		} catch (InvalidOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void calculateItems() {
		String[] items = new String[supervisorList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < supervisorList.getAvailable().size(); ++i)
		{
			items[i] = supervisorList.getAvailable().get(i).getAccount().getName();
		}
		
		if (valid)
			items[supervisorList.getAvailable().size()] = model.getName();
		items[supervisorList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes r\u00E9sztvev\u0151>";
		
		cmbSupervisor.setItems(items);
		if (valid)
			cmbSupervisor.setText(model.getName());
	}

	protected void addSupervisor(int selectionIndex) {
		if (supervisor != null)
			supervisorList.deselect(supervisor);
		supervisor = supervisorList.getAvailable().get(selectionIndex);
		model.setName(supervisor.getAccount().getName());
		model.setAddress(supervisor.getAccount().getAddress());
		model.setDateOfBirth(supervisor.getAccount().getBirthdate());
		model.setId(supervisor.getAccount().getId());
		model.setIdentifier(supervisor.getIdentifier());
		
		valid = true;
		custom = false;
		
		supervisorList.select(supervisor);
		cmbSupervisor.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomSupervisor() {
		if (supervisor != null)
		{
			supervisorList.deselect(supervisor);
			supervisor = null;
		}
		CustomSupervisorDialog dialog = new CustomSupervisorDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore());
		dialog.setSupervisor(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbSupervisor.clearSelection();
			calculateItems();
			cmbSupervisor.update();
			modelUpdated();
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbSupervisor.setText(model.getName());
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Supervisor> available) {
		supervisor = null;
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