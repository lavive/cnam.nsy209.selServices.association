package cnam.nsy209.selServices.association.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.page.concretePage.IdHome;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Association implements EntryPoint {
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		int width = Window.getClientWidth();
		int height = Window.getClientHeight();
		DialogBoxWaiting.get((int)(width*0.33),(int)(height*0.25));
		RootPanel.get().add(IdHome.get(I18n.getI18nConstants().authentication()));
		
	}
}