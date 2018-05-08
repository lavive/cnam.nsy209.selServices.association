package cnam.nsy209.selServices.association.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.page.concretePage.IdHome;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Association implements EntryPoint {
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		int width = Window.getClientWidth();
		int height = Window.getClientHeight();
		DialogBoxWaiting.get((int)(width*0.33),(int)(height*0.25));
		RootPanel.get().add(IdHome.get(I18n.getI18nConstants().authentication()));//new IdHome(width,height,I18n.getI18nConstants().authentication()));
		//RootPanel.get().add(new Logo());
		//RootPanel.get().add(new Menu((int)(0.2*width),(int)(0.65*height)));
		//FastMessage fastMessage = new FastMessage(width,height);
		//RootPanel.get().add(fastMessage);
		//RootPanel.get().add(new Home(width,height));
		//RootPanel.get().add(new BottomBand(width,height));
		//RootPanel.get().add(new MembersDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new FastMessage((int)(0.78*width),(int)(0.25*height),I18n.getI18nMessages().fastMessage()));
		//RootPanel.get().add(new MenuMemberSub((int)(0.78*width),(int)(0.25*height)));
		//RootPanel.get().add(new MenuSupplies((int)(0.78*width),(int)(0.25*height),I18n.getI18nConstants().supplies()));
		//RootPanel.get().add(MenuDemands.get());//new MenuDemands((int)(0.78*width),(int)(0.25*height)));//,I18n.getI18nConstants().demands()));
		//RootPanel.get().add(new WealthSheetDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new SuppliesDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new DemandsDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new CategoriesDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new MessagesDisplay((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new AssociationDisplay((int)(0.78*width),(int)(0.65*height),AssociationDisplay.get()));
		//RootPanel.get().add(AssociationEdit.get(new AssociationDto()));//new AssociationEdit((int)(0.78*width),(int)(0.65*height),AssociationEdit.get()));
		//RootPanel.get().add(new CategoryEdit((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new TransactionEdit((int)(0.78*width),(int)(0.65*height)));
		//RootPanel.get().add(new MemberDisplay((int)(0.78*width),(int)(0.65*height),MemberDisplay.get()));
		//RootPanel.get().add(new MemberEdit((int)(0.78*width),(int)(0.65*height),MemberEdit.get()));
		//RootPanel.get().add(new MemberResearch((int)(0.78*width),(int)(0.65*height),I18n.getI18nMessages().researchCriteria()));
//		HomePage homePage = new HomePage(width,height);
//		RootPanel.get().add(homePage);
//		MemberHomePage memberHomePage = new MemberHomePage(width,height);
//		RootPanel.get().add(memberHomePage);
//		MemberResearchPage memberResearchPage = new MemberResearchPage(width,height);
//		RootPanel.get().add(memberResearchPage);
//		MembersResearchResultPage memberResearchResultPage = new MembersResearchResultPage(width,height);
//		RootPanel.get().add(memberResearchResultPage);
//		MemberDto member =MembersCellTable.members().get(89);
//		MemberCardPage memberCardPage = new MemberCardPage(width,height,member);
//		RootPanel.get().add(memberCardPage);
//		MemberDto member =MembersCellTable.members().get(89);
//		MemberEditPage memberEditPage = new MemberEditPage(width,height,member);
//		RootPanel.get().add(memberEditPage);
//		MemberCreatePage memberCreatePage = new MemberCreatePage(width,height);
//		RootPanel.get().add(memberCreatePage);
//		MemberDto member =MembersCellTable.members().get(89);
//		WealthSheetDisplayPage wealthSheetDisplayPage = new WealthSheetDisplayPage(width,height,member);
//		RootPanel.get().add(wealthSheetDisplayPage);
//		TransactionEditPage transactionEditPage = new TransactionEditPage(width,height);
//		RootPanel.get().add(transactionEditPage);
//		SuppliesDisplayPage suppliesDisplayPage = new SuppliesDisplayPage(width,height);
//		RootPanel.get().add(suppliesDisplayPage);
//		DemandsDisplayPage demandsDisplayPage = new DemandsDisplayPage(width,height);
//		RootPanel.get().add(demandsDisplayPage);
//		CategoriesDisplayPage categoriesDisplayPage = new CategoriesDisplayPage(width,height);
//		RootPanel.get().add(categoriesDisplayPage);
//		CategoryEditPage categoryEditPage = new CategoryEditPage(width,height);
//		RootPanel.get().add(categoryEditPage);
//		AssociationDisplayPage associationDisplayPage = new AssociationDisplayPage(width,height,AssociationDisplay.get());
//		RootPanel.get().add(associationDisplayPage);
//		AssociationEditPage associationEditPage = new AssociationEditPage(width,height,AssociationDisplay.get());
//		RootPanel.get().add(associationEditPage);
//		MessagesDisplayPage messagesDisplayPage = new MessagesDisplayPage(width,height);
//		RootPanel.get().add(messagesDisplayPage);
	}
	
//	private void initWaitinModel() {
//		ElementToDisplay.waitingModels.add(AssociationEditModel.get());
//		ElementToDisplay.waitingModels.add(CategoryEditModel.get());
//		ElementToDisplay.waitingModels.add(FastMessageModel.get());
//		ElementToDisplay.waitingModels.add(IdHomeModel.get());
//		ElementToDisplay.waitingModels.add(MemberEditModel.get());
//		ElementToDisplay.waitingModels.add(MemberResearchModel.get());
//		ElementToDisplay.waitingModels.add(MenuHorizontalModel.get());
//	}
}