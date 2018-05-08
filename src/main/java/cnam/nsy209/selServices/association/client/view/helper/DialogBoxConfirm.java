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

public class DialogBoxConfirm<T> extends DialogBox{
	
	private T object;
	
	/* Constructor */
	public DialogBoxConfirm(T t,String textToDisplay,IActionToTransmit<T> actionConfirm) {
		super();
		object = t;
		onInitialize(textToDisplay,actionConfirm);
	}	

	/* helper method */
	private void onInitialize(String textToDisplay,IActionToTransmit<T> actionConfirm) {
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
	    
	    Button cancel = new Button();
	    cancel.setWidth(width*0.25+"px");
	    cancel.setStyleName("buttonDialog");
	    cancel.setText(I18n.getI18nConstants().cancel());
	    cancel.addClickHandler(getClickCancel());
	    Button confirm = new Button();
	    confirm.setWidth(width*0.25+"px");
	    confirm.setStyleName("buttonDialog");
	    confirm.setText(I18n.getI18nConstants().confirm());
	    confirm.addClickHandler(getClickConfirm(actionConfirm));
	    
	    hPanel.add(cancel);
	    hPanel.add(confirm);
	    
	    panel.add(sentence);
	    panel.add(hPanel);
	    
	    setWidget(panel);
	    /**********************************************************************************************/	    
	    
	    /* dialog box effects */
	    setGlassEnabled(true);
	    setAnimationEnabled(true);
	}
	
	/* helper Method */
	private ClickHandler getClickCancel() {
		return new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						hide();
						clear();
					}
	          };
	}	
	private ClickHandler getClickConfirm(IActionToTransmit<T> action) {
		return new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						hide();
						action.action(object);
						clear();
					}
	          };
	}	

}
