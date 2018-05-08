package cnam.nsy209.selServices.association.client.asyncCallback;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.controler.IdHomeControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.BottomBandModel;
import cnam.nsy209.selServices.association.client.view.page.HomePage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.MembersDisplay;
import cnam.nsy209.selServices.association.shared.exception.AuthenticationException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class AuthenticationAsyncCallback {

	/* attributes */
	private AsyncCallback<String> nameCallback;
	private AsyncCallback<String> associationCallback;
	private AsyncCallback<List<MemberLocalDto>> authenticationCallback;
	private IdHomeControler controler;
	
	/* method */	
	public void buildAuthentication(TextBox loginInput,PasswordTextBox passwordInput, int numberToDisplay) {
			
		authenticationCallback = new AsyncCallback<List<MemberLocalDto>>() {

			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof AuthenticationException)
					controler.getModel().onNoResultDisplay(loginInput.getText());
				else
					controler.getModel().onNetworkErrorDisplay(loginInput.getText());				
			}

			@Override
			public void onSuccess(List<MemberLocalDto> result) {
				
//					MemberAsyncCallback homeCallback = new MemberAsyncCallback();
//					homeCallback.getLastMembers(null,true);
//					Window.alert("login: "+loginInput.getText()+" /password: "+passwordInput.getText());	
//					controler.initialize(loginInput.getText());
					RootPanel.get().clear();
					HomePage page = new HomePage(controler.getWidth(),controler.getHeight());
					MembersDisplay.get().getMembersTable().getControler().getModel().onSet(result);
					RootPanel.get().add(page);
//					AuthenticationAsyncCallback.this.goHome();
					
			}
			
		};
		
		ServicesProxy.getAuthenticationService().checkIds(loginInput.getText(),
															passwordInput.getText(),
															numberToDisplay,
															authenticationCallback);
		
	}
	
	public void buildName(Label label) {
			
		nameCallback = new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				label.setText(I18n.getI18nMessages().associationNameError());			
			}

			@Override
			public void onSuccess(String result) {
				if(result != null)
					label.setText(result);
				else
					label.setText(I18n.getI18nMessages().associationNameError());						
			}
			
		};
		
		ServicesProxy.getAuthenticationService().getName(nameCallback);
	}	
	
	public void getAssociation() {
			
		associationCallback = new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				BottomBandModel.get().onChange(I18n.getI18nMessages().netWorkError());			
			}

			@Override
			public void onSuccess(String result) {
				if(result != null) {
					BottomBandModel.get().onChange(result);	
				}
				else
					BottomBandModel.get().onChange(I18n.getI18nMessages().netWorkError());							
			}
			
		};
		
		ServicesProxy.getAuthenticationService().getAssociation(associationCallback);
	}	
	
	/* getter and setter */
	
	public void setControler(IdHomeControler controler) {
		this.controler = controler;
	}

	public AsyncCallback<List<MemberLocalDto>> getAuthenticationCallback() {
		return authenticationCallback;
	}
	
	
}
