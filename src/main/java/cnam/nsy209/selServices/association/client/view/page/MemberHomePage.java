package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MembersDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.MenuMemberMain;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class MemberHomePage extends AbstractPage implements Observer {

	/* Constructor */
	public MemberHomePage(int width, int height) {
		super(width, height);
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		ElementToDisplay.dto = dto;
		ElementToDisplay.enumOrigin = EnumMenuHorizontal.MEMBER_HOME;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(MenuMemberMain.get());
		displayStrategy.addPanel(Menu.get());
		displayStrategy.addPanel(MembersDisplay.get());
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub
		
	}

}
