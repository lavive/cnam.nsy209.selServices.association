package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.validators.helper.EnumCheck;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.validators.helper.FieldValidators;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

@SuppressWarnings("serial")
public class AssociationEditModel extends Observable implements WaitingModel{
	
	/* Singleton */
	private static AssociationEditModel instance;
	public static AssociationEditModel get() {
		if(instance == null)
			instance = new AssociationEditModel();
		
		return instance;
	}
	
	/* Constructor */
	private AssociationEditModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* attribute */
	private AssociationLocalDto provisionalAssociation;
	private EnumCheck associationNameError;	
	private EnumCheck associationAddressError;	
	private EnumCheck associationPostalCodeError;	
	private EnumCheck associationTownError;	
	private EnumCheck associationEmailError;	
	private EnumCheck associationCellNumberError;	
	private EnumCheck associationPhoneNumberError;	
	private EnumCheck associationWebSiteError;	
	private EnumCheck associationPasswordError;	
	private boolean waiting;
	
	/* initialize page values */
	public void onInitialize(AssociationLocalDto association) {
		if(association != null) provisionalAssociation = association;
		else provisionalAssociation = new AssociationLocalDto();
		setAssociationToDisplay(provisionalAssociation);

		associationNameError = null;	
		associationAddressError = null;	
		associationPostalCodeError = null;	
		associationTownError = null;	
		associationEmailError = null;	
		associationCellNumberError = null;	
		associationPhoneNumberError = null;	
		associationWebSiteError = null;	
		associationPasswordError = null;	
		
		waiting = false;
		
		notifyObservers();
	}
	
