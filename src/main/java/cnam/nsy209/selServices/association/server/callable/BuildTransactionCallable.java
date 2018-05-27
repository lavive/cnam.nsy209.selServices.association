package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.TransactionDto;
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
public class BuildTransactionCallable  implements IWebService<TransactionDto> {

	private TransactionDto transaction;
	
	public BuildTransactionCallable(TransactionDto transaction) {
		this.transaction = transaction;
	}

	@Override
	public Call<TransactionDto> execute() {
		
		return RetrofitBuilder.getClient().buildTransaction(transaction);
	}
	
}