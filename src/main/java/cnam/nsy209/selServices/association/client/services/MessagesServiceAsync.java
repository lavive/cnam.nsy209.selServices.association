package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;
/** 
 * 
 * Interface which calls Message service
 * 
 * @author lavive
 *
 */
public interface MessagesServiceAsync {
	public void add(MessageLocalDto message,AsyncCallback<List<MessageLocalDto> > callback);
	public void getMessages(AsyncCallback<List<MessageLocalDto>> callback);
	public void delete(MessageLocalDto message,AsyncCallback<List<MessageLocalDto>> callback);
}
