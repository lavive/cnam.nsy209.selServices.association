package cnam.nsy209.selServices.association.client.view.strategy;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainDisplayStrategy implements IDisplayStrategy {
	
	/* Attributes */
	private Widget logo;
	private Widget upBand;
	private Widget menu;
	private Widget mainWidget;
	private Widget bottomBand;	
	private Widget buildWidget;
	
	/* Constructors */
	public MainDisplayStrategy(Widget logo, Widget upBand, Widget menu, Widget mainWidget, Widget bottomBand) {
		super();
		this.logo = logo;
		this.upBand = upBand;
		this.menu = menu;
		this.mainWidget = mainWidget;
		this.bottomBand = bottomBand;
	}
	public MainDisplayStrategy() {
		this(null,null,null,null,null);
	}
	public MainDisplayStrategy(Widget logo) {
		this(logo,null,null,null,null);
	}
	public MainDisplayStrategy(Widget logo, Widget upBand) {
		this(logo,upBand,null,null,null);
	}
	public MainDisplayStrategy(Widget logo, Widget upBand, Widget menu) {
		this(logo,upBand,menu,null,null);
	}
	public MainDisplayStrategy(Widget logo, Widget upBand, Widget menu, Widget mainWidget) {
		this(logo,upBand,menu,mainWidget,null);
	}
	

	@Override
	public Widget display() {
		return buildWidget;
	}

	@Override
	public void addPanel(Widget panel) {
		/*************** Panels **************************************************************************/
		VerticalPanel mainPanel = new VerticalPanel();
		HorizontalPanel hPanel1 = new HorizontalPanel();
		HorizontalPanel hPanel2 = new HorizontalPanel();
		HorizontalPanel hPanel3 = new HorizontalPanel();
		/*************************************************************************************************/
		
		/*************** inits panels ********************************************************************/
		if(logo == null) 
			logo = panel;
		else if(upBand == null)
			upBand = panel;
		else if(menu == null)
			menu = panel;
		else if(mainWidget == null)
			mainWidget = panel;
		else if(bottomBand == null)
			bottomBand = panel;
		/*************************************************************************************************/

		/*************** display panels ******************************************************************/
		if(logo != null)
			hPanel1.add(logo);
		if(upBand != null) 
			hPanel1.add(upBand);
		if(menu != null)
			hPanel2.add(menu);
		if(mainWidget != null)
			hPanel2.add(mainWidget);
		if(bottomBand != null)
			hPanel3.add(bottomBand);
		
		mainPanel.add(hPanel1);
		mainPanel.add(hPanel2);
		mainPanel.add(hPanel3);
		/*************************************************************************************************/
 
		buildWidget = mainPanel;
	}

}
