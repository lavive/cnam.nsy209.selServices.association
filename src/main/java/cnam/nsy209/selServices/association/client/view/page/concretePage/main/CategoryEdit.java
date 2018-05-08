package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.CategoryEditControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.CategoryEditModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class CategoryEdit extends AbstractPage implements Observer {
	
	/* Singleton */
	private static CategoryEdit instance;
	public static CategoryEdit get() {
		if(instance == null)
			instance = new CategoryEdit((int)(0.78*WIDTH), (int)(0.65*HEIGHT));			
		
		return instance;
	}
	
	/* attributes */
	private FlexTable layout;
//	private WaitingTransfer waiting;
	private Button validate;
	private CategoryEditControler controler;

	/* Constructor */
	private CategoryEdit(int width, int height) {
		super(width, height);
		controler.getModel().onInitialize("");
	}

	@Override
	public void update(Observable observable, Object object) {
		CategoryEditModel categoryEditModel = (CategoryEditModel) observable;
		
		/* update view */
		controler.getEdit().setText(categoryEditModel.getCategory());
		/* input error */
		if(categoryEditModel.getCategoryError() != null)
			layout.setHTML(1, 2,categoryEditModel.getCategoryError().getErrorMessage());
		else {
			layout.setHTML(1, 2, "");
		}
		/* validate button and waiting message */
		if(categoryEditModel.isWaiting()) {
			validate.setEnabled(false);
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			this.validate.setEnabled(true);
//			if(this.waiting.isRunning())
//				this.waiting.stop();			
		}
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {	
		controler = new CategoryEditControler();
		controler.getModel().addObserver(this);
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
	    /*********** Create a table to layout the form options ****************************/
	    layout = new FlexTable();
	    layout.setCellSpacing(10);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

	    /* Add a title to the form */
	    layout.setHTML(0, 0, I18n.getI18nConstants().edit());
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    layout.setHTML(1, 0, I18n.getI18nConstants().category()+":");
	    TextBox edit = new TextBox();
	    edit.addClickHandler(controler.getTextBoxClickHandler());	    
	    controler.setEdit(edit);
	    layout.setWidget(1, 1,edit);
	    layout.setHTML(1, 2, "");
	    
	    /* Add a button 'Validate' to the form */
	    validate = new Button(I18n.getI18nConstants().validate());
	    validate.addClickHandler(controler.getValidateClickHandler());
	    layout.setWidget(2, 0, validate);
	    cellFormatter.setColSpan(2, 0, 2);
	    cellFormatter.setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* Add a waiting message to the form */
//		waiting = new WaitingTransfer();
//	    layout.setWidget(3, 0, waiting);
//	    cellFormatter.setColSpan(3, 0, 2);
//	    cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    
	    /* style */
	    cellFormatter.setStyleName(0, 0, "titleFontFlexTable");
	    cellFormatter.setStyleName(1, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 2, "errorFont");
	    validate.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidth(width*0.4+"px");
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/

	    return panel;
	}

}
