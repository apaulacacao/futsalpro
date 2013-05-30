package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee;

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

class RefereeHolder implements hu.bme.mit.inf.mvsd.futsal.application.views.DropDownListManager.DDListListener<hu.bme.mit.inf.mvsd.futsal.core.database.Referee>
{
	/**
	 * 
	 */
	private final InitReport parent;
	private Referee model;
	private int refereeIndex;
	private Composite composite;
	private Combo cmbReferee;
	private boolean valid = false;
	private boolean custom = false;
	private DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Referee> refereeList;
	private hu.bme.mit.inf.mvsd.futsal.core.database.Referee referee;
	
	public boolean isValid() {
		return valid;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public Referee getModel() {
		return model;
	}
	
	public RefereeHolder(InitReport initReport, Group container, int refereeIndex, DropDownListManager<hu.bme.mit.inf.mvsd.futsal.core.database.Referee> refereeList)
	{
		parent = initReport;
		this.refereeList = refereeList;
		this.refereeIndex = refereeIndex;
		
		refereeList.addListener(this);
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
				
		cmbReferee = new Combo(composite, SWT.READ_ONLY);
		cmbReferee.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cmbReferee.getSelectionIndex() == RefereeHolder.this.refereeList.getAvailable().size() + (valid ? 1 : 0))
					addCustomReferee();
				else if (cmbReferee.getSelectionIndex() < RefereeHolder.this.refereeList.getAvailable().size())
					addReferee(cmbReferee.getSelectionIndex());
			}
		});
		cmbReferee.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		calculateItems();
		
		model = parent.getCore().createReferee();
		try {
			setReferee(model);
		} catch (InvalidOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void setReferee(Referee referee)
			throws InvalidOperationException {
		model = referee;
		switch (refereeIndex) {
		case 1:
			parent.getCore().setReferee1(referee);
			break;
		case 2:
			parent.getCore().setReferee2(referee);
			break;
		case 3:
			parent.getCore().setReferee3(referee);
			break;
		default:
			break;
		}
	}

	private void calculateItems() {
		String[] items = new String[refereeList.getAvailable().size() + (valid ? 2 : 1)];
		
		for (int i = 0; i < refereeList.getAvailable().size(); ++i)
		{
			items[i] = refereeList.getAvailable().get(i).getAccount().getName();
		}
		
		if (valid)
			items[refereeList.getAvailable().size()] = model.getName();
		items[refereeList.getAvailable().size() + (valid ? 1 : 0)] = "<Ideiglenes r\u00E9sztvev\u0151>";
		
		cmbReferee.setItems(items);
		if (valid)
			cmbReferee.setText(model.getName());
	}

	protected void addReferee(int selectionIndex) {
		if (referee != null)
			refereeList.deselect(referee);
		referee = refereeList.getAvailable().get(selectionIndex);
		model.setName(referee.getAccount().getName());
		model.setAddress(referee.getAccount().getAddress());
		model.setDateOfBirth(referee.getAccount().getBirthdate());
		model.setId(referee.getAccount().getId());
		model.setIdentifier(referee.getIdentifier());
		
		valid = true;
		custom = false;
		
		refereeList.select(referee);
		cmbReferee.setText(model.getName());
		modelUpdated();
	}

	protected void addCustomReferee() {
		if (referee != null)
		{
			refereeList.deselect(referee);
			referee = null;
		}
		CustomRefereeDialog dialog = new CustomRefereeDialog(parent.getShell(), SWT.DIALOG_TRIM, parent.getCore());
		dialog.setReferee(model);
		dialog.open();
		if (dialog.isCancelled())
		{
			valid = false;
			custom = false;
			cmbReferee.clearSelection();
			calculateItems();
			cmbReferee.update();
			modelUpdated();
		}
		else
		{
			valid = true;
			custom = true;

			calculateItems();
			cmbReferee.setText(model.getName());
			modelUpdated();
		}
	}

	@Override
	public void listChanged(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Referee> available) {
		calculateItems();
	}

	@Override
	public void reinitialized(
			List<hu.bme.mit.inf.mvsd.futsal.core.database.Referee> available) {
		referee = null;
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