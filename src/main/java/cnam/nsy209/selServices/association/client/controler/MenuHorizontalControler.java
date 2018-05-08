package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.asyncCallback.AssociationAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.CategoryAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.model.MembersResearchResultModel;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.view.helper.ElementToDisplay;
import cnam.nsy209.selServices.association.client.view.helper.EnumMenuHorizontal;
import cnam.nsy209.selServices.association.client.view.page.MemberCardPage;
import cnam.nsy209.selServices.association.client.view.page.MemberResearchPage;
import cnam.nsy209.selServices.association.client.view.page.MembersResearchResultPage;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MenuHorizontalControler {
	
	/* Attributes */
	private EnumMenuHorizontal enumMenu;
	private MenuHorizontalModel model;
	private int width;
	private int height;
	
	/* Constructors */
	public MenuHorizontalControler(int width, int height, EnumMenuHorizontal enumMenu, MemberLocalDto attributes) {
		this.enumMenu = enumMenu;
		this.width = width;
		this.height = height;
		this.model = MenuHorizontalModel.get(attributes);
		
	}
	
	/* get the handler for back button */
	public ClickHandler getBackClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				if(enumMenu.equals(EnumMenuHorizontal.ASSOCIATION_EDIT)) {	
					model.onWaitingDisplay();
					Timer t = new Timer() {
						@Override
						public void run() {
							AssociationAsyncCallback callback = new AssociationAsyncCallback(width,height);
							callback.getAssociation(null,true);
						}
					};
					t.schedule(0);
//					RootPanel.get().add(new AssociationDisplayPage(width,height,AssociationDisplay.get()));
				}
				if(enumMenu.equals(EnumMenuHorizontal.CATEGORY_EDIT)) {	
					model.onWaitingDisplay();
					Timer t = new Timer() {
						@Override
						public void run() {
							CategoryAsyncCallback callback = new CategoryAsyncCallback(width,height);
							callback.getCategories(null,true);
						}
					};
					t.schedule(0);
//					RootPanel.get().add(new CategoriesDisplayPage(width,height));
				}
				if(enumMenu.equals(EnumMenuHorizontal.MEMBER_CARD)) {
					if(ElementToDisplay.enumOrigin.equals(EnumMenuHorizontal.HOME)) {
						model.onWaitingDisplay();
						Timer t = new Timer() {
							@Override
							public void run() {
								MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
								callback.getLastMembers(null,true);
							}
						};
						t.schedule(0);
//						RootPanel.get().add(new HomePage(width,height));
					}
					else if(ElementToDisplay.enumOrigin.equals(EnumMenuHorizontal.MEMBER_HOME)) {
						model.onWaitingDisplay();
						Timer t = new Timer() {
							@Override
							public void run() {
								MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
								callback.getMembers(new Button(),true);
							}
						};
						t.schedule(0);
//							RootPanel.get().add(new MemberHomePage(width,height));
					}
					else if(ElementToDisplay.enumOrigin.equals(EnumMenuHorizontal.MEMBER_RESEARCH_RESULT)) {
						MembersResearchResultPage page = new MembersResearchResultPage(width,
																				height,model.getAttributes());
						MembersResearchResultModel.get().onSet(MembersResearchResultModel.get().getMembers());
						RootPanel.get().add(page);
					}
					else {
						model.onWaitingDisplay();
						Timer t = new Timer() {
							@Override
							public void run() {
								MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
								callback.getLastMembers(null,true);
							}
						};
						t.schedule(0);
//						RootPanel.get().add(new HomePage(width,height));
					}
				}
				if(enumMenu.equals(EnumMenuHorizontal.MEMBER_CREATE)) {
					model.onWaitingDisplay();
					Timer t = new Timer() {
						@Override
						public void run() {
							MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
							callback.getMembers(new Button(),true);
						}
					};
					t.schedule(0);
//					RootPanel.get().add(new MemberHomePage(width,height));
				}
				if(enumMenu.equals(EnumMenuHorizontal.MEMBER_EDIT)) {
					RootPanel.get().add(new MemberCardPage(width,height,ElementToDisplay.dto));
				}
				if(enumMenu.equals(EnumMenuHorizontal.MEMBER_RESEARCH)) {
					model.onWaitingDisplay();
					Timer t = new Timer() {
						@Override
						public void run() {
							MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
							callback.getMembers(new Button(),true);
						}
					};
					t.schedule(0);
//					RootPanel.get().add(new MemberHomePage(width,height));
				}
				if(enumMenu.equals(EnumMenuHorizontal.MEMBER_RESEARCH_RESULT)) {
					RootPanel.get().add(new MemberResearchPage(width,height));
				}
				if(enumMenu.equals(EnumMenuHorizontal.TRANSACTION_EDIT)) {
					model.onWaitingDisplay();
					Timer t = new Timer() {
						@Override
						public void run() {
							MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
							callback.getLastMembers(null,true);
						}
					};
					t.schedule(0);
//					RootPanel.get().add(new WealthSheetDisplayPage(width,height,ElementToDisplay.dto));
				}
				if(enumMenu.equals(EnumMenuHorizontal.WEALTHSHEET_DISPLAY)) {
					RootPanel.get().add(new MemberCardPage(width,height,ElementToDisplay.dto));
				}
			}
		};
		
		return clickHandler;
	}
	
	/* getter */

	public MenuHorizontalModel getModel() {
		return model;
	}

}
