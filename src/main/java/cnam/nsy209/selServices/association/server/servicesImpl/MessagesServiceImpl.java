package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.MessagesService;
import cnam.nsy209.selServices.association.server.callable.AddMessageCallable;
import cnam.nsy209.selServices.association.server.callable.DeleteMessageCallable;
import cnam.nsy209.selServices.association.server.callable.GetMessagesCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.MessageDto;
import cnam.nsy209.selServices.association.server.dto.MessagesDto;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;

@SuppressWarnings("serial")
public class MessagesServiceImpl extends RemoteServiceServlet implements MessagesService {

	@Override
	public List<MessageLocalDto>  add(MessageLocalDto message) throws EmptyException {
		if (message.getText() == null || message.getText().trim().equals("")) throw new EmptyException();
		
		MessagesDto messages = null;
		MessageDto messageRemote = LocalToRemote.toRemoteMessage(message);
		
		try {
			new WebServiceCallable<Void>(new AddMessageCallable(messageRemote)).call();
			messages = new WebServiceCallable<MessagesDto>(new GetMessagesCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MessageLocalDto> messagesLocal = new ArrayList<MessageLocalDto>();
		for(MessageDto msg:messages.getMessages()) {
			messagesLocal.add(RemoteToLocal.toLocalMessage(msg));
		}
		return messagesLocal;
	
//		MessageTable.add(message);
	}

	@Override
	public List<MessageLocalDto> getMessages() {
		
		MessagesDto messages = null;
		try {
			messages = new WebServiceCallable<MessagesDto>(new GetMessagesCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MessageLocalDto> messagesLocal = new ArrayList<MessageLocalDto>();
		for(MessageDto message:messages.getMessages()) {
			messagesLocal.add(RemoteToLocal.toLocalMessage(message));
		}
		return messagesLocal;
				
//		return MessageTable.getMessages();
	}

	@Override
	public List<MessageLocalDto> delete(MessageLocalDto message) throws DoNotExistException {
		boolean exist = false;
		for(MessageLocalDto messageCursor:getMessages()) {
			if(messageCursor.getId().longValue() == message.getId().longValue()) exist = true;
		}
		if(!exist) throw new DoNotExistException();

		MessagesDto messages = null;
		try {
			MessageDto messageRemote = LocalToRemote.toRemoteMessage(message);
			messages = new WebServiceCallable<MessagesDto>(new DeleteMessageCallable(messageRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MessageLocalDto> messagesLocal = new ArrayList<MessageLocalDto>();
		for(MessageDto mess:messages.getMessages()) {
			messagesLocal.add(RemoteToLocal.toLocalMessage(mess));
		}
		return messagesLocal;
		
		
//		return MessageTable.delete(message);
	}

}
