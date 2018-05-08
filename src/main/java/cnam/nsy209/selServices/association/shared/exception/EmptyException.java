package cnam.nsy209.selServices.association.shared.exception;

import java.io.Serializable;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

@SuppressWarnings("serial")
public class EmptyException extends Exception implements Serializable {
	
	public EmptyException() {}
	
	public String message() {
		return I18n.getI18nMessages().empty();
	}

}
