package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;

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

public class CustomPitchDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	protected Pitch result;
	protected Shell shlAddLocation;
	private Text txtName;
	private Text txtAddress;
	private FutsalServiceInterface core;
	protected boolean cancelled = true;
	private Button btnAdd;
	
	public boolean isCancelled() {
		return cancelled;
	}
	
	public Pitch getPitch() {
		return result;
	}
	
	public void setPitch(Pitch result) {
		this.result = result;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CustomPitchDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, style);
		this.core = core;
		setText("Helysz\u00EDn hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Pitch open() {
		if (result == null){
			result = core.createPitch();
		}
		createContents();
		shlAddLocation.open();
		shlAddLocation.layout();
		Display display = getParent().getDisplay();
		while (!shlAddLocation.isDisposed()) {
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
		shlAddLocation = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlAddLocation.setSize(332, 210);
		shlAddLocation.setText("Helysz\u00EDn hozz\u00E1ad\u00E1sa");
		GridLayout gl_shlAddLocation = new GridLayout(2, false);
		gl_shlAddLocation.marginRight = 5;
		gl_shlAddLocation.marginLeft = 5;
		shlAddLocation.setLayout(gl_shlAddLocation);
		
		Label lblInstructions = new Label(shlAddLocation, SWT.WRAP);
		lblInstructions.setAlignment(SWT.CENTER);
		GridData gd_lblInstructions = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblInstructions.widthHint = 299;
		lblInstructions.setLayoutData(gd_lblInstructions);
		lblInstructions.setText("Az adatb\u00E1zisban nem szerepl\u0151, alkalmi helysz\u00EDn megad\u00E1s\u00E1hoz adja meg a p\u00E1lya adatait. A c\u00EDm mez\u0151ben elegend\u0151 a telep\u00FCl\u00E9st megadni.");
		
		Label lblPadding1 = new Label(shlAddLocation, SWT.NONE);
		new Label(shlAddLocation, SWT.NONE);
		
		Label lblName = new Label(shlAddLocation, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("N\u00E9v*:");
		
		txtName = new Text(shlAddLocation, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0 && txtAddress.getText() != null && txtAddress.getText().length() > 0);
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAddress = new Label(shlAddLocation, SWT.NONE);
		lblAddress.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAddress.setText("C\u00EDm*:");
		
		txtAddress = new Text(shlAddLocation, SWT.BORDER);
		txtAddress.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0 && txtAddress.getText() != null && txtAddress.getText().length() > 0);
			}
		});
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPadding2 = new Label(shlAddLocation, SWT.NONE);
		new Label(shlAddLocation, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlAddLocation, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddLocation.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				shlAddLocation.dispose();
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
		IObservableValue observeTextTxtAddressObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtAddress);
		IObservableValue addressResultObserveValue = PojoProperties.value("address").observe(result);
		bindingContext.bindValue(observeTextTxtAddressObserveWidget, addressResultObserveValue, null, null);
		//
		return bindingContext;
	}
}
