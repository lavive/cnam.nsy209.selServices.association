package cnam.nsy209.selServices.association.client.controler;

import cnam.nsy209.selServices.association.client.model.WealthSheetDisplayModel;

public class WealthSheetDisplayControler {
	
	/* Attributes */
	private WealthSheetDisplayModel model;
	
	/* Constructors */
	public WealthSheetDisplayControler(int width, int height) {
		this.model = WealthSheetDisplayModel.get();
	}
	
	
	/* getter */

	public WealthSheetDisplayModel getModel() {
		return model;
	}
}