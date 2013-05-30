package hu.bme.mit.inf.mvsd.futsal.application.views;

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

class CaptainHolder implements HolderUpdateListener
{
	private Team team;
	private InitReport parent;
	private Composite composite;
	private Combo cmbCaptain;
	private List<FieldPlayerHolder> fieldPlayerHolders;
	private List<GoalkeeperHolder> goalkeeperHolders;
	private List<SubstituteHolder> substituteHolders;
	private ArrayList<Player> availablePlayers = new ArrayList<Player>();
	
	public boolean isValid() {
		return team.getCaptain() != null;
	}
	
	public CaptainHolder(InitReport initReport, Group container, Team team, List<FieldPlayerHolder> fieldPlayerHolders, List<GoalkeeperHolder> goalkeeperHolders, List<SubstituteHolder> substituteHolders)
	{
		parent = initReport;
		this.team = team;
		this.fieldPlayerHolders = fieldPlayerHolders;
		this.goalkeeperHolders = goalkeeperHolders;
		this.substituteHolders = substituteHolders;
		
		composite = new Composite(container, SWT.NONE);
		GridLayout gl_compTeam1Crew1 = new GridLayout(1, false);
		gl_compTeam1Crew1.marginHeight = 0;
		gl_compTeam1Crew1.marginWidth = 0;
		composite.setLayout(gl_compTeam1Crew1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
				
		cmbCaptain = new Combo(composite, SWT.READ_ONLY);
		cmbCaptain.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CaptainHolder.this.team.setCaptain(availablePlayers.get(cmbCaptain.getSelectionIndex()));
			}
		});
		cmbCaptain.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		registerToHolders();
		
		calculateItems();
	}
	
	private void registerToHolders() {
		for (FieldPlayerHolder fieldPlayerHolder : fieldPlayerHolders) {
			fieldPlayerHolder.addListener(this);
		}
		for (GoalkeeperHolder goalkeeperHolder : goalkeeperHolders) {
			goalkeeperHolder.addListener(this);
		}
		for (SubstituteHolder substituteHolder : substituteHolders) {
			substituteHolder.addListener(this);
		}
	}

	@Override
	public void modelUpdated() {
		calculateItems();
	}

	private void calculateItems() {
		availablePlayers.clear();
		for (FieldPlayerHolder fieldPlayer : fieldPlayerHolders) {
			if (fieldPlayer.isValid()) {
				availablePlayers.add(fieldPlayer.getModel());
			}
		}
		for (GoalkeeperHolder goalkeeper : goalkeeperHolders) {
			if (goalkeeper.isValid()) {
				availablePlayers.add(goalkeeper.getModel());
			}
		}
		for (SubstituteHolder substitute : substituteHolders) {
			if (substitute.isValid()) {
				availablePlayers.add(substitute.getModel());
			}
		}
		
		String[] items = new String[availablePlayers.size()];
		
		for (int i = 0; i < availablePlayers.size(); ++i)
		{
			items[i] = availablePlayers.get(i).getName();
		}
		
		if (!Arrays.asList(items).contains(cmbCaptain.getText())) {
			team.setCaptain(null);
			cmbCaptain.clearSelection();
		}
		
		cmbCaptain.setItems(items);
		if (team.getCaptain() != null)
			cmbCaptain.setText(team.getCaptain().getName());
		cmbCaptain.update();
	}
	
}