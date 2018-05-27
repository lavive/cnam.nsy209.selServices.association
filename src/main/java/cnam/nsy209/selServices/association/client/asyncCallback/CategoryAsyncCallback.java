package cnam.nsy209.selServices.association.client.asyncCallback;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.controler.CategoriesDisplayControler;
import cnam.nsy209.selServices.association.client.controler.CategoryEditControler;
import cnam.nsy209.selServices.association.client.controler.MenuControler;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.MenuHorizontalModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxMessage;
import cnam.nsy209.selServices.association.client.view.page.CategoriesDisplayPage;
import cnam.nsy209.selServices.association.client.view.page.concretePage.main.CategoriesDisplay;
import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;


/** 
 * 
 * Class to manage result from Category service call
 * 
 * @author lavive
 *
 */
public class CategoryAsyncCallback {

	/* attributes */
	private AsyncCallback<List<CategoryLocalDto>> addCallback;
	private AsyncCallback<List<CategoryLocalDto>> getCallback;
	private AsyncCallback<List<CategoryLocalDto>> deleteCallback;
	private int width;
	private int height;
	private MenuControler menuControler;
	private CategoryEditControler categoryEditControler;
	private CategoriesDisplayControler categoriesDisplayControler;
	
	/* Constructors */
	public CategoryAsyncCallback(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public CategoryAsyncCallback() {}
	
	/* methods */
	public void addCategory(CategoryLocalDto category) {
			
		addCallback = new AsyncCallback<List<CategoryLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(categoryEditControler != null) categoryEditControler.getModel().onInitialize(category.getName());
				if(caught instanceof AlReadyExistException) {
					DialogBoxMessage message = new DialogBoxMessage(((AlReadyExistException) caught).message());
					message.center();
					message.show();
				} else if(caught instanceof EmptyException) {
					DialogBoxMessage message = new DialogBoxMessage(((EmptyException) caught).message());
					message.center();
					message.show();
				} else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<CategoryLocalDto> result) {
				if(categoryEditControler != null) categoryEditControler.getModel().onInitialize(category.getName());
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().addCategoryConfirm());
				message.center();
				message.show();

				CategoriesDisplayPage page = new CategoriesDisplayPage(width,height);
				RootPanel.get().clear();
				CategoriesDisplay.get().getCategoriesTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getCategoriesService().add(category, addCallback);
	}

	public void getCategories(final Button button, boolean back) {
			
		getCallback = new AsyncCallback<List<CategoryLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				if(menuControler != null) menuControler.getModel().onActiveButton(null);
				DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
				message.center();
				message.show();
			}		
	
			@Override
			public void onSuccess(List<CategoryLocalDto> result) {
				if(back) MenuHorizontalModel.get(null).onInitialise();
				RootPanel.get().clear();
				if(menuControler != null) menuControler.getModel().onActiveButton(button);
				CategoriesDisplayPage page = new CategoriesDisplayPage(width,height);
				CategoriesDisplay.get().getCategoriesTable().getControler().getModel().onSet(result);
				RootPanel.get().add(page);
			}
			
		};
		
		ServicesProxy.getCategoriesService().getCategories(getCallback);
	}
	
	public void deleteCategory(CategoryLocalDto category) {
			
		deleteCallback = new AsyncCallback<List<CategoryLocalDto>>() {
	
			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof DoNotExistException) {
					DialogBoxMessage message = new DialogBoxMessage(((DoNotExistException) caught).message());
					message.center();
					message.show();
				}else {
					DialogBoxMessage message = new DialogBoxMessage(I18n.getI18nMessages().netWorkError());
					message.center();
					message.show();
				}
			}
	
			@Override
			public void onSuccess(List<CategoryLocalDto> result) {
				categoriesDisplayControler.getModel().onSet(result);				
			}
			
		};
		
		ServicesProxy.getCategoriesService().delete(category, deleteCallback);
	}
	
	
	/* getter and setter */

	public void setMenuControler(MenuControler menuControler) {
		this.menuControler = menuControler;
	}
	public void setCategoryEditControler(CategoryEditControler categoryEditControler) {
		this.categoryEditControler = categoryEditControler;
	}
	public void setCategoriesDisplayControler(CategoriesDisplayControler categoriesDisplayControler) {
		this.categoriesDisplayControler = categoriesDisplayControler;
	}

}
