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

import cnam.nsy209.selServices.association.client.controler.DemandsDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class DemandsCellTable extends CellTable<SupplyDemandLocalDto> {
	
	/* attributes */
	private VerticalPanel panel;
	private ListDataProvider<SupplyDemandLocalDto> dataProvider;
	private DemandsDisplayControler controler;
	
	/* Constructor */
	public DemandsCellTable(int width, int height, String emptyMessage,List<SupplyDemandLocalDto> suppliesDemands) {	
		super();
		controler = new DemandsDisplayControler(suppliesDemands);
		
		/************** main panel ****************************************************/
		panel = new VerticalPanel();
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /******************************************************************************/
 
	    /************** Add a selection model so we can select cells ******************/
	    /******************************************************************************/
		
		/****************** put datas on CellTable ************************************/	    
	    dataProvider = new ListDataProvider<SupplyDemandLocalDto>();
	    dataProvider.setList(suppliesDemands);		
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
	    
	    /*  Category */
	    TextColumn<SupplyDemandLocalDto> categoryColumn =
	        new TextColumn<SupplyDemandLocalDto>() {
	          @Override
	          public String getValue(SupplyDemandLocalDto object) {
	            return object.getCategory();
	          }
	    };
	    addColumn(categoryColumn, I18n.getI18nConstants().category());
	    setColumnWidth(categoryColumn, 2*columnWidth, Unit.PX);

	    /* Title */
	    TextColumn<SupplyDemandLocalDto> titleColumn =
	        new TextColumn<SupplyDemandLocalDto>() {
	          @Override
	          public String getValue(SupplyDemandLocalDto object) {
	            return object.getTitle();
	          }
	    };
	    addColumn(titleColumn, I18n.getI18nConstants().description());
	    setColumnWidth(titleColumn, 5*columnWidth, Unit.PX);

	    /* Emitter */
	    TextColumn<SupplyDemandLocalDto> emitterColumn =
	        new TextColumn<SupplyDemandLocalDto>() {
	          @Override
	          public String getValue(SupplyDemandLocalDto object) {
	            return object.getMember().getFullName();
	          }
	    };
	    addColumn(emitterColumn, I18n.getI18nConstants().emitter());
	    setColumnWidth(emitterColumn, 2*columnWidth, Unit.PX);
	    
	    /* Delete Button */
		Column<SupplyDemandLocalDto,SupplyDemandLocalDto> deleteColumn = 
				new Column<SupplyDemandLocalDto, SupplyDemandLocalDto>(controler.getDeleteAction()) {
			
			@Override
			public SupplyDemandLocalDto getValue(SupplyDemandLocalDto object) {
				
				return object;
			}
		};
		addColumn(deleteColumn);
	    setColumnWidth(deleteColumn, columnWidth, Unit.PX);
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


	/* getter */
	public ListDataProvider<SupplyDemandLocalDto> getDataProvider() {
		return dataProvider;
	}

	public DemandsDisplayControler getControler() {
		return controler;
	}

}

