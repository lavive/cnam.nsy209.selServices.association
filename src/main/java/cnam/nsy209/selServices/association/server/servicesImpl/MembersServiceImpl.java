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
//		return MemberTable.getLastMembers(numberToDisplay);
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
//		if (HelperServicesMethods.getMembers(memberRemote,members.getMembers()).isEmpty())
//			throw new EmptyMemberListException();
//		else {
//			List<MemberDto> membersRemote =
//						HelperServicesMethods.getMembers(memberRemote,members.getMembers());
//			List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
//			for(MemberDto memb:membersRemote) {
//				membersLocal.add(RemoteToLocal.toLocalMember(memb));
//			}
//			
//			return membersLocal;
//		}
		List<MemberLocalDto> result = new ArrayList<MemberLocalDto>();
		for(MemberDto memb:members.getMembers()) {
			result.add(RemoteToLocal.toLocalMember(memb));
		}
		return result;
	}

//	@Override
//	public List<MemberDto> delete(MemberDto member,List<MemberDto> members) throws DoNotExistException {
//		if(noExistMember(member,members)) throw new DoNotExistException();
//		return MemberTable.delete(member,members);
//	}

	@Override
	public List<MemberLocalDto> create(MemberLocalDto member) throws AlReadyExistException,EmptyException {
		MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
//		DialogBox test = new DialogBox();
//		test.setText("3id: "+memberRemote.getId()+ ": "+memberRemote);
//		test.show();
		
		if(HelperServicesMethods.emptyMember(memberRemote)) 
			throw new EmptyException();
		
//		List<MemberDto> membersRemote = new ArrayList<MemberDto>();
//		for(MemberLocalDto memb:getMembers()) {
//			membersRemote.add(LocalToRemote.toRemoteMember(memb));
//		}
//		if(HelperServicesMethods.existMember(memberRemote,membersRemote)) 
//			throw new AlReadyExistException(member.getFullName());
 	   	 

		
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
		
		
		
		
//		MemberTable.create(member);
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
//			System.out.println("2id: "+memberRemote.getId()+ ": "+memberRemote);
//			DialogBox test = new DialogBox();
//			test.setText("2id: "+memberRemote.getId()+ ": "+memberRemote);
//			test.show();
			newMember = new WebServiceCallable<MemberDto>(new UpdateMemberCallable(memberRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			new WebServiceCallable<MemberDto>(new GetMemberCallable(member.getId())).call();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return RemoteToLocal.toLocalMember(newMember);
//		return MemberTable.update(member);
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
		
		//return MemberTable.delete(member);
	}

	@Override
	public List<MemberLocalDto> delete(MemberLocalDto member, MemberLocalDto attributes) throws DoNotExistException {
		delete(member);
		//MembersDto members = new MembersDto();
		List<MemberLocalDto> membersLocal = null;
		
		try {
			membersLocal = getMembers(attributes);
			//members.setMembers(getMembers(attributes));
		} catch (EmptyMemberListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membersLocal;//members.getMembers();
//		if(HelperServicesMethods.noExistMember(member,MemberTable.getMembers())) throw new DoNotExistException();
//		return MemberTable.delete(member,attributes);
	}

	@Override
	public List<MemberLocalDto> deleteLastMember(MemberLocalDto member, int numberToDisplay) throws DoNotExistException {
		delete(member);
//		MembersDto members = new MembersDto();
//		members.setMembers(getLastMembers(numberToDisplay));
		List<MemberLocalDto> membersLocal = getLastMembers(numberToDisplay);
		return membersLocal;//members.getMembers();
//		if(HelperServicesMethods.noExistMember(member,MemberTable.getMembers())) throw new DoNotExistException();
//		return MemberTable.deleteLastMember(member,numberToDisplay);
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
