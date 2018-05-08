package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.CategoriesDto;
import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class DeleteCategoryCallable implements IWebService<CategoriesDto> {
	
	private CategoryDto category;
	
	public DeleteCategoryCallable(CategoryDto category) {
		this.category = category;
	}

	@Override
	public Call<CategoriesDto> execute() {
		
		return RetrofitBuilder.getClient().deleteCategory(category.getId());
	}
	
}