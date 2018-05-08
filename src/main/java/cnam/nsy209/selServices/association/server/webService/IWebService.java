package cnam.nsy209.selServices.association.server.webService;

import retrofit2.Call;

public interface IWebService<T> {
	
	Call<T> execute();
}
