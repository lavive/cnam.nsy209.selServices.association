package cnam.nsy209.selServices.association.client.view.page;

import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * Interface to abstract pages to display
 * 
 * Extends Observer because a page changes when corresponding model changes
 * Need a display strategy to display
 *
 */
public interface IPage /*extends Observer*/ {
	
	public Widget layout();

}
