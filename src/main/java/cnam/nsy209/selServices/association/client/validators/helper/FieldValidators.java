package cnam.nsy209.selServices.association.client.validators.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cnam.nsy209.selServices.association.client.validators.BigDecimalValidator;
import cnam.nsy209.selServices.association.client.validators.EmailValidator;
import cnam.nsy209.selServices.association.client.validators.EmptyValidator;
import cnam.nsy209.selServices.association.client.validators.IValidator;
import cnam.nsy209.selServices.association.client.validators.Less100Validator;
import cnam.nsy209.selServices.association.client.validators.Less200Validator;
import cnam.nsy209.selServices.association.client.validators.Less50Validator;
import cnam.nsy209.selServices.association.client.validators.More8Validator;
import cnam.nsy209.selServices.association.client.validators.NumberValidator;
import cnam.nsy209.selServices.association.client.validators.PhoneNumberValidator;
import cnam.nsy209.selServices.association.client.validators.PostalCodeValidator;
import cnam.nsy209.selServices.association.client.validators.Validators;

/**
 * 
 * Class to bind validators with field
 *
 */

public class FieldValidators {
	
	/* Singleton */
	private static FieldValidators instance;
	public static FieldValidators get() {
		if(instance == null)
			instance = new FieldValidators();
		
		return instance;
	}
	
	/* Constructor */
	private FieldValidators() {
		build();
	}
	
	/* retrieve field checks */
	public Validators getValidators(EnumField field) {
		Validators validators = new Validators();
		for(EnumCheck check:getChecks(field)) {
			validators.addValidator(CheckValidator.getValidator(check));
		}
		return validators;
	}
	
	/* helper methods */
	private  HashMap<EnumField,List<EnumCheck>> fieldCheck = new HashMap<EnumField,List<EnumCheck>>();
	
	private  List<EnumCheck> getChecks(EnumField field){
		return fieldCheck.get(field);
	}
	
	/* helper inner class */
	private static class CheckValidator {
		private static HashMap<EnumCheck,IValidator> checkValidator = new HashMap<EnumCheck,IValidator>();
		public static IValidator getValidator(EnumCheck check) { return checkValidator.get(check); }
		public static void putValidator(EnumCheck check,IValidator validator) { checkValidator.put(check, validator); }
	}
	
	private void build() {
		/* EnumField.ASSOCIATION_ID */
		List<EnumCheck> assosID = new ArrayList<EnumCheck>();
		assosID.add(EnumCheck.EMPTY);
		assosID.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.ASSOCIATION_ID,assosID);
		
		/* EnumField.ASSOCIATION_PASSWORD */
		List<EnumCheck> assosPwd = new ArrayList<EnumCheck>();
		assosPwd.add(EnumCheck.EMPTY);
		assosPwd.add(EnumCheck.LESS_THAN_50);
		assosPwd.add(EnumCheck.MORE_THAN_8);
		fieldCheck.put(EnumField.ASSOCIATION_PASSWORD,assosPwd);
		
