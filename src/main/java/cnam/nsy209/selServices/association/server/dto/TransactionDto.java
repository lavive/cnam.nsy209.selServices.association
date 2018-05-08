package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;

import com.squareup.moshi.Json;

public class TransactionDto implements Serializable{

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	@Json(name = "id")
	private Long id;

	@Json(name = "debtorMemberId")
	private Long debtorMemberId;

	@Json(name = "creditorMemberId")
	private Long creditorMemberId;

	@Json(name = "supplyDemandId")
	private Long supplyDemandId;

	@Json(name = "amount")
	private String amount;

	public TransactionDto(){}

	/* getter and setter */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreditorMemberId() {
		return creditorMemberId;
	}

	public void setCreditorMemberId(Long creditorMemberId) {
		this.creditorMemberId = creditorMemberId;
	}

	public Long getDebtorMemberId() {
		return debtorMemberId;
	}

	public void setDebtorMemberId(Long debtorMemberId) {
		this.debtorMemberId = debtorMemberId;
	}

	public Long getSupplyDemandId() {
		return supplyDemandId;
	}

	public void setSupplyDemandId(Long supplyDemandId) {
		this.supplyDemandId= supplyDemandId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void copy(TransactionDto transactionDto) {
		setId(transactionDto.getId());
		setCreditorMemberId(transactionDto.getCreditorMemberId());
		setDebtorMemberId(transactionDto.getDebtorMemberId());
		setSupplyDemandId(transactionDto.getSupplyDemandId());
		setAmount(transactionDto.getAmount());
	}

	@Override
	public String toString() {
		return "amount: "+getAmount();
	}


}

