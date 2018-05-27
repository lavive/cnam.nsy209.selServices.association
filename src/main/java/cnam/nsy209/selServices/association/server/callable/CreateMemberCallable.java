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
public class CreateMemberCallable implements IWebService<Void>  {
	
	private MemberDto memberDto;
	
	public CreateMemberCallable(MemberDto memberDto) {
		this.memberDto = memberDto;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().create(memberDto);
	}
	

}
