package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;

/**
 * 
 * IDHome page Model to implement MVC pattern
 *
 */
@SuppressWarnings("serial")
public class IdHomeModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static IdHomeModel instance;
	public static IdHomeModel get() {
		if(instance == null)
			instance = new IdHomeModel();
		
		return instance;
	}
	
	/* Constructor */
	private IdHomeModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	
	/* attribute */
	private String login;
	private String password;
	private EnumCheck associationIDError;	
	private EnumCheck associationPasswordError;	
	private boolean waiting;
	private boolean authenticationError;
	private boolean networkError;

	
	/* initialize page values */
	public void onInitialize(String login,String password) {
		this.login=login;
		this.password=password;
		this.associationIDError = null;
		this.associationPasswordError = null;
		this.waiting = false;
		this.authenticationError = false;
		this.networkError = false;
		
		//setChanged();
		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(String associationIdInput,String associationPasswordInput) {
		this.login=associationIdInput;
		this.password=associationPasswordInput;
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_ID).validate(associationIdInput) != null) {
			this.associationIDError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_ID).validate(associationIdInput);
		} else {
			this.associationIDError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_PASSWORD).validate(associationPasswordInput) != null) {
			this.associationPasswordError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_PASSWORD).validate(associationPasswordInput);
		} else {
			this.associationPasswordError = null;
		}
		this.waiting = false;	
		this.authenticationError = false;	
		this.networkError = false;
		
		//setChanged();
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(String login, String password) {
		this.login = login;
		this.password=password;
		this.associationIDError = null;
		this.associationPasswordError = null;
		this.waiting = true;
		this.authenticationError = false;
		this.networkError = false;
		
		//setChanged();
		notifyObservers();
	}
	
	/* change values after no result */
	public void onNoResultDisplay(String login) {
		this.login = login;
		this.password="";
		this.associationIDError = null;
		this.associationPasswordError = null;
		this.waiting = false;
		this.authenticationError = true;
		this.networkError = false;
		
		
		notifyObservers();
	}
	
	/* change values after network error */
	public void onNetworkErrorDisplay(String login) {
		this.login = login;
		this.password="";
		this.associationIDError = null;
		this.associationPasswordError = null;
		this.waiting = false;
		this.authenticationError = false;
		this.networkError = true;
		
		
		notifyObservers();
	}
	
	/* getters and setters */

	public boolean isAuthenticationError() {
		return authenticationError;
	}

	public void setAuthenticationError(boolean authenticationError) {
		this.authenticationError = authenticationError;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public EnumCheck getAssociationIDError() {
		return associationIDError;
	}

	public EnumCheck getAssociationPasswordError() {
		return associationPasswordError;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setAssociationIDError(EnumCheck associationIDError) {
		this.associationIDError = associationIDError;
	}

	public void setAssociationPasswordError(EnumCheck associationPasswordError) {
		this.associationPasswordError = associationPasswordError;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public boolean isNetworkError() {
		return networkError;
	}

	public void setNetworkError(boolean networkError) {
		this.networkError = networkError;
	}
	
	

}
