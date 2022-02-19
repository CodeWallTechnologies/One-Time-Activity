package com.turorials.onetimeactivity.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


//    @GET("v2/list")
    @GET("api/blogs")
    Call<String>  STRING_CALL();


    @GET("api/websites")
    Call<String> STRING_CALL1();





}
