package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

@SuppressWarnings("serial")
public class MembersResearchResultModel extends Observable {
	
	/* Singleton */
	private static MembersResearchResultModel instance;
	public static MembersResearchResultModel get() {
		if(instance == null)
			instance = new MembersResearchResultModel();
		
		return instance;
	}
	
	/* Constructor */
	private MembersResearchResultModel() {}
	
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