	/* change values after input check */
	public void onDisplay(AssociationLocalDto association) {
		if(association != null) provisionalAssociation = association;
		else provisionalAssociation = new AssociationLocalDto();
		setAssociationToDisplay(provisionalAssociation);
		
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_NAME).validate(provisionalAssociation.getName()) != null) {
			associationNameError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_NAME).validate(provisionalAssociation.getName());
		} else {
			associationNameError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_PASSWORD).validate(provisionalAssociation.getPassword()) != null) {
			associationPasswordError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_PASSWORD).validate(provisionalAssociation.getPassword());
		} else {
			associationPasswordError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_POSTAL_CODE).validate(provisionalAssociation.getPostalCode()) != null) {
			associationPostalCodeError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_POSTAL_CODE).validate(provisionalAssociation.getPostalCode());
		} else {
			associationPostalCodeError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_ADDRESS).validate(provisionalAssociation.getAddress()) != null) {
			associationAddressError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_ADDRESS).validate(provisionalAssociation.getAddress());
		} else {
			associationAddressError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_TOWN).validate(provisionalAssociation.getTown()) != null) {
			associationTownError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_TOWN).validate(provisionalAssociation.getTown());
		} else {
			associationTownError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_EMAIL).validate(provisionalAssociation.getEmail()) != null) {
			associationEmailError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_EMAIL).validate(provisionalAssociation.getEmail());
		} else {
			associationEmailError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_CELL_NUMBER).validate(provisionalAssociation.getCellNumber()) != null) {
			associationCellNumberError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_CELL_NUMBER).validate(provisionalAssociation.getCellNumber());
		} else {
			associationCellNumberError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_PHONE_NUMBER).validate(provisionalAssociation.getPhoneNumber()) != null) {
			associationPhoneNumberError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_PHONE_NUMBER).validate(provisionalAssociation.getPhoneNumber());
		} else {
			associationPhoneNumberError = null;
		}
		if(FieldValidators.get().getValidators(EnumField.ASSOCIATION_WEB_SITE).validate(provisionalAssociation.getWebsite()) != null) {
			associationWebSiteError = FieldValidators.get().getValidators(EnumField.ASSOCIATION_WEB_SITE).validate(provisionalAssociation.getWebsite());
		} else {
			associationWebSiteError = null;
		}
		
		this.waiting = false;
		
		notifyObservers();
	}
	
	/* delete values error */
	public void onDisplay(AssociationLocalDto association, EnumField field) {
		if(association != null) provisionalAssociation = association;
		else provisionalAssociation = new AssociationLocalDto();	
		setAssociationToDisplay(provisionalAssociation);
		
		if(field.equals(EnumField.ASSOCIATION_NAME))
			associationNameError = null;
		if(field.equals(EnumField.ASSOCIATION_WEB_SITE))
			associationWebSiteError = null;
		if(field.equals(EnumField.ASSOCIATION_PASSWORD))
			associationPasswordError = null;
		if(field.equals(EnumField.ASSOCIATION_POSTAL_CODE))
			associationPostalCodeError = null;
		if(field.equals(EnumField.ASSOCIATION_ADDRESS))
			associationAddressError = null;
		if(field.equals(EnumField.ASSOCIATION_TOWN))
			associationTownError = null;
		if(field.equals(EnumField.ASSOCIATION_EMAIL))
			associationEmailError = null;
		if(field.equals(EnumField.ASSOCIATION_CELL_NUMBER))
			associationCellNumberError = null;
		if(field.equals(EnumField.ASSOCIATION_PHONE_NUMBER))
			associationPhoneNumberError = null;
		
		this.waiting = false;
		
		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay(AssociationLocalDto association) {
		if(association != null) provisionalAssociation = association;
		else provisionalAssociation = new AssociationLocalDto();
		setAssociationToDisplay(provisionalAssociation);

		associationNameError = null;	
		associationAddressError = null;	
		associationPostalCodeError = null;	
		associationTownError = null;	
		associationEmailError = null;	
		associationCellNumberError = null;	
		associationPhoneNumberError = null;	
		associationWebSiteError = null;	
		associationPasswordError = null;	
		
		waiting = true;
		
		notifyObservers();
	}
	
	/* check if there are errors */
	public boolean noError() {
		return associationNameError == null &&	
			associationAddressError == null &&	
			associationPostalCodeError == null &&	
			associationTownError == null &&		
			associationEmailError == null &&		
			associationCellNumberError == null &&	
			associationPhoneNumberError == null &&	
			associationWebSiteError == null &&	
			associationPasswordError == null;
	}
	
	/* Helper method */
	private void setAssociationToDisplay(AssociationLocalDto association) {
		if(association.getName() == null) association.setName("");
		if(association.getAddress() == null) association.setAddress("");
		if(association.getPostalCode() == null) association.setPostalCode("");
		if(association.getTown() == null) association.setTown("");
		if(association.getEmail() == null) association.setEmail("");
		if(association.getCellNumber() == null) association.setCellNumber("");
		if(association.getPhoneNumber() == null) association.setPhoneNumber("");
		if(association.getWebsite() == null) association.setWebsite("");
		if(association.getPassword() == null) association.setPassword("");
	}
	
	/* getters and setters */

	public AssociationLocalDto getProvisionalAssociation() {
		return provisionalAssociation;
	}

	public EnumCheck getAssociationNameError() {
		return associationNameError;
	}

	public EnumCheck getAssociationAddressError() {
		return associationAddressError;
	}

	public EnumCheck getAssociationPostalCodeError() {
		return associationPostalCodeError;
	}

	public EnumCheck getAssociationTownError() {
		return associationTownError;
	}

	public EnumCheck getAssociationEmailError() {
		return associationEmailError;
	}

	public EnumCheck getAssociationCellNumberError() {
		return associationCellNumberError;
	}

	public EnumCheck getAssociationPhoneNumberError() {
		return associationPhoneNumberError;
	}

	public EnumCheck getAssociationWebSiteError() {
		return associationWebSiteError;
	}

	public EnumCheck getAssociationPasswordError() {
		return associationPasswordError;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setAssociationNameError(EnumCheck associationNameError) {
		this.associationNameError = associationNameError;
	}

	public void setAssociationAddressError(EnumCheck associationAddressError) {
		this.associationAddressError = associationAddressError;
	}

	public void setAssociationPostalCodeError(EnumCheck associationPostalCodeError) {
		this.associationPostalCodeError = associationPostalCodeError;
	}

	public void setAssociationTownError(EnumCheck associationTownError) {
		this.associationTownError = associationTownError;
	}

	public void setAssociationEmailError(EnumCheck associationEmailError) {
		this.associationEmailError = associationEmailError;
	}

	public void setAssociationCellNumberError(EnumCheck associationCellNumberError) {
		this.associationCellNumberError = associationCellNumberError;
	}

	public void setAssociationPhoneNumberError(EnumCheck associationPhoneNumberError) {
		this.associationPhoneNumberError = associationPhoneNumberError;
	}

	public void setAssociationWebSiteError(EnumCheck associationWebSiteError) {
		this.associationWebSiteError = associationWebSiteError;
	}

	public void setAssociationPasswordError(EnumCheck associationPasswordError) {
		this.associationPasswordError = associationPasswordError;
	}
	
}
