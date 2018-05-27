package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.SuppliesDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.SuppliesCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class SuppliesDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static SuppliesDisplay instance;
	public static SuppliesDisplay get() {
		if(instance == null)
			instance = new SuppliesDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}

	/* Attribute */
	private List<SupplyDemandLocalDto> supplies;
	private SuppliesCellTable suppliesTable;

	/* Constructor */
	private SuppliesDisplay(int width,int height) {
		super(width,height);
		suppliesTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		supplies = ((SuppliesDisplayModel) observable).getSupplies();
		
		suppliesTable.getDataProvider().setList(supplies);
		suppliesTable.getDataProvider().refresh();
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}	
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {
		
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/*********** Data Grid Supply Demand **********************************************/
		supplies = new ArrayList<SupplyDemandLocalDto>();
		suppliesTable = new SuppliesCellTable(width,height,
												I18n.getI18nMessages().noSupply(),supplies);
		/**********************************************************************************/
		
		panel.add(suppliesTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public SuppliesCellTable getSuppliesTable() {
		return suppliesTable;
	}

}

