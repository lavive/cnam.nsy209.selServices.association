package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.WealthSheetDto;
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
public class GetWealthSheetCallable implements IWebService<WealthSheetDto>  {
	
	private MemberDto memberDto;
	
	public GetWealthSheetCallable(MemberDto memberDto) {
		this.memberDto = memberDto;
	}

	@Override
	public Call<WealthSheetDto> execute() {
		
		return RetrofitBuilder.getClient().getWealthSheet(memberDto.getId());
	}
}
