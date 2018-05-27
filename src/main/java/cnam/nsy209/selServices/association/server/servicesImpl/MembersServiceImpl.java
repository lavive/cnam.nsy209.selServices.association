package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.MembersService;
import cnam.nsy209.selServices.association.server.callable.CreateMemberCallable;
import cnam.nsy209.selServices.association.server.callable.DeleteMemberCallable;
import cnam.nsy209.selServices.association.server.callable.GetAllMembersCallable;
import cnam.nsy209.selServices.association.server.callable.GetLastMembersCallable;
import cnam.nsy209.selServices.association.server.callable.GetMemberCallable;
import cnam.nsy209.selServices.association.server.callable.GetMembersCallable;
import cnam.nsy209.selServices.association.server.callable.UpdateMemberCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.exception.EmptyMemberListException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the Member Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class MembersServiceImpl extends RemoteServiceServlet implements MembersService {

	@Override
	public List<MemberLocalDto> getMembers() {
		
		MembersDto members = null;
		try {
			members = new WebServiceCallable<MembersDto>(new GetAllMembersCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
		for(MemberDto member:members.getMembers()) {
			membersLocal.add(RemoteToLocal.toLocalMember(member));
		}
		
		return membersLocal;
	}

	@Override
	public List<MemberLocalDto> getLastMembers(int numberToDisplay) {
		
		MembersDto members = null;
		try {
			members = new WebServiceCallable<MembersDto>(new GetLastMembersCallable(numberToDisplay)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
		for(MemberDto member:members.getMembers()) {
			membersLocal.add(RemoteToLocal.toLocalMember(member));
		}
		
		return membersLocal;
	}

	@Override
	public List<MemberLocalDto> getMembers(MemberLocalDto member) throws EmptyMemberListException {
		
		MembersDto members = null;
		MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
		try {
			members = new WebServiceCallable<MembersDto>(new GetMembersCallable(memberRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MemberLocalDto> result = new ArrayList<MemberLocalDto>();
		for(MemberDto memb:members.getMembers()) {
			result.add(RemoteToLocal.toLocalMember(memb));
		}
		return result;
	}


	@Override
	public List<MemberLocalDto> create(MemberLocalDto member) throws AlReadyExistException,EmptyException {
		MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
		
		if(HelperServicesMethods.emptyMember(memberRemote)) 
			throw new EmptyException();
 	   	 

		
		MembersDto members = null;
		try {
			new WebServiceCallable<Void>(new CreateMemberCallable(memberRemote)).call();
			members = new WebServiceCallable<MembersDto>(new GetAllMembersCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
		for(MemberDto mem:members.getMembers()) {
			membersLocal.add(RemoteToLocal.toLocalMember(mem));
		}
		
		return membersLocal;
		
		
	}

	@Override
	public MemberLocalDto update(MemberLocalDto member) throws DoNotExistException {
		MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
		List<MemberDto> membersRemote = new ArrayList<MemberDto>();
		for(MemberLocalDto memb:getMembers()) {
			membersRemote.add(LocalToRemote.toRemoteMember(memb));
		}
		if(HelperServicesMethods.noExistMember(memberRemote,membersRemote))			
			throw new DoNotExistException();

		MemberDto newMember = null;
		try {

			newMember = new WebServiceCallable<MemberDto>(new UpdateMemberCallable(memberRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return RemoteToLocal.toLocalMember(newMember);
	}
	
	@Override
	public List<MemberLocalDto> delete(MemberLocalDto member) throws DoNotExistException {
		MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
		List<MemberDto> membersRemote = new ArrayList<MemberDto>();
		for(MemberLocalDto memb:getMembers()) {
			membersRemote.add(LocalToRemote.toRemoteMember(memb));
		}
		if(HelperServicesMethods.noExistMember(memberRemote,membersRemote)) 
			throw new DoNotExistException();

		MembersDto members = null;
		try {
			members = new WebServiceCallable<MembersDto>(new DeleteMemberCallable(memberRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
		for(MemberDto memb:members.getMembers()) {
			membersLocal.add(RemoteToLocal.toLocalMember(memb));
		}
		
		return membersLocal;
		
	}

	@Override
	public List<MemberLocalDto> delete(MemberLocalDto member, MemberLocalDto attributes) throws DoNotExistException {
		delete(member);
		List<MemberLocalDto> membersLocal = null;
		
		try {
			membersLocal = getMembers(attributes);
		} catch (EmptyMemberListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membersLocal;
	}

	@Override
	public List<MemberLocalDto> deleteLastMember(MemberLocalDto member, int numberToDisplay) throws DoNotExistException {
		delete(member);
		List<MemberLocalDto> membersLocal = getLastMembers(numberToDisplay);
		return membersLocal;
	}

	@Override
	public MemberLocalDto getMember(long id) {
		
		MemberDto member = null;
		try {
			member = new WebServiceCallable<MemberDto>(new GetMemberCallable(id)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return RemoteToLocal.toLocalMember(member);
	}

}
