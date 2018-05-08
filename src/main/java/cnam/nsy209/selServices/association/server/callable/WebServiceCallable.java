package cnam.nsy209.selServices.association.server.callable;

import java.io.IOException;
import java.util.concurrent.Callable;

import cnam.nsy209.selServices.association.server.webService.IWebService;
import retrofit2.Call;
import retrofit2.Response;

public class WebServiceCallable<T>  implements Callable<T> {
	
	private IWebService<T> webServiceCallable;
	
	public WebServiceCallable(IWebService<T> webServiceCallable) {
		this.webServiceCallable = webServiceCallable;
	}


	@Override
	public T call() throws Exception  {
	
	    /* call checkUpdate service method */
	    Call<T> call = webServiceCallable.execute();
	
	    /* get informations from response */
	    try {
	    	return callable(call);
	    }
	    catch(InterruptedException e){
	        throw new Exception("Thread interrupted ; because of " + e.getMessage());
	    }
	
	}
	
	private T callable(Call<T> call) throws InterruptedException {
		
	    Response<T> response;
	    T t = null;
	    
		try {
			response = call.execute();
			t = response.body();
		} catch (IOException e) {
			e.printStackTrace();
		}    
	
	    return t;
		
	}

}
