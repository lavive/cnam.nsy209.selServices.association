package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextArea;

import cnam.nsy209.selServices.association.client.asyncCallback.AssociationAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.MessageAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.FastMessageModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

public class FastMessageControler {
	
	/* Attribute */
	private FastMessageModel model;
	private TextArea text;
	private TextArea title;
	
	/* Constructors */
	public FastMessageControler() {
		model = FastMessageModel.get();
	}
	
	/* get the handler for Send button */
	public ClickHandler getSendClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onDisplay(text.getText(),title.getText());
				if(model.noError()) { 
					 DialogBoxConfirm<MessageLocalDto> dialogBox = 
							 new DialogBoxConfirm<MessageLocalDto>(buildMessage(),
							 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
					 dialogBox.center();
					 dialogBox.show();
				}
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Reset button */
	public ClickHandler getResetClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onInitialize("","");
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for text area */
	public ClickHandler getTextAreaClickHandler(TextArea area) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				if(area == text) {
					if(model.getTextError() != null)
						model.onInitializeText(text.getText(),title.getText());
				} else if(area == title) {
					if(model.getTitleError() != null)
						model.onInitializeTitle(text.getText(),title.getText());
				}
			}
		};
		
		return clickHandler;
	}

	/* getter */
	public FastMessageModel getModel() {
		return model;
	}
	
	public TextArea getText() {
		return text;
	}

	public void setText(TextArea text) {
		this.text = text;
	}

	public TextArea getTitle() {
		return title;
	}

	public void setTitle(TextArea title) {
		this.title = title;
	}

	/* helper method */
	private MessageLocalDto buildMessage() {
		MessageLocalDto message = new MessageLocalDto();
		message.setTitle(title.getText());
		message.setText(text.getText());
		AssociationLocalDto emitter = new AssociationLocalDto();
		AssociationAsyncCallback callback = new AssociationAsyncCallback();
		callback.getAssociation(emitter);
		message.setEmitterPerson(emitter);
		
		return message;
	}
	
	private void send(final MessageLocalDto message) {
		this.model.onWaitingDisplay(text.getText(),title.getText());
		Timer t = new Timer() {
			@Override
			public void run() {
				MessageAsyncCallback callback = new MessageAsyncCallback();
				callback.setFastMessageControler(FastMessageControler.this);
				callback.addMessage(message);
			}
		};
		t.schedule(0);
	}
	
	private IActionToTransmit<MessageLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<MessageLocalDto>() {
			@Override
			public void action(MessageLocalDto message) {
				send(message);	
				
			}
      };
	}
}
