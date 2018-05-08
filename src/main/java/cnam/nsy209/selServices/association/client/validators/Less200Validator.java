package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Less than 200 validator leaf
 *
 */
public class Less200Validator implements IValidator {

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(stringToValidate.length() >= 200) {
			return EnumCheck.LESS_THAN_200;
		}
		return null;
	}

}