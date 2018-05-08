package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MemberEditControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MemberEditModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberEdit extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MemberEdit instance;
	public static MemberEdit get(LocalDto member, boolean update) {
		if(member instanceof MemberLocalDto)
			instance = new MemberEdit((int)(0.78*WIDTH), (int)(0.65*HEIGHT),member, update);			
		
		return instance;
	}
	
	/* attributes */
	private FlexTable layout;
//	private WaitingTransfer waiting;
	private Button validate;
	private MemberEditControler controler;

	/*Constructor */
	private MemberEdit(int width, int height, LocalDto dto, boolean update) {
		super(width, height, dto);
		long id = ((MemberLocalDto) dto).getId() != null ? ((MemberLocalDto) dto).getId():-1;
		validate.addClickHandler(controler.getValidateClickHandler(update,id));
	}

	@Override
	public void update(Observable observable, Object object) {
		MemberEditModel memberEditModel = (MemberEditModel) observable;
		
		/* update view */
		controler.getName().setText(memberEditModel.getProvisionalMember().getName());
		controler.getForname().setText(memberEditModel.getProvisionalMember().getForname());
		controler.getAddress().setText(memberEditModel.getProvisionalMember().getAddress());
		controler.getPostalCode().setText(memberEditModel.getProvisionalMember().getPostalCode());
		controler.getTown().setText(memberEditModel.getProvisionalMember().getTown());
		controler.getEmail().setText(memberEditModel.getProvisionalMember().getEmail());
		controler.getCellNumber().setText(memberEditModel.getProvisionalMember().getCellNumber());
		controler.getPhoneNumber().setText(memberEditModel.getProvisionalMember().getPhoneNumber());
		controler.getPassword().setText(memberEditModel.getProvisionalMember().getMobileId());
		controler.getInitialAccount().setText(
				memberEditModel.getProvisionalMember().getWealthSheet().getInitialAccount());
		
		/* input error */
		if(memberEditModel.getMemberNameError() != null)
			layout.setHTML(1, 2,memberEditModel.getMemberNameError().getErrorMessage());
		else {
			layout.setHTML(1, 2, "");
		}
		if(memberEditModel.getMemberFornameError() != null)
			layout.setHTML(2, 2,memberEditModel.getMemberFornameError().getErrorMessage());
		else {
			layout.setHTML(2, 2, "");
		}
		if(memberEditModel.getMemberAddressError() != null)
			layout.setHTML(3, 2,memberEditModel.getMemberAddressError().getErrorMessage());
		else {
			layout.setHTML(3, 2, "");
		}
		if(memberEditModel.getMemberPostalCodeError() != null)
			layout.setHTML(4, 2,memberEditModel.getMemberPostalCodeError().getErrorMessage());
		else {
			layout.setHTML(4, 2, "");
		}
		if(memberEditModel.getMemberTownError() != null)
			layout.setHTML(5, 2,memberEditModel.getMemberTownError().getErrorMessage());
		else {
			layout.setHTML(5, 2, "");
		}
		if(memberEditModel.getMemberEmailError() != null)
			layout.setHTML(6, 2,memberEditModel.getMemberEmailError().getErrorMessage());
		else {
			layout.setHTML(6, 2, "");
		}
		if(memberEditModel.getMemberCellNumberError() != null)
			layout.setHTML(7, 2,memberEditModel.getMemberCellNumberError().getErrorMessage());
		else {
			layout.setHTML(7, 2, "");
		}
		if(memberEditModel.getMemberPhoneNumberError() != null)
			layout.setHTML(8, 2,memberEditModel.getMemberPhoneNumberError().getErrorMessage());
		else {
			layout.setHTML(8, 2, "");
		}
		if(memberEditModel.getMemberPasswordError() != null)
			layout.setHTML(9, 2, memberEditModel.getMemberPasswordError().getErrorMessage());
		else {
			layout.setHTML(9, 2, "");
		}
		if(memberEditModel.getMemberAccountError() != null)
			layout.setHTML(10, 2, memberEditModel.getMemberAccountError().getErrorMessage());
		else {
			layout.setHTML(10, 2, "");
		}
		/* validate button and waiting message */
		if(memberEditModel.isWaiting()) {
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
		controler = new MemberEditControler();
		controler.getModel().addObserver(this);
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
	    /*********** Create a table to layout the form options ****************************/
		MemberLocalDto member = (MemberLocalDto) dto;
		if (member == null) {
			member = new MemberLocalDto();
		}
		
	    layout = new FlexTable();
	    layout.setCellSpacing(5);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    
	    /* Add a title to the form */
	    layout.setHTML(0, 0, I18n.getI18nConstants().edit());
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    layout.setHTML(1, 0, I18n.getI18nConstants().name()+":");
	    TextBox name = new TextBox();
	    name.setText(member.getName() != null ? member.getName():"");
	    layout.setWidget(1, 1,name);
	    layout.setHTML(1, 2, "");
	    
	    layout.setHTML(2, 0, I18n.getI18nConstants().forname()+":");
	    TextBox forname = new TextBox();
	    forname.setText(member.getForname() != null ? member.getForname():"");
	    layout.setWidget(2, 1,forname);
	    layout.setHTML(2, 2, "");
	    
	    layout.setHTML(3, 0, I18n.getI18nConstants().address()+":");
	    TextBox address = new TextBox();
	    address.setText(member.getAddress() != null ? member.getAddress():"");
	    layout.setWidget(3, 1,address);
	    layout.setHTML(3, 2, "");
	    
	    layout.setHTML(4, 0, I18n.getI18nConstants().postalCode()+":");
	    TextBox postalCode = new TextBox();
	    postalCode.setText(member.getPostalCode() != null ? member.getPostalCode():"");
	    layout.setWidget(4, 1,postalCode);
	    layout.setHTML(4, 2, "");
	    	    
	    layout.setHTML(5, 0, I18n.getI18nConstants().town()+":");
	    TextBox town = new TextBox();
	    town.setText(member.getTown() != null ? member.getTown():"");
	    layout.setWidget(5, 1,town);
	    layout.setHTML(5, 2, "");
	    
	    layout.setHTML(6, 0, I18n.getI18nConstants().email()+":");
	    TextBox email = new TextBox();
	    email.setText(member.getEmail() != null ? member.getEmail():"");
	    layout.setWidget(6, 1,email);
	    layout.setHTML(6, 2, "");
	    
	    layout.setHTML(7, 0, I18n.getI18nConstants().cellNumber()+":");
	    TextBox cellNumber = new TextBox();
	    cellNumber.setText(member.getCellNumber() != null ? member.getCellNumber():"");
	    layout.setWidget(7, 1,cellNumber);
	    layout.setHTML(7, 2, "");
	    
	    layout.setHTML(8, 0, I18n.getI18nConstants().phoneNumber()+":");
	    TextBox phoneNumber = new TextBox();
	    phoneNumber.setText(member.getPhoneNumber() != null ? member.getPhoneNumber():"");
	    layout.setWidget(8, 1,phoneNumber);
	    layout.setHTML(8, 2, "");
	    
	    layout.setHTML(9, 0, I18n.getI18nConstants().password()+":");
	    TextBox password = new TextBox();
	    password.setText(member.getPassword() != null ? member.getMobileId():"");
	    layout.setWidget(9, 1,password);	
	    layout.setHTML(9, 2, "");
	    layout.setHTML(10, 0, I18n.getI18nConstants().account()+":");
	    TextBox account = new TextBox();
	    if(member.getWealthSheet() == null) {
	    	account.setText("");
	    } else {
	    	account.setText(member.getWealthSheet().getInitialAccount());
	    }
	    layout.setWidget(10, 1,account);	
	    layout.setHTML(10, 2, "");
	    
	    /* Add a button 'Validate' to the form */
	    validate = new Button(I18n.getI18nConstants().validate());
	    //validate.addClickHandler(controler.getValidateClickHandler(false));
	    layout.setWidget(11, 0, validate);
	    cellFormatter.setColSpan(11, 0, 2);
	    cellFormatter.setHorizontalAlignment(11, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* Add a waiting message to the form */
//		waiting = new WaitingTransfer();
//	    layout.setWidget(11, 0, waiting);
//	    cellFormatter.setColSpan(11, 0, 2);
//	    cellFormatter.setHorizontalAlignment(11, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
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
	    cellFormatter.setStyleName(10, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(10, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(10, 2, "errorFont");
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
	    forname.addClickHandler(controler.getTextBoxClickHandler(forname));
	    controler.setForname(forname);
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
	    password.addClickHandler(controler.getTextBoxClickHandler(password));
	    controler.setPassword(password);
	    account.addClickHandler(controler.getTextBoxClickHandler(account));
	    controler.setInitialAccount(account);
	    
	    //controler.getModel().onInitialize((MemberDto) dto);
		/**********************************************************************************/

	    controler.getModel().onInitialize(member);
	    
	    return panel;
	}
	
//	/* for the test */
//	public static MemberLocalDto getMemberDto() {
//		MemberLocalDto member = new MemberLocalDto();
//		member.setAddress("adresseeee");
//		member.setName("nameee");
//		member.setForname("fornameeee");
//		//member.setPostalCode("31330");
//		member.setTown("Grenade");
//		member.setCellNumber("0620304050");
//		member.setPhoneNumber("0520304050");
//		member.setEmail("sel@save.com");
//		member.setPassword("PP7sw0rdd");
//		member.getWealthSheet().setInitialAccount("100.00");
//		
//		return member;
//	}

}
