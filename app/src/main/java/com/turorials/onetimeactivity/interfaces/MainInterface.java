package com.turorials.onetimeactivity.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainInterface {
    @GET("b/7IQ2")
    Call<String> IMAGE_CALL();
}
