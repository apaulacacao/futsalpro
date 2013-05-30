package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;

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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CustomPlayerDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	private FutsalServiceInterface core;

	protected Player result;
	protected Shell shlAddPlayer;
	private Text txtName;

	private boolean enableChoice;

	private boolean goalkeeper;

	public boolean isGoalkeeper() {
		return goalkeeper;
	}

	public Player getPlayer() {
		return result;
	}

	public void setPlayer(Player result) {
		this.result = result;
		if (result instanceof GoalKeeper) {
			this.goalkeeper = true;
		} else {
			this.goalkeeper = false;
		}
	}

	private Button cbGoalkeeper;
	private Spinner spnSquadNumber;
	private Spinner spnLicenceNumber;

	private boolean cancelled = true;

	private Button btnAdd;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public CustomPlayerDialog(Shell parent, int style,
			FutsalServiceInterface core, boolean enableChoice,
			boolean isGoalkeeper) {
		super(parent, style);
		this.enableChoice = enableChoice;
		this.goalkeeper = isGoalkeeper;
		setText("J\u00E1t\u00E9kos hozz\u00E1ad\u00E1sa");
		this.core = core;
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Player open() {
		if (result == null) {
			if (goalkeeper) {
				result = core.createGoalkeeper();
			} else {
				result = core.createPlayer();
			}
		}
		createContents();
		shlAddPlayer.open();
		shlAddPlayer.layout();
		cbGoalkeeper.setSelection(goalkeeper);
		cbGoalkeeper.setEnabled(enableChoice);
		Display display = getParent().getDisplay();
		while (!shlAddPlayer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void changeToGoalkeeper() {
		if (result == null)
			return;
		if (result instanceof GoalKeeper)
			return;
		GoalKeeper goalkeeper = core.createGoalkeeper();
		goalkeeper.setId(result.getId());
		goalkeeper.setName(result.getName());
		goalkeeper.setSquadNumber(result.getSquadNumber());
		goalkeeper.setLicenceNumber(result.getLicenceNumber());
		goalkeeper.setDateOfBirth(result.getDateOfBirth());
		goalkeeper.setAddress(result.getAddress());
		goalkeeper.setTeam(result.getTeam());
		result = goalkeeper;
		this.goalkeeper = true;
	}

	private void changeToPlayer() {
		if (result == null)
			return;
		if (!(result instanceof GoalKeeper))
			return;
		Player player = core.createPlayer();
		player.setId(result.getId());
		player.setName(result.getName());
		player.setSquadNumber(result.getSquadNumber());
		player.setLicenceNumber(result.getLicenceNumber());
		player.setDateOfBirth(result.getDateOfBirth());
		player.setAddress(result.getAddress());
		player.setTeam(result.getTeam());
		result = player;
		this.goalkeeper = false;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlAddPlayer = new Shell(getParent(), SWT.DIALOG_TRIM
				| SWT.APPLICATION_MODAL);
		shlAddPlayer.setSize(332, 253);
		shlAddPlayer.setText("J\u00E1t\u00E9kos hozz\u00E1ad\u00E1sa");
		GridLayout gl_shlAddPlayer = new GridLayout(3, false);
		gl_shlAddPlayer.marginRight = 5;
		gl_shlAddPlayer.marginLeft = 5;
		shlAddPlayer.setLayout(gl_shlAddPlayer);

		Label lblInstructions = new Label(shlAddPlayer, SWT.WRAP);
		lblInstructions.setAlignment(SWT.CENTER);
		GridData gd_lblInstructions = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1);
		gd_lblInstructions.widthHint = 299;
		lblInstructions.setLayoutData(gd_lblInstructions);
		lblInstructions
				.setText("Az adatb\u00E1zisban nem szerepl\u0151, alkalmi j\u00E1t\u00E9kos vagy kapus megad\u00E1s\u00E1hoz adja meg a j\u00E1t\u00E9kos ideiglenes adatait. Amennyiben a j\u00E1t\u00E9kos nem rendelkezik igazol\u00E1ssz\u00E1mmal, a 0 \u00E9rt\u00E9ket adja meg.");

		Label lblPadding1 = new Label(shlAddPlayer, SWT.NONE);
		new Label(shlAddPlayer, SWT.NONE);
		new Label(shlAddPlayer, SWT.NONE);

		Label lblName = new Label(shlAddPlayer, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("N\u00E9v*:");

		txtName = new Text(shlAddPlayer, SWT.BORDER);
		txtName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				btnAdd.setEnabled(txtName.getText() != null && txtName.getText().length() > 0);
			}
		});
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));

		Label lblSquadNumber = new Label(shlAddPlayer, SWT.NONE);
		lblSquadNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblSquadNumber.setText("Mezsz\u00E1m*:");

		spnSquadNumber = new Spinner(shlAddPlayer, SWT.BORDER);
		spnSquadNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		spnSquadNumber.setMinimum(1);

		cbGoalkeeper = new Button(shlAddPlayer, SWT.CHECK);
		cbGoalkeeper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (cbGoalkeeper.getSelection()) {
					changeToGoalkeeper();
					goalkeeper = true;
				} else {
					changeToPlayer();
					goalkeeper = false;
				}
			}
		});
		cbGoalkeeper.setText("Kapus");

		Label lblLicenceNumber = new Label(shlAddPlayer, SWT.NONE);
		lblLicenceNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblLicenceNumber.setText("Igazol\u00E1ssz\u00E1m:");

		spnLicenceNumber = new Spinner(shlAddPlayer, SWT.BORDER);
		spnLicenceNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		new Label(shlAddPlayer, SWT.NONE);
		new Label(shlAddPlayer, SWT.NONE);
		new Label(shlAddPlayer, SWT.NONE);

		SashForm sashForm = new SashForm(shlAddPlayer, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				3, 1));

		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddPlayer.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");

		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				shlAddPlayer.dispose();
			}
		});
		btnAdd.setText("Hozz\u00E1ad\u00E1s");
		sashForm.setWeights(new int[] { 1, 1 });
		m_bindingContext = initDataBindings();

	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtNameObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(txtName);
		IObservableValue nameResultObserveValue = PojoProperties.value("name")
				.observe(result);
		bindingContext.bindValue(observeTextTxtNameObserveWidget,
				nameResultObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnSquadNumberObserveWidget = WidgetProperties
				.selection().observe(spnSquadNumber);
		IObservableValue squadNumberResultObserveValue = PojoProperties.value(
				"squadNumber").observe(result);
		bindingContext.bindValue(observeSelectionSpnSquadNumberObserveWidget,
				squadNumberResultObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnLicenceNumberObserveWidget = WidgetProperties
				.selection().observe(spnLicenceNumber);
		IObservableValue licenceNumberResultObserveValue = PojoProperties
				.value("licenceNumber").observe(result);
		bindingContext.bindValue(observeSelectionSpnLicenceNumberObserveWidget,
				licenceNumberResultObserveValue, null, null);
		//
		return bindingContext;
	}

	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return cancelled;
	}
}
