package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MembersDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.MembersCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class HomeDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static HomeDisplay instance;
	public static HomeDisplay get() {
		if(instance == null)
			instance = new HomeDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}

	/* Attribute */
	private List<MemberLocalDto> members;
	private MembersCellTable membersTable;
	
	/* Constructor */
	private HomeDisplay(int width,int height) {
		super(width,height);
		membersTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		members = ((MembersDisplayModel) observable).getMembers();
		
		membersTable.getDataProvider().setList(members);
		membersTable.getDataProvider().refresh();
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
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
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/*********** Data Grid Member *****************************************************/
		members = new ArrayList<MemberLocalDto>();//MembersCellTable.members();
		membersTable = new MembersCellTable(width,height,I18n.getI18nMessages().noMember(),members,
											false,null);
		/**********************************************************************************/
		
		panel.add(membersTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public MembersCellTable getMembersTable() {
		return membersTable;
	}

}
