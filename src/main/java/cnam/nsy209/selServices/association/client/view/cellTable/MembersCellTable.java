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

import cnam.nsy209.selServices.association.client.controler.MembersDisplayControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MembersCellTable extends CellTable<MemberLocalDto> {
	
	/* attributes */
	private VerticalPanel panel;
	private ListDataProvider<MemberLocalDto> dataProvider;
	private MembersDisplayControler controler;
	
	/* Constructor */
	public MembersCellTable(int width, int height, String emptyMessage,List<MemberLocalDto> members,
							boolean allMember, MemberLocalDto attributes) {	
		super();
		controler = new MembersDisplayControler(width,height,members);
		if(allMember) controler.setAllMemberTrue();
		else if(attributes != null) controler.setResultMember(attributes);
		else controler.setLastMemberTrue();
		
		/************** main panel ****************************************************/
		panel = new VerticalPanel();
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    //setWidth("100%"); 
	    /******************************************************************************/
 
	    /************** Add a selection model so we can select cells ******************/	    
//	    final SingleSelectionModel<MemberDto> selectionModel = 
//	    		new SingleSelectionModel<MemberDto>(KEY_PROVIDER);
//	    this.setSelectionModel(selectionModel);
//	    selectionModel.addSelectionChangeHandler(getSelectionChangeEvent(selectionModel));
//	    
//	    /* an another selection model to test */
//	    final NoSelectionModel<MemberDto> selectionModel = new NoSelectionModel<MemberDto>();
//	    selectionModel.addSelectionChangeHandler(getSelectionChangeEvent2((selectionModel)));
//	    /* add selection model to dataGrid */
//	    setSelectionModel(selectionModel); 
	    /******************************************************************************/
		
		/****************** put datas on CellTable ************************************/	    
	    dataProvider = new ListDataProvider<MemberLocalDto>();
	    dataProvider.setList(members);		
	    setRowCount(dataProvider.getList().size());
	    setRowData(0, dataProvider.getList());
	    setEmptyTableWidget(new Label(emptyMessage));
	    dataProvider.addDataDisplay(this);
	    /******************************************************************************/
	    
	    /************** add the columns ***********************************************/
	    /* do not refresh the header */
	    setAutoHeaderRefreshDisabled(true); 
	    
	    /* column width*/
	    double columnWidth = width/9;
	    
	    /*  Forname */
	    TextColumn<MemberLocalDto> fornameColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getForname();
	          }
	    };
	    addColumn(fornameColumn, I18n.getI18nConstants().forname());
	    setColumnWidth(fornameColumn, columnWidth, Unit.PX);

	    /* Name */
	    TextColumn<MemberLocalDto> nameColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getName();
	          }
	    };
	    addColumn(nameColumn, I18n.getI18nConstants().name());
	    setColumnWidth(nameColumn, columnWidth, Unit.PX);

	    /* Address */
	    TextColumn<MemberLocalDto> addressColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getAddress();
	          }
	    };
	    addColumn(addressColumn, I18n.getI18nConstants().address());
	    setColumnWidth(addressColumn, columnWidth, Unit.PX);

	    /* Postal Code */
	    TextColumn<MemberLocalDto> postalCodeColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getPostalCode();
	          }
	    };
	    addColumn(postalCodeColumn, I18n.getI18nConstants().postalCode());
	    setColumnWidth(postalCodeColumn, columnWidth, Unit.PX);
	    
	    /* Town */
	    TextColumn<MemberLocalDto> townColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getTown();
	          }
	    };
	    addColumn(townColumn, I18n.getI18nConstants().town());
	    setColumnWidth(townColumn, columnWidth, Unit.PX);

	    /* Email */
	    TextColumn<MemberLocalDto> emailColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getEmail();
	          }
	    };
	    addColumn(emailColumn, I18n.getI18nConstants().email());
	    setColumnWidth(emailColumn, columnWidth, Unit.PX);

	    /* Cell Number */
	    TextColumn<MemberLocalDto> cellNumberColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getCellNumber();
	          }
	    };
	    addColumn(cellNumberColumn, I18n.getI18nConstants().cellNumber());
	    setColumnWidth(cellNumberColumn, columnWidth, Unit.PX);

	    /* Phone Number */
	    TextColumn<MemberLocalDto> phoneNumberColumn =
	        new TextColumn<MemberLocalDto>() {
	          @Override
	          public String getValue(MemberLocalDto object) {
	            return object.getPhoneNumber();
	          }
	    };
	    addColumn(phoneNumberColumn, I18n.getI18nConstants().postalCode());
	    setColumnWidth(phoneNumberColumn, columnWidth, Unit.PX);
	    
	    /* Delete Button */
		Column<MemberLocalDto,MemberLocalDto> deleteColumn = 
				new Column<MemberLocalDto, MemberLocalDto>(controler.getDeleteAction()) {
			
			@Override
			public MemberLocalDto getValue(MemberLocalDto object) {
				
				return object;
			}
		};
		addColumn(deleteColumn);
	    setColumnWidth(deleteColumn, columnWidth*0.5, Unit.PX);
	    
	    /* Look Button */
		Column<MemberLocalDto,MemberLocalDto> lookColumn = new Column<MemberLocalDto, MemberLocalDto>(controler.getLookAction()) {
			
			@Override
			public MemberLocalDto getValue(MemberLocalDto object) {
				
				return object;
			}
		};
		addColumn(lookColumn);
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
	
	/* helper method */	
