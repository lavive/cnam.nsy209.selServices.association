package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

@SuppressWarnings("serial")
public class MembersDisplayModel extends Observable {
	
	/* Singleton */
	private static MembersDisplayModel instance;
	public static MembersDisplayModel get(List<MemberLocalDto> members) {
		if(instance == null)
			instance = new MembersDisplayModel(members);
		
		return instance;
	}
	
	/* Constructor */
	private MembersDisplayModel(List<MemberLocalDto> members) {
		this.members = members;
	}
	
	/* Attributes */
	private List<MemberLocalDto> members = new ArrayList<MemberLocalDto>();
	
	public void onSet(List<MemberLocalDto> members) {
		this.members = members;

		notifyObservers();
	}
	
	/* getter */

	public List<MemberLocalDto> getMembers() {
		return members;
	}

}
