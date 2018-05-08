package cnam.nsy209.selServices.association.client.asyncCallback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.AssociationEditControler;
import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.BottomBandModel;
import cnam.nsy209.selServices.association.client.model.LogoModel;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.AssociationDisplayPage;
import cnam.nsy209.selServices.association.shared.exception.AssociationException;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

public class AssociationAsyncCallback {

	/* attributes */
	private AsyncCallback<Void> updateCallback;
	private AsyncCallback<AssociationLocalDto> getCallback;
	private AsyncCallback<AssociationLocalDto> getCallSimpleback;
	private int width;
	private int height;
	private MenuControler menuControler;
	private AssociationEditControler associationEditControler;
	
	/* Constructors */
	public AssociationAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public AssociationAsyncCallback() {}
	
	/* methods */
	public void updateAssociation(final AssociationLocalDto association) {
			
		updateCallback = new AsyncCallback<Void>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(associationEditControler != null) 
					associationEditControler.getModel().onInitialize(association);
				if(caught instanceof AssociationException) {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
				else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}			
			}
	
			@Override
			public void onSuccess(Void result) {
				if(associationEditControler != null) 
					associationEditControler.getModel().onInitialize(association);
				LogoModel.get().onChange(association.getName());
				BottomBandModel.get().onChange(association.getName()+" - "+association.getAddress()+" - "+association.getPostalCode()+
				" "+association.getTown()+" - "+association.getEmail()+" - "+association.getCellNumber()+
				" - "+association.getPhoneNumber()+" - "+association.getWebsite());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().updateAssociationConfirm());
				message.center();
				message.show();
				
				AssociationDisplayPage page = new AssociationDisplayPage(width, height, association);
				RootPanel.get().clear();
				RootPanel.get().add(page);
				
			}
			
		};
		
		ServicesProxy.getAssociationService().upDate(association, updateCallback);
	}
	
	public void getAssociation(final Button button, boolean back) {
		
		getCallback = new AsyncCallback<AssociationLocalDto>() {

			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				if(caught instanceof AssociationException) {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
				else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}			
			}
	
			@Override
			public void onSuccess(AssociationLocalDto result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				RootPanel.get().add(new AssociationDisplayPage(width,height,result));
			}
			
		};
	
		ServicesProxy.getAssociationService().getAssociation(getCallback);
	
	}
	
	public void getAssociation(final AssociationLocalDto association) {
		
		getCallSimpleback = new AsyncCallback<AssociationLocalDto>() {

			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof AssociationException) {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
				else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}			
			}
	
			@Override
			public void onSuccess(AssociationLocalDto result) {
				association.copy(result);
			}
			
		};
	
		ServicesProxy.getAssociationService().getAssociation(getCallSimpleback);
	
	}
	
	
	/* getter and setter */

	public void setMenuControler(MenuControler menuControler) {
		this.menuControler = menuControler;
	}
	public void setAssociationEditControler(AssociationEditControler associationEditControler) {
		this.associationEditControler = associationEditControler;
	}
	

}
