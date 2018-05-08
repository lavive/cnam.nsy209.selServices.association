package cnam.nsy209.selServices.association.client.validators.helper;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

/**
 * 
 * enum to tag each kind of input checking 
 *
 */

public enum EnumCheck {
	EMPTY("empty"),
	LESS_THAN_200("less200"),
	LESS_THAN_100("less100"),
	LESS_THAN_50("less50"),
	MORE_THAN_8("more8"),
	BIGDECIMAL_WELL_FORMED("bigDecimalWellFormed"),
	POSTAL_CODE_WELL_FORMED("postalCodeWellFormed"),
	PHONE_NUMBER_WELL_FORMED("phoneNumberWellFormed"),
	EMAIL_WELL_FORMED("emailWellFormed"),
	NUMBER_WELL_FORMED("numberWellFormed");
	
	String wording;
	
	EnumCheck(String wording){
		this.wording = wording;
	}
	
	public String getWording() {
		return this.wording;
	}
	
	public String getErrorMessage() {
		if(this.equals(EMPTY))
			return I18n.getI18nMessages().emptyError();
		else if(this.equals(LESS_THAN_200))
			return I18n.getI18nMessages().less200Error();
		else if(this.equals(LESS_THAN_100))
			return I18n.getI18nMessages().less100Error();
		else if(this.equals(LESS_THAN_50))
			return I18n.getI18nMessages().less50Error();
		else if(this.equals(MORE_THAN_8))
			return I18n.getI18nMessages().more8Error();
		else if(this.equals(BIGDECIMAL_WELL_FORMED))
			return I18n.getI18nMessages().bigDecimalError();
		else if(this.equals(POSTAL_CODE_WELL_FORMED))
			return I18n.getI18nMessages().postalCodeError();
		else if(this.equals(PHONE_NUMBER_WELL_FORMED))
			return I18n.getI18nMessages().phoneNumberError();
		else if(this.equals(EMAIL_WELL_FORMED))
			return I18n.getI18nMessages().emailError();
		else if(this.equals(NUMBER_WELL_FORMED))
			return I18n.getI18nMessages().numberError();
		return null;
	}
	
	public static EnumCheck getByWording(String wording) {
		for(EnumCheck enumCheck : values()) {
			if(enumCheck.getWording().equals(wording))
				return enumCheck;
		}
		return null;
	}

}
