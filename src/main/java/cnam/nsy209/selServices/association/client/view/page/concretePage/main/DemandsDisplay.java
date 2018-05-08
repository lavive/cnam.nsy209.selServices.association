package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.DemandsDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.DemandsCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class DemandsDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static DemandsDisplay instance;
	public static DemandsDisplay get() {
		if(instance == null)
			instance = new DemandsDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}

	/* Attribute */
	private List<SupplyDemandLocalDto> demands;
	private DemandsCellTable demandsTable;

	/* Constructor */
	private DemandsDisplay(int width,int height) {
		super(width,height);
		demandsTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		demands = ((DemandsDisplayModel) observable).getDemands();
		
		demandsTable.getDataProvider().setList(demands);
		demandsTable.getDataProvider().refresh();
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
		demands = new ArrayList<SupplyDemandLocalDto>();//DemandsCellTable.suppliesDemands();
		demandsTable = new DemandsCellTable(width,height,
												I18n.getI18nMessages().noDemand(),demands);
		/**********************************************************************************/
		
		panel.add(demandsTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public DemandsCellTable getDemandsTable() {
		return demandsTable;
	}

}

