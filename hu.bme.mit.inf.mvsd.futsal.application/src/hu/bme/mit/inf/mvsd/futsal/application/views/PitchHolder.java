package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;

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

class PitchHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Pitch model;
	private Composite composite;
	private Combo cmbPitch;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch> pitchList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Pitch pitch;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public Pitch getModel() {
		return model;
	}
	
	public PitchHolder(InitReport initReport, Group container, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch> pitchList)
	{
		parent = initReport;
		this.pitchList = pitchList;
		
		pitchList.addListener(this);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
				
		cmbPitch = new Combo(composite, SWT.READ_ONLY);
		cmbPitch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbPitch.getSelectionIndex() == PitchHolder.this.pitchList.getAvailable().size() + (valid ? 1 : 0))
					addCustomSupervisor();
				else if (cmbPitch.getSelectionIndex() < PitchHolder.this.pitchList.getAvailable().size())
					addSupervisor(cmbPitch.getSelectionIndex());
			}
		});
		cmbPitch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = parent.getCore().createPitch();
		try {
			parent.getCore().setPitch(model);
		} catch (InvalidOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void calculateItems() {
		String[] items = new String[pitchList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < pitchList.getAvailable().size(); ++i)
		{
			items[i] = pitchList.getAvailable().get(i).getName() + " (" + pitchList.getAvailable().get(i).getAddress() + ")";
		}
		
		if (valid)
			items[pitchList.getAvailable().size()] = model.getName() + " (" + model.getAddress() + ")";
		items[pitchList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes helyszín>";
		
		cmbPitch.setItems(items);
		if (valid)
			cmbPitch.setText(model.getName() + " (" + model.getAddress() + ")");
	}

	protected void addSupervisor(int selectionIndex) {
		if (pitch != null)
			pitchList.deselect(pitch);
		pitch = pitchList.getAvailable().get(selectionIndex);
		model.setName(pitch.getName());
		model.setAddress(pitch.getAddress());
		
		valid = true;
		custom = false;

		pitchList.select(pitch);
		cmbPitch.setText(model.getName() + " (" + model.getAddress() + ")");
		modelUpdated();
	}

	protected void addCustomSupervisor() {
		if (pitch != null)
		{
			pitchList.deselect(pitch);
			pitch = null;
		}
		CustomPitchDialog dialog = new CustomPitchDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore());
		dialog.setPitch(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbPitch.clearSelection();
			calculateItems();
			cmbPitch.update();
			modelUpdated();
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbPitch.setText(model.getName() + " (" + model.getAddress() + ")");
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Pitch> available) {
		pitch = null;
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