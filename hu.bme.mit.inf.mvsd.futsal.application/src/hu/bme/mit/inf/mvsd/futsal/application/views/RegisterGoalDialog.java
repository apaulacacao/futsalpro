package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.util.ArrayList;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;

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

public class RegisterGoalDialog extends Dialog {

	private Goal result;
	private boolean cancelled = true;
	protected Shell shlGoal;
	private FutsalServiceInterface core;
	private Combo cmbScorer;
	private Button cbOwn;
	private DateTime dateTime;
	private ArrayList<Player> fieldPlayers;
	
	boolean ownGoalDefined = false;
	private Button btnAdd;
	

	public Goal getGoal() {
		return result;
	}

	public void setGoal(Goal result) {
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
	public RegisterGoalDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, SWT.DIALOG_TRIM);
		this.core = core;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Goal open() {
		createContents();
		if (result == null) {
			result = core.createGoal();
		}
		else
		{
			bindResult();
		}
		shlGoal.open();
		shlGoal.layout();
		Display display = getParent().getDisplay();
		while (!shlGoal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void bindResult() {
		dateTime.setTime(0, core.getElapsedTime()/60, core.getElapsedTime()%60);

		if (result.getPlayer() != null)
			cmbScorer.setText(result.getPlayer().getName() + " (" + result.getPlayer().getTeam().getName() + ")");
		else
			btnAdd.setEnabled(false);
		
		if (result.getScorerTeam() != null)
		{
			if (result.getPlayer() != null)
			{
				cbOwn.setSelection(result.getPlayer().getTeam() != result.getScorerTeam());
			}
			else
			{
				cbOwn.setSelection(false);
			}
		}
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlGoal = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlGoal.setSize(325, 188);
		shlGoal.setText("G\u00F3l");
		GridLayout gl_shlGoal = new GridLayout(2, false);
		gl_shlGoal.marginRight = 5;
		gl_shlGoal.marginLeft = 5;
		shlGoal.setLayout(gl_shlGoal);
		
		Label lblPadding1 = new Label(shlGoal, SWT.NONE);
		new Label(shlGoal, SWT.NONE);
		
		Label lblTime = new Label(shlGoal, SWT.NONE);
		lblTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTime.setText("Id\u0151:");
		
		dateTime = new DateTime(shlGoal, SWT.BORDER | SWT.TIME);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblScorer = new Label(shlGoal, SWT.NONE);
		lblScorer.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblScorer.setText("G\u00F3lszerz\u0151:");
		
		cmbScorer = new Combo(shlGoal, SWT.READ_ONLY);
		cmbScorer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.setPlayer(fieldPlayers.get(cmbScorer.getSelectionIndex()));
				btnAdd.setEnabled(true);
				calculateViews();
			}
		});
		cmbScorer.setItems(new String[] {});
		cmbScorer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlGoal, SWT.NONE);
		
		fieldPlayers = new ArrayList<Player>();
		fieldPlayers.addAll(core.getAllPlayers(null));
		
		String[] items = new String[fieldPlayers.size()];
		
		for (int i = 0; i < fieldPlayers.size(); ++i)
		{
			items[i] = fieldPlayers.get(i).getName() + " (" + fieldPlayers.get(i).getTeam().getName() + ")";
		}
		
		cmbScorer.setItems(items);
		
		cbOwn = new Button(shlGoal, SWT.CHECK);
		cbOwn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ownGoalDefined = true;
				calculateViews();
			}
		});
		cbOwn.setText("\u00D6ng\u00F3l");
		
		Label lblPadding2 = new Label(shlGoal, SWT.NONE);
		new Label(shlGoal, SWT.NONE);
		
		SashForm sashForm = new SashForm(shlGoal, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlGoal.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				registerEvent(e);
				RegisterGoalDialog.this.shlGoal.dispose();
			}
		});
		btnAdd.setText("Feljegyez");
		sashForm.setWeights(new int[] {1, 1});

	}
	
	protected void registerEvent(SelectionEvent e) {
		result.setTime(dateTime.getHours()*60*60 + dateTime.getMinutes()*60 + dateTime.getSeconds());
		result.setScorerTeam(cbOwn.getSelection() ? (result.getPlayer().getTeam() == core.getMatch().getTeam1() ? core.getMatch().getTeam2() : core.getMatch().getTeam1()) : result.getPlayer().getTeam());
	}

	private void calculateViews()
	{
		if (result.getScorerTeam() != null)
		{
			if (result.getPlayer() != null)
			{
				if (!ownGoalDefined)
				{
					cbOwn.setSelection(result.getPlayer().getTeam() != result.getScorerTeam());
				}
			}
		}
	}
}
