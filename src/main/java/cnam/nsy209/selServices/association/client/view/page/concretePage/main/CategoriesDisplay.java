package cnam.nsy209.selServices.association.client.view.page.concretePage.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.CategoriesDisplayModel;
import cnam.nsy209.selServices.association.client.view.cellTable.CategoryCellTable;
import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.client.view.helper.Observer;
import cnam.nsy209.selServices.association.client.view.page.AbstractPage;
import cnam.nsy209.selServices.association.client.view.strategy.IDisplayStrategy;
import cnam.nsy209.selServices.association.client.view.strategy.SingleDisplayStrategy;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.LocalDto;

public class CategoriesDisplay extends AbstractPage implements Observer {
	
	/* Singleton */
	private static CategoriesDisplay instance;
	public static CategoriesDisplay get() {
		if(instance == null)
			instance = new CategoriesDisplay((int)(0.78*WIDTH), (int)(0.65*HEIGHT));			
		
		return instance;
	}

	/* Attribute */
	private List<CategoryLocalDto> categories;
	private CategoryCellTable categoriesTable;

	/* Constructor */
	private CategoriesDisplay(int width,int height) {
		super(width,height);
		categoriesTable.getControler().getModel().addObserver(this);
	}

	@Override
	public void update(Observable observable, Object object) {
		categories = ((CategoriesDisplayModel) observable).getCategories();
		
		categoriesTable.getDataProvider().setList(categories);
		categoriesTable.getDataProvider().refresh();
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
		categories = new ArrayList<CategoryLocalDto>();//CategoryCellTable.categories();
		categoriesTable = new CategoryCellTable(width,height,I18n.getI18nMessages().noCategory(),
											categories);
		/**********************************************************************************/
		
		panel.add(categoriesTable.getPanel());
		
		return panel;
	}
	
	/* getter */

	public CategoryCellTable getCategoriesTable() {
		return categoriesTable;
	}

}
