package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * BigDecimal validator leaf
 *
 */
public class BigDecimalValidator implements IValidator {
	private final String regex = "^[1-9][0-9]*(\\.[0-9]{1,2})?$";

	@Override
	public EnumCheck validate(String stringToValidate) {
		if(!stringToValidate.matches(regex)) {
			return EnumCheck.BIGDECIMAL_WELL_FORMED;
		}
		return null;
	}

}
