package cnam.nsy209.selServices.association.server.callable;

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
