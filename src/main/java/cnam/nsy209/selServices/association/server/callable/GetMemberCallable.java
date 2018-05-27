package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
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
public class GetMemberCallable implements IWebService<MemberDto> {
	
	private long id;
	
	public GetMemberCallable(long id) {
		this.id = id;
	}
	
	@Override
	public Call<MemberDto> execute() {
		
		return RetrofitBuilder.getClient().getMember(id);
	}
	
}