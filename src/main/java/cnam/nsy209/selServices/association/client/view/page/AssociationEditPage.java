package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.AssociationEdit;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.MenuHorizontal;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class AssociationEditPage extends AbstractPage implements Observer {

	public AssociationEditPage(int width, int height, LocalDto dto) {
		super(width, height, dto);
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
		displayStrategy.addPanel(MenuHorizontal.get(EnumMenuHorizontal.ASSOCIATION_EDIT,null));
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(AssociationEdit.get(dto));
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

}
