package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MemberEditModel;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

public class MemberEditControler {
	
	/* Attributes */
	private MemberEditModel model;
	private TextBox name;
	private TextBox forname;
	private TextBox address;
	private TextBox postalCode;
	private TextBox town;
	private TextBox email;
	private TextBox cellNumber;
	private TextBox phoneNumber;
	private TextBox password;
	private TextBox initialAccount;
	
	/* Constructors */
	public MemberEditControler() {
		this.model = MemberEditModel.get();
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler(final boolean update, long id) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	 
				MemberLocalDto member = buildMember();	
				model.onDisplay(member);
				if(model.noError()) { 
					if(update) {
						 member.setId(id);
						 DialogBoxConfirm<MemberLocalDto> dialogBox = 
								 new DialogBoxConfirm<MemberLocalDto>(member,
								 I18n.getI18nMessages().sure(),clickHandlerUpdateToTransmit());
						 dialogBox.center();
						 dialogBox.show();
					}else {
						 DialogBoxConfirm<MemberLocalDto> dialogBox = 
								 new DialogBoxConfirm<MemberLocalDto>(member,
								 I18n.getI18nMessages().sure(),clickHandlerNoUpdateToTransmit());
						 dialogBox.center();
						 dialogBox.show();
					}
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
				MemberLocalDto member = buildMember();
				if(box == name) {
					model.onDisplay(member, EnumField.MEMBER_NAME);
				}
				if(box == forname) {
					model.onDisplay(member, EnumField.MEMBER_FORNAME);
				}
				if(box == address) {
					model.onDisplay(member, EnumField.MEMBER_ADDRESS);
				}
				if(box == postalCode) {
					model.onDisplay(member, EnumField.MEMBER_POSTAL_CODE);
				}
				if(box == town) {
					model.onDisplay(member, EnumField.MEMBER_TOWN);
				}
				if(box == email) {
					model.onDisplay(member, EnumField.MEMBER_EMAIL);
				}
				if(box == cellNumber) {
					model.onDisplay(member, EnumField.MEMBER_CELL_NUMBER);
				}
				if(box == phoneNumber) {
					model.onDisplay(member, EnumField.MEMBER_PHONE_NUMBER);
				}
				if(box == password) {
					model.onDisplay(member, EnumField.MEMBER_PASSWORD);
				}
				if(box == initialAccount) {
					model.onDisplay(member, EnumField.AMOUNT);
				}
			}
		};
		
		return clickHandler;
	}
	
	/* getter */

	public MemberEditModel getModel() {
		return model;
	}
	
	public TextBox getName() {
		return name;
	}

	public void setName(TextBox name) {
		this.name = name;
	}

	public TextBox getForname() {
		return forname;
	}

	public void setForname(TextBox forname) {
		this.forname = forname;
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

	public TextBox getPassword() {
		return password;
	}

	public void setPassword(TextBox password) {
		this.password = password;
	}

	public TextBox getInitialAccount() {
		return initialAccount;
	}

	public void setInitialAccount(TextBox initialAccount) {
		this.initialAccount = initialAccount;
	}

	/* helper method */
	private MemberLocalDto buildMember() {
		MemberLocalDto member = new MemberLocalDto();
		member.setName(name.getText());
		member.setForname(forname.getText());
		member.setAddress(address.getText());
		member.setPostalCode(postalCode.getText());
		member.setTown(town.getText());
		member.setEmail(email.getText());
		member.setCellNumber(cellNumber.getText());
		member.setPhoneNumber(phoneNumber.getText());
		member.setMobileId(password.getText());
		WealthSheetLocalDto wealthSheet = new WealthSheetLocalDto();
		wealthSheet.setInitialAccount(initialAccount.getText());
		member.setWealthSheet(wealthSheet);
		
		return member;
	}

	private void sendData(final MemberLocalDto member,final boolean update) {
		this.model.onWaitingDisplay(member);
		Timer t = new Timer() {
			@Override
			public void run() {
				MemberAsyncCallback callback = new MemberAsyncCallback();
				callback.setMemberEditControler(MemberEditControler.this);
				if(update) callback.updateMember(member);
				else callback.addMember(member);
			}
		};
		t.schedule(0);
	}
	private IActionToTransmit<MemberLocalDto> clickHandlerUpdateToTransmit() {
		return new IActionToTransmit<MemberLocalDto>() {
			@Override
			public void action(MemberLocalDto member) {
				sendData(member,true);	
				
			}
      };
	}
	private IActionToTransmit<MemberLocalDto> clickHandlerNoUpdateToTransmit() {
		return new IActionToTransmit<MemberLocalDto>() {
			@Override
			public void action(MemberLocalDto member) {
					sendData(member,false);	
				
			}
      };
	}
}
