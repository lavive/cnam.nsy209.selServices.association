package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.controler.MemberResearchControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MemberResearchModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxWaiting;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;

public class MemberResearch extends AbstractPage implements Observer {
	
	/* Singleton */
	private static MemberResearch instance;
	public static MemberResearch get() {
		if(instance == null)
			instance = new MemberResearch((int)(0.78*WIDTH), (int)(0.65*HEIGHT));			
		
		return instance;
	}
	
	/* attributes */
	private FlexTable layout;
	private Label noResult;
	private Button validate;
	private Button reset;
	private MemberResearchControler controler;

	/* Constructor */
	private MemberResearch(int width, int height) {
		super(width, height);
		controler.getModel().onWaitingDisplay(null);
	}

	@Override
	public void update(Observable observable, Object object) {
		MemberResearchModel memberResearchModel = (MemberResearchModel) observable;

		/* update view */
		if(memberResearchModel.getMembersForList() != null &&
				!memberResearchModel.getMembersForList().isEmpty()) {
			memberResearchModel.setWaiting(false);
			DialogBoxWaiting.get(0, 0).hide();
	    	((MultiWordSuggestOracle)controler.getName().getSuggestOracle()).clear();
	    	((MultiWordSuggestOracle)controler.getForname().getSuggestOracle()).clear();
	    	((MultiWordSuggestOracle)controler.getAddress().getSuggestOracle()).clear();
	    	((MultiWordSuggestOracle)controler.getPostalCode().getSuggestOracle()).clear();
	    	((MultiWordSuggestOracle)controler.getTown().getSuggestOracle()).clear();
	    	((MultiWordSuggestOracle)controler.getCellNumber().getSuggestOracle()).clear();
		    for(MemberLocalDto member:memberResearchModel.getMembersForList()) {
		    	((MultiWordSuggestOracle)controler.getName().getSuggestOracle()).add(member.getName());
		    	((MultiWordSuggestOracle)controler.getForname().getSuggestOracle()).add(member.getForname());
		    	((MultiWordSuggestOracle)controler.getAddress().getSuggestOracle()).add(member.getAddress());
		    	((MultiWordSuggestOracle)controler.getPostalCode().getSuggestOracle()).add(member.getPostalCode());
		    	((MultiWordSuggestOracle)controler.getTown().getSuggestOracle()).add(member.getTown());
		    	((MultiWordSuggestOracle)controler.getCellNumber().getSuggestOracle()).add(member.getCellNumber());
		    }
		}
		controler.getName().setText(memberResearchModel.getProvisionalMember().getName());
		controler.getForname().setText(memberResearchModel.getProvisionalMember().getForname());
		controler.getAddress().setText(memberResearchModel.getProvisionalMember().getAddress());
		controler.getPostalCode().setText(memberResearchModel.getProvisionalMember().getPostalCode());
		controler.getTown().setText(memberResearchModel.getProvisionalMember().getTown());
		controler.getCellNumber().setText(memberResearchModel.getProvisionalMember().getCellNumber());
		
		/* input error */
		if(memberResearchModel.getMemberNameError() != null)
			layout.setHTML(1, 2,memberResearchModel.getMemberNameError().getErrorMessage());
		else {
			layout.setHTML(1, 2, "");
		}
		if(memberResearchModel.getMemberFornameError() != null)
			layout.setHTML(2, 2,memberResearchModel.getMemberFornameError().getErrorMessage());
		else {
			layout.setHTML(2, 2, "");
		}
		if(memberResearchModel.getMemberAddressError() != null)
			layout.setHTML(3, 2,memberResearchModel.getMemberAddressError().getErrorMessage());
		else {
			layout.setHTML(3, 2, "");
		}
		if(memberResearchModel.getMemberPostalCodeError() != null)
			layout.setHTML(4, 2,memberResearchModel.getMemberPostalCodeError().getErrorMessage());
		else {
			layout.setHTML(4, 2, "");
		}
		if(memberResearchModel.getMemberTownError() != null)
			layout.setHTML(5, 2,memberResearchModel.getMemberTownError().getErrorMessage());
		else {
			layout.setHTML(5, 2, "");
		}
		if(memberResearchModel.getMemberCellNumberError() != null)
			layout.setHTML(6, 2,memberResearchModel.getMemberCellNumberError().getErrorMessage());
		else {
			layout.setHTML(6, 2, "");
		}
		/* no result and waiting message */
		if(memberResearchModel.isNoResult()) {
			layout.setWidget(8, 0, noResult);
			noResult.setText(I18n.getI18nMessages().noMemberResult());
		}else if(memberResearchModel.isWaiting()) {
			validate.setEnabled(false);
			reset.setEnabled(false);
		} else {
			this.validate.setEnabled(true);
			this.reset.setEnabled(true);	
		}
	}

	@Override
	public IDisplayStrategy getDisplayStrategy(int width, int height, String title, LocalDto dto) {
		
		IDisplayStrategy displayStrategy = new SingleDisplayStrategy();
		displayStrategy.addPanel(buildPanel(width,height));
		
		return displayStrategy;
	}
	
