package cnam.nsy209.selServices.association.server.callable;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.webService.IWebService;
import cnam.nsy209.selServices.association.server.webService.RetrofitBuilder;
import retrofit2.Call;


public class UpdateAssociationCallable  implements IWebService<Void> {
	
	private AssociationDto associationDto;
	
	public UpdateAssociationCallable(AssociationDto associationDto) {
		this.associationDto = associationDto;
	}

	@Override
	public Call<Void> execute() {
		
		return RetrofitBuilder.getClient().upDateAssociation(associationDto);
	}
	
}
//public class UpdateAssociationCallable  implements Callable<Void> {
//	
//	private AssociationLocalDto associationDto;
//	
//	public UpdateAssociationCallable(AssociationLocalDto associationDto) {
//		this.associationDto = associationDto;
//	}
//
//
//	@Override
//	public Void call() throws Exception  {
//		/* get retrofit service*/
//	    WebService webService = RetrofitBuilder.getClient();
//	
//	    /* call checkUpdate service method */
//	    Call<Void> updateAssociationCall = webService.upDateAssociation(associationDto);
//	
//	    /* get informations from response */
//	    AssociationLocalDto associationDto = new AssociationLocalDto();
//	    try {
//	    	updateAssociationCallable(updateAssociationCall,associationDto);
//	    }
//	    catch(InterruptedException e){
//	        throw new Exception("Thread interrupted ; because of " + e.getMessage());
//	    }
//		return null;
//	
//	}
//	
//	private void updateAssociationCallable(Call<Void> updateAssociationCall,
//											AssociationLocalDto associationDto)
//										throws InterruptedException {
//
//		try {
//			updateAssociationCall.execute();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//	
//		
//	}
//
//}
