package cnam.nsy209.selServices.association.client.view.page.concretePage;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.BottomBandModel;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class BottomBand extends AbstractPage implements Observer {
	
	/* Singleton */
	private static BottomBand instance;
	public static BottomBand get() {
		if(instance == null)
			instance = new BottomBand((int)(0.98*WIDTH), (int)(0.65*HEIGHT));
		
		return instance;
	}
	
	/* Attribute */
	private Label text;

	private BottomBand(int width, int height) {
		super(width, height);
		BottomBandModel.get().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		BottomBandModel model = (BottomBandModel) observable;
		
		text.setText(model.getAssociationDatas());

	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height,String title,LocalDto dto) {
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {

		/*********** Main Panel ***********************************************************/
		HorizontalPanel panel = new HorizontalPanel();
		/* Style */
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		
		text = new Label();
		text.setWidth("100%");
		text.setHeight("100%");
		text.getElement().getStyle().setBackgroundColor(I18n.getI18nConstants().backgroundColor());
		text.addStyleName("BottomBand");
		text.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		text.setText("");//getAssociationDatas());
		
		panel.add(text);
		/**********************************************************************************/
		
		return panel;
	}

}