	/* private helper method */
	/* to build the page panel */
	private Widget buildPanel(int width,int height) {	
		controler = new MemberResearchControler();
		controler.getModel().addObserver(this);
		/*********** Main Panel ***********************************************************/
		VerticalPanel panel = new VerticalPanel();
		/* Style */
		panel.setWidth(width+"px");
		panel.setHeight(height+"px");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**********************************************************************************/
		
	    /*********** Create a table to layout the form options ****************************/
	    layout = new FlexTable();
	    layout.setCellSpacing(10);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    
	    /* Add a title to the form */
	    layout.setHTML(0, 0, I18n.getI18nMessages().researchCriteria());
	    cellFormatter.setColSpan(0, 0, 3);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    /* Add fields to display */
	    this.controler.getModel().setMembersForList();
	    MultiWordSuggestOracle suggestNameOracle = new MultiWordSuggestOracle();
	    MultiWordSuggestOracle suggestFornameOracle = new MultiWordSuggestOracle();
	    MultiWordSuggestOracle suggestAddressOracle = new MultiWordSuggestOracle();
	    MultiWordSuggestOracle suggestPostalCodeOracle = new MultiWordSuggestOracle();
	    MultiWordSuggestOracle suggestTownOracle = new MultiWordSuggestOracle();
	    MultiWordSuggestOracle suggestCellNumber = new MultiWordSuggestOracle();
	    layout.setHTML(1, 0, I18n.getI18nConstants().name()+":");	    
	    SuggestBox name = new SuggestBox(suggestNameOracle);
	    layout.setWidget(1, 1,name);
	    layout.setHTML(1, 2, "");
	    
	    layout.setHTML(2, 0, I18n.getI18nConstants().forname()+":");
	    SuggestBox forname = new SuggestBox(suggestFornameOracle);
	    layout.setWidget(2, 1,forname);
	    layout.setHTML(2, 2, "");
	    
	    layout.setHTML(3, 0, I18n.getI18nConstants().address()+":");
	    SuggestBox address = new SuggestBox(suggestAddressOracle);
	    layout.setWidget(3, 1,address);
	    layout.setHTML(3, 2, "");
	    
	    layout.setHTML(4, 0, I18n.getI18nConstants().postalCode()+":");
	    SuggestBox postalCode = new SuggestBox(suggestPostalCodeOracle);
	    layout.setWidget(4, 1,postalCode);
	    layout.setHTML(4, 2, "");
	    	    
	    layout.setHTML(5, 0, I18n.getI18nConstants().town()+":");
	    SuggestBox town = new SuggestBox(suggestTownOracle);
	    layout.setWidget(5, 1,town);
	    layout.setHTML(5, 2, "");
	    
	    layout.setHTML(6, 0, I18n.getI18nConstants().cellNumber()+":");
	    SuggestBox cellNumber = new SuggestBox(suggestCellNumber);
	    layout.setWidget(6, 1,cellNumber);
	    layout.setHTML(6, 2, "");

	    /* Add a panel button */
	    HorizontalPanel buttonPanel = new HorizontalPanel();
	    buttonPanel.setWidth("100%");
	    buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    /* Buttons */
	    validate = new Button(I18n.getI18nConstants().validate());
	    validate.setWidth(width*0.15+"px");
	    validate.addClickHandler(controler.getValidateClickHandler());
	    reset = new Button(I18n.getI18nConstants().reset());	
	    reset.setWidth(width*0.15+"px");    
	    reset.addClickHandler(controler.getResetClickHandler());
	    buttonPanel.add(validate);
	    buttonPanel.add(reset);	   

	    layout.setWidget(7, 0, buttonPanel);
	    cellFormatter.setColSpan(7, 0, 3);
	    cellFormatter.setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    /* Add a Label to display no result */
	    noResult = new Label();
	    
	    /* style */
	    cellFormatter.setStyleName(0, 0, "titleFontFlexTable");
	    cellFormatter.setStyleName(1, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(1, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(2, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(3, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(4, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(5, 1, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 0, "calibriFontFlexTable");
	    cellFormatter.setStyleName(6, 1, "calibriFontFlexTable");
	    validate.setStyleName("singleButton");
	    reset.setStyleName("singleButton");
	    cellFormatter.setStyleName(8, 0, "errorLabel");
		/**********************************************************************************/
	    
		/***************** Fill the main panel ********************************************/	    
	    /* Wrap the contents in a DecoratorPanel */
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    panel.add(decPanel);
		/**********************************************************************************/

	    /***************** Controler ******************************************************/
	    name.getValueBox().addClickHandler(controler.getTextBoxClickHandler(name));
	    controler.setName(name);
	    forname.getValueBox().addClickHandler(controler.getTextBoxClickHandler(forname));
	    controler.setForname(forname);
	    address.getValueBox().addClickHandler(controler.getTextBoxClickHandler(address));
	    controler.setAddress(address);
	    postalCode.getValueBox().addClickHandler(controler.getTextBoxClickHandler(postalCode));
	    controler.setPostalCode(postalCode);
	    town.getValueBox().addClickHandler(controler.getTextBoxClickHandler(town));
	    controler.setTown(town);
	    cellNumber.getValueBox().addClickHandler(controler.getTextBoxClickHandler(cellNumber));
	    controler.setCellNumber(cellNumber);
	
	    controler.getModel().onInitialize();
		/**********************************************************************************/


	    return panel;
	}
}
