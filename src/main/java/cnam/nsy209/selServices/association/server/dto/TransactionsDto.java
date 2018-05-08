package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;

public class TransactionsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Json(name = "transactions")
    private List<TransactionDto> transactions = new ArrayList<TransactionDto>();

    /* getter and setter */

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString(){
        String result ="{ ";
        for(TransactionDto transactionDto:transactions){
            result += transactionDto.toString()+" , ";
        }
        result = result.substring(0,result.length()-1);
        result +="}";
        return result;
    }
}
