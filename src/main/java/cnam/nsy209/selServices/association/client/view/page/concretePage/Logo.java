package cnam.nsy209.selServices.association.client.view.page.concretePage;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.asyncCallback.AuthenticationAsyncCallback;
import cnam.nsy209.selServices.association.client.model.LogoModel;
import cnam.nsy209.selServices.association.client.resources.Res;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class Logo extends AbstractPage implements Observer{
	
	/* Singleton */
	private static Logo instance;
	public static Logo get() {
		if(instance == null)
			instance = new Logo((int)(0.2*WIDTH), (int)(0.25*HEIGHT));
		
		return instance;
	}
	
	/* Attribute */
	private Label associationName;

	/* Constructor */
	private Logo(int width,int height) {
		super(width,height);
		
	}

	@Override
	public void update(Observable observable, Object object) {
		associationName.setText(((LogoModel) observable).getAssociationName());
		
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width,int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}	
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {
		LogoModel.get().addObserver(this);
		
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/*********** Logo *****************************************************************/
		Image logo = new Image(Res.getResources().logo());
		int logoWidth = width/2;
		int logoHeight = logoWidth;
		logo.setWidth(logoWidth+"px");
		logo.setHeight(logoHeight+"px");
		/**********************************************************************************/
		
		/*********** Association name label ***********************************************/
		associationName = new Label();
		/* Style */
		associationName.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		associationName.addStyleName("comicSmallFont");
		/* Association name text */
		AuthenticationAsyncCallback callback = new AuthenticationAsyncCallback();
		callback.buildName(associationName);
		/**********************************************************************************/
		
		/********** Fill Main Panel *******************************************************/
		panel.setHeight(height+"px");
		panel.add(logo);
		panel.add(associationName);
		/**********************************************************************************/
		
		return panel;
		
	}
	
}
