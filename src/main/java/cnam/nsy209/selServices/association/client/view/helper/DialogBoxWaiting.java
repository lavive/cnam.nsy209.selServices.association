package cnam.nsy209.selServices.association.client.view.helper;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import cnam.nsy209.selServices.association.client.model.WaitingModel;

public class DialogBoxWaiting extends DialogBox implements Observer{
	
	/* Singleton */
	private static DialogBoxWaiting instance;
	public static DialogBoxWaiting get(int width, int height) {
		if(instance == null)
			instance = new DialogBoxWaiting(new WaitingTransfer(width,height));			
		
		return instance;
	}
	
	/* Constructor */
	private DialogBoxWaiting(WaitingTransfer waiting) {
		super();
		onInitialize(waiting);
	}	
	
	/* Attributes */
	private WaitingTransfer waiting;

	@Override
	public void update(Observable observable, Object object) {
		WaitingModel model = (WaitingModel) observable;
		
		if(model.isWaiting()) {
			if(!this.waiting.isRunning())
				this.waiting.start();
			center();
			show();
		}
		else {
			if(this.waiting.isRunning())
				this.waiting.stop();	
			hide();			
		}
		
	}

	/* helper method */
	private void onInitialize(WaitingTransfer waiting) {
		this.waiting = waiting;
		
	    /**************** Create the main panel *******************************************************/
	    VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		//panel.setSpacing(20);
		panel.setWidth("100%");
	    /**********************************************************************************************/
	    
	    /**************** Create dialog box contents **************************************************/
	    HorizontalPanel upPanel = new HorizontalPanel();
	    upPanel.setHeight(this.waiting.getHeight()*0.50+"px");
	    
	    HorizontalPanel midleRightPanel = new HorizontalPanel();
	    midleRightPanel.setWidth(this.waiting.getWidth()*0.27+"px");
	    
	    HorizontalPanel midlePanel = new HorizontalPanel();
	    midlePanel.setWidth(this.waiting.getWidth()+"px");
	    midlePanel.add(midleRightPanel);
	    midlePanel.add(this.waiting);
	    
	    panel.add(upPanel);
	    panel.add(midlePanel);
//	    panel.add(this.waiting);
	    setWidth(this.waiting.getWidth()+"px");
	    setHeight(this.waiting.getHeight()+"px");
	    setWidget(panel);
	    /**********************************************************************************************/	    
	    
	    /* dialog box effects */
	    setGlassEnabled(true);
	    setAnimationEnabled(true);
	    hide();
	}

}

