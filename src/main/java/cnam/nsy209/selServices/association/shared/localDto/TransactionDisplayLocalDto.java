package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;

public class TransactionDisplayLocalDto implements Serializable{

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private MemberLocalDto debtorMember;

	private MemberLocalDto creditorMember;

	private SupplyDemandLocalDto supplyDemand;

	private String amount;

	public TransactionDisplayLocalDto(){}

	/* getter and setter */

	public MemberLocalDto getDebtorMember() {
		return debtorMember;
	}

	public void setDebtorMember(MemberLocalDto debtorMember) {
		this.debtorMember = debtorMember;
	}

	public MemberLocalDto getCreditorMember() {
		return creditorMember;
	}

	public void setCreditorMember(MemberLocalDto creditorMember) {
		this.creditorMember = creditorMember;
	}

	public SupplyDemandLocalDto getSupplyDemand() {
		return supplyDemand;
	}

	public void setSupplyDemand(SupplyDemandLocalDto supplyDemand) {
		this.supplyDemand = supplyDemand;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}	

	@Override
	public String toString() {
		return "amount: "+getAmount()+"\n"+
	           "creditor: "+getCreditorMember()+"\n"+ 
	           "debtor: "+getDebtorMember()+"\n"+ 
	           "supplyDemand: "+getSupplyDemand() ;
	}


}

