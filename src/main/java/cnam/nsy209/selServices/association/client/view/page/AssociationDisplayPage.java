package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.AssociationDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.UpTitle;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class AssociationDisplayPage extends AbstractPage implements Observer {	

	/* Constructor */
	public AssociationDisplayPage(int width, int height, LocalDto dto) {
		super(width, height, dto);
	}

	@Override
	public void update(Observable observable, Object object) {
		

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		ElementToDisplay.dto = dto;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(UpTitle.get(EnumMenuHorizontal.ASSOCIATION_DISPLAY));
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(AssociationDisplay.get(dto));
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

}
