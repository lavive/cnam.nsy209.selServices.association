package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.asyncCallback.TransactionAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;

public class TransactionEditControler {
	
	/* Attributes */
	private TransactionEditModel model;
	private ListBox creditor;
	private ListBox debtor;
	private ListBox supplyDemandBox;
	private TextBox amount;
	
	/* Constructors */
	public TransactionEditControler() {
		this.model = TransactionEditModel.get();
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onDisplay(amount.getText(),
								creditor.getSelectedIndex(),
								debtor.getSelectedIndex(),
								supplyDemandBox.getSelectedIndex());
				if(model.noError()) {
					 DialogBoxConfirm<TransactionLocalDto> dialogBox = 
							 new DialogBoxConfirm<TransactionLocalDto>(buildTransaction(),
							 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
					 dialogBox.center();
					 dialogBox.show();
				}
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for amount */
	public ClickHandler getAmountClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				if(model.getTransactionAmountError() != null) model.setTransactionAmountError(null);
				
			}
		};
		
		return clickHandler;
	}
	
	/* getter */

	public TransactionEditModel getModel() {
		return model;
	}
	
	public ListBox getCreditor() {
		return creditor;
	}

	public void setCreditor(ListBox creditor) {
		this.creditor = creditor;
	}

	public ListBox getDebtor() {
		return debtor;
	}

	public void setDebtor(ListBox debtor) {
		this.debtor = debtor;
	}

	public ListBox getSupplyDemandBox() {
		return supplyDemandBox;
	}

	public void setSupplyDemandBox(ListBox supplyDemandBox) {
		this.supplyDemandBox = supplyDemandBox;
	}

	public TextBox getAmount() {
		return amount;
	}

	public void setAmount(TextBox amount) {
		this.amount = amount;
	}

	/* helper method */
	private TransactionLocalDto buildTransaction() {
		
		TransactionLocalDto temporaryTransaction = new TransactionLocalDto();
		temporaryTransaction.setCreditorMemberId(MemberLocalDto.getIdByFullName(this.creditor.getSelectedItemText()));
		temporaryTransaction.setDebtorMemberId(MemberLocalDto.getIdByFullName(this.debtor.getSelectedItemText()));
		temporaryTransaction.setSupplyDemandId(SupplyDemandLocalDto.getIdByFullName(this.supplyDemandBox.getSelectedItemText()));
		temporaryTransaction.setAmount(this.amount.getText());
		
		return temporaryTransaction;
	}
	private void sendData(TransactionLocalDto transaction) {
		this.model.onWaitingDisplay(transaction.getAmount().toString());
		Timer t = new Timer() {
			@Override
			public void run() {
				TransactionAsyncCallback transactionCallback = new TransactionAsyncCallback();
				transactionCallback.setTransactionEditControler(TransactionEditControler.this);
				transactionCallback.addTransaction(transaction);
			}
		};
		t.schedule(0);
	}
	private IActionToTransmit<TransactionLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<TransactionLocalDto>() {
			@Override
			public void action(TransactionLocalDto transaction) {
				sendData(transaction);	
				
			}
      };
	}
}

