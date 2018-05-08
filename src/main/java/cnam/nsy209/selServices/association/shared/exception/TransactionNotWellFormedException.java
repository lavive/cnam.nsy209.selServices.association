package cnam.nsy209.selServices.association.shared.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransactionNotWellFormedException extends Exception implements Serializable {
	
	private String originError;
	
	public TransactionNotWellFormedException() {}
	
	public TransactionNotWellFormedException(String originError) {
		this.originError = originError;
	}

	public String getOriginError() {
		return originError;
	}
	
}
