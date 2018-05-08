package cnam.nsy209.selServices.association.client.model;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.Button;

import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class MenuModel extends Observable implements WaitingModel {
	
	/* Singleton */
	private static MenuModel instance;
	public static MenuModel get() {
		if(instance == null)
			instance = new MenuModel();
		
		return instance;
	}
	
	/* Constructor */
	private MenuModel() {
		activeButtons = new HashMap<Button,Boolean>();
		addObserver(DialogBoxWaiting.get(0, 0));
	}
	
	/* Attributes */
	private HashMap<Button,Boolean> activeButtons;
	private boolean waiting;
	
	public void onInitialise(List<Button> buttons) {
		for(Button button:buttons) {
			activeButtons.put(button,false);
		}
		
		waiting = false;

		notifyObservers();
	}	

	/* localize actived button */
	public void onActiveButton(Button button) {	
		if(button != null) {
			for(Button buttonInside:activeButtons.keySet()) {
				if(buttonInside == button) {			
					activeButtons.put(buttonInside,true);
					buttonInside.setEnabled(false);
				}
				else {
					activeButtons.put(buttonInside,false);
					buttonInside.setEnabled(true);
				}
			}
		}
		waiting = false;

		notifyObservers();
	}
	
	/* change values while looking for datas */
	public void onWaitingDisplay() {		
		waiting = true;
		
		notifyObservers();
	}
	
	/* getter */
	public HashMap<Button, Boolean> getActiveButtons() {
		return activeButtons;
	}

	public boolean isWaiting() {
		return waiting;
	}

}
