package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.io.IOException;

import javax.xml.soap.SOAPException;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.futsal.core.InvalidOperationException;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Results extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Results(Composite parent, int style, Futsal mainWindow) {
		super(parent, style);
		
		this.mainWindow = mainWindow;
		
		setLayout(new GridLayout(2, false));
		
		Browser brwHtmlReport = new Browser(this, SWT.NONE);
		brwHtmlReport.setText(getCore().getHtmlReport());
		brwHtmlReport.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		Label label_1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnSendHtml = new Button(this, SWT.NONE);
		btnSendHtml.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getCore().sendHtmlReport();
					ReportLinkDialog dialog = new ReportLinkDialog(Results.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore().getHtmlUrl());
					dialog.open();
				} catch (IOException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(Results.this.mainWindow.shlFutsalPro);
					mb.setText("Hiba");
					mb.setMessage("A jegyzõkönyvet nem sikerült elküldeni. A szolgáltatás nem elérhetõ. Lehetséges, hogy nem veheti igénybe a szolgáltatást, mivel az csak a BME MIT tanszékén mûködõ Hibatûrõ Rendszerek Kutatócsoportjának belsõ hálózatából elérhetõ.");
					mb.open();
				}
			}
		});
		btnSendHtml.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnSendHtml.setText("HTML jegyz\u0151k\u00F6nyv bek\u00FCld\u00E9se");
		
		Button btnSendLatex = new Button(this, SWT.NONE);
		btnSendLatex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getCore().generateLatexReport();
					getCore().sendLatexReport();
					btnSavePdf.setEnabled(true);
					ReportLinkDialog dialog = new ReportLinkDialog(Results.this.mainWindow.shlFutsalPro, SWT.MODELESS, getCore().getPdfUrl());
					dialog.open();
				} catch (IOException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(Results.this.mainWindow.shlFutsalPro);
					mb.setText("Hiba");
					mb.setMessage("A jegyzõkönyvet nem sikerült elküldeni. A szolgáltatás nem elérhetõ. Lehetséges, hogy nem veheti igénybe a szolgáltatást, mivel az csak a BME MIT tanszékén mûködõ Hibatûrõ Rendszerek Kutatócsoportjának belsõ hálózatából elérhetõ.");
					mb.open();
				}
			}
		});
		btnSendLatex.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnSendLatex.setText("PDF jegyz\u0151k\u00F6nyv bek\u00FCld\u00E9se");
		
		Button btnSaveHtml = new Button(this, SWT.NONE);
		btnSaveHtml.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(Results.this.mainWindow.shlFutsalPro, SWT.SAVE);
				dialog.setFilterNames(new String[] {"HTML"});
				dialog.setFilterExtensions(new String[] {"*.html"});
				String path = dialog.open();
				try {
					getCore().saveHtmlReport(path);
				} catch (IOException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(Results.this.mainWindow.shlFutsalPro);
					mb.setText("Hiba");
					mb.setMessage("Nem sikerült menteni a fájlt.");
					mb.open();
				}
			}
		});
		btnSaveHtml.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnSaveHtml.setText("HTML jegyz\u0151k\u00F6nyv ment\u00E9se");
		
		btnSavePdf = new Button(this, SWT.NONE);
		btnSavePdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(Results.this.mainWindow.shlFutsalPro, SWT.SAVE);
				dialog.setFilterNames(new String[] {"PDF"});
				dialog.setFilterExtensions(new String[] {"*.pdf"});
				String path = dialog.open();
				try {
					getCore().savePdfReport(path);
				} catch (IOException e1) {
					e1.printStackTrace();
					MessageBox mb = new MessageBox(Results.this.mainWindow.shlFutsalPro);
					mb.setText("Hiba");
					mb.setMessage("Nem sikerült menteni a fájlt.");
					mb.open();
				}
			}
		});
		btnSavePdf.setEnabled(false);
		btnSavePdf.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnSavePdf.setText("PDF jegyz\u0151k\u00F6nyv ment\u00E9se");
		
		Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		label.setText("");
		
		Button btnExit = new Button(this, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Results.this.mainWindow.close();
			}
		});
		btnExit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnExit.setText("Kil\u00E9p\u00E9s");
		
		Button btnNewMatch = new Button(this, SWT.NONE);
		btnNewMatch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Results.this.mainWindow.reset();
			}
		});
		btnNewMatch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnNewMatch.setText("\u00DAj m\u00E9rk\u0151z\u00E9s");

	}

	private FutsalServiceInterface getCore() {
		// TODO Auto-generated method stub
		return mainWindow.getCore();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private Futsal mainWindow;
	private Button btnSavePdf;
	
	private Futsal getMainWindow() {
		return mainWindow;
	}

	private void setMainWindow(Futsal mainWindow) {
		this.mainWindow = mainWindow;
	}

}
