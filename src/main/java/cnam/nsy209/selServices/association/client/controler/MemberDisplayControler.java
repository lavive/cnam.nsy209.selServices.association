package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.asyncCallback.TransactionAsyncCallback;
import cnam.nsy209.selServices.association.client.view.page.MemberEditPage;
import cnam.nsy209.selServices.association.client.view.page.WealthSheetDisplayPage;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberDisplayControler {
	
	/* Attributes */
	private int width;
	private int height;
	
	/* Constructors */
	public MemberDisplayControler(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	/* get the handler for update button */
	public ClickHandler getUpdateClickHandler(final LocalDto member) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				RootPanel.get().add(new MemberEditPage(MemberDisplayControler.this.width,
						MemberDisplayControler.this.height, member));
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for wealthSheet button */
	public ClickHandler getWealthSheetClickHandler(final LocalDto member) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				TransactionAsyncCallback transactionCallback = new TransactionAsyncCallback();
				transactionCallback.getTransactions((MemberLocalDto) member, false);
				RootPanel.get().clear();
				RootPanel.get().add(new WealthSheetDisplayPage(MemberDisplayControler.this.width,
						MemberDisplayControler.this.height, member));
			}
		};
		
		return clickHandler;
	}
}