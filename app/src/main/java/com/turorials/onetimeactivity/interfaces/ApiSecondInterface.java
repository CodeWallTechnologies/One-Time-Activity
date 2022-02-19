package com.turorials.onetimeactivity.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSecondInterface {

    @GET("api/classes")
    Call<String> STRING_CALL3();



}
