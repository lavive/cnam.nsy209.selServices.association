package cnam.nsy209.selServices.association.client.view.page.concretePage.upBand;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MenuHorizontalControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MenuHorizontal extends AbstractPage implements Observer {
	
	/* Singleton */
	private static HashMap<EnumMenuHorizontal,MenuHorizontal> instance = 
								new HashMap<EnumMenuHorizontal,MenuHorizontal>();
	public static MenuHorizontal get(final EnumMenuHorizontal enumMenuHorizontal,final MemberLocalDto attributes) {
		if(instance.get(enumMenuHorizontal) == null)
			create(enumMenuHorizontal, attributes);
		
		return instance.get(enumMenuHorizontal);
	}
	
	private static void create(EnumMenuHorizontal enumMenu, MemberLocalDto attributes) {
		if(enumMenu.equals(EnumMenuHorizontal.ASSOCIATION_DISPLAY)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().associationDatas(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.ASSOCIATION_EDIT)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().associationDatasUpdate(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.CATEGORIES_DISPLAY)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nConstants().categories(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.CATEGORY_EDIT)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().addCategory(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MEMBER_CARD)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().cardMember(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MEMBER_CREATE)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().editMember(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MEMBER_EDIT)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().editMember(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MEMBER_RESEARCH)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().searchMember(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MEMBER_RESEARCH_RESULT)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().resultMember(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MESSAGES_DISPLAY)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().messagesMembers(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.TRANSACTION_EDIT)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().addTransaction(),enumMenu,attributes));
		}
		if(enumMenu.equals(EnumMenuHorizontal.WEALTHSHEET_DISPLAY)) {
			instance.put(enumMenu, new MenuHorizontal((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().transactions(),enumMenu,attributes));
		}
	}

	/* Constructor */
	private MenuHorizontal(int width, int height,String title,EnumMenuHorizontal enumMenu, MemberLocalDto attributes) {
		super(width, height,title);
		addBackClickHandler(width, height,enumMenu, attributes);
	}

	/* Attribute */
	private MenuHorizontalControler controler;	
	private Button back;

	@Override
	public void update(Observable observable, Object object) {
		MenuHorizontalModel menuHorizontalModel = (MenuHorizontalModel) observable;		
		/* validate button and waiting message */
		if(menuHorizontalModel.isWaiting()) {
			back.setEnabled(false);
		} else {
			back.setEnabled(true);		
		}
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height,title));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height,String title) {
				
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
		titleLabel.setText(title);
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
		back = new Button(I18n.getI18nConstants().back());
		back.setStyleName("buttonHorizontalMenu");
		
		int buttonWidth = (int) (width*0.16);
		back.setWidth(buttonWidth+"px");
		/**********************************************************************************/
		
		/********** Fill Main Panel *******************************************************/
		buttonPanelInter.add(back);
		buttonPanel.add(buttonPanelInter);
		
		panel.add(titleLabel);
		panel.add(buttonPanel);
		/**********************************************************************************/

		return panel;
		
	}
	
	private void addBackClickHandler(int width, int height,EnumMenuHorizontal enumMenu, MemberLocalDto attributes) {
		controler = new MenuHorizontalControler(width,height,enumMenu,attributes);
		controler.getModel().addObserver(this);
		controler.getModel().onInitialise();
		back.addClickHandler(controler.getBackClickHandler());
	}
	

}
