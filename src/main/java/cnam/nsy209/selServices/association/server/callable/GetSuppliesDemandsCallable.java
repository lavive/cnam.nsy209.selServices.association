package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.SuppliesDemandsDto;
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
public class GetSuppliesDemandsCallable implements IWebService<SuppliesDemandsDto>  {
	
	private String type;
	
	public GetSuppliesDemandsCallable(String type) {
		this.type = type;
	}

	@Override
	public Call<SuppliesDemandsDto> execute() {
		if(this.type == null)
			return RetrofitBuilder.getClient().getAllSuppliesDemands();
		
		return RetrofitBuilder.getClient().getSuppliesDemands(type);
	}
}
