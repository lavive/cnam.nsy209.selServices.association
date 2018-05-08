package cnam.nsy209.selServices.association.shared.localDto.transform;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.SupplyDemandAsyncCallback;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionDisplayLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;

public class LocalToLocal {
	
	
//	public static List<TransactionDisplayLocalDto> toTransactionsDisplay(List<TransactionLocalDto> transactions) {
//
//		List<TransactionDisplayLocalDto> transactionsDisplay = new ArrayList<TransactionDisplayLocalDto>();
//		
//  	    MemberLocalDto creditor = new MemberLocalDto();
//  	    MemberLocalDto debtor = new MemberLocalDto();
//  	    MemberAsyncCallback memberCallback = new MemberAsyncCallback();
//  	    
//  	    SupplyDemandLocalDto supplyDemand = new SupplyDemandLocalDto();
//  	    SupplyDemandAsyncCallback supplyDemandCallback = new SupplyDemandAsyncCallback();
//  	    
//  	    for(TransactionLocalDto transaction: transactions) {
//			TransactionDisplayLocalDto transactionDisplay = new TransactionDisplayLocalDto();
//			
//  	    	memberCallback.getMember(transaction.getCreditorMemberId(), creditor);
//			transactionDisplay.setCreditorMember(creditor.getFullName());
//
//  	    	memberCallback.getMember(transaction.getCreditorMemberId(), creditor);
//			transactionDisplay.setDebtorMember(debtor.getFullName());
//			
//			supplyDemandCallback.getSupplyDemand(transaction.getSupplyDemandId(), supplyDemand);
//			transactionDisplay.setSupplyDemand(supplyDemand.getTitle());
//			
//			transactionDisplay.setAmount(transaction.getAmount());
//			
//			transactionsDisplay.add(transactionDisplay);
//  	    }
//		
//		return transactionsDisplay;		
//	}	



}
