package cnam.nsy209.selServices.association.shared.exception;

import java.io.Serializable;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception implements Serializable {

	public AuthenticationException() {}
	
	public String message() {
		return I18n.getI18nMessages().authenticationWrong();
	}
}
