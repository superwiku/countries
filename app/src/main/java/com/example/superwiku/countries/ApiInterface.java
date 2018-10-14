package com.example.superwiku.countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("all")
    Call<List<Negara>> getNegara();


    @GET("region/{region}")
    Call<List<Negara>> getNegaraBenua(@Path("region") String region);


    @GET("name/{name}")
    Call<List<NegaraFull>> getSatuNegara(@Path ("name") String name);
}
