package cnam.nsy209.selServices.association.client.view.page.concretePage.upBand;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MenuMemberMainControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class MenuMemberMain extends AbstractPage implements Observer {	
	
	/* Singleton */
	private static MenuMemberMain instance;
	public static MenuMemberMain get() {
		if(instance == null)
			instance = new MenuMemberMain((int)(0.78*WIDTH), (int)(0.25*HEIGHT));
		
		return instance;
	}

	/* Constructor */
	private MenuMemberMain(int width, int height) {
		super(width, height);
	}

	/* Attribute */
	private MenuMemberMainControler controler;

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {
		
		controler = new MenuMemberMainControler(width, height);
		
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
		titleLabel.setText(I18n.getI18nMessages().homeMember());
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
		Button search = new Button(I18n.getI18nConstants().search());
		search.setStyleName("buttonHorizontalMenu");
		search.addClickHandler(controler.getSearchClickHandler());
		Button add = new Button(I18n.getI18nConstants().add());
		add.setStyleName("buttonHorizontalMenu");
		add.addClickHandler(controler.getAddClickHandler());
		
		int buttonWidth = (int) (width*0.16);
		search.setWidth(buttonWidth+"px");
		add.setWidth(buttonWidth+"px");		
		/**********************************************************************************/
		
		/********** Fill Main Panel *******************************************************/
		buttonPanelInter.add(search);
		buttonPanelInter.add(add);
		buttonPanel.add(buttonPanelInter);
		
		panel.add(titleLabel);
		panel.add(buttonPanel);
		/**********************************************************************************/
		
		return panel;
		
	}

}
