package cnam.nsy209.selServices.association.client.controler;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.user.client.Timer;

import cnam.nsy209.selServices.association.client.asyncCallback.MessageAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MessagesDisplayModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

public class MessagesDisplayControler {
	
	/* Attributes */
	private MessagesDisplayModel model;
	
	/* Constructors */
	public MessagesDisplayControler(List<MessageLocalDto> messages) {
		this.model = MessagesDisplayModel.get(messages);
	}
	
	/* get the action for delete button */
	public ActionCell<MessageLocalDto> getDeleteAction(){
		return new ActionCell<MessageLocalDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<MessageLocalDto>() {
			 @Override
			 public void execute(MessageLocalDto message) {
				 DialogBoxConfirm<MessageLocalDto> dialogBox = new DialogBoxConfirm<MessageLocalDto>(message,
						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
				 dialogBox.center();
				 dialogBox.show();
			 }
		 });

	}
	
	/* getter */

	public MessagesDisplayModel getModel() {
		return model;
	}
	
	/* helper method */
	private void delete(MessageLocalDto message) {
		Timer t = new Timer() {
			@Override
			public void run() {
				MessageAsyncCallback callback = new MessageAsyncCallback();
				callback.setMessagesDisplayControler(MessagesDisplayControler.this);
				callback.deleteMessage(message);
			}
		};
		t.schedule(0);
	}
	private IActionToTransmit<MessageLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<MessageLocalDto>() {
			@Override
			public void action(MessageLocalDto message) {
				 delete(message);				
			}
      };
	}	
}
