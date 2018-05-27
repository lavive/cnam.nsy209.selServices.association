package cnam.nsy209.selServices.association.client.asyncCallback;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.FastMessageControler;
import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.controler.MessagesDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.MessagesDisplayPage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MessagesDisplay;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

/** 
 * 
 * Class to manage result from Message service call
 * 
 * @author lavive
 *
 */
public class MessageAsyncCallback {
	/* attributes */
	private AsyncCallback<List<MessageLocalDto>> addCallback;
	private AsyncCallback<List<MessageLocalDto>> getCallback;
	private AsyncCallback<List<MessageLocalDto>> deleteCallback;
	private int width;
	private int height;
	private MenuControler menuControler;
	private FastMessageControler fastMessageControler;
	private MessagesDisplayControler messagesDisplayControler;
	
	/* Constructors */
	public MessageAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public MessageAsyncCallback() {}
	
	/* methods */
	public void addMessage(MessageLocalDto message) {
			
		addCallback = new AsyncCallback<List<MessageLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(fastMessageControler != null) 
					fastMessageControler.getModel().onInitialize(message.getText(),message.getTitle());
				if(caught instanceof EmptyException) {
					DialogBoxMessage message = new DialogBoxMessage(((EmptyException) caught).message());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<MessageLocalDto> result) {
				if(fastMessageControler != null) 
					fastMessageControler.getModel().onInitialize(message.getText(),message.getTitle());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().addMessageConfirm());
				message.center();
				message.show();				

				RootPanel.get().clear();
				MessagesDisplayPage page = new MessagesDisplayPage(width,height);
				MessagesDisplay.get().getMessagesTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMessagesService().add(message, addCallback);
	}
	
	public void getMessages(final Button button, boolean back) {
			
		getCallback = new AsyncCallback<List<MessageLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<MessageLocalDto> result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				MessagesDisplayPage page = new MessagesDisplayPage(width,height);
				MessagesDisplay.get().getMessagesTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMessagesService().getMessages(getCallback);
	}
	
	public void deleteMessage(MessageLocalDto message) {
			
		deleteCallback = new AsyncCallback<List<MessageLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof DoNotExistException) {
					DialogBoxMessage message = new DialogBoxMessage(((DoNotExistException) caught).message());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<MessageLocalDto> result) {
				messagesDisplayControler.getModel().onSet(result);				
			}
			
		};
		
		ServicesProxy.getMessagesService().delete(message, deleteCallback);
	}
	
	
	/* getter and setter */

	public void setMenuControler(MenuControler menuControler) {
		this.menuControler = menuControler;
	}
	public void setFastMessageControler(FastMessageControler fastMessageControler) {
		this.fastMessageControler = fastMessageControler;
	}
	public void setMessagesDisplayControler(MessagesDisplayControler messagesDisplayControler) {
		this.messagesDisplayControler = messagesDisplayControler;
	}

}
