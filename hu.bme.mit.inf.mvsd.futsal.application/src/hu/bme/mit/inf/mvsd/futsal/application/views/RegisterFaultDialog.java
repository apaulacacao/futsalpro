package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.util.ArrayList;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class RegisterFaultDialog extends Dialog {

	private Fault result;
	private boolean cancelled = true;
	protected Shell shlFault;
	private FutsalServiceInterface core;
	private Combo cmbPlayer;
	private DateTime dateTime;
	private ArrayList<Player> fieldPlayers;
	
	private Button btnAdd;
	private Combo cmbType;
	private Team team;
	

	public Fault getFault() {
		return result;
	}

	public void setFault(Fault result) {
		this.result = result;
	}
	
	public boolean isCancelled()
	{
		return cancelled;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public RegisterFaultDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, SWT.DIALOG_TRIM);
		this.core = core;
		setText("Kispadon \u00FCl\u0151 szem\u00E9ly hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Fault open() {
		createContents();
		if (result == null) {
			result = core.createFault();
		}
		else
		{
			bindResult();
		}
		shlFault.open();
		shlFault.layout();
		Display display = getParent().getDisplay();
		while (!shlFault.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void bindResult() {
		dateTime.setTime(0, core.getElapsedTime()/60, core.getElapsedTime()%60);

		if (result.getPlayer() != null)
			cmbPlayer.setText(result.getPlayer().getName());
		else
			btnAdd.setEnabled(false);
		
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlFault = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlFault.setSize(325, 188);
		shlFault.setText("Szab\u00E1lytalans\u00E1g");
		GridLayout gl_shlFault = new GridLayout(2, false);
		gl_shlFault.marginRight = 5;
		gl_shlFault.marginLeft = 5;
		shlFault.setLayout(gl_shlFault);
		
		Label lblPadding1 = new Label(shlFault, SWT.NONE);
		new Label(shlFault, SWT.NONE);
		
		Label lblTime = new Label(shlFault, SWT.NONE);
		lblTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTime.setText("Id\u0151:");
		
		dateTime = new DateTime(shlFault, SWT.BORDER | SWT.TIME);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPlayer = new Label(shlFault, SWT.NONE);
		lblPlayer.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPlayer.setText("J\u00E1t\u00E9kos:");
		
		cmbPlayer = new Combo(shlFault, SWT.READ_ONLY);
		cmbPlayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setPlayer(fieldPlayers.get(cmbPlayer.getSelectionIndex()));
				btnAdd.setEnabled(true);
			}
		});
		cmbPlayer.setItems(new String[] {});
		cmbPlayer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		fieldPlayers = new ArrayList<Player>();
		fieldPlayers.addAll(core.getAllPlayers(team));
		
		String[] items = new String[fieldPlayers.size()];
		
		for (int i = 0; i < fieldPlayers.size(); ++i)
		{
			items[i] = fieldPlayers.get(i).getName();
		}
		
		cmbPlayer.setItems(items);
		
		Label lblType = new Label(shlFault, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("B\u00FCntet\u00E9s:");
		
		cmbType = new Combo(shlFault, SWT.READ_ONLY);
		cmbType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setType(FaultType.get(cmbType.getSelectionIndex()));
			}
		});
		cmbType.setItems(new String[] {"B\u00FCntet\u0151", "S\u00E1rga lap", "Piros lap"});
		cmbType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cmbType.select(0);
		
		Label lblPadding2 = new Label(shlFault, SWT.NONE);
		new Label(shlFault, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlFault, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlFault.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				registerEvent(e);
				RegisterFaultDialog.this.shlFault.dispose();
			}
		});
		btnAdd.setText("Feljegyez");
		sashForm.setWeights(new int[] {1, 1});

	}
	
	protected void registerEvent(SelectionEvent e) {
		result.setTime(dateTime.getHours()*60*60 + dateTime.getMinutes()*60 + dateTime.getSeconds());
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
