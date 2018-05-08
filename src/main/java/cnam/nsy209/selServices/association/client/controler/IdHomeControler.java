package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.asyncCallback.AuthenticationAsyncCallback;
import cnam.nsy209.selServices.association.client.model.IdHomeModel;
import cnam.nsy209.selServices.association.client.view.page.concretePage.BottomBand;

/**
 * 
 * IDHome page Controler to implement MVC pattern
 *
 */
public class IdHomeControler {
	private static int NUMBER_TO_DISPLAY = 9;
	
	/* Attributes */
	private IdHomeModel model;
	private int width;
	private int height;
	
	/* Constructors */
	public IdHomeControler(int width, int height) {
		this.model = IdHomeModel.get();
		this.width = width;
		this.height = height;
	}
	
	/* Methods */
	
	/* call to initialize view */
	public void initialize(String login,String password) {
		this.model.onInitialize(login,password);
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler(TextBox loginInput,PasswordTextBox passwordInput) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				IdHomeControler.this.model.onDisplay(loginInput.getText(), passwordInput.getText());
				if(IdHomeControler.this.model.getAssociationIDError() == null &&
						IdHomeControler.this.model.getAssociationPasswordError() == null) {
					IdHomeControler.this.model.onWaitingDisplay(loginInput.getText(),passwordInput.getText());		
					Timer t = new Timer() {
						@Override
						public void run() {
								BottomBand.get();
								AuthenticationAsyncCallback callback = new AuthenticationAsyncCallback();
								callback.setControler(IdHomeControler.this);
								callback.getAssociation();
								callback.buildAuthentication(loginInput, passwordInput,NUMBER_TO_DISPLAY);
						}
					};
					t.schedule(0);	
				}	
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler when input begin */
	public ClickHandler getInputClickHandler(TextBox loginInput,PasswordTextBox passwordInput) {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				initialize(loginInput.getText(),passwordInput.getText());
			}
		};
		
		return clickHandler;
	}
	
	
	/* getter */

	public IdHomeModel getModel() {
		return model;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	

}
