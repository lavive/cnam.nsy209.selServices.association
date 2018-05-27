package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MessageDto;
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
public class AddMessageCallable implements IWebService<Void>  {
	
	private MessageDto messageDto;
	
	public AddMessageCallable(MessageDto messageDto) {
		this.messageDto = messageDto;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().addMessage(messageDto);
	}
}
