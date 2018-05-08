package cnam.nsy209.selServices.association.client.model;

import java.util.List;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

@SuppressWarnings("serial")
public class MemberResearchModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static MemberResearchModel instance;
	public static MemberResearchModel get() {
		if(instance == null)
			instance = new MemberResearchModel();
		
		return instance;
	}
	
	/* Constructor */
	private MemberResearchModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private MemberLocalDto provisionalMember;
	private EnumCheck memberNameError;		
	private EnumCheck memberFornameError;	
	private EnumCheck memberAddressError;	
	private EnumCheck memberPostalCodeError;	
	private EnumCheck memberTownError;	
	private EnumCheck memberCellNumberError;	
	private boolean waiting;
	private boolean noResult;
	private List<MemberLocalDto> membersForList;
	
	/* initialize page values */
	public void onInitialize() {
		provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);	

		memberNameError = null;	
		memberAddressError = null;	
		memberPostalCodeError = null;	
		memberTownError = null;	
		memberCellNumberError = null;		
		memberFornameError = null;	
		
		waiting = false;
		noResult = false;

		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(MemberLocalDto member) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);
		
		if(FieldValidators.get().getValidators(EnumField.MEMBER_NAME_RESEARCH).validate(provisionalMember.getName()) != null) {
			memberNameError = FieldValidators.get().getValidators(EnumField.MEMBER_NAME_RESEARCH).validate(provisionalMember.getName());
		} else {
			memberNameError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_FORNAME_RESEARCH).validate(provisionalMember.getForname()) != null) {
			memberFornameError = FieldValidators.get().getValidators(EnumField.MEMBER_FORNAME_RESEARCH).validate(provisionalMember.getForname());
		} else {
			memberFornameError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_POSTAL_CODE_RESEARCH).validate(provisionalMember.getPostalCode()) != null) {
			memberPostalCodeError = FieldValidators.get().getValidators(EnumField.MEMBER_POSTAL_CODE_RESEARCH).validate(provisionalMember.getPostalCode());
		} else {
			memberPostalCodeError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_ADDRESS_RESEARCH).validate(provisionalMember.getAddress()) != null) {
			memberAddressError = FieldValidators.get().getValidators(EnumField.MEMBER_ADDRESS_RESEARCH).validate(provisionalMember.getAddress());
		} else {
			memberAddressError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_TOWN_RESEARCH).validate(provisionalMember.getTown()) != null) {
			memberTownError = FieldValidators.get().getValidators(EnumField.MEMBER_TOWN_RESEARCH).validate(provisionalMember.getTown());
		} else {
			memberTownError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_CELL_NUMBER_RESEARCH).validate(provisionalMember.getCellNumber()) != null) {
			memberCellNumberError = FieldValidators.get().getValidators(EnumField.MEMBER_CELL_NUMBER_RESEARCH).validate(provisionalMember.getCellNumber());
		} else {
			memberCellNumberError = null;
		}
		
		waiting = false;
		noResult = false;
		
		notifyObservers();
	}
	
	/* delete values error */
	public void onDisplay(MemberLocalDto member, EnumField field) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);
		
		if(field.equals(EnumField.MEMBER_NAME_RESEARCH))
			memberNameError = null;
		if(field.equals(EnumField.MEMBER_FORNAME_RESEARCH))
			memberFornameError = null;
		if(field.equals(EnumField.MEMBER_POSTAL_CODE_RESEARCH))
			memberPostalCodeError = null;
		if(field.equals(EnumField.MEMBER_ADDRESS_RESEARCH))
			memberAddressError = null;
		if(field.equals(EnumField.MEMBER_TOWN_RESEARCH))
			memberTownError = null;
		if(field.equals(EnumField.MEMBER_CELL_NUMBER_RESEARCH))
			memberCellNumberError = null;
		
		this.waiting = false;
		noResult = false;
		
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(MemberLocalDto member) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);

		memberNameError = null;	
		memberAddressError = null;	
		memberPostalCodeError = null;	
		memberTownError = null;	
		memberCellNumberError = null;		
		memberFornameError = null;	
		
		waiting = true;
		noResult = false;
		
		notifyObservers();
	}
	
	/* no data found */
	public void onNoResultDisplay() {
		provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);

		memberNameError = null;	
		memberAddressError = null;	
		memberPostalCodeError = null;	
		memberTownError = null;	
		memberCellNumberError = null;		
		memberFornameError = null;	
		
		waiting = false;
		noResult = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return memberNameError == null &&	
		memberAddressError == null &&	
		memberPostalCodeError == null &&	
		memberTownError == null &&	
		memberCellNumberError == null &&	
		memberFornameError == null;
	}
	
	/* Helper method */
	private void setMemberToDisplay(MemberLocalDto member) {
		if(member.getName() == null) member.setName("");
		if(member.getForname() == null) member.setForname("");
		if(member.getAddress() == null) member.setAddress("");
		if(member.getPostalCode() == null) member.setPostalCode("");
		if(member.getTown() == null) member.setTown("");
		if(member.getEmail() == null) member.setEmail("");
		if(member.getCellNumber() == null) member.setCellNumber("");
		if(member.getPhoneNumber() == null) member.setPhoneNumber("");
		if(member.getPassword() == null) member.setPassword("");
	}
	
	/* getters and setters */

	public MemberLocalDto getProvisionalMember() {
		return provisionalMember;
	}

	public EnumCheck getMemberNameError() {
		return memberNameError;
	}

	public EnumCheck getMemberAddressError() {
		return memberAddressError;
	}

	public EnumCheck getMemberPostalCodeError() {
		return memberPostalCodeError;
	}

	public EnumCheck getMemberTownError() {
		return memberTownError;
	}

	public EnumCheck getMemberCellNumberError() {
		return memberCellNumberError;
	}

	public EnumCheck getMemberFornameError() {
		return memberFornameError;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public boolean isNoResult() {
		return noResult;
	}

	public void setMemberNameError(EnumCheck memberNameError) {
		this.memberNameError = memberNameError;
	}

	public void setMemberFornameError(EnumCheck memberFornameError) {
		this.memberFornameError = memberFornameError;
	}

	public void setMemberAddressError(EnumCheck memberAddressError) {
		this.memberAddressError = memberAddressError;
	}

	public void setMemberPostalCodeError(EnumCheck memberPostalCodeError) {
		this.memberPostalCodeError = memberPostalCodeError;
	}

	public void setMemberTownError(EnumCheck memberTownError) {
		this.memberTownError = memberTownError;
	}

	public void setMemberCellNumberError(EnumCheck memberCellNumberError) {
		this.memberCellNumberError = memberCellNumberError;
	}

	public List<MemberLocalDto> getMembersForList() {
		return membersForList;
	}

	public void setMembersForList() {
		MemberAsyncCallback memberCallback = new MemberAsyncCallback();
		/*this.membersForList = */memberCallback.getMembersForListBox();
	}

	public void setMembersForList(List<MemberLocalDto> members) {
		this.membersForList = members;
		
		notifyObservers();
	}
	
}
