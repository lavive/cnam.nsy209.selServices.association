package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Phone Number validator leaf
 *
 */
public class PhoneNumberValidator implements IValidator {
	private final String regex = "^0[1-9][0-9]{8}$";

	@Override
	public EnumCheck validate(String stringToValidate) {
        /* phoneNumber can be not input */
        if(stringToValidate == null || stringToValidate.equals("")) {
            return null;
        }
        
		if(!stringToValidate.matches(regex) && !stringToValidate.equals("")) {
			return EnumCheck.PHONE_NUMBER_WELL_FORMED;
		}
		return null;
	}

}