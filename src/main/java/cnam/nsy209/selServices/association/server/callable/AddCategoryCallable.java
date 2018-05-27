package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;
/** 
 * 
 * Class wrapping REST Service call and get his result
 * 
 * @author lavive
 *
 */
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