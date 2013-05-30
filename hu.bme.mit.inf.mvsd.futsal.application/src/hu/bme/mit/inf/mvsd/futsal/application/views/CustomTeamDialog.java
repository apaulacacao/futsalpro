package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class CustomTeamDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	protected Team result;
	protected Shell shlAddTeam;
	private Text txtName;
	private FutsalServiceInterface core;
	protected boolean cancelled = true;
	private Button btnAdd;
	
	public boolean isCancelled() {
		return cancelled;
	}
	
	public Team getTeam() {
		return result;
	}
	
	public void setTeam(Team result) {
		this.result = result;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CustomTeamDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, style);
		this.core = core;
		setText("Helysz\u00EDn hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Team open() {
		if (result == null){
			return null;
		}
		createContents();
		shlAddTeam.open();
		shlAddTeam.layout();
		Display display = getParent().getDisplay();
		while (!shlAddTeam.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlAddTeam = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlAddTeam.setSize(332, 169);
		shlAddTeam.setText("Csapat hozz\u00E1ad\u00E1sa");
		GridLayout gl_shlAddTeam = new GridLayout(2, false);
		gl_shlAddTeam.marginRight = 5;
		gl_shlAddTeam.marginLeft = 5;
		shlAddTeam.setLayout(gl_shlAddTeam);
		
		Label lblInstructions = new Label(shlAddTeam, SWT.WRAP);
		lblInstructions.setAlignment(SWT.CENTER);
		GridData gd_lblInstructions = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblInstructions.widthHint = 299;
		lblInstructions.setLayoutData(gd_lblInstructions);
		lblInstructions.setText("Az adatb\u00E1zisban nem szerepl\u0151, alkalmi csapat megad\u00E1s\u00E1hoz adja meg a csapat nev\u00E9t.");
		
		Label lblPadding1 = new Label(shlAddTeam, SWT.NONE);
		new Label(shlAddTeam, SWT.NONE);
		
		Label lblName = new Label(shlAddTeam, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("N\u00E9v*:");
		
		txtName = new Text(shlAddTeam, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0);
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPadding2 = new Label(shlAddTeam, SWT.NONE);
		new Label(shlAddTeam, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlAddTeam, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddTeam.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				shlAddTeam.dispose();
			}
		});
		btnAdd.setText("Hozz\u00E1ad\u00E1s");
		sashForm.setWeights(new int[] {1, 1});
		
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtName);
		IObservableValue nameResultObserveValue = PojoProperties.value("name").observe(result);
		bindingContext.bindValue(observeTextTxtNameObserveWidget, nameResultObserveValue, null, null);
		//
		return bindingContext;
	}
}
