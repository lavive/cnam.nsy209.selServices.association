package cnam.nsy209.selServices.association.client.controler;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.asyncCallback.MemberAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MembersDisplayModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.client.view.page.MemberCardPage;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MembersDisplayControler {
	
	/* Attributes */
	private MembersDisplayModel model;
	private int width;
	private int height;
	private boolean lastMembers;
	private boolean allMembers;
	private MemberLocalDto resultMember;
	
	
	/* Constructors */
	public MembersDisplayControler(int width, int height, List<MemberLocalDto> members) {
		this.model = MembersDisplayModel.get(members);
		this.width = width;
		this.height = height;
		this.lastMembers = true;
		this.allMembers = false;
		this.resultMember = null;
	}
	
	/* get the action for delete button */
	public ActionCell<MemberLocalDto> getDeleteAction(){
		return new ActionCell<MemberLocalDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<MemberLocalDto>() {
			 @Override
			 public void execute(MemberLocalDto member) {
				 DialogBoxConfirm<MemberLocalDto> dialogBox = new DialogBoxConfirm<MemberLocalDto>(member,
						 I18n.getI18nMessages().sure(),clickHandlerDeleteToTransmit());
				 dialogBox.center();
				 dialogBox.show();
			 }
		 });

	}
	
	/* get the action for look button */
	public ActionCell<MemberLocalDto> getLookAction(){
		return new ActionCell<MemberLocalDto>(I18n.getI18nConstants().look(), new ActionCell.Delegate<MemberLocalDto>() {
			 @Override
			 public void execute(MemberLocalDto member) {
				 //Window.alert("You want to see: " + member.getName());
				 look(member);
			 }
		 });

	}
	private IActionToTransmit<MemberLocalDto> clickHandlerDeleteToTransmit() {
		return new IActionToTransmit<MemberLocalDto>() {
			@Override
			public void action(MemberLocalDto member) {
				if(lastMembers)
					deleteLastMember(member);	
				else if(allMembers)
					delete(member);
				else 
					deleteResultMember(member,resultMember);
				
			}
      };
	}		
	
	/* getter */

	public MembersDisplayModel getModel() {
		return model;
	}
	
	public void setLastMemberTrue() {
		this.lastMembers = true;
		this.allMembers = false;
		this.resultMember = null;
		
	}
	
	public void setAllMemberTrue() {
		this.lastMembers = false;
		this.allMembers = true;
		this.resultMember = null;
		
	}
	
	public void setResultMember(MemberLocalDto member) {
		this.lastMembers = false;
		this.allMembers = false;
		this.resultMember = member;
		
	}
	
	/* helper method */
	private void delete(final MemberLocalDto member) {
		Timer t = new Timer() {
			@Override
			public void run() {
				MemberAsyncCallback callback = new MemberAsyncCallback();
				callback.setMembersDisplayControler(MembersDisplayControler.this);
				callback.deleteMember(member);
			}
		};
		t.schedule(1000);
//		/******Asynck******/
//		List<MemberDto> members = model.getMembers();
//		members.remove(member);
//		model.onSet(members);
	}
	
	private void deleteLastMember(final MemberLocalDto member) {
		Timer t = new Timer() {
			@Override
			public void run() {
				MemberAsyncCallback callback = new MemberAsyncCallback();
				callback.setMembersDisplayControler(MembersDisplayControler.this);
				callback.deleteLastMember(member);
			}
		};
		t.schedule(0);
//		/******Asynck******/
//		List<MemberDto> members = model.getMembers();
//		members.remove(member);
//		model.onSet(members);
	}
	
	private void deleteResultMember(final MemberLocalDto member,final MemberLocalDto attributes) {
		Timer t = new Timer() {
			@Override
			public void run() {
				MemberAsyncCallback callback = new MemberAsyncCallback();
				callback.setMembersDisplayControler(MembersDisplayControler.this);
				callback.deleteMember(member,attributes);
			}
		};
		t.schedule(1000);
//		/******Asynck******/
//		List<MemberDto> members = model.getMembers();
//		members.remove(member);
//		model.onSet(members);
	}
	
	private void look(MemberLocalDto member) {
//		/******Asynck******/
		RootPanel.get().clear();
		RootPanel.get().add(new MemberCardPage(this.width,this.height,member));
	}
}
