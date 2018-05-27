package cnam.nsy209.selServices.association.client.view.page;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

/**
 * 
 * An abstract page to display
 *
 */
public abstract class AbstractPage extends Composite implements IPage {
	
	/* Static attributes */
	protected static final int WIDTH = Window.getClientWidth();
	protected static final int HEIGHT = Window.getClientHeight();
	
	/* Attributes */
	
	private IDisplayStrategy displayStrategy;
	
	/* Constructors */
	
	protected AbstractPage(int width,int height) {
		this.displayStrategy = getDisplayStrategy(width,height,null,null);
		initWidget(layout());
	}
	
	protected AbstractPage(int width,int height,String title) {
		this.displayStrategy = getDisplayStrategy(width,height,title,null);
		initWidget(layout());
	}
	
	protected AbstractPage(int width,int height,LocalDto dto) {
		this.displayStrategy = getDisplayStrategy(width,height,null,dto);
		initWidget(layout());
	}
	
	
	/* Method */

	@Override
	public final Widget layout() {
		return this.displayStrategy.display();		
	}
	
	public abstract IDisplayStrategy getDisplayStrategy(int width,int height,String title,LocalDto dto);

}
