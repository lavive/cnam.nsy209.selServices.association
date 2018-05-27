package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.TransactionsService;
import cnam.nsy209.selServices.association.server.callable.AddTransactionCallable;
import cnam.nsy209.selServices.association.server.callable.BuildTransactionCallable;
import cnam.nsy209.selServices.association.server.callable.GetMemberCallable;
import cnam.nsy209.selServices.association.server.callable.GetSupplyDemandCallable;
import cnam.nsy209.selServices.association.server.callable.GetWealthSheetCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
import cnam.nsy209.selServices.association.server.dto.TransactionDto;
import cnam.nsy209.selServices.association.server.dto.WealthSheetDto;
import cnam.nsy209.selServices.association.shared.exception.TransactionNotWellFormedException;
import cnam.nsy209.selServices.association.shared.localDto.MemberLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionDisplayLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.TransactionLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.WealthSheetLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the Association Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class TransactionsServiceImpl extends RemoteServiceServlet implements TransactionsService {

	@Override
	public WealthSheetLocalDto getTransactions(MemberLocalDto member) {
		WealthSheetDto wealthSheetDto = null;
		WealthSheetLocalDto result = null;
		try {
			MemberDto memberRemote = LocalToRemote.toRemoteMember(member);
			wealthSheetDto = new WebServiceCallable<WealthSheetDto>(new GetWealthSheetCallable(memberRemote)).call();
			List<TransactionDisplayLocalDto> transactionsDisplay = new ArrayList<TransactionDisplayLocalDto>();
			for(TransactionDto transaction:wealthSheetDto.getTransactions()) {
				MemberDto creditor = new WebServiceCallable<MemberDto>(
						new GetMemberCallable(transaction.getCreditorMemberId())).call();
				MemberDto debtor = new WebServiceCallable<MemberDto>(
						new GetMemberCallable(transaction.getDebtorMemberId())).call();
				SupplyDemandDto supplyDemand = new WebServiceCallable<SupplyDemandDto>(
						new GetSupplyDemandCallable(transaction.getSupplyDemandId())).call();
				
				TransactionDisplayLocalDto transactionDisplay = new TransactionDisplayLocalDto();
				transactionDisplay.setCreditorMember(RemoteToLocal.toLocalMember(creditor));
				transactionDisplay.setDebtorMember(RemoteToLocal.toLocalMember(debtor));
				transactionDisplay.setSupplyDemand(RemoteToLocal.toLocalSupplyDemand(supplyDemand));
				transactionDisplay.setAmount(transaction.getAmount());
				
				transactionsDisplay.add(transactionDisplay);
			}
			
			result = RemoteToLocal.toLocalWealthSheet(wealthSheetDto);
			result.setTransactionsDisplay(transactionsDisplay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void add(TransactionLocalDto transaction) throws TransactionNotWellFormedException {
		TransactionDto transactionRemote = LocalToRemote.toRemoteTransaction(transaction);
		if(!HelperServicesMethods.checkTransactionWellFormed(transactionRemote).equals(""))
			throw new TransactionNotWellFormedException(HelperServicesMethods.checkTransactionWellFormed(transactionRemote));
		try {
			new WebServiceCallable<Void>(new AddTransactionCallable(transactionRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TransactionLocalDto buildTransaction(TransactionLocalDto transaction) {
		TransactionDto transactionRemote = LocalToRemote.toRemoteTransaction(transaction);
		TransactionDto transactionDto = null;
		try {
			transactionDto = 
					new WebServiceCallable<TransactionDto>(
							new BuildTransactionCallable(transactionRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RemoteToLocal.toLocalTransaction(transactionDto);
	}

}
