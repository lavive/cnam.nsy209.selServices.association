package cnam.nsy209.selServices.association.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;
/** 
 * 
 * Interface which calls Transaction service
 * 
 * @author lavive
 *
 */
public interface TransactionsServiceAsync {
	public void getTransactions(MemberLocalDto member,AsyncCallback<WealthSheetLocalDto> callback);
	public void add(TransactionLocalDto transaction,AsyncCallback<Void> callback);
	public void buildTransaction(TransactionLocalDto transaction, AsyncCallback<TransactionLocalDto> callback);
}
