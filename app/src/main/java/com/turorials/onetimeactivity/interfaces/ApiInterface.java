package com.turorials.onetimeactivity.interfaces;

import com.turorials.onetimeactivity.model.Model3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


//    @GET("v2/list")
    @GET("api/firsts")
    Call<String>  STRING_CALL();


    @GET("users")
    Call<String> STRING_CALL1();



}
