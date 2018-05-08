package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

public interface CategoriesServiceAsync {
	public void add(CategoryLocalDto category,AsyncCallback<List<CategoryLocalDto>> callback);
	public void getCategories(AsyncCallback<List<CategoryLocalDto>> callback);
	public void delete(CategoryLocalDto category,AsyncCallback<List<CategoryLocalDto>> callback);
}
