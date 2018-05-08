package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MemberDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MemberDisplay instance;
	public static MemberDisplay get(LocalDto member, EnumMenuHorizontal enumOrigin) {
		if(member instanceof MemberLocalDto)
			instance = new MemberDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT),member,enumOrigin);			
		
		return instance;
	}

	/* Constructor */
	private MemberDisplay(int width, int height,LocalDto dto, EnumMenuHorizontal enumOrigin) {
		super(width, height,dto);
		this.enumOrigin = enumOrigin;
	}
	
	/* Attribute */
	private MemberDisplayControler controler;
	private EnumMenuHorizontal enumOrigin;

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height,dto));
		
		return displayStrategy;
	}	
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height,LocalDto dto) {	
		controler = new MemberDisplayControler(width, height);
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
	    layout.setHTML(1, 1,((MemberLocalDto) dto).getName());
	    
	    layout.setHTML(2, 0, I18n.getI18nConstants().forname()+":");
	    layout.setHTML(2, 1,((MemberLocalDto) dto).getForname());
	    
	    layout.setHTML(3, 0, I18n.getI18nConstants().address()+":");
	    layout.setHTML(3, 1,((MemberLocalDto) dto).getAddress());
	    
	    layout.setHTML(4, 0, I18n.getI18nConstants().postalCode()+":");
	    layout.setHTML(4, 1,((MemberLocalDto) dto).getPostalCode());
	    	    
	    layout.setHTML(5, 0, I18n.getI18nConstants().town()+":");
	    layout.setHTML(5, 1,((MemberLocalDto) dto).getTown());
	    
	    layout.setHTML(6, 0, I18n.getI18nConstants().email()+":");
	    layout.setHTML(6, 1,((MemberLocalDto) dto).getEmail());
	    
	    layout.setHTML(7, 0, I18n.getI18nConstants().cellNumber()+":");
	    layout.setHTML(7, 1,((MemberLocalDto) dto).getCellNumber());
	    
	    layout.setHTML(8, 0, I18n.getI18nConstants().phoneNumber()+":");
	    layout.setHTML(8, 1,((MemberLocalDto) dto).getPhoneNumber());
	    
	    layout.setHTML(9, 0, I18n.getI18nConstants().password()+":");
	    layout.setHTML(9, 1,((MemberLocalDto) dto).getMobileId());
	    
	    /* Add a panel button */
	    HorizontalPanel buttonPanel = new HorizontalPanel();
	    buttonPanel.setWidth("100%");
	    buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /* Buttons */
	    Button wealthSheet = new Button(I18n.getI18nConstants().wealthSheet());
	    wealthSheet.setWidth(width*0.15+"px");
	    wealthSheet.addClickHandler(controler.getWealthSheetClickHandler((MemberLocalDto) dto));
	    Button update = new Button(I18n.getI18nConstants().update());	
	    update.setWidth(width*0.15+"px");
	    update.addClickHandler(controler.getUpdateClickHandler((MemberLocalDto) dto));
	    buttonPanel.add(wealthSheet);
	    buttonPanel.add(update);	   
	    
	    layout.setWidget(10, 0, buttonPanel);
	    cellFormatter.setColSpan(10, 0, 2);
	    cellFormatter.setHorizontalAlignment(9, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
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
	    wealthSheet.setStyleName("singleButton");
	    update.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/
//        MemberLocalDto member = (MemberLocalDto) dto;
//        DialogBox test = new DialogBox();
//        test.setText(member+": "+member.getWealthSheet());
//        test.show();
        
	    return panel;
	}
	
	/* getter */

	public EnumMenuHorizontal getEnumOrigin() {
		return enumOrigin;
	}
	
	/* for the test */
	public static MemberLocalDto get() {
		MemberLocalDto member = new MemberLocalDto();
		member.setAddress("adresseeee");
		member.setName("nameee");
		member.setForname("fornameeee");
		member.setPostalCode("31330");
		member.setTown("Grenade");
		member.setCellNumber("0620304050");
		member.setPhoneNumber("0520304050");
		member.setEmail("sel@save.com");
		member.setPassword("PP7sw0rdd");
		
		return member;
	}

}
