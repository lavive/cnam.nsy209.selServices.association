package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Less than 2=100 validator leaf
 *
 */
public class Less50Validator implements IValidator {

	@Override
	public EnumCheck validate(String stringToValidate) {
        /* can be not input */
        if(stringToValidate == null || stringToValidate.equals("")) {
            return null;
        }
        
		if(stringToValidate.length() >= 50) {
			return EnumCheck.LESS_THAN_50;
		}
		return null;
	}

}