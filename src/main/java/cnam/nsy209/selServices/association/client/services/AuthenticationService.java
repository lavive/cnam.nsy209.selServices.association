package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.AuthenticationException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

@RemoteServiceRelativePath("AuthenticationService")
public interface AuthenticationService extends RemoteService {
	public List<MemberLocalDto> checkIds(String login,String password, int numberToDisplay) throws AuthenticationException;
	public String getName();
	public String getAssociation();
}
