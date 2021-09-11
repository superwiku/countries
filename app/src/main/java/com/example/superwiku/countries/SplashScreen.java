package com.example.superwiku.countries;

import android.content.Intent;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    private ApiInterface apiInterface;
    private Negara negara;
    private List<Negara>negaraList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new AmbilData().execute();


    }

    private class AmbilData extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<Negara>>call=apiInterface.getNegara();
            call.enqueue(new Callback<List<Negara>>() {
                @Override
                public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                    negaraList=response.body();
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    intent.putExtra("datanya",(Serializable)negaraList);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<List<Negara>> call, Throwable t) {

                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }
}
