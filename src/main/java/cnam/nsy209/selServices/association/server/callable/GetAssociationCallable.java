package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
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
public class GetAssociationCallable  implements IWebService<AssociationDto> {

	@Override
	public Call<AssociationDto> execute() {
		
		return RetrofitBuilder.getClient().getAssociation();
	}
	
}