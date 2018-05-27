package cnam.nsy209.selServices.association.client.view.strategy;

import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * Interface to abstract display strategies to implement
 *
 */

public interface IDisplayStrategy {
	
	public Widget display();
	
	public void addPanel(Widget panel);

}
