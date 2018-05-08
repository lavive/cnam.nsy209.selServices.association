package cnam.nsy209.selServices.association.client.asyncCallback;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.DemandsDisplayControler;
import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.controler.SuppliesDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuDemandsModel;
import cnam.nsy209.selServices.association.client.model.MenuSuppliesModel;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.DemandsDisplayPage;
import cnam.nsy209.selServices.association.client.view.page.SuppliesDisplayPage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.DemandsDisplay;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.SuppliesDisplay;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.localDto.EnumSupplyDemandDto;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class SupplyDemandAsyncCallback {
	/* attributes */
	private AsyncCallback<List<SupplyDemandLocalDto>> getCallback;
	private AsyncCallback<List<SupplyDemandLocalDto>> deleteCallback;
	private AsyncCallback<List<SupplyDemandLocalDto>> getForListCallback;
	private AsyncCallback<SupplyDemandLocalDto> getSingleCallback;
	private int width;
	private int height;
	private MenuControler menuControler;
	private DemandsDisplayControler demandsDisplayControler;
	private SuppliesDisplayControler suppliesDisplayControler;
	
	/* Constructors */
	public SupplyDemandAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public SupplyDemandAsyncCallback() {}
	
	/* methods */
	
	public void getSuppliesDemands(final String type,final Button button) {
			
		getCallback = new AsyncCallback<List<SupplyDemandLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<SupplyDemandLocalDto> result) {
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				if(type.equals(EnumSupplyDemandDto.SUPPLY.getWording())) {
					SuppliesDisplayPage page = new SuppliesDisplayPage(width,height);
					SuppliesDisplay.get().getSuppliesTable().getControler().getModel().onSet(result);
					MenuSuppliesModel.get().onInitialise();
					RootPanel.get().add(page);
				} else if(type.equals(EnumSupplyDemandDto.DEMAND.getWording())) {
					DemandsDisplayPage page = new DemandsDisplayPage(width,height);
					DemandsDisplay.get().getDemandsTable().getControler().getModel().onSet(result);
					MenuDemandsModel.get().onInitialise();
					RootPanel.get().add(page);
				}
			}
			
		};
		
		ServicesProxy.getSuppliesDemandsService().getSuppliesDemands(type,getCallback);
	}
	
	public void deleteSupplyDemand(SupplyDemandLocalDto supplyDemand) {
			
		deleteCallback = new AsyncCallback<List<SupplyDemandLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof DoNotExistException) {
					DialogBoxMessage message = new DialogBoxMessage(((DoNotExistException) caught).message());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<SupplyDemandLocalDto> result) {
				if(supplyDemand.getType().equals(EnumSupplyDemandDto.DEMAND.getWording())) {
					List<SupplyDemandLocalDto> resultDemands = new ArrayList<SupplyDemandLocalDto>();
					for(SupplyDemandLocalDto suppDem: result) {
						if(suppDem.getType().equals(EnumSupplyDemandDto.DEMAND.getWording()))
							resultDemands.add(suppDem);
					}
					demandsDisplayControler.getModel().onSet(resultDemands);	
				}
				else if(supplyDemand.getType().equals(EnumSupplyDemandDto.SUPPLY.getWording())) {
					List<SupplyDemandLocalDto> resultSupplies = new ArrayList<SupplyDemandLocalDto>();
					for(SupplyDemandLocalDto suppDem: result) {
						if(suppDem.getType().equals(EnumSupplyDemandDto.SUPPLY.getWording()))
						resultSupplies.add(suppDem);
					}
					suppliesDisplayControler.getModel().onSet(resultSupplies);	
				}
			}
			
		};
		
		ServicesProxy.getSuppliesDemandsService().delete(supplyDemand, deleteCallback);
	}	

	public void /*List<SupplyDemandDto>*/ getSuppliesDemandsForListBox() {
		
//		final List<SupplyDemandDto> suppliesDemands = new ArrayList<SupplyDemandDto>();
		
		getForListCallback = new AsyncCallback<List<SupplyDemandLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<SupplyDemandLocalDto> result) {
//				for(SupplyDemandDto supplyDemand:result) {
//					suppliesDemands.add(supplyDemand);
//				}
				TransactionEditModel.get().setSuppliesDemandsForList(result);
			}
			
		};
		
		ServicesProxy.getSuppliesDemandsService().getSuppliesDemands(null,getForListCallback);
		
//		return suppliesDemands;
	}
	
	public void getSupplyDemand(final long id, final SupplyDemandLocalDto supplyDemandDto) {
				
		getSingleCallback = new AsyncCallback<SupplyDemandLocalDto>() {
	
			@Override
			public void onFailure(Throwable caught) {
				supplyDemandDto.copy(new SupplyDemandLocalDto());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(SupplyDemandLocalDto result) {
				supplyDemandDto.copy(result);
			}
			
		};
		
		ServicesProxy.getSuppliesDemandsService().getSupplyDemand(id,getSingleCallback);
	}
	
	/* getter and setter */

	public void setMenuControler(MenuControler menuControler) {
		this.menuControler = menuControler;
	}
	public void setDemandsDisplayControler(DemandsDisplayControler demandsDisplayControler) {
		this.demandsDisplayControler = demandsDisplayControler;
	}
	public void setSuppliesDisplayControler(SuppliesDisplayControler suppliesDisplayControler) {
		this.suppliesDisplayControler = suppliesDisplayControler;
	}

}
