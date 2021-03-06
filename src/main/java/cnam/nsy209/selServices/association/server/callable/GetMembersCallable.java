package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
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
public class GetMembersCallable implements IWebService<MembersDto> {
	
	private MemberDto memberDto;
	
	public GetMembersCallable(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	@Override
	public Call<MembersDto> execute() {
		
		return RetrofitBuilder.getClient().getMembers(memberDto);
	}
	
}