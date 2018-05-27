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
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the Association Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class AssociationServiceImpl extends RemoteServiceServlet implements AssociationService {

	@Override
	public void upDate(AssociationLocalDto association) throws AssociationException{
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

}
