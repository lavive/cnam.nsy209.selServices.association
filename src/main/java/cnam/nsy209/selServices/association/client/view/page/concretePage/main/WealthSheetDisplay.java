package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.WealthSheetDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.WealthSheetCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

public class WealthSheetDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static WealthSheetDisplay instance;
	public static WealthSheetDisplay get(LocalDto member) {
		if(member instanceof MemberLocalDto)
			instance = new WealthSheetDisplay((int)(0.78*WIDTH), (int)(0.25*HEIGHT),member);			
		
		return instance;
	}

	/* Attribute */
	private WealthSheetLocalDto wealthSheet;
	private WealthSheetCellTable wealthSheetTable;

	/* Constructor */
	private WealthSheetDisplay(int width, int height,LocalDto dto) {
		super(width, height,dto);
		wealthSheetTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		wealthSheet = ((WealthSheetDisplayModel) observable).getWealthSheet();
		
		wealthSheetTable.getDataProvider().setList(wealthSheet.getTransactionsDisplay());
		wealthSheetTable.getDataProvider().refresh();
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height,dto));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height,LocalDto dto) {
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/*********** Data Grid WealthSheet ************************************************/
		wealthSheet = ((MemberLocalDto) dto).getWealthSheet();
		String name = ((MemberLocalDto) dto).getFullName();
		wealthSheetTable = new WealthSheetCellTable(width,height,I18n.getI18nMessages().noTransaction(),
				wealthSheet,name);
		/**********************************************************************************/
		
		panel.add(wealthSheetTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public WealthSheetCellTable getWealthSheetTable() {
		return wealthSheetTable;
	}

}
