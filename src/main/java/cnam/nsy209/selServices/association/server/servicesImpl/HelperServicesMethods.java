package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.TransactionDto;

public class HelperServicesMethods {	
	
	/* static method */
	public static List<MemberDto> getMembers(MemberDto attributes, List<MemberDto> members) {
		List<MemberDto> membersToGet = new ArrayList<MemberDto>();
		for(MemberDto memberToCheck:members) {
			if(compareAttributes(memberToCheck,attributes))
				membersToGet.add(memberToCheck);
		}
		return membersToGet;
	}

	public static boolean existMember(MemberDto member, List<MemberDto> members) {
		for(MemberDto memberCursor:members) {
			if(memberCursor.getId().longValue() == member.getId().longValue()) return true;
			if(member.getAddress() != null? member.getAddress().equals(memberCursor.getAddress()):true &&
				member.getName() != null? member.getName().equals(memberCursor.getName()):true &&
				member.getForname() != null? member.getForname().equals(memberCursor.getForname()):true &&
				member.getPostalCode() != null? member.getPostalCode().equals(memberCursor.getPostalCode()):true &&
				member.getTown() != null? member.getTown().equals(memberCursor.getTown()):true &&
				member.getCellNumber() != null? member.getCellNumber().equals(memberCursor.getCellNumber()):true &&
				member.getPhoneNumber() != null? member.getPhoneNumber().equals(memberCursor.getPhoneNumber()):true &&
				member.getEmail() != null? member.getEmail().equals(memberCursor.getEmail()):true &&
				!(member.getAddress() == null && member.getName() == null && member.getForname() == null && 
				member.getPostalCode() == null && member.getTown() == null && member.getCellNumber() == null && 
				member.getPhoneNumber() == null && member.getEmail() == null))
				return true;
		}
		return false;
	}

	public static boolean noExistMember(MemberDto member, List<MemberDto> members) {
		for(MemberDto memberCursor:members) {
			if(memberCursor.getId().longValue() == member.getId().longValue()) return false;
		}
		return true;
	}	

	public static boolean emptyMember(MemberDto member) {
		return member.getAddress() == null && member.getName() == null && member.getForname() == null && 
				member.getPostalCode() == null && member.getTown() == null && member.getCellNumber() == null && 
				member.getPhoneNumber() == null && member.getEmail() == null;
	}
	
	public static String checkTransactionWellFormed(TransactionDto transaction) {
		String originError = "";
//		/* check if member origin of supply demand is well a debtor or a creditor */
//		if(!transaction.getCreditorMember().equals(transaction.getSupplyDemand().getMember())) {
//			if(!transaction.getDebtorMember().equals(transaction.getSupplyDemand().getMember()))
//				originError = I18n.getI18nMessages().memberCreditorDebtor();
//		}
//		/* check if creditor and debtor are well different */
//		if(!transaction.getDebtorMember().equals(transaction.getCreditorMember()))
//			originError = I18n.getI18nMessages().differentCreditorDebtor();
//		/* check if member origin is creditor, supplyDemand has to be a supply */
//		if(transaction.getCreditorMember().equals(transaction.getSupplyDemand().getMember())) {
//			if(transaction.getSupplyDemand().getType().equals(EnumSupplyDemandDto.DEMAND))
//				originError = I18n.getI18nMessages().creditorSupply();
//		} 
//		/* check if member origin is debtor, supplyDemand has to be a demand */
//		if(transaction.getDebtorMember().equals(transaction.getSupplyDemand().getMember())) {
//			if(transaction.getSupplyDemand().getType().equals(EnumSupplyDemandDto.SUPPLY))
//				originError = I18n.getI18nMessages().debtorDemand();
//		}
		
		return originError;
	}
	
	/* helper methods */
	private static boolean compareAttributes(MemberDto memberToCheck,MemberDto attributes) {
		return			(attributes.getAddress() != null || !attributes.getAddress().contentEquals(""))?
							memberToCheck.getAddress().equals(attributes.getAddress()):true
					&&	(attributes.getName() != null || !attributes.getName().contentEquals(""))?
							memberToCheck.getName().equals(attributes.getName()):true
					&&	(attributes.getForname() != null || !attributes.getForname().contentEquals(""))?
							memberToCheck.getForname().equals(attributes.getForname()):true
					&&	(attributes.getPostalCode() != null || !attributes.getPostalCode().contentEquals(""))?
							memberToCheck.getPostalCode().equals(attributes.getPostalCode()):true
					&&	(attributes.getTown() != null || !attributes.getTown().contentEquals(""))?
							memberToCheck.getTown().equals(attributes.getTown()):true
					&&	(attributes.getCellNumber() != null || !attributes.getCellNumber().contentEquals(""))?
							memberToCheck.getAddress().equals(attributes.getAddress()):true
					&&	(attributes.getPhoneNumber() != null || !attributes.getPhoneNumber().contentEquals(""))?
							memberToCheck.getPhoneNumber().equals(attributes.getPhoneNumber()):true
					&&	(attributes.getEmail() != null || !attributes.getEmail().contentEquals(""))?
							memberToCheck.getEmail().equals(attributes.getEmail()):true;
	}

}
