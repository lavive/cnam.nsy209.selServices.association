package cnam.nsy209.selServices.association.client.view.page.concretePage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class Menu extends AbstractPage implements Observer {	
	
	/* Singleton */
	private static Menu instance;
	public static Menu get() {
		if(instance == null)
			instance = new Menu((int)(0.2*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}
	
	/* Attribute */
	private MenuControler controler;

	/* Constructor */
	private Menu(int width,int height) {
		super(width,height);
	}

	@Override
	public void update(Observable observable, Object object) {
		MenuModel menuModel = (MenuModel) observable;
		/* active and desactive buttons */
		for(Button button:menuModel.getActiveButtons().keySet()) {
			if(menuModel.getActiveButtons().get(button)) {
				controler.setActivedButton(button);
				button.setStyleName("buttonMenuCliked");
			}
			else
				button.setStyleName("buttonMenu");
		}		
		/* validate button and waiting message */
		if(menuModel.isWaiting()) {
			for(Button button:menuModel.getActiveButtons().keySet()) {
				button.setEnabled(false);
			}
		} else {
			for(Button button:menuModel.getActiveButtons().keySet()) {
				if(button != controler.getActivedButton()) button.setEnabled(true);
			}		
		}
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width,int height,String title,LocalDto dto) {
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
		/**********************************************************************************/

		/*********** Buttons *****************************************************************/
		Button home = new Button(I18n.getI18nConstants().home());
		home.setStyleName("buttonMenu");
		Button members = new Button(I18n.getI18nConstants().members());
		members.setStyleName("buttonMenu");
		Button suppliesDemands = new Button(I18n.getI18nConstants().suppliesDemands());
		suppliesDemands.setStyleName("buttonMenu");
		Button addTransaction = new Button(I18n.getI18nConstants().transaction());
		addTransaction.setStyleName("buttonMenu");
		Button fastMessages = new Button(I18n.getI18nMessages().fastMessage());
		fastMessages.setStyleName("buttonMenu");
		Button messages = new Button(I18n.getI18nConstants().messages());
		messages.setStyleName("buttonMenu");
		Button catalog = new Button(I18n.getI18nConstants().categories());
		catalog.setStyleName("buttonMenu");
		Button particulars = new Button(I18n.getI18nConstants().particulars());
		particulars.setStyleName("buttonMenu");
		
		int buttonWidth = (int) (width*0.8);
		home.setWidth(buttonWidth+"px");
		members.setWidth(buttonWidth+"px");
		suppliesDemands.setWidth(buttonWidth+"px");
		addTransaction.setWidth(buttonWidth+"px");
		fastMessages.setWidth(buttonWidth+"px");
		messages.setWidth(buttonWidth+"px");
		catalog.setWidth(buttonWidth+"px");
		particulars.setWidth(buttonWidth+"px");	
		/**********************************************************************************/	

		/*********** Controler ************************************************************/
		List<Button> buttonsToActive = new ArrayList<Button>();
		buttonsToActive.add(home);
		buttonsToActive.add(members);
		buttonsToActive.add(suppliesDemands);
		buttonsToActive.add(addTransaction);
		buttonsToActive.add(fastMessages);
		buttonsToActive.add(messages);
		buttonsToActive.add(catalog);
		buttonsToActive.add(particulars);	
		
		controler = new MenuControler(width,height,buttonsToActive);
		controler.getModel().addObserver(this);
		controler.getModel().onActiveButton(home);
		
		home.addClickHandler(controler.getHomeClickHandler(home));
		members.addClickHandler(controler.getMembersClickHandler(members));
		suppliesDemands.addClickHandler(controler.getSuppliesClickHandler(suppliesDemands));
		addTransaction.addClickHandler(controler.getTransactionClickHandler(addTransaction));
		fastMessages.addClickHandler(controler.getFastMessagesClickHandler(fastMessages));
		messages.addClickHandler(controler.getMessagesClickHandler(messages));
		catalog.addClickHandler(controler.getCategoriesClickHandler(catalog));
		particulars.addClickHandler(controler.getParticularsClickHandler(particulars));
		/**********************************************************************************/
		
		/********** Fill Main Panel *******************************************************/
		VerticalPanel panelInter = new VerticalPanel();
		panelInter.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panelInter.add(home);
		panelInter.add(members);
		panelInter.add(suppliesDemands);
		panelInter.add(addTransaction);
		panelInter.add(fastMessages);
		panelInter.add(messages);
		panelInter.add(catalog);
		panelInter.add(particulars);
		
		panel.add(panelInter);
		/**********************************************************************************/
		
		return panel;
		
	}

}
