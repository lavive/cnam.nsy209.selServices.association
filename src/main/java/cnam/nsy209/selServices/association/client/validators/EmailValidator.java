package cnam.nsy209.selServices.association.client.validators;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Email validator leaf
 *
 */
public class EmailValidator implements IValidator {
	private final String regex = "^[a-z0-9]+(.[a-z0-9]+)*@[a-z0-9]+(\\.[a-z0-9])*(\\.[a-z]{2,4})$";

	@Override
	public EnumCheck validate(String stringToValidate) {
        /* email can be not input */
        if(stringToValidate == null || stringToValidate.equals("")) {
            return null;
        }
        
		if(!stringToValidate.matches(regex) && !stringToValidate.equals("") ) {
			return EnumCheck.EMAIL_WELL_FORMED;
		}
		return null;
	}

}
