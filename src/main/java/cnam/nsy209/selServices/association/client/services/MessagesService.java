package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;
/** 
 * 
 * Interface which calls Message service
 * 
 * @author lavive
 *
 */
@RemoteServiceRelativePath("MessagesService")
public interface MessagesService extends RemoteService {
	public List<MessageLocalDto>  add(MessageLocalDto message) throws EmptyException;
	public List<MessageLocalDto> getMessages();
	public List<MessageLocalDto> delete(MessageLocalDto message) throws DoNotExistException;

}
