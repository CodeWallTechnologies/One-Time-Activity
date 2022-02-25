package com.turorials.onetimeactivity.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiThirdInterface {



    @GET("api/our-blogs")
    Call<String> STRING_CALL4();

    @GET("api/all-lessons")
    Call<String> STRING_CALL5();


    @GET("api/cheat-sheets")
    Call<String> STRING_CALL6();
}
