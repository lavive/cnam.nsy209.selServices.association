package cnam.nsy209.selServices.association.client.view.cellTable;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import cnam.nsy209.selServices.association.client.controler.CategoriesDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

public class CategoryCellTable extends CellTable<CategoryLocalDto> {
	
	/* attributes */
	private VerticalPanel panel;
	private ListDataProvider<CategoryLocalDto> dataProvider;
	private CategoriesDisplayControler controler;
	
	/* Constructor */
	public CategoryCellTable(int width, int height, String emptyMessage,List<CategoryLocalDto> categories) {	
		super();
		controler = new CategoriesDisplayControler(width,height,categories);
		
		/************** main panel ****************************************************/
		panel = new VerticalPanel();
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /******************************************************************************/
 
	    /************** Add a selection model so we can select cells ******************/	
	    /******************************************************************************/
		
		/****************** put datas on CellTable ************************************/	    
	    dataProvider = new ListDataProvider<CategoryLocalDto>();
	    dataProvider.setList(categories);		
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
	    
	    /*  Name */
	    TextColumn<CategoryLocalDto> nameColumn =
	        new TextColumn<CategoryLocalDto>() {
	          @Override
	          public String getValue(CategoryLocalDto object) {
	            return object.getName();
	          }
	    };
	    addColumn(nameColumn, I18n.getI18nConstants().category());
	    setColumnWidth(nameColumn, 8*columnWidth, Unit.PX);
	    
	    /* Delete Button */
		Column<CategoryLocalDto,CategoryLocalDto> deleteColumn = 
				new Column<CategoryLocalDto, CategoryLocalDto>(controler.getDeleteAction()) {
			
			@Override
			public CategoryLocalDto getValue(CategoryLocalDto object) {
				
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

	    /****************** Panel for 'Add' Button************* ***********************/
	    HorizontalPanel buttonPanel = new HorizontalPanel();
	    buttonPanel.setWidth(width+"px");
	    buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
	    
	    Button add = new Button(I18n.getI18nConstants().add());
	    add.setStyleName("singleButton");
	    add.addClickHandler(controler.getAddClickHandler());
	    
	    buttonPanel.add(add);
	    /******************************************************************************/
	    
	    /****************** Fill the main panel ***************************************/
	    panel.add(this);
	    panel.add(pager);
	    panel.add(buttonPanel);
	    /******************************************************************************/
	}
	
	/* getter */
	public VerticalPanel getPanel() {
		return panel;
	}
	
//	private ActionCell<CategoryDto> getDeleteAction(){
//		return new ActionCell<CategoryDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<CategoryDto>() {
//			 @Override
//			 public void execute(CategoryDto category) {
//				 DialogBoxConfirm<CategoryDto> dialogBox = new DialogBoxConfirm<CategoryDto>(category,
//						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
//				 dialogBox.center();
//				 dialogBox.show();
//			 }
//		 });
//
//	}
//	private IActionToTransmit<CategoryDto> clickHandlerToTransmit() {
//		return new IActionToTransmit<CategoryDto>() {
//			@Override
//			public void action(CategoryDto category) {
//				 dataProvider.getList().remove(category);
//				 dataProvider.refresh();
//				
//			}
//      };
//	}	

	/* getter */
	public ListDataProvider<CategoryLocalDto> getDataProvider() {
		return dataProvider;
	}

	public CategoriesDisplayControler getControler() {
		return controler;
	}

}
