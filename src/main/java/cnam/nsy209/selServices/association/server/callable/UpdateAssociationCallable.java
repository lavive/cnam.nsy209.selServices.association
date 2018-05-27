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

public class UpdateAssociationCallable  implements IWebService<Void> {
	
	private AssociationDto associationDto;
	
	public UpdateAssociationCallable(AssociationDto associationDto) {
		this.associationDto = associationDto;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().upDateAssociation(associationDto);
	}
	
}