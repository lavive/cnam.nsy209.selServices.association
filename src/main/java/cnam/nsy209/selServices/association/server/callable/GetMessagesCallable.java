package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MessagesDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class GetMessagesCallable implements IWebService<MessagesDto>  {

	@Override
	public Call<MessagesDto> execute() {
		
		return RetrofitBuilder.getClient().getMessages();
	}
}
