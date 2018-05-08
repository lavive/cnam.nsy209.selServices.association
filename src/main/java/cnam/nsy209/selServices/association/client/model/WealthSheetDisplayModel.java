package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

@SuppressWarnings("serial")
public class WealthSheetDisplayModel extends Observable {
	
	/* Singleton */
	private static WealthSheetDisplayModel instance;
	public static WealthSheetDisplayModel get() {
		if(instance == null)
			instance = new WealthSheetDisplayModel();
		
		return instance;
	}
	
	/* Constructor */
	private WealthSheetDisplayModel() {}
	
	/* Attributes */
	private WealthSheetLocalDto wealthSheet;
	
	public void onSet(WealthSheetLocalDto wealthSheet) {
		this.wealthSheet = wealthSheet;

		notifyObservers();
	}
	
	/* getter */

	public WealthSheetLocalDto getWealthSheet() {
		return wealthSheet;
	}

}
