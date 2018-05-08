package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;


public class GetAssociationCallable  implements IWebService<AssociationDto> {

	@Override
	public Call<AssociationDto> execute() {
		
		return RetrofitBuilder.getClient().getAssociation();
	}
	
}
//public class GetAssociationCallable  implements Callable<String> {
//
//
//    @Override
//    public String call() throws Exception  {
//		/* get retrofit service*/
//        WebService webService = RetrofitBuilder.getClient();
//
//        /* call checkUpdate service method */
//        Call<AssociationLocalDto> getAssociationCall = webService.getAssociation();
//
//        /* get informations from response */
//        AssociationLocalDto association = new AssociationLocalDto();
//        try {
//        	return getAssociationCallable(getAssociationCall,association);
//        }
//        catch(InterruptedException e){
//            throw new Exception("Thread interrupted ; because of " + e.getMessage());
//        }
//
//    }
//	
//	private String getAssociationCallable(Call<AssociationLocalDto> getAssociationCall,
//											   AssociationLocalDto association)
//										throws InterruptedException {
//		
//        Response<AssociationLocalDto> getAssociationResponse;
//        
//		try {
//			getAssociationResponse = getAssociationCall.execute();
//	        association = getAssociationResponse.body();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        if(association == null){
//            return "";
//        }      
//
//        return association.getAddress();
//		
//	}
//
//}
