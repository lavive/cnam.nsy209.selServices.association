package cnam.nsy209.selServices.association.server.servicesImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.AssociationService;
import cnam.nsy209.selServices.association.server.callable.GetAssociationCallable;
import cnam.nsy209.selServices.association.server.callable.UpdateAssociationCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.shared.exception.AssociationException;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;

@SuppressWarnings("serial")
public class AssociationServiceImpl extends RemoteServiceServlet implements AssociationService {

	@Override
	public void upDate(AssociationLocalDto association) throws AssociationException{
//		if(association == null) throw new AssociationException();
//		AssociationTable.update(association);
		AssociationDto associationRemote = LocalToRemote.toRemoteAssociation(association);
		try {
			new WebServiceCallable<Void>(new UpdateAssociationCallable(associationRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AssociationLocalDto getAssociation()  {
//		Properties props = new Properties(); 
//    	props.put("java.naming.factory.initial","com.sun.enterprise.naming.impl.SerialInitContextFactory");
//    	props.put("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
//    	props.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//	   	InitialContext context = null;
//		ServicesDao services = null;
//		try {
//			context = new InitialContext(props);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   	 try {
//			services = (ServicesDao)context.lookup("java:global/selServices.server/ServicesDaoBean!services.remote.ServicesDao") ;
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   	return transformToLocal(services.getAssociation());
//		return AssociationTable.get();
		AssociationLocalDto association = null;
		try {
			AssociationDto associationRemote
								= new WebServiceCallable<AssociationDto>(new GetAssociationCallable()).call();
			association = RemoteToLocal.toLocalAssociation(associationRemote);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return association;
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
