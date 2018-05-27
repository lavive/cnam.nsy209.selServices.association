package cnam.nsy209.selServices.association.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.TransactionNotWellFormedException;
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
@RemoteServiceRelativePath("TransactionsService")
public interface TransactionsService extends RemoteService {
	public WealthSheetLocalDto getTransactions(MemberLocalDto member);
	public void add(TransactionLocalDto transaction) throws TransactionNotWellFormedException;
	public TransactionLocalDto buildTransaction(TransactionLocalDto transaction);
}
