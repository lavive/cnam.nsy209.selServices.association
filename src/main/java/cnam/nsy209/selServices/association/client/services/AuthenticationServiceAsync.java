package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public interface AuthenticationServiceAsync {
	void checkIds(String login, String password, int numberToDisplay, AsyncCallback<List<MemberLocalDto>> callback);
	public void getName(AsyncCallback<String> callback);
	public void getAssociation(AsyncCallback<String> callback);
}
