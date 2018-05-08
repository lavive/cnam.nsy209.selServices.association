package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class GetAllMembersCallable implements IWebService<MembersDto> {
	
	@Override
	public Call<MembersDto> execute() {
		
		return RetrofitBuilder.getClient().getAllMembers();
	}
	
}