package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
/** 
 * 
 * Interface which calls Member service
 * 
 * @author lavive
 *
 */
public interface MembersServiceAsync {
	public void getMembers(AsyncCallback<List<MemberLocalDto>> callback);
	public void getLastMembers(int numberToDisplay,AsyncCallback<List<MemberLocalDto>> callback);
	public void getMembers(MemberLocalDto member,AsyncCallback<List<MemberLocalDto>> callback);
	public void delete(MemberLocalDto member,AsyncCallback<List<MemberLocalDto>> callback);
	public void delete(MemberLocalDto member, MemberLocalDto attributes, AsyncCallback<List<MemberLocalDto>> callback);
	public void deleteLastMember(MemberLocalDto member,int numberToDisplay,AsyncCallback<List<MemberLocalDto>> callback);
	public void create(MemberLocalDto member,AsyncCallback<List<MemberLocalDto>> callback);
	public void update(MemberLocalDto member,AsyncCallback<MemberLocalDto> callback);
	public void getMember(long id,AsyncCallback<MemberLocalDto> callback);
}
