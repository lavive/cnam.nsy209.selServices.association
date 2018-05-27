package cnam.nsy209.selServices.association.client.asyncCallback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.TransactionEditControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.TransactionEditPage;
import cnam.nsy209.selServices.association.client.view.page.WealthSheetDisplayPage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.WealthSheetDisplay;
import cnam.nsy209.selServices.association.shared.exception.TransactionNotWellFormedException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

/** 
 * 
 * Class to manage result from Transaction service call
 * 
 * @author lavive
 *
 */
public class TransactionAsyncCallback {
	/* attributes */
	private AsyncCallback<Void> addCallback;
	private AsyncCallback<WealthSheetLocalDto> getCallback;
	private AsyncCallback<TransactionLocalDto> buildCallback;
	private int width;
	private int height;
	private TransactionEditControler TransactionEditControler;
	
	/* Constructors */
	public TransactionAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public TransactionAsyncCallback() {}
	
	/* methods */
	public void addTransaction(TransactionLocalDto transaction) {
			
		addCallback = new AsyncCallback<Void>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(TransactionEditControler != null) 
					TransactionEditControler.getModel().onInitialize(transaction.getAmount().toString());
				if(caught instanceof TransactionNotWellFormedException) {
					DialogBoxMessage message = 
							new DialogBoxMessage(((TransactionNotWellFormedException) caught).getOriginError());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(Void result) {
				if(TransactionEditControler != null) 
					TransactionEditControler.getModel().onInitialize(transaction.getAmount().toString());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().addTransactionConfirm());
				message.center();
				message.show();

				TransactionEditPage page = new TransactionEditPage(width,height);
				TransactionEditModel.get().onInitialize("");
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getTransactionsService().add(transaction, addCallback);
	}
	
	public void getTransactions(MemberLocalDto member, boolean back) {
			
		getCallback = new AsyncCallback<WealthSheetLocalDto>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(WealthSheetLocalDto result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				WealthSheetDisplayPage page = new WealthSheetDisplayPage(width,height,member);
				WealthSheetDisplay.get(member).getWealthSheetTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getTransactionsService().getTransactions(member, getCallback);
	}
	
	public void buildTransaction(TransactionLocalDto temporaryTransaction, TransactionLocalDto transaction) {
			
		buildCallback = new AsyncCallback<TransactionLocalDto>() {
	
			@Override
			public void onFailure(Throwable caught) {
				transaction.copy(new TransactionLocalDto());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}
	
			@Override
			public void onSuccess(TransactionLocalDto result) {
				transaction.copy(transaction);
//				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().addTransactionConfirm());
//				message.center();
//				message.show();
			}
			
		};
		
		ServicesProxy.getTransactionsService().buildTransaction(temporaryTransaction, buildCallback);
	}
	
	/* getter and setter */
	public void setTransactionEditControler(TransactionEditControler transactionEditControler) {
		TransactionEditControler = transactionEditControler;
	}


}
