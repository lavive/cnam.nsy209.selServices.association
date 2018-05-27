package cnam.nsy209.selServices.association.server.callable;

import java.io.IOException;
import java.util.concurrent.Callable;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import cnam.nsy209.selServices.association.server.webService.WebService;
import retrofit2.Call;
import retrofit2.Response;
/** 
 * 
 * Class wrapping REST Service call and get his result
 * 
 * @author lavive
 *
 */
public class GetAssociationNameCallable  implements Callable<String> {


	@Override
	public String call() throws Exception  {
		/* get retrofit service*/
	    WebService webService = RetrofitBuilder.getClient();
	
	    /* call checkUpdate service method */
	    Call<AssociationDto> getAssociationCall = webService.getAssociation();
	
	    /* get informations from response */
	    AssociationDto association = new AssociationDto();
	    try {
	    	return getAssociationCallable(getAssociationCall,association);
	    }
	    catch(InterruptedException e){
	        throw new Exception("Thread interrupted ; because of " + e.getMessage());
	    }
	
	}
	
	private String getAssociationCallable(Call<AssociationDto> getAssociationCall,
											   AssociationDto association)
										throws InterruptedException {
		
	    Response<AssociationDto> getAssociationResponse;
	    
		try {
			getAssociationResponse = getAssociationCall.execute();
	        association = getAssociationResponse.body();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    if(association == null){
	        return "";
	    }      
	
	    return association.getName();
		
	}

}
