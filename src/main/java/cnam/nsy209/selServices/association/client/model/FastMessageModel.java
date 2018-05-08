package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class FastMessageModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static FastMessageModel instance;
	public static FastMessageModel get() {
		if(instance == null)
			instance = new FastMessageModel();
		
		return instance;
	}
	
	/* Constructor */
	private FastMessageModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private String text;
	private String title;
	private EnumCheck titleError;	
	private EnumCheck textError;	
	private boolean waiting;
	
	/* initialize page values */
	public void onInitialize(String text,String title) {
		if(text != null) this.text = text;
		else this.text = "";
		if(title != null) this.title = title;
		else this.title = "";

		textError = null;
		titleError = null;
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* initialize page values */
	public void onInitializeText(String text,String title) {
		if(text != null) this.text = text;
		else this.text = "";
		if(title != null) this.title = title;
		else this.title = "";

		textError = null;
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* initialize page values */
	public void onInitializeTitle(String text,String title) {
		if(text != null) this.text = text;
		else this.text = "";
		if(title != null) this.title = title;
		else this.title = "";

		titleError = null;
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(String text,String title) {
		if(text != null) this.text = text;
		else this.text ="";
		if(title != null) this.title = title;
		else this.title = "";
		
		if(FieldValidators.get().getValidators(EnumField.FAST_MESSAGE_TITLE).validate(title) != null) {
			titleError = FieldValidators.get().getValidators(EnumField.FAST_MESSAGE_TITLE).validate(title);
		} else {
			titleError = null;
		}
		
		if(FieldValidators.get().getValidators(EnumField.FAST_MESSAGE_TEXT).validate(text) != null) {
			textError = FieldValidators.get().getValidators(EnumField.FAST_MESSAGE_TEXT).validate(text);
		} else {
			textError = null;
		}
		
		this.waiting = false;
		
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(String text,String title) {
		if(text != null) this.text = text;
		else this.text ="";
		if(title != null) this.title = title;
		else this.title = "";

		textError = null;		
		
		waiting = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return textError == null && titleError == null;
	}
	
	/* getters and setters */

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

	public EnumCheck getTextError() {
		return textError;
	}

	public EnumCheck getTitleError() {
		return titleError;
	}

	public boolean isWaiting() {
		return waiting;
	}
	
}
