package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Empty validator leaf
 *
 */
public class EmptyValidator implements IValidator {

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(stringToValidate == null || stringToValidate.trim().equals("")) {
			return EnumCheck.EMPTY;
		}
		return null;
	}

}