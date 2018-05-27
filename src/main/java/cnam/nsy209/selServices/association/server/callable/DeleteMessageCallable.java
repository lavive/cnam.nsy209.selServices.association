package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MessageDto;
import cnam.nsy209.selServices.association.server.dto.MessagesDto;
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
public class DeleteMessageCallable implements IWebService<MessagesDto>  {
	
	private MessageDto messageDto;
	
	public DeleteMessageCallable(MessageDto messageDto) {
		this.messageDto = messageDto;
	}

	@Override
	public Call<MessagesDto> execute() {
		
		return RetrofitBuilder.getClient().deleteMessage(messageDto.getId());
	}
}
