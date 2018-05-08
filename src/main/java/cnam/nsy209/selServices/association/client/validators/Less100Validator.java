package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Less than 100 validator leaf
 *
 */
public class Less100Validator implements IValidator {

	@Override
	public EnumCheck validate(String stringToValidate) {
        /* can be not input */
        if(stringToValidate == null || stringToValidate.equals("")) {
            return null;
        }
        
		if(stringToValidate.length() >= 100) {
			return EnumCheck.LESS_THAN_100;
		}
		return null;
	}

}