package com.example.superwiku.countries;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface ApiInterface {
    @Streaming
    @GET("all")
    Call<List<Negara>> getNegara();

    @Streaming
    @GET("region/{region}")
    Call<List<Negara>> getNegaraBenua(@Path("region") String region);

    @Streaming
    @GET("name/{name}")
    Call<Negara> getSatuNegara(@Path("name") String name);
}
