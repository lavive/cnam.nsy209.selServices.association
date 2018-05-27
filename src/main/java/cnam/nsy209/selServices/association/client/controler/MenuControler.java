
package cnam.nsy209.selServices.association.client.controler;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.asyncCallback.AssociationAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.CategoryAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.MessageAsyncCallback;
import cnam.nsy209.selServices.association.client.asyncCallback.SupplyDemandAsyncCallback;
import cnam.nsy209.selServices.association.client.model.MenuModel;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.page.FastMessagePage;
import cnam.nsy209.selServices.association.client.view.page.TransactionEditPage;
import cnam.nsy209.selServices.association.shared.localDto.EnumSupplyDemandDto;

public class MenuControler {
	
	/* Attributes */
	private MenuModel model;
	private int width;
	private int height;
	private Button activedButton;
	
	/* Constructors */
	public MenuControler(int width, int height, List<Button> buttons) {
		this.model = MenuModel.get();
		this.model.onInitialise(buttons);
		this.height = height;
		this.width = width;
	}
	
	/* get the handler for Home button */
	public ClickHandler getHomeClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getLastMembers(button,false);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Members button */
	public ClickHandler getMembersClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						MemberAsyncCallback callback = new MemberAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getMembers(button,false);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Supplies/Demands button */
	public ClickHandler getSuppliesClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						SupplyDemandAsyncCallback callback = new SupplyDemandAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getSuppliesDemands(EnumSupplyDemandDto.SUPPLY.getWording(),button);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for transaction button */
	public ClickHandler getTransactionClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						RootPanel.get().clear();
						TransactionEditPage page = new TransactionEditPage(width,height);
						TransactionEditModel.get().setMembersForList();
						TransactionEditModel.get().setSuppliesDemandsForList();
						RootPanel.get().add(page);
						model.onActiveButton(button);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Messages button */
	public ClickHandler getFastMessagesClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						RootPanel.get().clear();
						RootPanel.get().add(new FastMessagePage(width,height));
						model.onActiveButton(button);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Messages button */
	public ClickHandler getMessagesClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						MessageAsyncCallback callback = new MessageAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getMessages(button,false);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Categories button */
	public ClickHandler getCategoriesClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						CategoryAsyncCallback callback = new CategoryAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getCategories(button,false);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for Particulars button */
	public ClickHandler getParticularsClickHandler(final Button button) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onWaitingDisplay();
				for(Button buttonCursor:model.getActiveButtons().keySet()) {
					if(buttonCursor == button) buttonCursor.setStyleName("buttonMenuCliked");
					else buttonCursor.setStyleName("buttonMenu");
				}
				Timer t = new Timer() {
					@Override
					public void run() {
						AssociationAsyncCallback callback = new AssociationAsyncCallback(width,height);
						callback.setMenuControler(MenuControler.this);
						callback.getAssociation(button,false);
					}
				};
				t.schedule(0);
			}
		};
		
		return clickHandler;
	}
	
	/* getter */

	public MenuModel getModel() {
		return model;
	}

	public Button getActivedButton() {
		return activedButton;
	}

	public void setActivedButton(Button activedButton) {
		this.activedButton = activedButton;
	}

}
