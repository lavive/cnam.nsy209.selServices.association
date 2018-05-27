package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MessagesDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.MessageCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

public class MessagesDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MessagesDisplay instance;
	public static MessagesDisplay get() {
		if(instance == null)
			instance = new MessagesDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT));			
		
		return instance;
	}

	/* Attribute */
	private List<MessageLocalDto> messages;
	private MessageCellTable messagesTable;

	/* Constructor */
	private MessagesDisplay(int width,int height) {
		super(width,height);
		messagesTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		messages = ((MessagesDisplayModel) observable).getMessages();
		
		messagesTable.getDataProvider().setList(messages);
		messagesTable.getDataProvider().refresh();
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
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
		/*********** Data Grid Member *****************************************************/
		messages =  new ArrayList<MessageLocalDto>();
		messagesTable = new MessageCellTable(width,height,I18n.getI18nMessages().noMessage(),messages);
		/**********************************************************************************/
		
		panel.add(messagesTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public MessageCellTable getMessagesTable() {
		return messagesTable;
	}

}
