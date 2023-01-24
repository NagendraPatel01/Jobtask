package com.example.newtaskjib;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterFace {

    @GET("entries")
    Call<DataModel> retrivedata();
}
