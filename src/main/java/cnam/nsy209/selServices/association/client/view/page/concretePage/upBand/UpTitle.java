package cnam.nsy209.selServices.association.client.view.page.concretePage.upBand;

import java.util.HashMap;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class UpTitle extends AbstractPage {
	
	/* Singleton */
	private static HashMap<EnumMenuHorizontal,UpTitle> instance = 
								new HashMap<EnumMenuHorizontal,UpTitle>();
	public static UpTitle get(final EnumMenuHorizontal enumMenuHorizontal) {
		if(instance.get(enumMenuHorizontal) == null)
			create(enumMenuHorizontal);
		
		return instance.get(enumMenuHorizontal);
	}
	
	private static void create(EnumMenuHorizontal enumMenu) {
		if(enumMenu.equals(EnumMenuHorizontal.ASSOCIATION_DISPLAY)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().associationDatas()));
		}
		if(enumMenu.equals(EnumMenuHorizontal.CATEGORIES_DISPLAY)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nConstants().categories()));
		}
		if(enumMenu.equals(EnumMenuHorizontal.MESSAGES_DISPLAY)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().messagesMembers()));
		}
		if(enumMenu.equals(EnumMenuHorizontal.FAST_MESSAGE)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().fastMessage()));
		}
		if(enumMenu.equals(EnumMenuHorizontal.HOME)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nConstants().home()));
		}
		if(enumMenu.equals(EnumMenuHorizontal.TRANSACTION_EDIT)) {
			instance.put(enumMenu, new UpTitle((int)(0.78*WIDTH), (int)(0.25*HEIGHT),
					I18n.getI18nMessages().addTransaction()));
		}
	}

	/* Constructor */
	private UpTitle(int width, int height,String title) {
		super(width, height,title);
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
		
		/********** Fill Main Panel *******************************************************/
		
		panel.add(titleLabel);
		/**********************************************************************************/
		
		return panel;
		
	}
//	
//	/* nested enum to limit instance of MenuHorizontal */
//	public static enum EnumMenuHorizontal{
//		ASSOCIATION_DISPLAY,
//		CATEGORIES_DISPLAY,
//		MESSAGES_DISPLAY;
//	}

}
