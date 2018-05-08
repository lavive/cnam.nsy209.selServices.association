package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.CategoriesDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class GetCategoriesCallable  implements IWebService<CategoriesDto> {
	
	@Override
	public Call<CategoriesDto> execute() {
		
		return RetrofitBuilder.getClient().getAllCategories();
	}
	
}