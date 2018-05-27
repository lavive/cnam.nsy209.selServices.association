package cnam.nsy209.selServices.association.client.asyncCallback;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.MemberEditControler;
import cnam.nsy209.selServices.association.client.controler.MemberResearchControler;
import cnam.nsy209.selServices.association.client.controler.MembersDisplayControler;
import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MemberResearchModel;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.model.TransactionEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.HomePage;
import cnam.nsy209.selServices.association.client.view.page.MemberCardPage;
import cnam.nsy209.selServices.association.client.view.page.MemberHomePage;
import cnam.nsy209.selServices.association.client.view.page.MembersResearchResultPage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MembersDisplay;
import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

/** 
 * 
 * Class to manage result from Member service call
 * 
 * @author lavive
 *
 */
public class MemberAsyncCallback {
	
	private static final int NUMBER_TO_DISPLAY = 9;

	/* attributes */
	private AsyncCallback<List<MemberLocalDto>> addCallback;
	private AsyncCallback<List<MemberLocalDto>> getCallback;
	private AsyncCallback<List<MemberLocalDto>> getLastCallback;
	private AsyncCallback<List<MemberLocalDto>> getResearchCallback;
	private AsyncCallback<List<MemberLocalDto>> deleteCallback;
	private AsyncCallback<MemberLocalDto> updateCallback;
	private AsyncCallback<List<MemberLocalDto>> getForListCallback;
	private AsyncCallback<MemberLocalDto> getSingleCallback;
	private int width;
	private int height;
	private MenuControler menuControler;
	private MemberEditControler memberEditControler;
	private MembersDisplayControler membersDisplayControler;
	private MemberResearchControler memberResearchControler;
	
	/* Constructors */
	public MemberAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public MemberAsyncCallback() {}
	
	/* methods */
	public void addMember(MemberLocalDto member) {
			
		addCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(memberEditControler != null) memberEditControler.getModel().onInitialize(member);
				if(caught instanceof AlReadyExistException) {
					DialogBoxMessage message = new DialogBoxMessage(((AlReadyExistException) caught).message());
					message.center();
					message.show();
				} else if(caught instanceof EmptyException) {
					DialogBoxMessage message = new DialogBoxMessage(((EmptyException) caught).message());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				if(memberEditControler != null) memberEditControler.getModel().onInitialize(member);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().addMemberConfirm());
				message.center();
				message.show();

				RootPanel.get().clear();
				MemberHomePage page = new MemberHomePage(width,height);
				MembersDisplay.get().getMembersTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMembersService().create(member, addCallback);
	}

	public void updateMember(MemberLocalDto member) {
			
		updateCallback = new AsyncCallback<MemberLocalDto>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(memberEditControler != null) memberEditControler.getModel().onInitialize(member);
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
			public void onSuccess(MemberLocalDto result) {
				if(memberEditControler != null) memberEditControler.getModel().onInitialize(result);
				RootPanel.get().clear();
				RootPanel.get().add(new MemberCardPage(width,height,result));
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().updateMemberConfirm());
				message.center();
				message.show();
			}
			
		};
		
		ServicesProxy.getMembersService().update(member, updateCallback);
	}

	public void getMembers(final Button button, boolean back) {
			
		getCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				MemberHomePage page = new MemberHomePage(width,height);
				MembersDisplay.get().getMembersTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMembersService().getMembers(getCallback);
	}

	public void getLastMembers(final Button button, boolean back) {
					
		getLastCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				HomePage page = new HomePage(width,height);
				MembersDisplay.get().getMembersTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMembersService().getLastMembers(NUMBER_TO_DISPLAY,getLastCallback);
	}

	public void getMembers(MemberLocalDto attributes, boolean back) {
			
		getResearchCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(attributes).onInitialise();
				if(memberResearchControler != null) memberResearchControler.getModel().onInitialize();
				if(caught instanceof DoNotExistException) {
					RootPanel.get().clear();
					MembersResearchResultPage page = new MembersResearchResultPage(width,height,attributes);
					MembersDisplay.get().getMembersTable().getControler().getModel()
								.onSet(new ArrayList<MemberLocalDto>());
					RootPanel.get().add(page);
				} else {
					if(back) MenuHorizontalModel.get(attributes).onInitialise();
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}		
	
			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				RootPanel.get().clear();
				MembersResearchResultPage page = new MembersResearchResultPage(width,height,attributes);
				MembersDisplay.get().getMembersTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getMembersService().getMembers(attributes,getResearchCallback);
	}
	

	public void deleteMember(MemberLocalDto member) {
		
		deleteCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
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
			public void onSuccess(List<MemberLocalDto> result) {
				membersDisplayControler.getModel().onSet(result);				
			}
			
		};
		
		ServicesProxy.getMembersService().delete(member, deleteCallback);
	}
	
	public void deleteMember(MemberLocalDto member, MemberLocalDto attributes) {
		
		deleteCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
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
			public void onSuccess(List<MemberLocalDto> result) {
				membersDisplayControler.getModel().onSet(result);				
			}
			
		};
		
		ServicesProxy.getMembersService().delete(member, attributes, deleteCallback);
	}
	
	public void deleteLastMember(MemberLocalDto member) {
		
		deleteCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
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
			public void onSuccess(List<MemberLocalDto> result) {
				membersDisplayControler.getModel().onSet(result);				
			}
			
		};
		
		ServicesProxy.getMembersService().deleteLastMember(member, NUMBER_TO_DISPLAY, deleteCallback);
	}	
	
	public void getMembersForListBox() {
		
		
		getForListCallback = new AsyncCallback<List<MemberLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				TransactionEditModel.get().setMembersForList(result);
				MemberResearchModel.get().setMembersForList(result);
			}
			
		};
		
		ServicesProxy.getMembersService().getMembers(getForListCallback);
		
	}

	public void getMember(final long id, final MemberLocalDto member) {
			
		getSingleCallback = new AsyncCallback<MemberLocalDto>() {
	
			@Override
			public void onFailure(Throwable caught) {
				member.copy(member);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(MemberLocalDto result) {
				member.copy(result);
			}
			
		};
		
		ServicesProxy.getMembersService().getMember(id,getSingleCallback);
	}
	
	
	/* getter and setter */

	public void setMenuControler(MenuControler menuControler) {
		this.menuControler = menuControler;
	}
	public void setMemberEditControler(MemberEditControler memberEditControler) {
		this.memberEditControler = memberEditControler;
	}
	public void setMembersDisplayControler(MembersDisplayControler membersDisplayControler) {
		this.membersDisplayControler = membersDisplayControler;
	}
	public void setMemberResearchControler(MemberResearchControler memberResearchControler) {
		this.memberResearchControler = memberResearchControler;
	}

}
