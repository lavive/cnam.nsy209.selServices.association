package cnam.nsy209.selServices.association.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.AssociationException;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

@RemoteServiceRelativePath("AssociationService")
public interface AssociationService extends RemoteService {
	public AssociationLocalDto getAssociation();
	public void upDate(AssociationLocalDto association) throws AssociationException;
}
