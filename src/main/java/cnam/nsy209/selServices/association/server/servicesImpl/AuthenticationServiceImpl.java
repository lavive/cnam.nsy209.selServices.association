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

@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements AuthenticationService {
	
//	@EJB
//	private ServicesRemote services;
	
//	private static Properties props;
//	private static InitialContext context = null;
//	private static ServicesRemote services = null;
//	private static String error ="";
//	
//	static /*String getServices() */{ 
//		props = new Properties();
//		props.put("java.naming.factory.initial","com.sun.enterprise.naming.impl.SerialInitContextFactory");
//		props.put("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
//		props.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//		try {
//			context = new InitialContext();//props);
//			error += "context: "+context.listBindings("");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			error += "context error: "+e.getMessage()+"|";
//			e.printStackTrace();
//			
//		} 
//		try {
//			error+="|_|";
//			services = (ServicesRemote)context.lookup("ServicesRemoteBean");//"ejb:/selServices.server/ServicesDaoBean!services.remote.ServicesDao");
//			error+="|_|";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			error += "lookup: "+e.getMessage();
//			e.printStackTrace();
//			
//		}
//		
//	}

	@Override
	public List<MemberLocalDto> checkIds(String login, String password, int numberToDisplay)  throws AuthenticationException{
		if(login == null || password == null) throw new AuthenticationException();
		
//		String loginResult = "test";// DataBase.get("login");
//		String passwordResult = "testtest";//DataBase.get("password");
//		
//		if(loginResult.equals(login) && passwordResult.equals(password)) {
//
//			return MemberTable.getLastMembers(numberToDisplay);
//		}
//		else throw new AuthenticationException();
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
		
//		return "TEST";//DataBase.get("name");

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
//		AssociationLocalDto association = AssociationTable.get();
//		return association.getName()+" - "+association.getAddress()+" - "+association.getPostalCode()+
//				" "+association.getTown()+" - "+association.getEmail()+" - "+association.getCellNumber()+
//				" - "+association.getPhoneNumber()+" - "+association.getWebsite();
//		
//	   	 return ": service: "+services;//+" ,error: "+error;
//		return services.getAssociation().getName();

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


	
//	private static AssociationLocalDto transformToLocal(AssociationDto associationDto) {
//		AssociationLocalDto associationLocalDto = new AssociationLocalDto();
//		associationLocalDto = new AssociationLocalDto();
//		associationLocalDto.setAddress(associationDto.getAddress());
//		associationLocalDto.setName(associationDto.getName());
//		associationLocalDto.setWebsite(associationDto.getWebsite());
//		associationLocalDto.setPostalCode(associationDto.getPostalCode());
//		associationLocalDto.setTown(associationDto.getTown());
//		associationLocalDto.setCellNumber(associationDto.getCellNumber());
//		associationLocalDto.setPhoneNumber(associationDto.getPhoneNumber());
//		associationLocalDto.setEmail(associationDto.getEmail());
//		associationLocalDto.setPassword("P7sw0rd");
//		
//		return associationLocalDto;
//	}
}
