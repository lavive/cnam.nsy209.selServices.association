package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WealthSheetLocalDto implements Serializable{

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String initialAccount;

	private String finalAccount;

	private List<TransactionLocalDto> transactions = new ArrayList<TransactionLocalDto>();

	private List<TransactionDisplayLocalDto> transactionsDisplay = new ArrayList<TransactionDisplayLocalDto>();


	/* getter and setter */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitialAccount() {
		return initialAccount;
	}

	public void setInitialAccount(String initialAccount) {
		this.initialAccount = initialAccount;
	}

	public String getFinalAccount() {
		return finalAccount;
	}

	public void setFinalAccount(String finalAccount) {
		this.finalAccount = finalAccount;
	}

	public List<TransactionLocalDto> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionLocalDto> transactions) {
		this.transactions = transactions;
	}

	public List<TransactionDisplayLocalDto> getTransactionsDisplay() {
		return transactionsDisplay;
	}

	public void setTransactionsDisplay(List<TransactionDisplayLocalDto> transactionsDisplay) {
		this.transactionsDisplay = transactionsDisplay;
	}

	@Override
	public String toString() {
		String transactions = "";
		for(TransactionLocalDto transaction:getTransactions()) {
			transactions += transaction+"\n";
		}
		String transactionsDisplay = "";
		for(TransactionDisplayLocalDto transaction:getTransactionsDisplay()) {
			transactionsDisplay += transaction+"\n";
		}
		return "initial account: "+getInitialAccount()+"\n"+
				"final account: "+getFinalAccount()+"\n"+
				"transactions: "+transactions+"\n"+
				"transactionsDisplay: "+transactionsDisplay;
	}

}
