package cnam.nsy209.selServices.association.client.view.cellTable;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import cnam.nsy209.selServices.association.client.controler.MessagesDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.shared.localDto.MessageLocalDto;

public class MessageCellTable extends CellTable<MessageLocalDto> {
	
	/* attributes */
	private VerticalPanel panel;
	private ListDataProvider<MessageLocalDto> dataProvider;
	private MessagesDisplayControler controler;
	
	/* Constructor */
	public MessageCellTable(int width, int height, String emptyMessage,List<MessageLocalDto> messages) {	
		super();
		controler = new MessagesDisplayControler(messages);
		
		/************** main panel ****************************************************/
		panel = new VerticalPanel();
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /******************************************************************************/
 
	    /************** Add a selection model so we can select cells ******************/	
	    /******************************************************************************/
		
		/****************** put datas on CellTable ************************************/	    
	    dataProvider = new ListDataProvider<MessageLocalDto>();
	    dataProvider.setList(messages);		
	    setRowCount(dataProvider.getList().size());
	    setRowData(0, dataProvider.getList());
	    setEmptyTableWidget(new Label(emptyMessage));
	    dataProvider.addDataDisplay(this);
	    /******************************************************************************/
	    
	    /************** add the columns ***********************************************/
	    /* do not refresh the header */
	    setAutoHeaderRefreshDisabled(true); 
	    
	    /* column width*/
	    double columnWidth = width*0.1;
	    
//	    /* Date */
//	    TextColumn<MessageLocalDto> dateColumn =
//	        new TextColumn<MessageLocalDto>() {
//	          @Override
//	          public String getValue(MessageLocalDto object) {
//	        	  DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
//	        	  return dateFormat.format(object.getDateLastUpdate());
//	          }
//	    };
//	    addColumn(dateColumn, I18n.getI18nConstants().date());
//	    setColumnWidth(dateColumn, columnWidth, Unit.PX);
	    
	    /* Title */
	    TextColumn<MessageLocalDto> titleColumn =
	        new TextColumn<MessageLocalDto>() {
	          @Override
	          public String getValue(MessageLocalDto object) {
	        	  return object.getTitle();
	          }
	    };
	    addColumn(titleColumn, I18n.getI18nConstants().title());
	    setColumnWidth(titleColumn, 2*columnWidth, Unit.PX);
	    
	    /* Text */
	    TextColumn<MessageLocalDto> textColumn =
	        new TextColumn<MessageLocalDto>() {
	          @Override
	          public String getValue(MessageLocalDto object) {
	        	  return object.getText();
	          }
	    };
	    addColumn(textColumn, I18n.getI18nConstants().statement());
	    setColumnWidth(textColumn, 4.5*columnWidth, Unit.PX);
	    
	    /* Emitter */
	    TextColumn<MessageLocalDto> emitterColumn =
	        new TextColumn<MessageLocalDto>() {
	          @Override
	          public String getValue(MessageLocalDto object) {
	        	  return object.getEmitterPerson().getName();
	          }
	    };
	    addColumn(emitterColumn, I18n.getI18nConstants().emitter());
	    setColumnWidth(emitterColumn, 2*columnWidth, Unit.PX);
	    
	    
	    /* Delete Button */
		Column<MessageLocalDto,MessageLocalDto> deleteColumn = new Column<MessageLocalDto, MessageLocalDto>(controler.getDeleteAction()) {
			
			@Override
			public MessageLocalDto getValue(MessageLocalDto object) {
				
				return object;
			}
		};
		addColumn(deleteColumn);
	    setColumnWidth(deleteColumn, columnWidth*0.5, Unit.PX);
		/******************************************************************************/

	    /****************** Create a Pager to control the table ***********************/
	    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	    pager.setDisplay(this);
	    pager.setPageSize(10);
	    /******************************************************************************/
	    
	    /****************** Fill the main panel ***************************************/
	    panel.add(this);
	    panel.add(pager);
	    /******************************************************************************/
	}
	
	/* getter */
	public VerticalPanel getPanel() {
		return panel;
	}	
	
//	private ActionCell<MessageDto> getDeleteAction(){
//		return new ActionCell<MessageDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<MessageDto>() {
//			 @Override
//			 public void execute(MessageDto message) {
//				 DialogBoxConfirm<MessageDto> dialogBox = new DialogBoxConfirm<MessageDto>(message,
//						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
//				 dialogBox.center();
//				 dialogBox.show();
//			 }
//		 });
//
//	}
//	private IActionToTransmit<MessageDto> clickHandlerToTransmit() {
//		return new IActionToTransmit<MessageDto>() {
//			@Override
//			public void action(MessageDto message) {
//				 dataProvider.getList().remove(message);
//				 dataProvider.refresh();
//				
//			}
//      };
//	}		

	/* getter */
	public ListDataProvider<MessageLocalDto> getDataProvider() {
		return dataProvider;
	}

	public MessagesDisplayControler getControler() {
		return controler;
	}

}