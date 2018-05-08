package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

@SuppressWarnings("serial")
public class MemberEditModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static MemberEditModel instance;
	public static MemberEditModel get() {
		if(instance == null)
			instance = new MemberEditModel();
		
		return instance;
	}
	
	/* Constructor */
	private MemberEditModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private MemberLocalDto provisionalMember;
	private EnumCheck memberNameError;		
	private EnumCheck memberFornameError;	
	private EnumCheck memberAddressError;	
	private EnumCheck memberPostalCodeError;	
	private EnumCheck memberTownError;	
	private EnumCheck memberEmailError;	
	private EnumCheck memberCellNumberError;	
	private EnumCheck memberPhoneNumberError;
	private EnumCheck memberPasswordError;	
	private EnumCheck memberAccountError;	
	private boolean waiting;
	
	/* initialize page values */
	public void onInitialize(MemberLocalDto member) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);	

		memberNameError = null;	
		memberAddressError = null;	
		memberPostalCodeError = null;	
		memberTownError = null;	
		memberEmailError = null;	
		memberCellNumberError = null;	
		memberPhoneNumberError = null;	
		memberFornameError = null;	
		memberPasswordError = null;	
		memberAccountError = null;
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(MemberLocalDto member) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);
		
		if(FieldValidators.get().getValidators(EnumField.MEMBER_NAME).validate(provisionalMember.getName()) != null) {
			memberNameError = FieldValidators.get().getValidators(EnumField.MEMBER_NAME).validate(provisionalMember.getName());
		} else {
			memberNameError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_FORNAME).validate(provisionalMember.getForname()) != null) {
			memberFornameError = FieldValidators.get().getValidators(EnumField.MEMBER_FORNAME).validate(provisionalMember.getForname());
		} else {
			memberFornameError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_PASSWORD).validate(provisionalMember.getMobileId()) != null) {
			memberPasswordError = FieldValidators.get().getValidators(EnumField.MEMBER_PASSWORD).validate(provisionalMember.getPassword());
		} else {
			memberPasswordError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_POSTAL_CODE).validate(provisionalMember.getPostalCode()) != null) {
			memberPostalCodeError = FieldValidators.get().getValidators(EnumField.MEMBER_POSTAL_CODE).validate(provisionalMember.getPostalCode());
		} else {
			memberPostalCodeError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_ADDRESS).validate(provisionalMember.getAddress()) != null) {
			memberAddressError = FieldValidators.get().getValidators(EnumField.MEMBER_ADDRESS).validate(provisionalMember.getAddress());
		} else {
			memberAddressError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_TOWN).validate(provisionalMember.getTown()) != null) {
			memberTownError = FieldValidators.get().getValidators(EnumField.MEMBER_TOWN).validate(provisionalMember.getTown());
		} else {
			memberTownError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_EMAIL).validate(provisionalMember.getEmail()) != null) {
			memberEmailError = FieldValidators.get().getValidators(EnumField.MEMBER_EMAIL).validate(provisionalMember.getEmail());
		} else {
			memberEmailError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_CELL_NUMBER).validate(provisionalMember.getCellNumber()) != null) {
			memberCellNumberError = FieldValidators.get().getValidators(EnumField.MEMBER_CELL_NUMBER).validate(provisionalMember.getCellNumber());
		} else {
			memberCellNumberError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.MEMBER_PHONE_NUMBER).validate(provisionalMember.getPhoneNumber()) != null) {
			memberPhoneNumberError = FieldValidators.get().getValidators(EnumField.MEMBER_PHONE_NUMBER).validate(provisionalMember.getPhoneNumber());
		} else {
			memberPhoneNumberError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.AMOUNT).validate(provisionalMember.getWealthSheet().getInitialAccount()) != null) {
			memberAccountError = FieldValidators.get().getValidators(EnumField.AMOUNT).validate(provisionalMember.getWealthSheet().getInitialAccount());
		} else {
			memberAccountError = null;
		}
		
		this.waiting = false;
		
		notifyObservers();
	}
	
	/* delete values error */
	public void onDisplay(MemberLocalDto member, EnumField field) {
		if(member != null) provisionalMember = member;
		else provisionalMember = new MemberLocalDto();	
		setMemberToDisplay(provisionalMember);
		
		if(field.equals(EnumField.MEMBER_NAME))
			memberNameError = null;
		if(field.equals(EnumField.MEMBER_FORNAME))
			memberFornameError = null;
		if(field.equals(EnumField.MEMBER_PASSWORD))
			memberPasswordError = null;
		if(field.equals(EnumField.MEMBER_POSTAL_CODE))
			memberPostalCodeError = null;
		if(field.equals(EnumField.MEMBER_ADDRESS))
			memberAddressError = null;
		if(field.equals(EnumField.MEMBER_TOWN))
			memberTownError = null;
		if(field.equals(EnumField.MEMBER_EMAIL))
			memberEmailError = null;
		if(field.equals(EnumField.MEMBER_CELL_NUMBER))
			memberCellNumberError = null;
		if(field.equals(EnumField.MEMBER_PHONE_NUMBER))
			memberPhoneNumberError = null;
		if(field.equals(EnumField.AMOUNT))
			memberAccountError = null;
		
		this.waiting = false;
		
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
		memberEmailError = null;	
		memberCellNumberError = null;	
		memberPhoneNumberError = null;	
		memberFornameError = null;	
		memberPasswordError = null;	
		memberAccountError = null;
		
		waiting = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return memberNameError == null &&	
		memberAddressError == null &&	
		memberPostalCodeError == null &&	
		memberTownError == null &&	
		memberEmailError == null &&	
		memberCellNumberError == null &&	
		memberPhoneNumberError == null &&	
		memberFornameError == null &&	
		memberPasswordError == null &&
		memberAccountError == null;
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
		if(member.getMobileId() == null) member.setMobileId("");
		if(member.getWealthSheet() == null) {
			WealthSheetLocalDto wealthSheet = new WealthSheetLocalDto();
			wealthSheet.setInitialAccount("");
			member.setWealthSheet(wealthSheet);
		}
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

	public EnumCheck getMemberEmailError() {
		return memberEmailError;
	}

	public EnumCheck getMemberCellNumberError() {
		return memberCellNumberError;
	}

	public EnumCheck getMemberPhoneNumberError() {
		return memberPhoneNumberError;
	}

	public EnumCheck getMemberFornameError() {
		return memberFornameError;
	}

	public EnumCheck getMemberPasswordError() {
		return memberPasswordError;
	}

	public boolean isWaiting() {
		return waiting;
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

	public void setMemberEmailError(EnumCheck memberEmailError) {
		this.memberEmailError = memberEmailError;
	}

	public void setMemberCellNumberError(EnumCheck memberCellNumberError) {
		this.memberCellNumberError = memberCellNumberError;
	}

	public void setMemberPhoneNumberError(EnumCheck memberPhoneNumberError) {
		this.memberPhoneNumberError = memberPhoneNumberError;
	}

	public void setMemberPasswordError(EnumCheck memberPasswordError) {
	}

	public EnumCheck getMemberAccountError() {
		return memberAccountError;
	}

	public void setMemberAccountError(EnumCheck memberAccountError) {
		this.memberAccountError = memberAccountError;
	}
	
}
