package cnam.nsy209.selServices.association.client.view.strategy;

import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * Concrete display strategy: display a single page
 *
 */

public class SingleDisplayStrategy implements IDisplayStrategy {
	
	/* Attributes */
	
	private Widget panel;
	
	
	/* Methods */	

	@Override
	public Widget display() {
		return this.panel;
	}

	@Override
	public void addPanel(Widget panel) {

		this.panel = panel;
		
	}

}
