package cnam.nsy209.selServices.association.client.view.page.concretePage.upBand;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MenuDemandsControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuDemandsModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class MenuDemands extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MenuDemands instance;
	public static MenuDemands get() {
		if(instance == null)
			instance = new MenuDemands((int)(0.78*WIDTH), (int)(0.25*HEIGHT));
		
		return instance;
	}

	/* Constructor */
	private MenuDemands(int width, int height) {
		super(width, height);
		this.controler = new MenuDemandsControler(width, height);
		this.controler.getModel().addObserver(this);
		this.supplies.addClickHandler(controler.getSuppliesClickHandler());
		this.controler.getModel().onInitialise();
//		this.back.addClickHandler(controler.getBackClickHandler());
	}

	/* Attribute */
	private MenuDemandsControler controler;
//	private Button back;
	private Button supplies;

	@Override
	public void update(Observable observable, Object object) {
		MenuDemandsModel menuDemandsModel = (MenuDemandsModel) observable;
		
		/* supplies button and waiting message */
		if(menuDemandsModel.isWaiting()) {
			supplies.setEnabled(false);
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			supplies.setEnabled(true);
//			if(this.waiting.isRunning())
//				this.waiting.stop();			
		}

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {

		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setHeight(height+"px");
		panel.setWidth(width+"px");
		panel.getElement().getStyle().setBackgroundColor(I18n.getI18nConstants().backgroundColor());
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setSpacing(5);
		/**********************************************************************************/

		/*********** Title Label **********************************************************/
		Label titleLabel = new Label();
		/* Style */
		titleLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		titleLabel.addStyleName("titleFont");
		/* Text */
		titleLabel.setText(I18n.getI18nConstants().demands());
		/**********************************************************************************/
		
		/*********** Buttons Panel ********************************************************/
		HorizontalPanel buttonPanel = new HorizontalPanel();
		/* Style */
		buttonPanel.setHeight(0.4*height+"px");
		buttonPanel.setWidth(width+"px");
		buttonPanel.getElement().getStyle().setBackgroundColor(I18n.getI18nConstants().backgroundColor());
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		HorizontalPanel buttonPanelInter = new HorizontalPanel();
		/* Style */
		buttonPanelInter.setHeight(0.4*height+"px");
		buttonPanelInter.setWidth(0.5*width+"px");
		buttonPanelInter.getElement().getStyle().setBackgroundColor(I18n.getI18nConstants().backgroundColor());
		buttonPanelInter.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);		
		/**********************************************************************************/

		/*********** Buttons **************************************************************/
//		back = new Button(I18n.getI18nConstants().back());
//		back.setStyleName("buttonHorizontalMenu");
		supplies = new Button(I18n.getI18nConstants().supplies());
		supplies.setStyleName("buttonHorizontalMenu");

		int buttonWidth = (int) (width*0.16);
//		back.setWidth(buttonWidth+"px");
		supplies.setWidth(buttonWidth+"px");
		/**********************************************************************************/

		/********** Fill Main Panel *******************************************************/
		buttonPanelInter.add(supplies);
//		buttonPanelInter.add(back);
		buttonPanel.add(buttonPanelInter);
		
		panel.add(titleLabel);
		panel.add(buttonPanel);
		/**********************************************************************************/
		
		return panel;
		
	}

}
