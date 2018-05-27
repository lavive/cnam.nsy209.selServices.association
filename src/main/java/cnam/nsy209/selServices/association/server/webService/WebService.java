package cnam.nsy209.selServices.association.server.webService;

import cnam.nsy209.selServices.association.server.dto.AssociationDto;
import cnam.nsy209.selServices.association.server.dto.CategoriesDto;
import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.server.dto.MemberDto;
import cnam.nsy209.selServices.association.server.dto.MembersDto;
import cnam.nsy209.selServices.association.server.dto.MessageDto;
import cnam.nsy209.selServices.association.server.dto.MessagesDto;
import cnam.nsy209.selServices.association.server.dto.SuppliesDemandsDto;
import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
import cnam.nsy209.selServices.association.server.dto.TransactionDto;
import cnam.nsy209.selServices.association.server.dto.TransactionsDto;
import cnam.nsy209.selServices.association.server.dto.WealthSheetDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
/** 
 * 
 * Interface which launch the call to the REST Services 
 * 
 * @author lavive
 *
 */
public interface WebService {

	/* check first connection */
    @GET("member/get/{mobileId}/{cellNumber}")
    Call<Long> getMyId(@Path("mobileId") String mobileId,@Path("cellNumber") String cellNumber);

    /* update local database */

    @GET("association")
    Call<AssociationDto> getAssociation();

    @GET("member/get/{id}/member")
    Call<MemberDto> getMyProfile(@Path("id") long id);

    @GET("supplyDemand/get/all")
    Call<SuppliesDemandsDto> getAllSuppliesDemands();

    @GET("member/get/all")
    Call<MembersDto> getAllMembers();

    @GET("category")
    Call<CategoriesDto> getAllCategories();

    @GET("member/get/{id}/wealthSheet")
    Call<WealthSheetDto> getWealthSheet(@Path("id") long id);

    @GET("member/get/{id}/transaction")
    Call<TransactionsDto> getTransactions(@Path("id") long id);

    /* update remote database */

    @PUT("member/put")
    Call<Void> updateProfile(@Body MembersDto memberDto);

    @PUT("member/put/{id}/dateLastUpdate")
    Call<Void> updateDateLastUpdate(@Path("id") long id);

    @DELETE("supplyDemand/delete/{id}")
    Call<Void> deleteSupplyDemand(@Path("id") long id);

    @PUT("supplyDemand/put")
    Call<Void> updateSupplyDemand(@Body SupplyDemandDto supplyDemandDto);

    @POST("supplyDemand/post")
    Call<Void> addSupplyDemand(@Body SupplyDemandDto supplyDemandDto);

    @POST("transaction")
    Call<Void> addTransaction(@Body TransactionDto transactionDto);
    
    @GET("association/authentication/{login}/{password}/{number}")
    Call<MembersDto> checkIds(@Path("login") String login, @Path("password") String password,@Path("number") int number);
    
    @PUT("association/put")
    Call<Void> upDateAssociation(@Body AssociationDto associationDto);
    
    @POST("category/post")
    Call<Void> addCategory(@Body CategoryDto categoryDto);
    
    @PUT("category/delete/{id}")
    Call<CategoriesDto> deleteCategory(@Path("id") long id);

    @GET("member/get/last/{number}")
    Call<MembersDto> getLastMembers(@Path("number") int number);
    
    @POST("member/get/attributes")
    Call<MembersDto> getMembers(@Body MemberDto memberDto);
    
    @DELETE("member/delete/{id}")
    Call<MembersDto>  deleteMember(@Path("id") long id);
 
    @POST("member/post")
    Call<Void> create(@Body MemberDto member);
    
    @PUT("member/put/member")
	Call<MemberDto> update(@Body MemberDto member);
    
    @POST("message")
    Call<Void> addMessage(@Body MessageDto message);
    
    @GET("message/get/all")
    Call<MessagesDto> getMessages();
    
    @PUT("message/delete/{id}")
    Call<MessagesDto> deleteMessage(@Path("id") long id);
    
    @GET("supplyDemand/get/type/{type}")
    Call<SuppliesDemandsDto> getSuppliesDemands(@Path("type") String type);
    
    @PUT("supplyDemand/delete/get/{id}")
    Call<SuppliesDemandsDto> deleteGetSupplyDemand(@Path("id") long id);
    
    @GET("member/get/{id}")
    Call<MemberDto> getMember(@Path("id") long id);
    
    @GET("supplyDemand/get/{id}")
    Call<SupplyDemandDto> getSupplyDemand(@Path("id") long id);
    
   
    @POST("transaction/post/get")
    Call<TransactionDto> buildTransaction(@Body TransactionDto transaction);
}
