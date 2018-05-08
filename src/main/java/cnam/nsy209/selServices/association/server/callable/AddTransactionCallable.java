package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.TransactionDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class AddTransactionCallable implements IWebService<Void>  {
	
	private TransactionDto transactionDto;
	
	public AddTransactionCallable(TransactionDto transactionDto) {
		this.transactionDto = transactionDto;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().addTransaction(transactionDto);
	}
}
