package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextBox;

import cnam.nsy209.selServices.association.client.asyncCallback.CategoryAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.CategoryEditModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

public class CategoryEditControler {
	
	/* Attributes */
	private CategoryEditModel model;
	private TextBox edit;
	
	/* Constructors */
	public CategoryEditControler() {
		this.model = CategoryEditModel.get();
	}
	
	/* get the handler for validate button */
	public ClickHandler getValidateClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				model.onDisplay(edit.getText());
				if(model.noError()) { 
					 DialogBoxConfirm<CategoryLocalDto> dialogBox = 
							 new DialogBoxConfirm<CategoryLocalDto>(buildCategory(),
							 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
					 dialogBox.center();
					 dialogBox.show();
					 //sendData(buildCategory());
				}
			}
		};
		
		return clickHandler;
	}
	
	/* get the handler for textbox */
	public ClickHandler getTextBoxClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				if(model.getCategoryError() != null) model.setCategoryError(null);
				
			}
		};
		
		return clickHandler;
	}
	
	/* getter and setter */

	public CategoryEditModel getModel() {
		return model;
	}
	
	public TextBox getEdit() {
		return edit;
	}

	public void setEdit(TextBox edit) {
		this.edit = edit;
	}

	/* helper method */
	private CategoryLocalDto buildCategory() {
		CategoryLocalDto category = new CategoryLocalDto();
		category.setName(edit.getText());
		
		return category;
	}
	
	private void sendData(final CategoryLocalDto category) {
		this.model.onWaitingDisplay(category.getName());
		Timer t = new Timer() {
			@Override
			public void run() {
				CategoryAsyncCallback callback = new CategoryAsyncCallback();
				callback.setCategoryEditControler(CategoryEditControler.this);
				callback.addCategory(category);
			}
		};
		t.schedule(0);
//		/******Asynck******/
//		String messageToDisplay =I18n.getI18nMessages().dataSaved();
//		(new DialogBoxMessage(messageToDisplay)).show();
	}
	private IActionToTransmit<CategoryLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<CategoryLocalDto>() {
			@Override
			public void action(CategoryLocalDto category) {
				sendData(category);	
				
			}
      };
	}
}
