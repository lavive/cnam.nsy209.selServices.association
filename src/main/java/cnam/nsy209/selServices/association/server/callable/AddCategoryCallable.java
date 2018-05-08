package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class AddCategoryCallable  implements IWebService<Void> {
	
	private CategoryDto category;
	
	public AddCategoryCallable(CategoryDto category) {
		this.category = category;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().addCategory(category);
	}
	
}