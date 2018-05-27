package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.FastMessageControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.FastMessageModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class FastMessage extends AbstractPage implements Observer {	
	
	/* Singleton */
	private static FastMessage instance;
	public static FastMessage get() {
		if(instance == null)
			instance = new FastMessage((int)(0.78*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}

	/* Constructor */
	private FastMessage(int width,int height) {
		super(width,height);
	}
	
	/* Attribute */
	private FlexTable layout;
	private FastMessageControler controler;
	private Button send;
	private Button reset;

	@Override
	public void update(Observable observable, Object object) {
		FastMessageModel fastMessageModel = (FastMessageModel) observable;
		
		controler.getText().setText(fastMessageModel.getText());
		controler.getTitle().setText(fastMessageModel.getTitle());
		
		/* update view */
		/* input error */
		if(fastMessageModel.getTextError() != null)
			layout.setHTML(1, 2,fastMessageModel.getTextError().getErrorMessage());
		else
			layout.setHTML(1, 2,"");
		if(fastMessageModel.getTitleError() != null)
			layout.setHTML(0, 2,fastMessageModel.getTitleError().getErrorMessage());
		else
			layout.setHTML(0, 2,"");

		/* validate button and waiting message */
		if(fastMessageModel.isWaiting()) {
			this.send.setEnabled(false);
			this.reset.setEnabled(false);
		} else {
			this.send.setEnabled(true);
			this.reset.setEnabled(true);
		}
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width,int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {
		controler  = new FastMessageControler();
		controler.getModel().addObserver(this);		
		/*********** Main Panel ***********************************************************/
		HorizontalPanel panel = new HorizontalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		VerticalPanel emptyPanel = new VerticalPanel();
		emptyPanel.setWidth(0.15*width+"px");
		/**********************************************************************************/
		
	    /*********** Create a table to layout the form options ****************************/
	    layout = new FlexTable();
	    layout.setCellSpacing(5);
	    //layout.setBorderWidth(2);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    	    
	    
	    /* Add fields to display */
	    layout.setHTML(0,0, I18n.getI18nConstants().title()+":");
	    TextArea title = new TextArea();
	    title.setCharacterWidth(70);
	    title.setVisibleLines(1);
	    layout.setWidget(0, 1,title);

	    layout.setHTML(1, 0, I18n.getI18nConstants().body()+":");
	    TextArea text = new TextArea();
	    text.setCharacterWidth(70);
	    text.setVisibleLines(10);
	    layout.setWidget(1, 1,text);
	    
	    /* Add an error message to the form */		
	    layout.setHTML(0, 2, "");
	    layout.setHTML(1, 2, "");
	    

	    /* Add a panel button to the form */
	    HorizontalPanel panelButton = new HorizontalPanel();
	    panelButton.setWidth("33%");
	    panelButton.setHorizontalAlignment( HasHorizontalAlignment.ALIGN_CENTER);
	    /* Add a button 'Reset' to the form */
	    reset = new Button(I18n.getI18nConstants().reset());
	    reset.addClickHandler(controler.getResetClickHandler());
	    /* Add a button 'Send' to the form */
	    send = new Button(I18n.getI18nConstants().send());
	    send.addClickHandler(controler.getSendClickHandler());;
	    panelButton.add(reset);
	    panelButton.add(send);
	    layout.setWidget(2, 1, panelButton);
	    cellFormatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT);


	    /* style */
	    cellFormatter.setStyleName(0, 0, "calibriFont");
	    cellFormatter.setStyleName(1, 0, "calibriFont");
	    cellFormatter.setStyleName(1, 1, "calibriSmallFont");
	    cellFormatter.setStyleName(0, 1, "calibriSmallFont");
	    cellFormatter.setStyleName(2, 1, "calibriSmallFont");
	    cellFormatter.setStyleName(0, 2, "errorFont");
	    cellFormatter.setStyleName(1, 2, "errorFont");
	    send.setStyleName("singleButton");
	    reset.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    panel.add(emptyPanel);
	    panel.add(decPanel);
		/**********************************************************************************/

	    /***************** Controler ******************************************************/
	    text.addClickHandler(controler.getTextAreaClickHandler(text));
	    controler.setText(text);
	    title.addClickHandler(controler.getTextAreaClickHandler(title));
	    controler.setTitle(title);
	    
	    controler.getModel().onInitialize("","");
		/**********************************************************************************/		
		
		return panel;
		
	}

}
