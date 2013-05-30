package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CustomCrewDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	private Crew result;
	private boolean cancelled = true;
	protected Shell shlAddCrew;
	private Text txtName;
	private FutsalServiceInterface core;
	private Spinner spnLicenceNumber;
	private Combo cmbRole;

	private Button btnAdd;
	
	

	public Crew getCrew() {
		return result;
	}

	public void setCrew(Crew result) {
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
	public CustomCrewDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, style);
		this.core = core;
		setText("Kispadon \u00FCl\u0151 szem\u00E9ly hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Crew open() {
		if (result == null) {
			result = core.createCrew();
		}
		createContents();
		shlAddCrew.open();
		shlAddCrew.layout();
		Display display = getParent().getDisplay();
		while (!shlAddCrew.isDisposed()) {
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
		shlAddCrew = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlAddCrew.setSize(332, 250);
		shlAddCrew.setText("Kispadon \u00FCl\u0151 szem\u00E9ly hozz\u00E1ad\u00E1sa");
		GridLayout gl_shlAddPlayer = new GridLayout(2, false);
		gl_shlAddPlayer.marginRight = 5;
		gl_shlAddPlayer.marginLeft = 5;
		shlAddCrew.setLayout(gl_shlAddPlayer);
		
		Label lblInstructions = new Label(shlAddCrew, SWT.WRAP);
		lblInstructions.setAlignment(SWT.CENTER);
		GridData gd_lblInstructions = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblInstructions.widthHint = 299;
		lblInstructions.setLayoutData(gd_lblInstructions);
		lblInstructions.setText("Az adatb\u00E1zisban nem szerepl\u0151, a kispadon helyet foglal\u00F3 szem\u00E9ly megad\u00E1s\u00E1hoz adja meg a szem\u00E9ly ideiglenes adatait. Amennyiben az illet\u0151 nem rendelkezik igazol\u00E1ssz\u00E1mmal, a 0 \u00E9rt\u00E9ket adja meg.");
		
		Label lblPadding1 = new Label(shlAddCrew, SWT.NONE);
		new Label(shlAddCrew, SWT.NONE);
		
		Label lblName = new Label(shlAddCrew, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("N\u00E9v*:");
		
		txtName = new Text(shlAddCrew, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0);
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRole = new Label(shlAddCrew, SWT.NONE);
		lblRole.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRole.setText("Szerep*:");
		
		cmbRole = new Combo(shlAddCrew, SWT.READ_ONLY);
		cmbRole.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setRole(CrewRole.get(cmbRole.getSelectionIndex()));
			}
		});
		cmbRole.setItems(new String[] {"edz\u0151", "vezet\u0151edz\u0151", "orvos", "gy\u00FAr\u00F3", "technikai vezet\u0151", "egy\u00E9b"});
		cmbRole.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cmbRole.select(0);
		
		Label lblLicenceNumber = new Label(shlAddCrew, SWT.NONE);
		lblLicenceNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLicenceNumber.setText("Igazol\u00E1ssz\u00E1m:");
		
		spnLicenceNumber = new Spinner(shlAddCrew, SWT.BORDER);
		spnLicenceNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPadding2 = new Label(shlAddCrew, SWT.NONE);
		new Label(shlAddCrew, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlAddCrew, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddCrew.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddCrew.dispose();
				cancelled = false;
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
		IObservableValue licenceNumberResultObserveValue = PojoProperties.value("licenceNumber").observe(result);
		bindingContext.bindValue(observeSelectionSpnLicenceNumberObserveWidget, licenceNumberResultObserveValue, null, null);
		//
		return bindingContext;
	}
}
