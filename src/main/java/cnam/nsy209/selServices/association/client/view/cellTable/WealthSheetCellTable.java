package cnam.nsy209.selServices.association.client.view.cellTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import cnam.nsy209.selServices.association.client.controler.WealthSheetDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.shared.localDto.TransactionDisplayLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;

public class WealthSheetCellTable extends CellTable<TransactionDisplayLocalDto> {
	
	/* attributes */
	private VerticalPanel panel;
	private ListDataProvider<TransactionDisplayLocalDto> dataProvider;
	private WealthSheetDisplayControler controler;
//	private MemberAsyncCallback memberCallback;
//	private SupplyDemandAsyncCallback supplyDemandCallback;
	
	/* Constructor */
	public WealthSheetCellTable(int width, int height, String emptyMessage,WealthSheetLocalDto wealthSheet,
								String name) {	
		super();
//		memberCallback = new MemberAsyncCallback();
//		supplyDemandCallback = new SupplyDemandAsyncCallback();
		
		controler = new WealthSheetDisplayControler(width,height);
		
		/************** main panel ****************************************************/
		panel = new VerticalPanel();
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /******************************************************************************/
		
		/************** name & account panel ******************************************/
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setWidth(width+"px");
		hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label nameLabel = new Label();
		nameLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		nameLabel.addStyleName("calibriFont");
		nameLabel.setText(name);
		
		Label accountLabel = new Label();
		accountLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		accountLabel.addStyleName("calibriFont");
		accountLabel.setText(I18n.getI18nConstants().account()+" "+wealthSheet.getFinalAccount());
		
		hPanel.add(nameLabel);
		hPanel.add(accountLabel);
	    /******************************************************************************/
 
	    /************** Add a selection model so we can select cells ******************/	
	    /******************************************************************************/
	    
	    /************** add the columns ***********************************************/
	    /* do not refresh the header */
	    setAutoHeaderRefreshDisabled(true); 
	    
	    /* column width*/
	    double columnWidth = width*0.1;
	    
//	    /*  Creditor */
//	    TextColumn<TransactionLocalDto> creditorColumn =
//	        new TextColumn<TransactionLocalDto>() {
//	          @Override
//	          public String getValue(TransactionLocalDto object) {
//	        	  MemberLocalDto creditor = new MemberLocalDto();
//	        	  MemberAsyncCallback memberCallback = new MemberAsyncCallback();
//	        	  memberCallback.getMember(object.getCreditorMemberId(), creditor);
//	              return creditor.getFullName();//object.getCreditorMember().getFullName();
//	          }
//	    };
//	    addColumn(creditorColumn, I18n.getI18nConstants().creditor());
//	    setColumnWidth(creditorColumn, 1.5*columnWidth, Unit.PX);
//	    
//	    /*  Debtor */
//	    TextColumn<TransactionLocalDto> debtorColumn =
//	        new TextColumn<TransactionLocalDto>() {
//	          @Override
//	          public String getValue(TransactionLocalDto object) {
//	        	  MemberLocalDto debtor = new MemberLocalDto();
//	        	  MemberAsyncCallback memberCallback = new MemberAsyncCallback();
//	        	  memberCallback.getMember(object.getDebtorMemberId(), debtor);
//	              return debtor.getFullName();//object.getDebtorMember().getFullName();
//	          }
//	    };
//	    addColumn(debtorColumn, I18n.getI18nConstants().debtor());
//	    setColumnWidth(debtorColumn, 1.5*columnWidth, Unit.PX);
//
//	    /* SupplyDemand */
//	    TextColumn<TransactionLocalDto> supplyDemandColumn =
//	        new TextColumn<TransactionLocalDto>() {
//	          @Override
//	          public String getValue(TransactionLocalDto object) {
//	        	  SupplyDemandLocalDto supplyDemand = new SupplyDemandLocalDto();
//	        	  SupplyDemandAsyncCallback supplyDemandCallback = new SupplyDemandAsyncCallback();
//	        	  supplyDemandCallback.getSupplyDemand(object.getSupplyDemandId(), supplyDemand);
//	              return supplyDemand.getTitle();//object.getSupplyDemand().getTitle();
//	          }
//	    };
//	    addColumn(supplyDemandColumn, I18n.getI18nConstants().supplyDemand());
//	    setColumnWidth(supplyDemandColumn, 5*columnWidth, Unit.PX);
//
//	    /* Amount */
//	    TextColumn<TransactionLocalDto> amountColumn =
//	        new TextColumn<TransactionLocalDto>() {
//	          @Override
//	          public String getValue(TransactionLocalDto object) {
//	            return object.getAmount().toString();
//	          }
//	    };
//	    addColumn(amountColumn, I18n.getI18nConstants().amount());
//	    setColumnWidth(amountColumn, columnWidth, Unit.PX);
	    /*  Creditor */
	    TextColumn<TransactionDisplayLocalDto> creditorColumn =
	        new TextColumn<TransactionDisplayLocalDto>() {
	          @Override
	          public String getValue(TransactionDisplayLocalDto object) {
	              return object.getCreditorMember().getFullName();
	          }
	    };
	    addColumn(creditorColumn, I18n.getI18nConstants().creditor());
	    setColumnWidth(creditorColumn, 1.5*columnWidth, Unit.PX);
	    
	    /*  Debtor */
	    TextColumn<TransactionDisplayLocalDto> debtorColumn =
	        new TextColumn<TransactionDisplayLocalDto>() {
	          @Override
	          public String getValue(TransactionDisplayLocalDto object) {
	              return object.getDebtorMember().getFullName();
	          }
	    };
	    addColumn(debtorColumn, I18n.getI18nConstants().debtor());
	    setColumnWidth(debtorColumn, 1.5*columnWidth, Unit.PX);

	    /* SupplyDemand */
	    TextColumn<TransactionDisplayLocalDto> supplyDemandColumn =
	        new TextColumn<TransactionDisplayLocalDto>() {
	          @Override
	          public String getValue(TransactionDisplayLocalDto object) {
	              return object.getSupplyDemand().getTitle();
	          }
	    };
	    addColumn(supplyDemandColumn, I18n.getI18nConstants().supplyDemand());
	    setColumnWidth(supplyDemandColumn, 5*columnWidth, Unit.PX);

	    /* Amount */
	    TextColumn<TransactionDisplayLocalDto> amountColumn =
	        new TextColumn<TransactionDisplayLocalDto>() {
	          @Override
	          public String getValue(TransactionDisplayLocalDto object) {
	            return object.getAmount().toString();
	          }
	    };
	    addColumn(amountColumn, I18n.getI18nConstants().amount());
	    setColumnWidth(amountColumn, columnWidth, Unit.PX);
		/******************************************************************************/
		
		/****************** put datas on CellTable ************************************/	    
	    dataProvider = new ListDataProvider<TransactionDisplayLocalDto>();
	    dataProvider.setList(wealthSheet.getTransactionsDisplay());		
	    setRowCount(dataProvider.getList().size());
	    setRowData(0, dataProvider.getList());
	    setEmptyTableWidget(new Label(emptyMessage));
	    dataProvider.addDataDisplay(this);
	    /******************************************************************************/

	    /****************** Create a Pager to control the table ***********************/
	    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	    pager.setDisplay(this);
	    pager.setPageSize(10);
	    /******************************************************************************/

	    /****************** Panel for 'Add' Button************* ***********************/
//	    HorizontalPanel buttonPanel = new HorizontalPanel();
//	    buttonPanel.setWidth(width+"px");
//	    buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//	    
//	    Button add = new Button(I18n.getI18nConstants().add());
//	    add.setStyleName("singleButton");
//	    add.addClickHandler(controler.getAddClickHandler());
//	    
//	    buttonPanel.add(add);
	    /******************************************************************************/
	    
	    /****************** Fill the main panel ***************************************/
	    panel.add(hPanel);
	    panel.add(this);
	    panel.add(pager);
//	    panel.add(buttonPanel);
	    /******************************************************************************/
	}
	
	/* getter */
	public VerticalPanel getPanel() {
		return panel;
	}

	/* getter */
	public ListDataProvider<TransactionDisplayLocalDto> getDataProvider() {
		return dataProvider;
	}

	public WealthSheetDisplayControler getControler() {
		return controler;
	}
	

}

