package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.AssociationDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class AssociationDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static AssociationDisplay instance;
	public static AssociationDisplay get(LocalDto association) {
		if(association instanceof AssociationLocalDto)
			instance = new AssociationDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT),association);			
		
		return instance;
	}

	/* Constructor */
	private AssociationDisplay(int width, int height,LocalDto dto) {
		super(width, height,dto);
	}
	
	/* Attribute */
	private AssociationDisplayControler controler;

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

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
		controler = new AssociationDisplayControler(width, height, (AssociationLocalDto) dto);
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
	    /*********** Create a table to layout the form options ****************************/
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(10);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

	    /* Add a title to the form */
	    layout.setHTML(0, 0, I18n.getI18nConstants().card());
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    layout.setHTML(1, 0, I18n.getI18nConstants().name()+":");
	    layout.setHTML(1, 1,((AssociationLocalDto) dto).getName());
	    
	    layout.setHTML(2, 0, I18n.getI18nConstants().address()+":");
	    layout.setHTML(2, 1,((AssociationLocalDto) dto).getAddress());
	    
	    layout.setHTML(3, 0, I18n.getI18nConstants().postalCode()+":");
	    layout.setHTML(3, 1,((AssociationLocalDto) dto).getPostalCode());
	    	    
	    layout.setHTML(4, 0, I18n.getI18nConstants().town()+":");
	    layout.setHTML(4, 1,((AssociationLocalDto) dto).getTown());
	    
	    layout.setHTML(5, 0, I18n.getI18nConstants().email()+":");
	    layout.setHTML(5, 1,((AssociationLocalDto) dto).getEmail());
	    
	    layout.setHTML(6, 0, I18n.getI18nConstants().cellNumber()+":");
	    layout.setHTML(6, 1,((AssociationLocalDto) dto).getCellNumber());
	    
	    layout.setHTML(7, 0, I18n.getI18nConstants().phoneNumber()+":");
	    layout.setHTML(7, 1,((AssociationLocalDto) dto).getPhoneNumber());
	    
	    layout.setHTML(8, 0, I18n.getI18nConstants().webSite()+":");
	    layout.setHTML(8, 1,((AssociationLocalDto) dto).getWebsite());
	    
	    layout.setHTML(9, 0, I18n.getI18nConstants().password()+":");
	    layout.setHTML(9, 1,((AssociationLocalDto) dto).getPassword());
	    
	    
	    /* Add a button 'update' */
	    Button update = new Button(I18n.getI18nConstants().update());
	    update.addClickHandler(controler.getUpdateClickHandler());
	    layout.setWidget(10, 0, update);
	    cellFormatter.setColSpan(10, 0, 2);
	    cellFormatter.setHorizontalAlignment(10, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* style */
	    cellFormatter.setStyleName(0, 0, "titleFontFlexTable");
	    cellFormatter.setStyleName(1, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(7, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(7, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(8, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(8, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(9, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(9, 1, "calibriFontFlexTable");
	    update.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/

	    return panel;
	}

}
