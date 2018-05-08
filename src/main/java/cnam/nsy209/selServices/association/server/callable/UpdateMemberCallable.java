package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class UpdateMemberCallable implements IWebService<MemberDto>  {
	
	private MemberDto memberDto;
	
	public UpdateMemberCallable(MemberDto memberDto) {
		this.memberDto = memberDto;
	}

	@Override
	public Call<MemberDto> execute() {
		
		return RetrofitBuilder.getClient().update(memberDto);
	}
}
