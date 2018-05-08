package cnam.nsy209.selServices.association.client.view.page.concretePage.upBand;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MenuSuppliesControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuSuppliesModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class MenuSupplies extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MenuSupplies instance;
	public static MenuSupplies get() {
		if(instance == null)
			instance = new MenuSupplies((int)(0.78*WIDTH), (int)(0.25*HEIGHT));
		
		return instance;
	}

	/* Constructor */
	private MenuSupplies(int width, int height) {
		super(width, height);
		this.controler = new MenuSuppliesControler(width, height);
		this.controler.getModel().addObserver(this);
		this.button.addClickHandler(controler.getDemandsClickHandler());
		this.controler.getModel().onInitialise();
	}

	/* Attribute */
	private MenuSuppliesControler controler;
	private Button button;

	@Override
	public void update(Observable observable, Object object) {
		MenuSuppliesModel menuSuppliesModel = (MenuSuppliesModel) observable;
		
		/* supplies button and waiting message */
		if(menuSuppliesModel.isWaiting()) {
			button.setEnabled(false);
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			button.setEnabled(true);
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
		titleLabel.setText(I18n.getI18nConstants().supplies());
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
//		Button back = new Button(I18n.getI18nConstants().back());
//		back.setStyleName("buttonHorizontalMenu");
		Button demands = new Button(I18n.getI18nConstants().demands());
		demands.setStyleName("buttonHorizontalMenu");
		
		int buttonWidth = (int) (width*0.16);
//		back.setWidth(buttonWidth+"px");
		demands.setWidth(buttonWidth+"px");
		this.button = demands;
		/**********************************************************************************/
		
		/********** Fill Main Panel *******************************************************/
		buttonPanelInter.add(demands);
//		buttonPanelInter.add(back);
		buttonPanel.add(buttonPanelInter);
		
		panel.add(titleLabel);
		panel.add(buttonPanel);
		/**********************************************************************************/
		
		return panel;
		
	}

}