		/* EnumField.ASSOCIATION_NAME */
		List<EnumCheck> assosName = new ArrayList<EnumCheck>();
		assosName.add(EnumCheck.EMPTY);
		assosName.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.ASSOCIATION_NAME,assosName);
		
		/* EnumField.ASSOCIATION_ADDRESS */
		List<EnumCheck> assosAddress = new ArrayList<EnumCheck>();
		assosAddress.add(EnumCheck.EMPTY);
		assosAddress.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.ASSOCIATION_ADDRESS,assosAddress);
		
		/* EnumField.ASSOCIATION_POSTAL_CODE */
		List<EnumCheck> assosPostalCode = new ArrayList<EnumCheck>();
		assosPostalCode.add(EnumCheck.EMPTY);
		assosPostalCode.add(EnumCheck.LESS_THAN_50);
		assosPostalCode.add(EnumCheck.POSTAL_CODE_WELL_FORMED);
		fieldCheck.put(EnumField.ASSOCIATION_POSTAL_CODE,assosPostalCode);
		
		/* EnumField.ASSOCIATION_TOWN */
		List<EnumCheck> assosTown = new ArrayList<EnumCheck>();
		assosTown.add(EnumCheck.EMPTY);
		assosTown.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.ASSOCIATION_TOWN,assosTown);
		
		/* EnumField.ASSOCIATION_EMAIL */
		List<EnumCheck> assosEmail = new ArrayList<EnumCheck>();
		assosEmail.add(EnumCheck.LESS_THAN_100);
		assosEmail.add(EnumCheck.EMAIL_WELL_FORMED);
		fieldCheck.put(EnumField.ASSOCIATION_EMAIL,assosEmail);
		
		/* EnumField.ASSOCIATION_CELL_NUMBER */
		List<EnumCheck> assosCNumber = new ArrayList<EnumCheck>();
		assosCNumber.add(EnumCheck.LESS_THAN_50);
		assosCNumber.add(EnumCheck.PHONE_NUMBER_WELL_FORMED);
		fieldCheck.put(EnumField.ASSOCIATION_CELL_NUMBER,assosCNumber);
		
		/* EnumField.ASSOCIATION_PHONE_NUMBER */
		List<EnumCheck> assosPNumber = new ArrayList<EnumCheck>();
		//assosPNumber.add(EnumCheck.EMPTY);
		assosPNumber.add(EnumCheck.LESS_THAN_50);
		assosPNumber.add(EnumCheck.PHONE_NUMBER_WELL_FORMED);
		fieldCheck.put(EnumField.ASSOCIATION_PHONE_NUMBER,assosPNumber);
		
		/* EnumField.ASSOCIATION_WEB_SITE */
		List<EnumCheck> assosWebSite = new ArrayList<EnumCheck>();
		assosWebSite.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.ASSOCIATION_WEB_SITE,assosWebSite);
		
		/* EnumField.CATEGORY */
		List<EnumCheck> category = new ArrayList<EnumCheck>();
		category.add(EnumCheck.EMPTY);
		category.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.CATEGORY,category);
		
		/* EnumField.MEMBER_PASSWORD */
		List<EnumCheck> memberPwd = new ArrayList<EnumCheck>();
		memberPwd.add(EnumCheck.EMPTY);
		memberPwd.add(EnumCheck.LESS_THAN_50);
		memberPwd.add(EnumCheck.MORE_THAN_8);
		fieldCheck.put(EnumField.MEMBER_PASSWORD,memberPwd);
		
		/* EnumField.MEMBER_NAME */
		List<EnumCheck> memberName = new ArrayList<EnumCheck>();
		memberName.add(EnumCheck.EMPTY);
		memberName.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.MEMBER_NAME,memberName);
		
		/* EnumField.MEMBER_FORNAME */
		List<EnumCheck> memberForname = new ArrayList<EnumCheck>();
		memberForname.add(EnumCheck.EMPTY);
		memberForname.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.MEMBER_FORNAME,memberForname);
		
		/* EnumField.MEMBER_ADDRESS */
		List<EnumCheck> memberAddress = new ArrayList<EnumCheck>();
		memberAddress.add(EnumCheck.EMPTY);
		memberAddress.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.MEMBER_ADDRESS,memberAddress);
		
		/* EnumField.MEMBER_POSTAL_CODE */
		List<EnumCheck> memberPostalCode = new ArrayList<EnumCheck>();
		memberPostalCode.add(EnumCheck.EMPTY);
		memberPostalCode.add(EnumCheck.LESS_THAN_50);
		memberPostalCode.add(EnumCheck.POSTAL_CODE_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_POSTAL_CODE,memberPostalCode);
		
		/* EnumField.MEMBER_TOWN */
		List<EnumCheck> memberTown = new ArrayList<EnumCheck>();
		memberTown.add(EnumCheck.EMPTY);
		memberTown.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.MEMBER_TOWN,memberTown);
		
		/* EnumField.MEMBER_EMAIL */
		List<EnumCheck> memberEmail = new ArrayList<EnumCheck>();
		memberEmail.add(EnumCheck.LESS_THAN_100);
		memberEmail.add(EnumCheck.EMAIL_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_EMAIL,memberEmail);
		
		/* EnumField.MEMBER_CELL_NUMBER */
		List<EnumCheck> memberCNumber = new ArrayList<EnumCheck>();
		memberCNumber.add(EnumCheck.EMPTY);
		memberCNumber.add(EnumCheck.LESS_THAN_50);
		memberCNumber.add(EnumCheck.PHONE_NUMBER_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_CELL_NUMBER,memberCNumber);
		
		/* EnumField.MEMBER_PHONE_NUMBER */
		List<EnumCheck> memberPNumber = new ArrayList<EnumCheck>();
		memberPNumber.add(EnumCheck.LESS_THAN_50);
		memberPNumber.add(EnumCheck.PHONE_NUMBER_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_PHONE_NUMBER,memberPNumber);
		
		/* EnumField.MEMBER_NAME_RESEARCH */
		List<EnumCheck> memberNameResearch = new ArrayList<EnumCheck>();
		memberNameResearch.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.MEMBER_NAME_RESEARCH,memberNameResearch);
		
		/* EnumField.MEMBER_FORNAME_RESEARCH */
		List<EnumCheck> memberFornameResearch = new ArrayList<EnumCheck>();
		memberFornameResearch.add(EnumCheck.LESS_THAN_50);
		fieldCheck.put(EnumField.MEMBER_FORNAME_RESEARCH,memberFornameResearch);
		
		/* EnumField.MEMBER_ADDRESS_RESEARCH */
		List<EnumCheck> memberAddressResearch = new ArrayList<EnumCheck>();
		memberAddressResearch.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.MEMBER_ADDRESS_RESEARCH,memberAddressResearch);
		
		/* EnumField.MEMBER_POSTAL_CODE_RESEARCH */
		List<EnumCheck> memberPostalCodeResearch = new ArrayList<EnumCheck>();
		memberPostalCodeResearch.add(EnumCheck.LESS_THAN_50);
		memberPostalCodeResearch.add(EnumCheck.POSTAL_CODE_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_POSTAL_CODE_RESEARCH,memberPostalCodeResearch);
		
		/* EnumField.MEMBER_TOWN _RESEARCH*/
		List<EnumCheck> memberTownResearch = new ArrayList<EnumCheck>();
		memberTownResearch.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.MEMBER_TOWN_RESEARCH,memberTownResearch);
		
		/* EnumField.MEMBER_CELL_NUMBER_RESEARCH */
		List<EnumCheck> memberCNumberResearch = new ArrayList<EnumCheck>();
		memberCNumberResearch.add(EnumCheck.LESS_THAN_50);
		memberCNumberResearch.add(EnumCheck.PHONE_NUMBER_WELL_FORMED);
		fieldCheck.put(EnumField.MEMBER_CELL_NUMBER_RESEARCH,memberCNumberResearch);
		
		/* EnumField.AMOUNT */
		List<EnumCheck> amount = new ArrayList<EnumCheck>();
		amount.add(EnumCheck.EMPTY);
		amount.add(EnumCheck.LESS_THAN_50);
		amount.add(EnumCheck.BIGDECIMAL_WELL_FORMED);
		fieldCheck.put(EnumField.AMOUNT,amount);
		
		/* EnumField.FAST_MESSAGE_TEXT */
		List<EnumCheck> fastMessageText = new ArrayList<EnumCheck>();
		fastMessageText.add(EnumCheck.EMPTY);
		fastMessageText.add(EnumCheck.LESS_THAN_200);
		fieldCheck.put(EnumField.FAST_MESSAGE_TEXT,fastMessageText);
		
		/* EnumField.FAST_MESSAGE_TITLE */
		List<EnumCheck> fastMessageTitle = new ArrayList<EnumCheck>();
		fastMessageTitle.add(EnumCheck.EMPTY);
		fastMessageTitle.add(EnumCheck.LESS_THAN_100);
		fieldCheck.put(EnumField.FAST_MESSAGE_TITLE,fastMessageTitle);
		
		
		/* fill CheckValidator */
		CheckValidator.putValidator(EnumCheck.EMPTY, new EmptyValidator());
		CheckValidator.putValidator(EnumCheck.BIGDECIMAL_WELL_FORMED, new BigDecimalValidator());
		CheckValidator.putValidator(EnumCheck.EMAIL_WELL_FORMED, new EmailValidator());
		CheckValidator.putValidator(EnumCheck.LESS_THAN_200, new Less200Validator());
		CheckValidator.putValidator(EnumCheck.LESS_THAN_100, new Less100Validator());
		CheckValidator.putValidator(EnumCheck.LESS_THAN_50, new Less50Validator());
		CheckValidator.putValidator(EnumCheck.MORE_THAN_8, new More8Validator());
		CheckValidator.putValidator(EnumCheck.NUMBER_WELL_FORMED, new NumberValidator());
		CheckValidator.putValidator(EnumCheck.PHONE_NUMBER_WELL_FORMED, new PhoneNumberValidator());
		CheckValidator.putValidator(EnumCheck.POSTAL_CODE_WELL_FORMED, new PostalCodeValidator());
	}

}
