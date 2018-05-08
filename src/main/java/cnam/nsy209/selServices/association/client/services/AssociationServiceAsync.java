package cnam.nsy209.selServices.association.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

public interface AssociationServiceAsync {
	public void upDate(AssociationLocalDto association, AsyncCallback<Void> callback);
	public void getAssociation(AsyncCallback<AssociationLocalDto> callback);

}
