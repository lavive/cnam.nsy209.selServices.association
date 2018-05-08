package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MessagesDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.UpTitle;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class MessagesDisplayPage extends AbstractPage implements Observer {

	/* Constructor */
	public MessagesDisplayPage(int width, int height) {
		super(width, height);
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		ElementToDisplay.dto = dto;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(UpTitle.get(EnumMenuHorizontal.MESSAGES_DISPLAY));
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(MessagesDisplay.get());
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

}
