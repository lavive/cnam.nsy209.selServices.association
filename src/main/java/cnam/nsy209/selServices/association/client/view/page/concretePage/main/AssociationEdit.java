package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.AssociationEditControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.AssociationEditModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class AssociationEdit extends AbstractPage implements Observer {
	
	/* Singleton */
	private static AssociationEdit instance;
	public static AssociationEdit get(LocalDto association) {
		if(association instanceof AssociationLocalDto)
			instance = new AssociationEdit((int)(0.78*WIDTH), (int)(0.65*HEIGHT),association);			
		
		return instance;
	}
	
	/* attributes */
	private FlexTable layout;
//	private WaitingTransfer waiting;
	private Button validate;
	private AssociationEditControler controler;

	/* Constructor */
	private AssociationEdit(int width, int height, LocalDto dto) {
		super(width, height, dto);
	}

	@Override
	public void update(Observable observable, Object object) {
		AssociationEditModel associationEditModel = (AssociationEditModel) observable;
		
		/* update view */
		controler.getName().setText(associationEditModel.getProvisionalAssociation().getName());
		controler.getAddress().setText(associationEditModel.getProvisionalAssociation().getAddress());
		controler.getPostalCode().setText(associationEditModel.getProvisionalAssociation().getPostalCode());
		controler.getTown().setText(associationEditModel.getProvisionalAssociation().getTown());
		controler.getEmail().setText(associationEditModel.getProvisionalAssociation().getEmail());
		controler.getCellNumber().setText(associationEditModel.getProvisionalAssociation().getCellNumber());
		controler.getPhoneNumber().setText(associationEditModel.getProvisionalAssociation().getPhoneNumber());
		controler.getWebSite().setText(associationEditModel.getProvisionalAssociation().getWebsite());
		controler.getPassword().setText(associationEditModel.getProvisionalAssociation().getPassword());
		
		/* input error */
		if(associationEditModel.getAssociationNameError() != null)
			layout.setHTML(1, 2,associationEditModel.getAssociationNameError().getErrorMessage());
		else {
			layout.setHTML(1, 2, "");
		}
		if(associationEditModel.getAssociationAddressError() != null)
			layout.setHTML(2, 2,associationEditModel.getAssociationAddressError().getErrorMessage());
		else {
			layout.setHTML(2, 2, "");
		}
		if(associationEditModel.getAssociationPostalCodeError() != null)
			layout.setHTML(3, 2,associationEditModel.getAssociationPostalCodeError().getErrorMessage());
		else {
			layout.setHTML(3, 2, "");
		}
		if(associationEditModel.getAssociationTownError() != null)
			layout.setHTML(4, 2,associationEditModel.getAssociationTownError().getErrorMessage());
		else {
			layout.setHTML(4, 2, "");
		}
		if(associationEditModel.getAssociationEmailError() != null)
			layout.setHTML(5, 2,associationEditModel.getAssociationEmailError().getErrorMessage());
		else {
			layout.setHTML(5, 2, "");
		}
		if(associationEditModel.getAssociationCellNumberError() != null)
			layout.setHTML(6, 2,associationEditModel.getAssociationCellNumberError().getErrorMessage());
		else {
			layout.setHTML(6, 2, "");
		}
		if(associationEditModel.getAssociationPhoneNumberError() != null)
			layout.setHTML(7, 2,associationEditModel.getAssociationPhoneNumberError().getErrorMessage());
		else {
			layout.setHTML(7, 2, "");
		}
		if(associationEditModel.getAssociationWebSiteError() != null)
			layout.setHTML(8, 2,associationEditModel.getAssociationWebSiteError().getErrorMessage());
		else {
			layout.setHTML(8, 2, "");
		}
		if(associationEditModel.getAssociationPasswordError() != null)
			layout.setHTML(9, 2, associationEditModel.getAssociationPasswordError().getErrorMessage());
		else {
			layout.setHTML(9, 2, "");
		}
		/* validate button and waiting message */
		if(associationEditModel.isWaiting()) {
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
		displayStrategy.addPanel(buildPanel(width,height,dto));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height,LocalDto dto) {
		controler = new AssociationEditControler();
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
	    layout.setCellSpacing(5);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

	    /* Add a title to the form */
	    layout.setHTML(0, 0, I18n.getI18nConstants().edit());
	    cellFormatter.setColSpan(0, 0, 3);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    layout.setHTML(1, 0, I18n.getI18nConstants().name()+":");
	    TextBox name = new TextBox();
	    name.setText(((AssociationLocalDto) dto).getName());
	    layout.setWidget(1, 1,name);
	    layout.setHTML(1, 2, "");
	    
	    layout.setHTML(2, 0, I18n.getI18nConstants().address()+":");
	    TextBox address = new TextBox();
	    address.setText(((AssociationLocalDto) dto).getAddress());
	    layout.setWidget(2, 1,address);
	    layout.setHTML(2, 2, "");
	    
	    layout.setHTML(3, 0, I18n.getI18nConstants().postalCode()+":");
	    TextBox postalCode = new TextBox();
	    postalCode.setText(((AssociationLocalDto) dto).getPostalCode());
	    layout.setWidget(3, 1,postalCode);
	    layout.setHTML(3, 2, "");
	    	    
	    layout.setHTML(4, 0, I18n.getI18nConstants().town()+":");
	    TextBox town = new TextBox();
	    town.setText(((AssociationLocalDto) dto).getTown());
	    layout.setWidget(4, 1,town);
	    layout.setHTML(4, 2, "");
	    
	    layout.setHTML(5, 0, I18n.getI18nConstants().email()+":");
	    TextBox email = new TextBox();
	    email.setText(((AssociationLocalDto) dto).getEmail());
	    layout.setWidget(5, 1,email);
	    layout.setHTML(5, 2, "");
	    
	    layout.setHTML(6, 0, I18n.getI18nConstants().cellNumber()+":");
	    TextBox cellNumber = new TextBox();
	    cellNumber.setText(((AssociationLocalDto) dto).getCellNumber());
	    layout.setWidget(6, 1,cellNumber);
	    layout.setHTML(6, 2, "");
	    
	    layout.setHTML(7, 0, I18n.getI18nConstants().phoneNumber()+":");
	    TextBox phoneNumber = new TextBox();
	    phoneNumber.setText(((AssociationLocalDto) dto).getPhoneNumber());
	    layout.setWidget(7, 1,phoneNumber);
	    layout.setHTML(7, 2, "");
	    
	    layout.setHTML(8, 0, I18n.getI18nConstants().webSite()+":");
	    TextBox webSite = new TextBox();
	    webSite.setText(((AssociationLocalDto) dto).getWebsite());
	    layout.setWidget(8, 1,webSite);	
	    layout.setHTML(8, 2, "");
	    
	    layout.setHTML(9, 0, I18n.getI18nConstants().password()+":");
	    TextBox password = new TextBox();
	    password.setText(((AssociationLocalDto) dto).getPassword());
	    layout.setWidget(9, 1,password);	
	    layout.setHTML(9, 2, "");
	    
	    /* Add a button 'Validate' to the form */
	    validate = new Button(I18n.getI18nConstants().validate());
	    validate.addClickHandler(controler.getValidateClickHandler());
	    layout.setWidget(10, 0, validate);
	    cellFormatter.setColSpan(10, 0, 2);
	    cellFormatter.setHorizontalAlignment(10, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* Add a waiting message to the form */
//		waiting = new WaitingTransfer();
//	    layout.setWidget(11, 0, waiting);
	    cellFormatter.setColSpan(11, 0, 2);
	    cellFormatter.setHorizontalAlignment(11, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    
	    /* style */
	    cellFormatter.setStyleName(0, 0, "titleFontFlexTable");
	    cellFormatter.setStyleName(1, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 2, "errorFont");
	    cellFormatter.setStyleName(2, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 2, "errorFont");
	    cellFormatter.setStyleName(3, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 2, "errorFont");
	    cellFormatter.setStyleName(4, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 2, "errorFont");
	    cellFormatter.setStyleName(5, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 2, "errorFont");
	    cellFormatter.setStyleName(6, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 2, "errorFont");
	    cellFormatter.setStyleName(7, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(7, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(7, 2, "errorFont");
	    cellFormatter.setStyleName(8, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(8, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(8, 2, "errorFont");
	    cellFormatter.setStyleName(9, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(9, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(9, 2, "errorFont");
	    validate.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidth(width*0.5+"px");
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/

	    /***************** Controler ******************************************************/
	    name.addClickHandler(controler.getTextBoxClickHandler(name));
	    controler.setName(name);
	    address.addClickHandler(controler.getTextBoxClickHandler(address));
	    controler.setAddress(address);
	    postalCode.addClickHandler(controler.getTextBoxClickHandler(postalCode));
	    controler.setPostalCode(postalCode);
	    town.addClickHandler(controler.getTextBoxClickHandler(town));
	    controler.setTown(town);
	    email.addClickHandler(controler.getTextBoxClickHandler(email));
	    controler.setEmail(email);
	    cellNumber.addClickHandler(controler.getTextBoxClickHandler(cellNumber));
	    controler.setCellNumber(cellNumber);
	    phoneNumber.addClickHandler(controler.getTextBoxClickHandler(phoneNumber));
	    controler.setPhoneNumber(phoneNumber);
	    webSite.addClickHandler(controler.getTextBoxClickHandler(webSite));
	    controler.setWebSite(webSite);
	    password.addClickHandler(controler.getTextBoxClickHandler(password));
	    controler.setPassword(password);
	    
	    controler.getModel().onInitialize((AssociationLocalDto) dto);
		/**********************************************************************************/

	    return panel;
	}


}
