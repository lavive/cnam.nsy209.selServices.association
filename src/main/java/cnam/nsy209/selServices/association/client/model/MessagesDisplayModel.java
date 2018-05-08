package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

@SuppressWarnings("serial")
public class MessagesDisplayModel extends Observable {
	
	/* Singleton */
	private static MessagesDisplayModel instance;
	public static MessagesDisplayModel get(List<MessageLocalDto> messages) {
		if(instance == null)
			instance = new MessagesDisplayModel(messages);
		
		return instance;
	}
	
	/* Constructor */
	private MessagesDisplayModel(List<MessageLocalDto> messages) {
		this.messages = messages;
	}
	
	/* Attributes */
	private List<MessageLocalDto> messages = new ArrayList<MessageLocalDto>();
	
	public void onSet(List<MessageLocalDto> messages) {
		this.messages = messages;

		notifyObservers();
	}
	
	/* getter */

	public List<MessageLocalDto> getMessages() {
		return messages;
	}

}
