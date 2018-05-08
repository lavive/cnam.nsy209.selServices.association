package cnam.nsy209.selServices.association.client.view.helper;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cnam.nsy209.selServices.association.client.internationalization.I18n;

public class DialogBoxMessage extends DialogBox{
	
	/* Constructor */
	public DialogBoxMessage(String textToDisplay) {
		super();
		onInitialize(textToDisplay);		
	}	

	/* helper method */
	private void onInitialize(String textToDisplay) {
	    /**************** Create the main panel *******************************************************/
		int width = Window.getClientWidth()/3;
	    VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setSpacing(20);
	    /**********************************************************************************************/
	    
	    /**************** Create dialog box contents **************************************************/
	    /* Add some text */
	    Label sentence = new Label();
	    sentence.addStyleName("titleFont");
	    sentence.setText(textToDisplay);
	    
	    /* panel for buttons */
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setWidth("25%");
	    hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    hPanel.setSpacing(20);
	    
	    Button ok = new Button();
	    ok.setWidth(width*0.25+"px");
	    ok.setStyleName("buttonDialog");
	    ok.setText(I18n.getI18nConstants().ok());
	    ok.addClickHandler(getClickOK());
	    
	    hPanel.add(ok);
	    
	    panel.add(sentence);
	    panel.add(hPanel);
	    
	    setWidget(panel);
	    /**********************************************************************************************/	    
	    
	    /* dialog box effects */
	    setGlassEnabled(true);
	    setAnimationEnabled(true);
	}
	
	/* helper Method */
	private ClickHandler getClickOK() {
		return new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						hide();
						clear();
					}
	          };
	}

}
