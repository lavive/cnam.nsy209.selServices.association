package cnam.nsy209.selServices.association.client.view.page.concretePage;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.asyncCallback.AuthenticationAsyncCallback;
import cnam.nsy209.selServices.association.client.controler.IdHomeControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.IdHomeModel;
import cnam.nsy209.selServices.association.client.resources.Res;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

/**
 * 
 * A concrete page: identification home
 *
 */

public final class IdHome extends AbstractPage implements Observer {	
	
	/* Singleton */
	private static IdHome instance;
	public static IdHome get(String title) {
		if(instance == null)
			instance = new IdHome(WIDTH, HEIGHT, title);
		
		return instance;
	}
	
	/* attributes */
	
	/* controler */
	private IdHomeControler controler;
	
	/* views */
	private TextBox loginInput;
	private PasswordTextBox passwordInput;
	private Label loginError;
	private Label passwordError;
	private Label authenticationError;
//	private WaitingTransfer waiting;
	private Button validate;
	
	/* constructors */
	
	private IdHome(int width,int height,String title) {
		super(width,height,title);
		
		/* controler */
		controler.getModel().addObserver(this);
		controler.initialize("","");
		
	}
	
	
	/* methods */

	@Override
	public void update(Observable observable, Object object) {
		IdHomeModel idHomeModel = (IdHomeModel) observable;
		
		/* update view */
		/* login input */
		this.loginInput.setText(idHomeModel.getLogin());
		this.passwordInput.setText(idHomeModel.getPassword());
		/* login error */
		if(idHomeModel.getAssociationIDError() != null)
			this.loginError.setText(idHomeModel.getAssociationIDError().getErrorMessage());
		else {
			this.loginError.setText("");
		}
		/* password error */
		if(idHomeModel.getAssociationPasswordError() != null)
			this.passwordError.setText(idHomeModel.getAssociationPasswordError().getErrorMessage());
		else {
			this.passwordError.setText("");
		}
		/* validate button and waiting message */
		if(idHomeModel.isWaiting()) {
			this.validate.setEnabled(false);
			this.loginInput.setEnabled(false);
			this.passwordInput.setEnabled(false);
//			if(!this.waiting.isRunning())
//				this.waiting.start();
		} else {
			this.validate.setEnabled(true);
			this.loginInput.setEnabled(true);
			this.passwordInput.setEnabled(true);
//			if(this.waiting.isRunning())
//				this.waiting.stop();			
		}
		/* label error */
		if(idHomeModel.isNetworkError()) {
			this.authenticationError.setVisible(true);
			this.authenticationError.setText(I18n.getI18nMessages().netWorkError());
		} else if(idHomeModel.isAuthenticationError()) {
			this.authenticationError.setVisible(true);
			this.authenticationError.setText(I18n.getI18nMessages().authenticationWrong());
		}
		else
			this.authenticationError.setVisible(false);
		
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width,int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height,title));
		
		return displayStrategy;
	}
	
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height,String title) {

		/************ attribute views instantiation ***************************************/
		loginInput = new TextBox();
		passwordInput = new PasswordTextBox();
		loginError = new Label();
		passwordError = new Label();
		authenticationError = new Label();
//		waiting = new WaitingTransfer();
//		waiting.getPanel().setHeight(0.05*height+"px");
		validate = new Button();
		/************ get Handler to Controler ********************************************/
		controler = new IdHomeControler(width,height);
		validate.addClickHandler(controler.getValidateClickHandler(loginInput, passwordInput));
		loginInput.addClickHandler(controler.getInputClickHandler(loginInput, passwordInput));
		passwordInput.addClickHandler(controler.getInputClickHandler(loginInput, passwordInput));
		/**********************************************************************************/
		
		/*********** Main panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(0.98*width+"px");//100%");
		//panel.setHeight(0.95*height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/********** Logo panel ************************************************************/
		VerticalPanel topPanel = new VerticalPanel();
		/* Style */
		topPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);	
		topPanel.getElement().getStyle().setMargin(2, Style.Unit.EM);
		
		/* Logo */
		Image logo = new Image(Res.getResources().logo());
		topPanel.add(logo);		
		
		/* Association name label */
		Label associationName = new Label();
		/* Style */
		associationName.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		associationName.addStyleName("comicFont");
		/* Association name text */
		AuthenticationAsyncCallback callback = new AuthenticationAsyncCallback();
		callback.buildName(associationName);
		topPanel.add(associationName);
		topPanel.setHeight(0.4*height+"px");
		/**********************************************************************************/
		
		/********** Authentication panel **************************************************/
		VerticalPanel authenticationPanel = new VerticalPanel();
		/* Style */
		authenticationPanel.setWidth("80%");
		authenticationPanel.setHeight(0.2*height+"px");
		authenticationPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		authenticationPanel.getElement().getStyle().setBackgroundColor("DeepSkyBlue");
		
		/* Title label */
		Label authenticationTitle = new Label();
		/* Title Style */
		authenticationTitle.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		authenticationTitle.addStyleName("titleFont");		
		authenticationTitle.getElement().getStyle().setMargin(0.25, Style.Unit.EM);
		/* Title text */
		authenticationTitle.setText(title);//I18n.getI18nConstants().authentication());
		
		/* Validate Panel */
		VerticalPanel validatePanel = new VerticalPanel();
		/* Validate Style */
		validatePanel.setWidth("100%");
		validatePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);	
		/* Validate Button Style */
		validate.setStyleName("calibriFont");
		validate.getElement().getStyle().setMargin(0.25, Style.Unit.EM);
		/* Validate Button text */
		validate.setText(I18n.getI18nConstants().validate());	
		validatePanel.add(validate);
		
		/* Flextable authentication */
		FlexTable authenticationTable = new FlexTable();
		/* Flextable authentication size*/
		authenticationTable.setWidth("100%");
		authenticationTable.getCellFormatter().setWidth(0,0, "30%");
		authenticationTable.getCellFormatter().setWidth(0,1, "15%");
		authenticationTable.getCellFormatter().setWidth(0,2, "25%");
		authenticationTable.getCellFormatter().setWidth(0,3, "30%");	
		
		/* Login error label Style */
		loginError.setWidth("100%");
		loginError.setStyleName("calibriSmallFont");
		loginError.getElement().getStyle().setColor("red");
		/* Password error label style*/
		passwordError.setWidth("100%");
		passwordError.setStyleName("calibriSmallFont");
		passwordError.getElement().getStyle().setColor("red");
		/* Login title label */
		Label login = new Label();
		/* Login title label style */
		login.setWidth("100%");
		login.addStyleName("calibriFont");
		login.getElement().getStyle().setMargin(0.25, Style.Unit.EM);
		login.setText(I18n.getI18nConstants().login());
		/* Password title label */
		Label password = new Label();
		/* Password title label style */
		password.setWidth("100%");
		password.addStyleName("calibriFont");
		password.getElement().getStyle().setMargin(0.25, Style.Unit.EM);
		password.setText(I18n.getI18nConstants().password());
		/* Login input textBox style*/
		loginInput.setWidth("98%");
		loginInput.addStyleName("calibriFont");
		/* Password input textBox style */
		passwordInput.setWidth("98%");
		passwordInput.addStyleName("calibriFont");
		
		/* Fill authentication table */
		authenticationTable.setWidget(0, 1, login);
		authenticationTable.setWidget(1, 1, password);
		authenticationTable.setWidget(0, 2, loginInput);
		authenticationTable.setWidget(1, 2, passwordInput);
		authenticationTable.setWidget(0, 3, loginError);
		authenticationTable.setWidget(1, 3, passwordError);

		/* Fill authentication panel */
		authenticationPanel.add(authenticationTitle);
		authenticationPanel.add(authenticationTable);
		authenticationPanel.add(validatePanel);
		/************************************************************************************/
		
		/******************* authentication error panel *************************************/
		HorizontalPanel authenticationErrorPanel = new HorizontalPanel();
		/* Style */
		authenticationErrorPanel.setWidth("100%");
		authenticationErrorPanel.setHeight(0.05*height+"px");
		authenticationErrorPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/* Authentication error label style */
		authenticationError.getElement().getStyle().setColor("red");
		authenticationError.addStyleName("calibriFont");
		
		authenticationErrorPanel.add(authenticationError);
		/************************************************************************************/
		
		/******************* progress *******************************************************/
		//waiting
		/************************************************************************************/
		
		/******************* bottom panel ***************************************************/
		HorizontalPanel bottomPanel = new HorizontalPanel();
		/* style */
		bottomPanel.setWidth("100%");
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		/* Version label */
		Label version = new Label();
		/* Version label */	
		version.addStyleName("calibriSmallFont");
		/* Version label text */	
		version.setText(Res.getVersion().version());
		bottomPanel.add(version);
		/************************************************************************************/
		
		/****************** fill main panel *************************************************/
		panel.add(topPanel);
		panel.add(authenticationPanel);
		panel.add(authenticationErrorPanel);
//		panel.add(waiting);
		panel.add(bottomPanel);
		/************************************************************************************/
		
		return panel;
	}
	

}
