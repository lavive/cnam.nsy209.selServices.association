package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Number validator leaf
 *
 */
public class NumberValidator implements IValidator {
	private final String regex = "^([1-9][0-9]*)|0$";

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(!stringToValidate.matches(regex)) {
			return EnumCheck.NUMBER_WELL_FORMED;
		}
		return null;
	}

}
