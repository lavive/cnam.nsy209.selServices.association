package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
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
public class GetSupplyDemandCallable implements IWebService<SupplyDemandDto>  {
	
	private long id;
	
	public GetSupplyDemandCallable(long id) {
		this.id = id;
	}

	@Override
	public Call<SupplyDemandDto> execute() {
		
		return RetrofitBuilder.getClient().getSupplyDemand(id);
	}
}
