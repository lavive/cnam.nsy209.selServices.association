package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class CategoryEditModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static CategoryEditModel instance;
	public static CategoryEditModel get() {
		if(instance == null)
			instance = new CategoryEditModel();
		
		return instance;
	}
	
	/* Constructor */
	private CategoryEditModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private String category;
	private EnumCheck categoryError;	
	private boolean waiting;
	
	/* initialize page values */
	public void onInitialize(String category) {
		if(category != null) this.category = category;	
		else this.category = "";
		categoryError = null;
		waiting = false;
		
		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(String category) {
		if(category != null) this.category = category;
		
		if(FieldValidators.get().getValidators(EnumField.CATEGORY).validate(this.category) != null) {
			categoryError = FieldValidators.get().getValidators(EnumField.CATEGORY).validate(this.category);
		} else {
			categoryError = null;
		}waiting = false;
		
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(String category) {
		this.category = category;	
		categoryError = null;
		waiting = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return categoryError == null;
	}
	
	/* getters and setters */

	public String getCategory() {
		return category;
	}

	public EnumCheck getCategoryError() {
		return categoryError;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setCategoryError(EnumCheck categoryError) {
		this.categoryError = categoryError;
		notifyObservers();
	}
}
