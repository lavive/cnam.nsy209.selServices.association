package cnam.nsy209.selServices.association.client.controler;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.asyncCallback.CategoryAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.CategoriesDisplayModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.client.view.page.CategoryEditPage;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

public class CategoriesDisplayControler {
	
	/* Attributes */
	private CategoriesDisplayModel model;
	private int width;
	private int height;
	
	/* Constructors */
	public CategoriesDisplayControler(int width, int height, List<CategoryLocalDto> categories) {
		this.height = height;
		this.width = width;
		this.model = CategoriesDisplayModel.get(categories);
	}
	
	/* get the handler for add button */
	public ClickHandler getAddClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				RootPanel.get().add(new CategoryEditPage(CategoriesDisplayControler.this.width,
						CategoriesDisplayControler.this.height));
			}
		};
		
		return clickHandler;
	}
	
	/* get the action for delete button */
	public ActionCell<CategoryLocalDto> getDeleteAction(){
		return new ActionCell<CategoryLocalDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<CategoryLocalDto>() {
			 @Override
			 public void execute(CategoryLocalDto category) {
				 DialogBoxConfirm<CategoryLocalDto> dialogBox = new DialogBoxConfirm<CategoryLocalDto>(category,
						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
				 dialogBox.center();
				 dialogBox.show();
			 }
		 });

	}
	private IActionToTransmit<CategoryLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<CategoryLocalDto>() {
			@Override
			public void action(CategoryLocalDto category) {
				delete(category);
			}
      };
	}	
	
	/* getter */

	public CategoriesDisplayModel getModel() {
		return model;
	}
	
	/* helper method */
	private void delete(CategoryLocalDto category) {
		Timer t = new Timer() {
			@Override
			public void run() {
				CategoryAsyncCallback callback = new CategoryAsyncCallback();
				callback.setCategoriesDisplayControler(CategoriesDisplayControler.this);
				callback.deleteCategory(category);
			}
		};
		t.schedule(0);
//		/******Asynck******/
//		List<CategoryDto> categories = model.getCategories();
//		categories.remove(category);
//		model.onSet(categories);
	}
}
