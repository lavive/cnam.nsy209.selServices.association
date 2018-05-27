package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.AuthenticationService;
import cnam.nsy209.selServices.association.server.callable.CheckIdsCallable;
import cnam.nsy209.selServices.association.server.callable.GetAssociationCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.shared.exception.AuthenticationException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the Authentication Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements AuthenticationService {
	


	@Override
	public List<MemberLocalDto> checkIds(String login, String password, int numberToDisplay)  throws AuthenticationException{
		if(login == null || password == null) throw new AuthenticationException();
		
		MembersDto members = null;
		try {
			members = new WebServiceCallable<MembersDto>(new CheckIdsCallable(login,password,numberToDisplay)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (members == null) throw new AuthenticationException();
		
		List<MemberLocalDto> membersLocal = new ArrayList<MemberLocalDto>();
		for(MemberDto member:members.getMembers()) {
			membersLocal.add(RemoteToLocal.toLocalMember(member));
		}
		
		return membersLocal;
	}

	@Override
	public String getName() {
		

		AssociationDto association = null;
		try {
			association = new WebServiceCallable<AssociationDto>(new GetAssociationCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return association.getName();
	}

	@Override
	public String getAssociation() {

		AssociationDto association = null;
		try {
			association = new WebServiceCallable<AssociationDto>(new GetAssociationCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return association.getName()+" - "+association.getAddress()+" - "+association.getPostalCode()+
				" "+association.getTown()+" - "+association.getEmail()+" - "+association.getCellNumber()+
				" - "+association.getPhoneNumber()+" - "+association.getWebsite();
	}
}
