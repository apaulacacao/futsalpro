package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor;

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

public class CustomSupervisorDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	private Supervisor result;
	protected Shell shlAddSupervisor;
	private Text txtName;
	private FutsalServiceInterface core;
	protected boolean cancelled = true;
	private Spinner spnLicenceNumber;

	private Button btnAdd;
	
	public boolean isCancelled() {
		return cancelled;
	}

	public Supervisor getSupervisor() {
		return result;
	}

	public void setSupervisor(Supervisor result) {
		this.result = result;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CustomSupervisorDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, style);
		this.core = core;
		setText("Fel\u00FCgyel\u0151 hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Supervisor open() {
		if (result == null){
			result = core.createSupervisor();
		}
		createContents();
		shlAddSupervisor.open();
		shlAddSupervisor.layout();
		Display display = getParent().getDisplay();
		while (!shlAddSupervisor.isDisposed()) {
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
		shlAddSupervisor = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlAddSupervisor.setSize(332, 226);
		shlAddSupervisor.setText("Fel\u00FCgyel\u0151 hozz\u00E1ad\u00E1sa");
		GridLayout gl_shlAddSupervisor = new GridLayout(2, false);
		gl_shlAddSupervisor.marginRight = 5;
		gl_shlAddSupervisor.marginLeft = 5;
		shlAddSupervisor.setLayout(gl_shlAddSupervisor);
		
		Label lblInstructions = new Label(shlAddSupervisor, SWT.WRAP);
		lblInstructions.setAlignment(SWT.CENTER);
		GridData gd_lblInstructions = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblInstructions.widthHint = 299;
		lblInstructions.setLayoutData(gd_lblInstructions);
		lblInstructions.setText("Az adatb\u00E1zisban nem szerepl\u0151, alkalmi fel\u00FCgyel\u0151 megad\u00E1s\u00E1hoz adja meg a fel\u00FCgyel\u0151 ideiglenes adatait. Amennyiben a fel\u00FCgyel\u0151 nem rendelkezik hivatalos azonos\u00EDt\u00F3val, a 0 \u00E9rt\u00E9ket adja meg.");
		
		Label lblPadding1 = new Label(shlAddSupervisor, SWT.NONE);
		new Label(shlAddSupervisor, SWT.NONE);
		
		Label lblName = new Label(shlAddSupervisor, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("N\u00E9v*:");
		
		txtName = new Text(shlAddSupervisor, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0);
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblIdentifier = new Label(shlAddSupervisor, SWT.NONE);
		lblIdentifier.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdentifier.setText("Azonos\u00EDt\u00F3:");
		
		spnLicenceNumber = new Spinner(shlAddSupervisor, SWT.BORDER);
		spnLicenceNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPadding2 = new Label(shlAddSupervisor, SWT.NONE);
		new Label(shlAddSupervisor, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlAddSupervisor, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddSupervisor.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				shlAddSupervisor.dispose();
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
		IObservableValue observeSelectionSpnLicenceNumberObserveWidget = WidgetProperties.selection().observe(spnLicenceNumber);
		IObservableValue identifierResultObserveValue = PojoProperties.value("identifier").observe(result);
		bindingContext.bindValue(observeSelectionSpnLicenceNumberObserveWidget, identifierResultObserveValue, null, null);
		//
		return bindingContext;
	}
}
