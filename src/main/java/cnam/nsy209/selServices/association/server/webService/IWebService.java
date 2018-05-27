package cnam.nsy209.selServices.association.server.webService;

import retrofit2.Call;
/** 
 * 
 * Interface picturing wrapping call to the REST services 
 * 
 * @author lavive
 *
 */
public interface IWebService<T> {
	
	Call<T> execute();
}
