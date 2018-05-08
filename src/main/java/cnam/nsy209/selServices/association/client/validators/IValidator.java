package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Interface validator
 *
 */

public interface IValidator {
	
	public EnumCheck validate(String stringToValidate);

}
