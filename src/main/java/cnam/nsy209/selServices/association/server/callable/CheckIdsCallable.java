package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class CheckIdsCallable  implements IWebService<MembersDto> {
	
	private String login;
	private String password;
	private int number;
	
	public CheckIdsCallable(String login,String password, int number) {
		this.login = login;
		this.password = password;
		this.number = number;
	}

	@Override
	public Call<MembersDto> execute() {
		return RetrofitBuilder.getClient().checkIds(login,password, number);
	}
}

//public class CheckIdsCallable  implements Callable<MembersDto> {
//	
//	private String login;
//	private String password;
//	private int number;
//	
//	public CheckIdsCallable(String login, String password, int number) {
//		this.login = login;
//		this.password = password;
//		this.number = number;
//	}
//
//
//	@Override
//	public MembersDto call() throws Exception  {
//		/* get retrofit service*/
//	    WebService webService = RetrofitBuilder.getClient();
//	
//	    /* call checkUpdate service method */
//	    Call<MembersDto> getLastMembersCall = webService.checkIds(login,password,number);
//	
//	    /* get informations from response */
//	    MembersDto membersDto = new MembersDto();
//	    try {
//	    	return getMembersCallable(getLastMembersCall,membersDto);
//	    }
//	    catch(InterruptedException e){
//	        throw new Exception("Thread interrupted ; because of " + e.getMessage());
//	    }
//	
//	}
//	
//	private MembersDto getMembersCallable(Call<MembersDto> getLastMembersCall,
//			 								MembersDto membersDto)
//										throws InterruptedException {
//		
//	    Response<MembersDto> getLastMemberResponse;
//	    
//		try {
//			getLastMemberResponse = getLastMembersCall.execute();
//			membersDto = getLastMemberResponse.body();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	    if(membersDto == null){
//	        return new MembersDto();
//	    }      
//	
//	    return membersDto;
//		
//	}
//
//}
