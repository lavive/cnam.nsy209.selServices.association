package cnam.nsy209.selServices.association.client.controler;

import cnam.nsy209.selServices.association.client.model.WealthSheetDisplayModel;

public class WealthSheetDisplayControler {
	
	/* Attributes */
//	private int width;
//	private int height;
	private WealthSheetDisplayModel model;
	
	/* Constructors */
	public WealthSheetDisplayControler(int width, int height) {
//		this.height = height;
//		this.width = width;
		this.model = WealthSheetDisplayModel.get();
	}
	
//	/* get the handler for add button */
//	public ClickHandler getAddClickHandler() {
//		ClickHandler clickHandler = new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {	
//				RootPanel.get().clear();
//				RootPanel.get().add(new TransactionEditPage(WealthSheetDisplayControler.this.width,
//						WealthSheetDisplayControler.this.height));
//			}
//		};
//		
//		return clickHandler;
//	}
	
	/* getter */

	public WealthSheetDisplayModel getModel() {
		return model;
	}
}