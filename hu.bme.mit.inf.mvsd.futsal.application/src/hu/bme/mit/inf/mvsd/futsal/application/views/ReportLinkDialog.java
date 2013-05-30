package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ReportLinkDialog extends Dialog {

	protected Shell shlLink;
	private String url;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ReportLinkDialog(Shell parent, int style, String url) {
		super(parent, style);
		this.url = url;
		setText("Jegyzõkönyv feltöltve");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public void open() {
		createContents();
		shlLink.open();
		shlLink.layout();
		Display display = getParent().getDisplay();
		while (!shlLink.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlLink = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shlLink.setText("Jegyz\u0151k\u00F6nyv felt\u00F6ltve");
		shlLink.setSize(500, 124);
		shlLink.setLayout(new GridLayout(1, false));
		
		Label lblNotification = new Label(shlLink, SWT.WRAP);
		lblNotification.setAlignment(SWT.CENTER);
		lblNotification.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblNotification.setText("A jegyz\u0151k\u00F6nyv sikeresen felt\u00F6lt\u00E9sre ker\u00FClt \u00E9s a k\u00F6vetkez\u0151 linken el\u00E9rhet\u0151:");
		
		Link link = new Link(shlLink, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (url != null)
				{
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		if (url != null)
			link.setText("<a href=\"" + url + "\">" + url + "</a>");
		link.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button btnOk = new Button(shlLink, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlLink.dispose();
			}
		});
		GridData gd_btnOk = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnOk.widthHint = 80;
		btnOk.setLayoutData(gd_btnOk);
		btnOk.setText("OK");
	}

}
