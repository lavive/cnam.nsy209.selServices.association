package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Postal Code validator leaf
 *
 */
public class PostalCodeValidator implements IValidator {
	private final String regex = "^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$";

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(!stringToValidate.matches(regex) && !stringToValidate.equals("")) {
			return EnumCheck.POSTAL_CODE_WELL_FORMED;
		}
		return null;
	}

}
