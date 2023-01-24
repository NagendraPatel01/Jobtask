package com.example.newtaskjib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit ;

    public  static Retrofit getRetrofit(){

        if (retrofit==null){


            return retrofit=new Retrofit.Builder().baseUrl("https://api.publicapis.org/")
                    .addConverterFactory(GsonConverterFactory.create()).build();


        }
        return retrofit;
    }
}
