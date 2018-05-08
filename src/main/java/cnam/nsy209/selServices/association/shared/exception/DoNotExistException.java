package cnam.nsy209.selServices.association.shared.exception;

import java.io.Serializable;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

@SuppressWarnings("serial")
public class DoNotExistException extends Exception implements Serializable {	
	
	public DoNotExistException() {}
	
	public String message() {
		
		return I18n.getI18nMessages().notFound();
	}

}
