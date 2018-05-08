package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.model.MemberResearchModel;
import cnam.nsy209.selServices.association.client.view.page.MemberCreatePage;
import cnam.nsy209.selServices.association.client.view.page.MemberResearchPage;

public class MenuMemberMainControler {
	
	/* Attributes */
	private int width;
	private int height;
	
	/* Constructors */
	public MenuMemberMainControler(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	/* get the handler for search button */
	public ClickHandler getSearchClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				MemberResearchPage page = new MemberResearchPage(MenuMemberMainControler.this.width,
						MenuMemberMainControler.this.height);
				MemberResearchModel.get().setMembersForList();
				RootPanel.get().add(page);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for add button */
	public ClickHandler getAddClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				RootPanel.get().add(new MemberCreatePage(MenuMemberMainControler.this.width,
						MenuMemberMainControler.this.height));
			}
		};
		
		return clickHandler;
	}
}