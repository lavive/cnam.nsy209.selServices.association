package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

@SuppressWarnings("serial")
public class MenuHorizontalModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static MenuHorizontalModel instance;
	public static MenuHorizontalModel get(MemberLocalDto attributes) {
		if(instance == null)
			instance = new MenuHorizontalModel(attributes);
		
		return instance;
	}
	
	/* Constructor */
	private MenuHorizontalModel(MemberLocalDto attributes) {
		waiting = false;
		this.attributes = attributes;
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* Attributes */
	private boolean waiting;
	private MemberLocalDto attributes;
	
	public void onInitialise() {
		
		waiting = false;

		notifyObservers();
	}	
	
	/* change values while looking for datas */
	public void onWaitingDisplay() {		
		waiting = true;
		
		notifyObservers();
	}
	
	/* getter */

	public boolean isWaiting() {
		return waiting;
	}

	public MemberLocalDto getAttributes() {
		return attributes;
	}

}
