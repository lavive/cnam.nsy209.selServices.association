package cnam.nsy209.selServices.association.server.webService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitBuilder {
    private static final String BASE_URL = "http://XX.XXX.XXX.XX:9991/selServices/";

    public static WebService getClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build();

        WebService webService = retrofit.create(WebService.class);

        return webService;
    }
}