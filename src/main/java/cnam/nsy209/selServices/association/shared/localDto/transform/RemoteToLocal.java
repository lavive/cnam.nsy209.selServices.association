package cnam.nsy209.selServices.association.shared.localDto.transform;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.server.dto.Dto;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.MessageDto;
import cnam.nsy209.selServices.association.server.dto.PersonDto;
import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
import cnam.nsy209.selServices.association.server.dto.TransactionDto;
import cnam.nsy209.selServices.association.server.dto.WealthSheetDto;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.PersonLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionDisplayLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

public class RemoteToLocal {
	
	public static AssociationLocalDto toLocalAssociation(AssociationDto association) {
		AssociationLocalDto associationLocal = new AssociationLocalDto();
		associationLocal.setId(association.getId());
		associationLocal.setName(association.getName());
		associationLocal.setAddress(association.getAddress());
		associationLocal.setPostalCode(association.getPostalCode());
		associationLocal.setTown(association.getTown());
		associationLocal.setEmail(association.getEmail());
		associationLocal.setCellNumber(association.getCellNumber());
		associationLocal.setPhoneNumber(association.getPhoneNumber());
		associationLocal.setPassword(association.getPassword());
		associationLocal.setWebsite(association.getWebsite());
		
		return associationLocal;		
	}
	
	public static CategoryLocalDto toLocalCategory(CategoryDto categoryRemote) {
		CategoryLocalDto categoryLocal = new CategoryLocalDto();
		categoryLocal.setId(categoryRemote.getId());
		categoryLocal.setName(categoryRemote.getName());
		
		return categoryLocal;	
	}
	
	public static LocalDto toLocal(Dto remote) {
		LocalDto local = new LocalDto();
		local.setId(remote.getId());
		
		return local;	
	}
	
	public static MemberLocalDto toLocalMember(MemberDto memberRemote) {
		MemberLocalDto memberLocal = new MemberLocalDto();
		memberLocal.setId(memberRemote.getId());
		memberLocal.setName(memberRemote.getName());
		memberLocal.setAddress(memberRemote.getAddress());
		memberLocal.setPostalCode(memberRemote.getPostalCode());
		memberLocal.setTown(memberRemote.getTown());
		memberLocal.setEmail(memberRemote.getEmail());
		memberLocal.setCellNumber(memberRemote.getCellNumber());
		memberLocal.setPhoneNumber(memberRemote.getPhoneNumber());
		memberLocal.setPassword(memberRemote.getPassword());
		memberLocal.setForname(memberRemote.getForname());
		memberLocal.setMobileId(memberRemote.getMobileId());
		if(memberRemote.getSupplyDemandIds() != null)
			memberLocal.setSupplyDemandIds(memberRemote.getSupplyDemandIds());
		memberLocal.setWealthSheet(toLocalWealthSheet(memberRemote.getWealthSheet()));		
		
		return memberLocal;	
	}
	
	public static MessageLocalDto toLocalMessage(MessageDto messageRemote) {
		MessageLocalDto messageLocal = new MessageLocalDto();
		messageLocal.setId(messageRemote.getId());
		messageLocal.setTitle(messageRemote.getTitle());
		messageLocal.setText(messageRemote.getText());
		messageLocal.setEmitterPerson(toLocalPerson(messageRemote.getEmitterPerson()));
		
		return messageLocal;	
	}
	
	public static PersonLocalDto toLocalPerson(PersonDto personRemote) {
		PersonLocalDto personLocal = new PersonLocalDto();
		personLocal.setId(personRemote.getId());
		personLocal.setName(personRemote.getName());
		personLocal.setAddress(personRemote.getAddress());
		personLocal.setPostalCode(personRemote.getPostalCode());
		personLocal.setTown(personRemote.getTown());
		personLocal.setEmail(personRemote.getEmail());
		personLocal.setCellNumber(personRemote.getCellNumber());
		personLocal.setPhoneNumber(personRemote.getPhoneNumber());
		personLocal.setPassword(personRemote.getPassword());
		
		return personLocal;	
	}
	
	public static SupplyDemandLocalDto toLocalSupplyDemand(SupplyDemandDto supplyDemandRemote) {
		SupplyDemandLocalDto supplyDemandLocal = new SupplyDemandLocalDto();
		supplyDemandLocal.setId(supplyDemandRemote.getId());
		supplyDemandLocal.setType(supplyDemandRemote.getType());
		supplyDemandLocal.setCategory(supplyDemandRemote.getCategory());
		supplyDemandLocal.setTitle(supplyDemandRemote.getTitle());
		supplyDemandLocal.setMember(toLocalMember(supplyDemandRemote.getMember()));
				
		return supplyDemandLocal;	
	}
	
	public static TransactionLocalDto toLocalTransaction(TransactionDto transactionRemote) {
		TransactionLocalDto transactionLocal = new TransactionLocalDto();
		transactionLocal.setId(transactionRemote.getId());
		transactionLocal.setCreditorMemberId(transactionRemote.getCreditorMemberId());
		transactionLocal.setDebtorMemberId(transactionRemote.getDebtorMemberId());
		transactionLocal.setSupplyDemandId(transactionRemote.getSupplyDemandId());
		transactionLocal.setAmount(transactionRemote.getAmount());
		
		return transactionLocal;	
	}
	
	public static WealthSheetLocalDto toLocalWealthSheet(WealthSheetDto wealthSheetRemote) {
		WealthSheetLocalDto wealthSheetLocal = new WealthSheetLocalDto();
		wealthSheetLocal.setId(wealthSheetRemote.getId());
		wealthSheetLocal.setInitialAccount(wealthSheetRemote.getInitialAccount());
		wealthSheetLocal.setFinalAccount(wealthSheetRemote.getFinalAccount());
		
		List<TransactionLocalDto> transactionsLocalDto = new ArrayList<TransactionLocalDto>();
		for(TransactionDto transactionRemote:wealthSheetRemote.getTransactions()) {
			transactionsLocalDto.add(toLocalTransaction(transactionRemote));
		}
		wealthSheetLocal.setTransactions(transactionsLocalDto);
		
		return wealthSheetLocal;	
	}

	public static TransactionDisplayLocalDto toLocalTransactionDisplay(MemberDto creditor, MemberDto debtor,
			                                                      SupplyDemandDto supplyDemand, String amount) {

	    TransactionDisplayLocalDto transactionDisplay = new TransactionDisplayLocalDto();
	
	    transactionDisplay.setCreditorMember(RemoteToLocal.toLocalMember(creditor));
	    transactionDisplay.setDebtorMember(RemoteToLocal.toLocalMember(debtor));
	    transactionDisplay.setSupplyDemand(RemoteToLocal.toLocalSupplyDemand(supplyDemand));
	    transactionDisplay.setAmount(amount);
	
	    return transactionDisplay;	
	}

}
