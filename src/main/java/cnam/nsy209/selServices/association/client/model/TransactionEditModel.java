package cnam.nsy209.selServices.association.client.model;

import java.util.List;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.SupplyDemandAsyncCallback;
import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

@SuppressWarnings("serial")
public class TransactionEditModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static TransactionEditModel instance;
	public static TransactionEditModel get() {
		if(instance == null)
			instance = new TransactionEditModel();
		
		return instance;
	}
	
	/* Constructor */
	private TransactionEditModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private String amount;
	private int creditorIndex;
	private int debtorIndex;
	private int supplyDemandIndex;
	private EnumCheck transactionAmountError;		
	private boolean waiting;
	private List<MemberLocalDto> membersForList;
	private List<SupplyDemandLocalDto> suppliesDemandsForList;
	
	/* initialize page values */
	public void onInitialize(String amount) {
		if(amount == null) this.amount ="";
		else this.amount=amount;
		creditorIndex = 0;
		debtorIndex = 0;
		supplyDemandIndex = 0;
		transactionAmountError = null;			
		waiting = false;

		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(String amount,int creditorIndex, int debtorIndex, int supplyDemandIndex) {
		if(amount != null) this.amount = amount;
		this.creditorIndex = creditorIndex;
		this.debtorIndex = debtorIndex;
		this.supplyDemandIndex = supplyDemandIndex;
		
		if(FieldValidators.get().getValidators(EnumField.AMOUNT).validate(amount) != null) {
			transactionAmountError = FieldValidators.get().getValidators(EnumField.AMOUNT).validate(amount);
		} else {
			transactionAmountError = null;
		}
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(String amount) {
		if(amount == null) this.amount = "";
		else this.amount=amount;
		transactionAmountError = null;		
		waiting = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return transactionAmountError == null;
	}
	
	/* getters and setters */

	public EnumCheck getTransactionAmountError() {
		return transactionAmountError;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public String getAmount() {
		return amount;
	}

	public int getCreditorIndex() {
		return creditorIndex;
	}

	public int getDebtorIndex() {
		return debtorIndex;
	}

	public int getSupplyDemandIndex() {
		return supplyDemandIndex;
	}

	public void setTransactionAmountError(EnumCheck transactionAmountError) {
		this.transactionAmountError = transactionAmountError;
		notifyObservers();
	}

	public List<MemberLocalDto> getMembersForList() {
		return membersForList;
	}

	public void setMembersForList() {
		MemberAsyncCallback memberCallback = new MemberAsyncCallback();
		memberCallback.getMembersForListBox();
	}

	public void setMembersForList(List<MemberLocalDto> members) {
		this.membersForList = members;
		
		notifyObservers();
	}

	public List<SupplyDemandLocalDto> getSuppliesDemandsForList() {
		return suppliesDemandsForList;
	}

	public void setSuppliesDemandsForList() {
		SupplyDemandAsyncCallback supplyDemandCallback = new SupplyDemandAsyncCallback();
		supplyDemandCallback.getSuppliesDemandsForListBox();
	}

	public void setSuppliesDemandsForList(List<SupplyDemandLocalDto> suppliesDemands) {
		this.suppliesDemandsForList = suppliesDemands;
		
		notifyObservers();
	}
	
}
