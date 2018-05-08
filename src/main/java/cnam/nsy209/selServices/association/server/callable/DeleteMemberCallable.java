package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class DeleteMemberCallable implements IWebService<MembersDto>  {
	
	private MemberDto memberDto;
	
	public DeleteMemberCallable(MemberDto memberDto) {
		this.memberDto = memberDto;
	}

	@Override
	public Call<MembersDto> execute() {
		
		return RetrofitBuilder.getClient().deleteMember(memberDto.getId());
	}
	

}
