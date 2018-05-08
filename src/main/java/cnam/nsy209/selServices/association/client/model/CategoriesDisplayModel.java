package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

@SuppressWarnings("serial")
public class CategoriesDisplayModel extends Observable {
	
	/* Singleton */
	private static CategoriesDisplayModel instance;
	public static CategoriesDisplayModel get(List<CategoryLocalDto> categories) {
		if(instance == null)
			instance = new CategoriesDisplayModel(categories);
		
		return instance;
	}
	
	/* Constructor */
	private CategoriesDisplayModel(List<CategoryLocalDto> categories) {
		this.categories = categories;
	}
	
	/* Attributes */
	private List<CategoryLocalDto> categories = new ArrayList<CategoryLocalDto>();
	
	public void onSet(List<CategoryLocalDto> categories) {
		this.categories = categories;

		notifyObservers();
	}
	
	/* getter */

	public List<CategoryLocalDto> getCategories() {
		return categories;
	}

}