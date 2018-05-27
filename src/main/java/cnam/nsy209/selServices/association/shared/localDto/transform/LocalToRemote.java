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
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;
/** 
 * 
 * Class to transform Local to Remote DTO
 * 
 * @author lavive
 *
 */
public class LocalToRemote {
	
	public static AssociationDto toRemoteAssociation(AssociationLocalDto associationLocal) {
		AssociationDto associationRemote = new AssociationDto();
		associationRemote.setId(associationLocal.getId());
		associationRemote.setName(associationLocal.getName());
		associationRemote.setAddress(associationLocal.getAddress());
		associationRemote.setPostalCode(associationLocal.getPostalCode());
		associationRemote.setTown(associationLocal.getTown());
		associationRemote.setEmail(associationLocal.getEmail());
		associationRemote.setCellNumber(associationLocal.getCellNumber());
		associationRemote.setPhoneNumber(associationLocal.getPhoneNumber());
		associationRemote.setPassword(associationLocal.getPassword());
		associationRemote.setWebsite(associationLocal.getWebsite());
		
		return associationRemote;
	}
	
	public static CategoryDto toRemoteCategory(CategoryLocalDto categoryLocal) {
		CategoryDto categoryRemote = new CategoryDto();
		categoryRemote.setId(categoryLocal.getId());
		categoryRemote.setName(categoryLocal.getName());
		
		return categoryRemote;		
	}
	
	public static Dto toRemote(LocalDto local) {
		Dto remote = new Dto();		
		remote.setId(local.getId());
		
		return remote;		
	}
	
	public static MemberDto toRemoteMember(MemberLocalDto memberLocal) {
		MemberDto memberRemote = new MemberDto();
		memberRemote.setId(memberLocal.getId());
		memberRemote.setName(memberLocal.getName());
		memberRemote.setAddress(memberLocal.getAddress());
		memberRemote.setPostalCode(memberLocal.getPostalCode());
		memberRemote.setTown(memberLocal.getTown());
		memberRemote.setEmail(memberLocal.getEmail());
		memberRemote.setCellNumber(memberLocal.getCellNumber());
		memberRemote.setPhoneNumber(memberLocal.getPhoneNumber());
		memberRemote.setPassword(memberLocal.getPassword());
		memberRemote.setForname(memberLocal.getForname());
		memberRemote.setMobileId(memberLocal.getMobileId());
		if(memberLocal.getSupplyDemandIds() != null)
			memberRemote.setSupplyDemandIds(memberLocal.getSupplyDemandIds());
		if(memberLocal.getWealthSheet() != null)
			memberRemote.setWealthSheet(toRemoteWealthSheet(memberLocal.getWealthSheet()));		
		
		return memberRemote;		
	}
	
	public static MessageDto toRemoteMessage(MessageLocalDto messageLocal) {
		MessageDto messageRemote = new MessageDto();
		messageRemote.setId(messageLocal.getId());
		messageRemote.setTitle(messageLocal.getTitle());
		messageRemote.setText(messageLocal.getText());
		messageRemote.setEmitterPerson(toRemotePerson(messageLocal.getEmitterPerson()));
		
		return messageRemote;		
	}
	
	public static PersonDto toRemotePerson(PersonLocalDto personLocal) {
		PersonDto personRemote = new PersonDto();
		personRemote.setId(personLocal.getId());
		personRemote.setName(personLocal.getName());
		personRemote.setAddress(personLocal.getAddress());
		personRemote.setPostalCode(personLocal.getPostalCode());
		personRemote.setTown(personLocal.getTown());
		personRemote.setEmail(personLocal.getEmail());
		personRemote.setCellNumber(personLocal.getCellNumber());
		personRemote.setPhoneNumber(personLocal.getPhoneNumber());
		personRemote.setPassword(personLocal.getPassword());
		
		return personRemote;		
	}
	
	public static SupplyDemandDto toRemoteSupplyDemand(SupplyDemandLocalDto supplyDemandLocal) {
		SupplyDemandDto supplyDemandRemote = new SupplyDemandDto();
		supplyDemandRemote.setId(supplyDemandLocal.getId());
		supplyDemandRemote.setType(supplyDemandLocal.getType());
		supplyDemandRemote.setCategory(supplyDemandLocal.getCategory());
		supplyDemandRemote.setTitle(supplyDemandLocal.getTitle());
		supplyDemandRemote.setMember(toRemoteMember(supplyDemandLocal.getMember()));
		
		return supplyDemandRemote;		
	}
	
	public static TransactionDto toRemoteTransaction(TransactionLocalDto transactionLocal) {
		TransactionDto transactionRemote = new TransactionDto();
		transactionRemote.setId(transactionLocal.getId());
		transactionRemote.setCreditorMemberId(transactionLocal.getCreditorMemberId());
		transactionRemote.setDebtorMemberId(transactionLocal.getDebtorMemberId());
		transactionRemote.setSupplyDemandId(transactionLocal.getSupplyDemandId());
		transactionRemote.setAmount(transactionLocal.getAmount());
		
		return transactionRemote;		
	}
	
	public static WealthSheetDto toRemoteWealthSheet(WealthSheetLocalDto wealthSheetLocal) {
		WealthSheetDto wealthSheetRemote = new WealthSheetDto();
		if(wealthSheetLocal.getId() != null)
			wealthSheetRemote.setId(wealthSheetLocal.getId());
		if(wealthSheetLocal.getInitialAccount() != null)
			wealthSheetRemote.setInitialAccount(wealthSheetLocal.getInitialAccount());
		if(wealthSheetLocal.getFinalAccount() != null)
			wealthSheetRemote.setFinalAccount(wealthSheetLocal.getFinalAccount());
		
		List<TransactionDto> transactionsDto = new ArrayList<TransactionDto>();
		if(wealthSheetLocal.getTransactions() != null) {
			for(TransactionLocalDto transactionLocal:wealthSheetLocal.getTransactions()) {
				transactionsDto.add(toRemoteTransaction(transactionLocal));
			}
		}
		wealthSheetRemote.setTransactions(transactionsDto);
		
		return wealthSheetRemote;		
	}

}
