package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * More than 8 validator leaf
 *
 */
public class More8Validator implements IValidator {

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(stringToValidate.length() < 8) {
			return EnumCheck.MORE_THAN_8;
		}
		return null;
	}

}