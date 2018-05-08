package cnam.nsy209.selServices.association.client.view.page;

import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Logo;
import cnam.nsy209.selServices.association.client.view.page.concretePage.Menu;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MembersDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MembersResultDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.upBand.MenuHorizontal;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.MainDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MembersResearchResultPage extends AbstractPage implements Observer {

	/* Constructor */
	public MembersResearchResultPage(int width, int height, LocalDto attributes) {
		super(width, height, attributes);
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		ElementToDisplay.dto = dto;
		ElementToDisplay.enumOrigin = EnumMenuHorizontal.MEMBER_RESEARCH_RESULT;
		IDisplayStrategy displayStrategy = new MainDisplayStrategy();
		displayStrategy.addPanel(Logo.get());
		displayStrategy.addPanel(MenuHorizontal.get(EnumMenuHorizontal.MEMBER_RESEARCH_RESULT,(MemberLocalDto) dto));
		displayStrategy.addPanel(Menu.get());
//		displayStrategy.addPanel(MembersResultDisplay.get((MemberLocalDto) dto));
		displayStrategy.addPanel(MembersDisplay.get());
		displayStrategy.addPanel(BottomBand.get());
		return displayStrategy;
	}

	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub
		
	}

}
