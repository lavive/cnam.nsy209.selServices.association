package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;

import cnam.nsy209.selServices.association.client.asyncCallback.SupplyDemandAsyncCallback;
import cnam.nsy209.selServices.association.client.model.MenuSuppliesModel;
import cnam.nsy209.selServices.association.shared.localDto.EnumSupplyDemandDto;

public class MenuSuppliesControler {
	
	/* Attributes */
	private int width;
	private int height;
	private MenuSuppliesModel model;
	
	/* Constructors */
	public MenuSuppliesControler(int width, int height) {
		this.model = MenuSuppliesModel.get();
		this.height = height;
		this.width = width;
	}
	
	/* get the handler for Demands button */
	public ClickHandler getDemandsClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onWaitingDisplay();
				Timer t = new Timer() {
					@Override
					public void run() {
						SupplyDemandAsyncCallback callback = new SupplyDemandAsyncCallback(width,height);
						callback.getSuppliesDemands(EnumSupplyDemandDto.DEMAND.getWording(), null);
					}
				};
				t.schedule(0);
//				RootPanel.get().clear();
//				RootPanel.get().add(new DemandsDisplayPage(MenuSuppliesControler.this.width,
//						MenuSuppliesControler.this.height));
			}
		};
		
		return clickHandler;
	}

	/* getter */
	public MenuSuppliesModel getModel() {
		return model;
	}
	
//	/* get the handler for back button */
//	public ClickHandler getBackClickHandler() {
//		ClickHandler clickHandler = new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {	
//				RootPanel.get().clear();
//				RootPanel.get().add(null);
//			}
//		};
//		
//		return clickHandler;
//	}
}