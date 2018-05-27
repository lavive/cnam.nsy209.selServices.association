package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MembersDto;
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
public class GetLastMembersCallable implements IWebService<MembersDto> {
	
	private int number;
	
	public GetLastMembersCallable(int number) {
		this.number = number;
	}
	
	@Override
	public Call<MembersDto> execute() {
		
		return RetrofitBuilder.getClient().getLastMembers(number);
	}
	
}