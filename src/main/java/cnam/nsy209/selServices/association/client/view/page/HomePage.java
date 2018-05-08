package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.HomeDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.UpTitle;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class HomePage extends AbstractPage implements Observer {

	/* Constructor */
	public HomePage(int width, int height) {
		super(width, height);
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		ElementToDisplay.dto = dto;
		ElementToDisplay.enumOrigin = EnumMenuHorizontal.HOME;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(UpTitle.get(EnumMenuHorizontal.HOME));
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(HomeDisplay.get());
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

}
