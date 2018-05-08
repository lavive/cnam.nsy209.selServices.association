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
//	private WaitingTransfer waiting;
	private FastMessageControler controler;
//	private TextArea edit;
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
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			this.send.setEnabled(true);
			this.reset.setEnabled(true);
//			if(this.waiting.isRunning())
//				this.waiting.stop();	
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
//		panel.getElement().getStyle().setBackgroundColor(I18n.getI18nConstants().backgroundColor());
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		VerticalPanel emptyPanel = new VerticalPanel();
		emptyPanel.setWidth(0.15*width+"px");
		/**********************************************************************************/
		
//		/*********** Label Title **********************************************************/
//		Label titleLabel = new Label();
//		/* Style */
//		titleLabel.addStyleName("calibriFont");
//		titleLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		/* text */
//		titleLabel.setText(title);
//		/**********************************************************************************/
//		
//		/*********** Text Area ************************************************************/
//		TextArea message = new TextArea();
//		message.setCharacterWidth(50);
//		message.setVisibleLines(4);
//		/**********************************************************************************/
//		
//		/*********** Send Button **********************************************************/
//		Button send = new Button();
//		/* Style */
//		send.setStyleName("singleButton");
//		/* Text */
//		send.setText(I18n.getI18nConstants().send());
//		/**********************************************************************************/
//		
//		/********** Fill Main Panel *******************************************************/
//		panel.add(titleLabel);
//		panel.add(message);
//		panel.add(send);
//		/**********************************************************************************/
		
		
		
		
		
		
		
		
		
		

		
	    /*********** Create a table to layout the form options ****************************/
	    layout = new FlexTable();
	    layout.setCellSpacing(5);
	    //layout.setBorderWidth(2);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    
//	    /* Add a title to the form */
//	    layout.setHTML(0, 0, I18n.getI18nMessages().fastMessage()+":");
//	    cellFormatter.setColSpan(0, 0, 2);
//	    cellFormatter.setRowSpan(0, 0, 3);
//	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    
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
	    //cellFormatter.setColSpan(4, 0, 3);
	    //cellFormatter.setHorizontalAlignment(0, 3, HasHorizontalAlignment.ALIGN_LEFT);
	    layout.setHTML(1, 2, "");
	    //cellFormatter.setColSpan(4, 0, 3);
	    //cellFormatter.setHorizontalAlignment(1, 2, HasHorizontalAlignment.ALIGN_LEFT);
	    

	    /* Add a panel button to the form */
	    HorizontalPanel panelButton = new HorizontalPanel();
	    panelButton.setWidth("33%");
	    panelButton.setHorizontalAlignment( HasHorizontalAlignment.ALIGN_CENTER);
	    /* Add a button 'Reset' to the form */
	    reset = new Button(I18n.getI18nConstants().reset());
	    reset.addClickHandler(controler.getResetClickHandler());
	    //layout.setWidget(1, 3, reset);
	    //cellFormatter.setColSpan(2, 0, 2);
	    //layout.setWidget(2, 1, reset);
	   //cellFormatter.setRowSpan(1, 0, 2);
	    //cellFormatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_CENTER);
	    /* Add a button 'Send' to the form */
	    send = new Button(I18n.getI18nConstants().send());
	    send.addClickHandler(controler.getSendClickHandler());
	    //layout.setWidget(2, 2, send);
	    //cellFormatter.setColSpan(2, 0, 2);
	    //cellFormatter.setRowSpan(1, 2, 2);
	    //cellFormatter.setHorizontalAlignment(2, 2, HasHorizontalAlignment.ALIGN_CENTER);
	    panelButton.add(reset);
	    panelButton.add(send);
	    layout.setWidget(2, 1, panelButton);
	    cellFormatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT);

	    
	    /* Add a waiting message to the form */
//		waiting = new WaitingTransfer();
//	    layout.setWidget(3, 0, waiting);
//	    cellFormatter.setColSpan(3, 0, 3);
//	    cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);


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
