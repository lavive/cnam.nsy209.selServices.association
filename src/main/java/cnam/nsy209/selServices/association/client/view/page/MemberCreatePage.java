package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MemberEdit;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.MenuHorizontal;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberCreatePage extends AbstractPage implements Observer {

	/* Constructor */
	public MemberCreatePage(int width, int height) {
		super(width, height,new MemberLocalDto());
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		ElementToDisplay.dto = dto;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(MenuHorizontal.get(EnumMenuHorizontal.MEMBER_CREATE,null));
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(MemberEdit.get(dto,false));
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub
		
	}

}