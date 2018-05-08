package cnam.nsy209.selServices.association.server.webService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitBuilder {
    private static final String BASE_URL = "http://78.221.197.69:9991/selServices/";

    public static WebService getClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build();

        WebService webService = retrofit.create(WebService.class);

        return webService;
    }
}