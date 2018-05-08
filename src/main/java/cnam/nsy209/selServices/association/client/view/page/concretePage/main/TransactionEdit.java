package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.TransactionEditControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class TransactionEdit extends AbstractPage implements Observer {
	
	/* Singleton */
	private static TransactionEdit instance;
	public static TransactionEdit get() {
		if(instance == null)
			instance = new TransactionEdit((int)(0.78*WIDTH), (int)(0.25*HEIGHT));			
		
		return instance;
	}
	
	/* attributes */
	private FlexTable layout;
//	private WaitingTransfer waiting;
	private Button validate;
	private TransactionEditControler controler;

	/* Constructor */
	private TransactionEdit(int width, int height) {
		super(width, height);
		controler.getModel().onWaitingDisplay("");
	}

	@Override
	public void update(Observable observable, Object object) {				
		TransactionEditModel transactionEditModel = (TransactionEditModel) observable;
		/* update view */
		if(transactionEditModel.getSuppliesDemandsForList() != null && 
				!transactionEditModel.getSuppliesDemandsForList().isEmpty() && 
				transactionEditModel.getMembersForList() != null && 
				!transactionEditModel.getMembersForList().isEmpty() &&
				transactionEditModel.getAmount().equals("")) {
			transactionEditModel.setWaiting(false);
			DialogBoxWaiting.get(0, 0).hide();
		}
		if(transactionEditModel.getMembersForList() != null && 
				!transactionEditModel.getMembersForList().isEmpty()) {
			controler.getCreditor().clear();
			controler.getDebtor().clear();
			for(MemberLocalDto member:transactionEditModel.getMembersForList()) {
				controler.getCreditor().addItem(member.getFullName());
				controler.getDebtor().addItem(member.getFullName());
			}
			controler.getCreditor().setItemSelected(transactionEditModel.getCreditorIndex(), true);
			controler.getDebtor().setItemSelected(transactionEditModel.getDebtorIndex(), true);
		}
		if(transactionEditModel.getSuppliesDemandsForList() != null && 
				!transactionEditModel.getSuppliesDemandsForList().isEmpty()) {
			controler.getSupplyDemandBox().clear();
			for(SupplyDemandLocalDto supplyDemand:transactionEditModel.getSuppliesDemandsForList()) {
				controler.getSupplyDemandBox().addItem(supplyDemand.getTitle()+"_"+supplyDemand.getId());
			}
			controler.getSupplyDemandBox().setItemSelected(transactionEditModel.getSupplyDemandIndex(), true);
		}
		controler.getAmount().setText(transactionEditModel.getAmount());
		/* input error */
		if(transactionEditModel.getTransactionAmountError() != null)
			layout.setHTML(3, 3,transactionEditModel.getTransactionAmountError().getErrorMessage());
		else {
			layout.setHTML(3, 3, "");
		}
		/* validate button and waiting message */
		if(transactionEditModel.isWaiting()) {
//			DialogBoxWaiting.get(0, 0).show();
			validate.setEnabled(false);
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			validate.setEnabled(true);
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
		controler = new TransactionEditControler();
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
	    cellFormatter.setColSpan(0, 0, 4);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    layout.setHTML(1, 0, I18n.getI18nConstants().creditor());
	    ListBox creditor = new ListBox();
//	    this.controler.getModel().setMembersForList();
//	    for(MemberDto member:this.controler.getModel().getMembersForList()) {
//	    	creditor.addItem(member.getFullName());
//	    }
	    layout.setWidget(2, 0,creditor);

	    layout.setHTML(1, 1, I18n.getI18nConstants().debtor());
	    ListBox debtor = new ListBox();
//	    this.controler.getModel().setMembersForList();
//	    for(MemberDto member:this.controler.getModel().getMembersForList()) {
//	    	debtor.addItem(member.getFullName());
//	    }
	    layout.setWidget(2, 1,debtor);
	    
	    layout.setHTML(1, 2, I18n.getI18nConstants().supplyDemand());
	    ListBox supplyDemandBox = new ListBox();
	    this.controler.getModel().setSuppliesDemandsForList();
//	    for(SupplyDemandDto supplyDemand:this.controler.getModel().getSuppliesDemandsForList()) {
//	    	supplyDemandBox.addItem(supplyDemand.getTitle());
//	    }
	    layout.setWidget(2, 2,supplyDemandBox);
	    	    
	    layout.setHTML(1, 3, I18n.getI18nConstants().amount());
	    TextBox amount = new TextBox();
	    amount.addClickHandler(controler.getAmountClickHandler());	    
	    controler.setAmount(amount);
	    layout.setWidget(2, 3,amount);
	    
	    layout.setHTML(3, 0, "");
	    layout.setHTML(3, 1, "");
	    layout.setHTML(3, 2, "");
	    layout.setHTML(3, 3, "");
	    
	    /* Add a button 'Validate' to the form */
	    validate = new Button(I18n.getI18nConstants().validate());
	    validate.addClickHandler(controler.getValidateClickHandler());
	    layout.setWidget(4, 0, validate);
	    cellFormatter.setColSpan(4, 0, 4);
	    cellFormatter.setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* Add a waiting message to the form */
//		waiting = new WaitingTransfer();
//	    layout.setWidget(5, 0, waiting);
//	    cellFormatter.setColSpan(5, 0, 4);
//	    cellFormatter.setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    
	    /* style */
	    cellFormatter.setStyleName(0, 0, "titleFont");
	    cellFormatter.setStyleName(1, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 2, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 3, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 0, "calibriSmallFontFlexTable");
	    cellFormatter.setStyleName(2, 1, "calibriSmallFontFlexTable");
	    cellFormatter.setStyleName(2, 2, "calibriSmallFontFlexTable");
	    cellFormatter.setStyleName(2, 3, "calibriSmallFontFlexTable");
	    cellFormatter.setStyleName(3, 0, "errorFont");
	    cellFormatter.setStyleName(3, 1, "errorFont");
	    cellFormatter.setStyleName(3, 2, "errorFont");
	    cellFormatter.setStyleName(3, 3, "errorFont");
	    validate.setStyleName("singleButton");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/

	    /***************** Controler ******************************************************/
	    controler.setCreditor(creditor);
	    controler.setDebtor(debtor);
	    controler.setSupplyDemandBox(supplyDemandBox);
	    amount.addClickHandler(controler.getAmountClickHandler());
	    controler.setAmount(amount);
		/**********************************************************************************/
	    
	    controler.getModel().onInitialize("");

	    return panel;
	}

}