//	/* to provide a key for cell table select */
//	private static final ProvidesKey<MemberDto> KEY_PROVIDER = new ProvidesKey<MemberDto>() {
//	      @Override
//	      public Object getKey(MemberDto item) {
//	        return item == null ? null : item.getId();
//	      }
//	};
//	private ActionCell<MemberDto> getDeleteAction(){
//		return new ActionCell<MemberDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<MemberDto>() {
//			 @Override
//			 public void execute(MemberDto member) {
//				 DialogBoxConfirm<MemberDto> dialogBox = new DialogBoxConfirm<MemberDto>(member,
//						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
//				 dialogBox.center();
//				 dialogBox.show();
//			 }
//		 });
//
//	}
//	private ActionCell<MemberDto> getLookAction(){
//		return new ActionCell<MemberDto>(I18n.getI18nConstants().look(), new ActionCell.Delegate<MemberDto>() {
//			 @Override
//			 public void execute(MemberDto member) {
//				 Window.alert("You want to see: " + member.getName());
//			 }
//		 });
//
//	}
//	private SelectionChangeEvent.Handler getSelectionChangeEvent(SingleSelectionModel<MemberDto> selectionModel){
//		return	new SelectionChangeEvent.Handler() {
//			        public void onSelectionChange(SelectionChangeEvent event) {
//			       	 MemberDto selected = selectionModel.getSelectedObject();
//			           if (selected != null) {
//			              Window.alert("You selected: " + selected.getName());
//			           }
//			        }
//			     };
//	}
//	private SelectionChangeEvent.Handler getSelectionChangeEvent2(NoSelectionModel<MemberDto> selectionModel){
//		return	new SelectionChangeEvent.Handler() {
//			        public void onSelectionChange(SelectionChangeEvent event) {
//			       	 MemberDto selected = selectionModel.getLastSelectedObject();
//			           if (selected != null) {
//			              Window.alert("You selected: " + selected.getName());
//			           }
//			        }
//			     };
//	}
//	private IActionToTransmit<MemberDto> clickHandlerToTransmit() {
//		return new IActionToTransmit<MemberDto>() {
//			@Override
//			public void action(MemberDto member) {
//				 dataProvider.getList().remove(member);
//				 dataProvider.refresh();
//				
//			}
//      };
//	}	

	/* getter */
	public ListDataProvider<MemberLocalDto> getDataProvider() {
		return dataProvider;
	}

	public MembersDisplayControler getControler() {
		return controler;
	}

}
