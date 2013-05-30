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

public class SetTimeDialog extends Dialog {

	private int result;
	private boolean cancelled = true;
	protected Shell shlTime;
	private FutsalServiceInterface core;
	private DateTime dateTime;
	
	private Button btnAdd;
	

	public int getTime() {
		return result;
	}

	public void setTime(int result) {
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
	public SetTimeDialog(Shell parent, int style, FutsalServiceInterface core) {
		super(parent, SWT.DIALOG_TRIM);
		this.core = core;
		setText("Kispadon \u00FCl\u0151 szem\u00E9ly hozz\u00E1ad\u00E1sa");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public int open() {
		createContents();
		bindResult();
		shlTime.open();
		shlTime.layout();
		Display display = getParent().getDisplay();
		while (!shlTime.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void bindResult() {
		dateTime.setTime(0, core.getElapsedTime()/60, core.getElapsedTime()%60);
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlTime = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlTime.setSize(174, 91);
		shlTime.setText("\u00D3ra \u00E1t\u00E1ll\u00EDt\u00E1sa");
		GridLayout gl_shlTime = new GridLayout(2, false);
		gl_shlTime.marginRight = 5;
		gl_shlTime.marginLeft = 5;
		shlTime.setLayout(gl_shlTime);
		
		Label lblTime = new Label(shlTime, SWT.NONE);
		lblTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTime.setText("Id\u0151:");
		
		dateTime = new DateTime(shlTime, SWT.BORDER | SWT.TIME);
		GridData gd_dateTime = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_dateTime.widthHint = 50;
		dateTime.setLayoutData(gd_dateTime);
		
		SashForm sashForm = new SashForm(shlTime, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnCancel = new Button(sashForm, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTime.dispose();
			}
		});
		btnCancel.setText("M\u00E9gse");
		
		btnAdd = new Button(sashForm, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelled = false;
				registerEvent(e);
				SetTimeDialog.this.shlTime.dispose();
			}
		});
		btnAdd.setText("\u00C1t\u00E1ll\u00EDt");
		sashForm.setWeights(new int[] {1, 1});

	}
	
	protected void registerEvent(SelectionEvent e) {
		result = dateTime.getHours()*60*60 + dateTime.getMinutes()*60 + dateTime.getSeconds();
	}
}
