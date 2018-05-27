package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.exception.EmptyMemberListException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
/** 
 * 
 * Interface which calls Member service
 * 
 * @author lavive
 *
 */
@RemoteServiceRelativePath("MembersService")
public interface MembersService extends RemoteService {
	public List<MemberLocalDto> getMembers();
	public List<MemberLocalDto> getLastMembers(int numberToDisplay);
	public List<MemberLocalDto> getMembers(MemberLocalDto member) throws EmptyMemberListException;
	public List<MemberLocalDto> delete(MemberLocalDto member) throws DoNotExistException;
	public List<MemberLocalDto> delete(MemberLocalDto member, MemberLocalDto attributes) throws DoNotExistException;
	public List<MemberLocalDto> deleteLastMember(MemberLocalDto member,int numberToDisplay) throws DoNotExistException;
	public List<MemberLocalDto> create(MemberLocalDto member) throws AlReadyExistException,EmptyException;
	public MemberLocalDto update(MemberLocalDto member) throws DoNotExistException;
	public MemberLocalDto getMember(long id);
}
