package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.futsal.core.FutsalCore;
import hu.bme.mit.inf.mvsd.futsal.core.FutsalServiceInterface;
import hu.bme.mit.inf.mvsd.futsal.core.database.DatabaseManager;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.ResourceManager;

public class Futsal {

	protected Shell shlFutsalPro;
	private Composite mainArea;

	private FutsalServiceInterface core;
	private DatabaseManager db;
	private Display display;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Futsal window = new Futsal();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				Display display = Display.getDefault();
				core = new FutsalCore();
				db = new DatabaseManager();
				createContents();
				shlFutsalPro.open();
				shlFutsalPro.layout();
				Platform.endSplash();
				while (!shlFutsalPro.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
				display.dispose();
			}
		});
	}

	/**
	 * Close the window.
	 */
	public void close() {
		if (!shlFutsalPro.isDisposed()) {
			shlFutsalPro.dispose();
			display.dispose();
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFutsalPro = new Shell();
		shlFutsalPro.setImage(ResourceManager.getPluginImage("hu.bme.mit.mvsd.futsal.application", "icons/icon16.gif"));
		shlFutsalPro.setSize(900, 700);
		shlFutsalPro.setText("Futsal Pro");
		shlFutsalPro.setLayout(new FillLayout(SWT.HORIZONTAL));

		// mainArea = new InitReport(shlFutsalPro, SWT.NONE);
		setScreen(Screens.Init);
	}

	public enum Screens {
		Init, Scoreboard, Results
	}

	public void setScreen(Screens screen) {
		switch (screen) {
		case Init:
			for (Control control : shlFutsalPro.getChildren()) {
				control.dispose();
			}
			mainArea = new InitReport(shlFutsalPro, SWT.NONE, this);
			shlFutsalPro.setSize(900, 690);
			shlFutsalPro.setText("Futsal Pro - Jegyzõkönyv");
			break;
		case Results:
			for (Control control : shlFutsalPro.getChildren()) {
				control.dispose();
			}
			mainArea = new Results(shlFutsalPro, SWT.NONE, this);
			shlFutsalPro.setSize(900, 690);
			shlFutsalPro.setText("Futsal Pro - Játék");
			break;
		case Scoreboard:
			for (Control control : shlFutsalPro.getChildren()) {
				control.dispose();
			}
			mainArea = new Scoreboard(shlFutsalPro, SWT.NONE, this);
			shlFutsalPro.setSize(900, 600);
			shlFutsalPro.setText("Futsal Pro - Eredmények");
			;
		default:
			break;

		}
	}

	public FutsalServiceInterface getCore() {
		return core;
	}
	
	public DatabaseManager getDb() {
		return db;
	}

	public Display getDisplay() {
		return display;
	}

	public void reset() {
		core = new FutsalCore();
		db = new DatabaseManager();
		setScreen(Screens.Init);
		shlFutsalPro.layout();
		shlFutsalPro.update();
	}
}
