package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class MenuSuppliesModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static MenuSuppliesModel instance;
	public static MenuSuppliesModel get() {
		if(instance == null)
			instance = new MenuSuppliesModel();
		
		return instance;
	}
	
	/* Constructor */
	private MenuSuppliesModel() {
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* Attributes */
	private boolean waiting;
	
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

}
