package cnam.nsy209.selServices.association.shared.exception;

import java.io.Serializable;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

@SuppressWarnings("serial")
public class AlReadyExistException extends Exception implements Serializable {
	
	private String existingAttribute;
	
	public AlReadyExistException() {}
	
	public AlReadyExistException(String existingAttribute) {
		this.existingAttribute = existingAttribute;
	}

	public String getExistingAttribute() {
		return existingAttribute;
	}
	
	public String message() {
		
		return existingAttribute+" "+I18n.getI18nMessages().alReadyExist();
	}

}
