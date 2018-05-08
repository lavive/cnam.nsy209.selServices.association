package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.TransactionDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;

public class BuildTransactionCallable  implements IWebService<TransactionDto> {
	
//	private long creditorId;
//	private long debtorId;
//	private long supplyDemandId;
	private TransactionDto transaction;
	
	public BuildTransactionCallable(TransactionDto transaction) {
//		this.creditorId = creditorId;
//		this.debtorId = debtorId;
//		this.supplyDemandId = supplyDemandId;
		this.transaction = transaction;
	}

	@Override
	public Call<TransactionDto> execute() {
		
		return RetrofitBuilder.getClient().buildTransaction(transaction);
	}
	
}