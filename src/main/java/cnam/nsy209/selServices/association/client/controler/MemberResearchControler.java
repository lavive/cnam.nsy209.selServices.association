package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.SuggestBox;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.model.MemberResearchModel;
import cnam.nsy209.selServices.association.client.validators.helper.EnumField;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberResearchControler {
	
	/* Attributes */
	private MemberResearchModel model;
	private SuggestBox name;
	private SuggestBox forname;
	private SuggestBox address;
	private SuggestBox postalCode;
	private SuggestBox town;
	private SuggestBox cellNumber;
	
	/* Constructors */
	public MemberResearchControler() {
		this.model = MemberResearchModel.get();
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				MemberLocalDto member = buildMember();
				model.onDisplay(member);
				if(model.noError()) sendData(member);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for reset button */
	public ClickHandler getResetClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onInitialize();				
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for textbox */
	public ClickHandler getTextBoxClickHandler(final SuggestBox box) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				MemberLocalDto member = buildMember();
				if(box == name) {
					model.onDisplay(member, EnumField.MEMBER_NAME_RESEARCH);//if(model.getMemberNameError() != null) model.setMemberNameError(null);
				}
				if(box == forname) {
					model.onDisplay(member, EnumField.MEMBER_FORNAME_RESEARCH);//if(model.getMemberFornameError() != null) model.setMemberFornameError(null);
				}
				if(box == address) {
					model.onDisplay(member, EnumField.MEMBER_ADDRESS_RESEARCH);//if(model.getMemberAddressError() != null) model.setMemberAddressError(null);
				}
				if(box == postalCode) {
					model.onDisplay(member, EnumField.MEMBER_POSTAL_CODE_RESEARCH);//if(model.getMemberPostalCodeError() != null) model.setMemberPostalCodeError(null);
				}
				if(box == town) {
					model.onDisplay(member, EnumField.MEMBER_TOWN_RESEARCH);//if(model.getMemberTownError() != null) model.setMemberTownError(null);
				}
				if(box == cellNumber) {
					model.onDisplay(member, EnumField.MEMBER_CELL_NUMBER_RESEARCH);//if(model.getMemberCellNumberError() != null) model.setMemberCellNumberError(null);
				}
			}
		};
		
		return clickHandler;
	}
	
	/* getter */

	public MemberResearchModel getModel() {
		return model;
	}	


	public SuggestBox getName() {
		return name;
	}

	public void setName(SuggestBox name) {
		this.name = name;
	}

	public SuggestBox getForname() {
		return forname;
	}

	public void setForname(SuggestBox forname) {
		this.forname = forname;
	}

	public SuggestBox getAddress() {
		return address;
	}

	public void setAddress(SuggestBox address) {
		this.address = address;
	}

	public SuggestBox getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(SuggestBox postalCode) {
		this.postalCode = postalCode;
	}

	public SuggestBox getTown() {
		return town;
	}

	public void setTown(SuggestBox town) {
		this.town = town;
	}

	public SuggestBox getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(SuggestBox cellNumber) {
		this.cellNumber = cellNumber;
	}

	/* helper method */
	private MemberLocalDto buildMember() {
		MemberLocalDto member = new MemberLocalDto();
		member.setName(name.getText());
		member.setForname(forname.getText());
		member.setAddress(address.getText());
		member.setPostalCode(postalCode.getText());
		member.setTown(town.getText());
		member.setCellNumber(cellNumber.getText());
		
		return member;
	}
	
	private void sendData(MemberLocalDto member) {
		this.model.onWaitingDisplay(member);
		Timer t = new Timer() {
			@Override
			public void run() {
				MemberAsyncCallback callback = new MemberAsyncCallback();
				callback.setMemberResearchControler(MemberResearchControler.this);
				callback.getMembers(member,false);
			}
		};
		t.schedule(0);
//		/******Asynck******/
//		String messageToDisplay =I18n.getI18nMessages().dataNotSended();
//		(new DialogBoxMessage(messageToDisplay)).show();
	}
}
