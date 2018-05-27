package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.CategoriesDto;
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
public class GetCategoriesCallable  implements IWebService<CategoriesDto> {
	
	@Override
	public Call<CategoriesDto> execute() {
		
		return RetrofitBuilder.getClient().getAllCategories();
	}
	
}