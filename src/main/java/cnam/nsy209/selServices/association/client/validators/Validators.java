package cnam.nsy209.selServices.association.client.validators;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;

/**
 * 
 * Composite validator
 *
 */
public class Validators implements IValidator {
	
	private List<IValidator> validators = new ArrayList<IValidator>();
	
	public void addValidator(IValidator validator) {
		this.validators.add(validator);
	}
	
	public void deleteValidator(IValidator validator) {
		this.validators.remove(validator);
	}

	@Override
	public EnumCheck validate(String stringToValidate) {
		for(IValidator validator:this.validators) {
			if(validator.validate(stringToValidate) != null) {
				return validator.validate(stringToValidate);
			}
		}
		return null;
	}
	
	
	/* getters */
	
	public List<IValidator> getValidators(){
		return this.validators;
	}

}
