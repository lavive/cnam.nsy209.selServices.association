package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.SuppliesDemandsDto;
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
public class DeleteSuppliesDemandsCallable implements IWebService<SuppliesDemandsDto>  {
	
	private SupplyDemandDto supplyDemandDto;
	
	public DeleteSuppliesDemandsCallable(SupplyDemandDto supplyDemandDto) {
		this.supplyDemandDto = supplyDemandDto;
	}

	@Override
	public Call<SuppliesDemandsDto> execute() {
		
		return RetrofitBuilder.getClient().deleteGetSupplyDemand(supplyDemandDto.getId());
	}
}
