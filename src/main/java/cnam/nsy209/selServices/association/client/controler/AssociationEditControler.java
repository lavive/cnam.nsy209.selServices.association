package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.asyncCallback.AssociationAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.AssociationEditModel;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

public class AssociationEditControler {
	
	/* Attributes */
	private AssociationEditModel model;
	private TextBox name;
	private TextBox address;
	private TextBox postalCode;
	private TextBox town;
	private TextBox email;
	private TextBox cellNumber;
	private TextBox phoneNumber;
	private TextBox webSite;
	private TextBox password;
	
	/* Constructors */
	public AssociationEditControler() {
		this.model = AssociationEditModel.get();
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				AssociationLocalDto association = buildAssociation();
				model.onDisplay(association);
				if(model.noError()) { 
					 DialogBoxConfirm<AssociationLocalDto> dialogBox =  new DialogBoxConfirm<AssociationLocalDto>(association,
							 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
					 dialogBox.center();
					 dialogBox.show();
					 //sendData(association);
				}
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for textbox */
	public ClickHandler getTextBoxClickHandler(final TextBox box) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				AssociationLocalDto association = buildAssociation();
				if(box == name) {
					model.onDisplay(association, EnumField.ASSOCIATION_NAME);//if(model.getMemberNameError() != null) model.setMemberNameError(null);
				}
				if(box == address) {
					model.onDisplay(association, EnumField.ASSOCIATION_ADDRESS);//if(model.getMemberAddressError() != null) model.setMemberAddressError(null);
				}
				if(box == postalCode) {
					model.onDisplay(association, EnumField.ASSOCIATION_POSTAL_CODE);//if(model.getMemberPostalCodeError() != null) model.setMemberPostalCodeError(null);
				}
				if(box == town) {
					model.onDisplay(association, EnumField.ASSOCIATION_TOWN);//if(model.getMemberTownError() != null) model.setMemberTownError(null);
				}
				if(box == email) {
					model.onDisplay(association, EnumField.ASSOCIATION_EMAIL);//if(model.getMemberEmailError() != null) model.setMemberEmailError(null);
				}
				if(box == cellNumber) {
					model.onDisplay(association, EnumField.ASSOCIATION_CELL_NUMBER);//if(model.getMemberCellNumberError() != null) model.setMemberCellNumberError(null);
				}
				if(box == phoneNumber) {
					model.onDisplay(association, EnumField.ASSOCIATION_PHONE_NUMBER);//if(model.getMemberPhoneNumberError() != null) model.setMemberPhoneNumberError(null);
				}
				if(box == webSite) {
					model.onDisplay(association, EnumField.ASSOCIATION_WEB_SITE);//if(model.getMemberFornameError() != null) model.setMemberFornameError(null);
				}
				if(box == password) {
					model.onDisplay(association, EnumField.ASSOCIATION_PASSWORD);//if(model.getMemberPasswordError() != null) model.setMemberPasswordError(null);
				}
			}
		};
		
		return clickHandler;
	}
	
	/* getter and setter */

	public AssociationEditModel getModel() {
		return model;
	}
	
	public TextBox getName() {
		return name;
	}

	public void setName(TextBox name) {
		this.name = name;
	}

	public TextBox getAddress() {
		return address;
	}

	public void setAddress(TextBox address) {
		this.address = address;
	}

	public TextBox getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(TextBox postalCode) {
		this.postalCode = postalCode;
	}

	public TextBox getTown() {
		return town;
	}

	public void setTown(TextBox town) {
		this.town = town;
	}

	public TextBox getEmail() {
		return email;
	}

	public void setEmail(TextBox email) {
		this.email = email;
	}

	public TextBox getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(TextBox cellNumber) {
		this.cellNumber = cellNumber;
	}

	public TextBox getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(TextBox phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public TextBox getWebSite() {
		return webSite;
	}

	public void setWebSite(TextBox webSite) {
		this.webSite = webSite;
	}

	public TextBox getPassword() {
		return password;
	}

	public void setPassword(TextBox password) {
		this.password = password;
	}

	/* helper methods */
	private AssociationLocalDto buildAssociation() {
		AssociationLocalDto association = new AssociationLocalDto();
		association.setName(name.getText());
		association.setAddress(address.getText());
		association.setPostalCode(postalCode.getText());
		association.setTown(town.getText());
		association.setEmail(email.getText());
		association.setCellNumber(cellNumber.getText());
		association.setPhoneNumber(phoneNumber.getText());
		association.setWebsite(webSite.getText());
		association.setPassword(password.getText());
		
		return association;
	}
	private void sendData(final AssociationLocalDto association) {	
		this.model.onWaitingDisplay(association);
		Timer t = new Timer() {
			@Override
			public void run() {
				AssociationAsyncCallback callback = new AssociationAsyncCallback();
				callback.setAssociationEditControler(AssociationEditControler.this);
				callback.updateAssociation(association);
			}
		};
		t.schedule(0);
//		/******Asynck******/
//		String messageToDisplay =I18n.getI18nMessages().dataSaved();
//		(new DialogBoxMessage(messageToDisplay)).show();
	}
	private IActionToTransmit<AssociationLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<AssociationLocalDto>() {
			@Override
			public void action(AssociationLocalDto association) {
				sendData(association);	
				
			}
      };
	}
}
