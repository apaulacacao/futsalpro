package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.util.ArrayList;
import java.util.Collection;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;
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

public class RegisterSubstitutionDialog extends Dialog {

	private Substitution result;
	private boolean cancelled = true;
	protected Shell shlSubstitution;
	private FutsalServiceInterface core;
	private Combo cmbSubstitute;
	private DateTime dateTime;
	private ArrayList<Player> fieldPlayers;
	
	private Button btnAdd;
	private Combo cmbInstead;
	private Team team;
	

	public Substitution getSubstitution() {
		return result;
	}

	public void setSubstitution(Substitution result) {
		this.result = result;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
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
	public RegisterSubstitutionDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, SWT.DIALOG_TRIM);
		this.core = core;
		setText("Kispadon \u00FCl\u0151 szem\u00E9ly hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Substitution open() {
		createContents();
		if (result == null) {
			result = core.createSubstitution();
		}
		else
		{
			bindResult();
		}
		shlSubstitution.open();
		shlSubstitution.layout();
		Display display = getParent().getDisplay();
		while (!shlSubstitution.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void bindResult() {
		if (result.getInstead() != null)
			team = result.getInstead().getTeam();
		fieldPlayers = new ArrayList<Player>();
		fieldPlayers.addAll(core.getAllPlayers(team));
		
		String[] items = new String[fieldPlayers.size()];
		
		for (int i = 0; i < fieldPlayers.size(); ++i)
		{
			items[i] = fieldPlayers.get(i).getName();
		}
		
		cmbSubstitute.setItems(items);
		cmbInstead.setItems(items);
		
		dateTime.setTime(0, core.getElapsedTime()/60, core.getElapsedTime()%60);

		if (result.getInstead() != null)
			cmbInstead.setText(result.getInstead().getName());
		
		
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlSubstitution = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlSubstitution.setSize(325, 188);
		shlSubstitution.setText("Csere");
		GridLayout gl_shlSubstitution = new GridLayout(2, false);
		gl_shlSubstitution.marginRight = 5;
		gl_shlSubstitution.marginLeft = 5;
		shlSubstitution.setLayout(gl_shlSubstitution);
		
		Label lblPadding1 = new Label(shlSubstitution, SWT.NONE);
		new Label(shlSubstitution, SWT.NONE);
		
		Label lblTime = new Label(shlSubstitution, SWT.NONE);
		lblTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTime.setText("Id\u0151:");
		
		dateTime = new DateTime(shlSubstitution, SWT.BORDER | SWT.TIME);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSubstitute = new Label(shlSubstitution, SWT.NONE);
		lblSubstitute.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSubstitute.setText("Csere:");
		
		cmbSubstitute = new Combo(shlSubstitution, SWT.READ_ONLY);
		cmbSubstitute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setSubstitute(fieldPlayers.get(cmbSubstitute.getSelectionIndex()));
				if (result.getInstead() != null && result.getInstead() != result.getSubstitute())
					btnAdd.setEnabled(true);
				else
					btnAdd.setEnabled(false);
			}
		});
		cmbSubstitute.setItems(new String[] {});
		cmbSubstitute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblInstead = new Label(shlSubstitution, SWT.NONE);
		lblInstead.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInstead.setText("Helyette:");
		
		cmbInstead = new Combo(shlSubstitution, SWT.READ_ONLY);
		cmbInstead.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setInstead(fieldPlayers.get(cmbInstead.getSelectionIndex()));
				if (result.getSubstitute() != null && result.getInstead() != result.getSubstitute())
					btnAdd.setEnabled(true);
				else
					btnAdd.setEnabled(false);
			}
		});
		cmbInstead.setItems(new String[] {});
		cmbInstead.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPadding2 = new Label(shlSubstitution, SWT.NONE);
		new Label(shlSubstitution, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlSubstitution, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlSubstitution.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				registerEvent(e);
				RegisterSubstitutionDialog.this.shlSubstitution.dispose();
			}
		});
		btnAdd.setText("Feljegyez");
		sashForm.setWeights(new int[] {1, 1});

	}
	
	protected void registerEvent(SelectionEvent e) {
		result.setTime(dateTime.getHours()*60*60 + dateTime.getMinutes()*60 + dateTime.getSeconds());
	}
}
