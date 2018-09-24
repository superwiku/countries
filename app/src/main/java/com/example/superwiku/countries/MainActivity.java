package com.example.superwiku.countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NegaraAllAdapter negaraAllAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Negara> negaras;
    private Negara satuNegara;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv_countries);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Negara>> call=apiInterface.getNegara();
        call.enqueue(new Callback<List<Negara>>() {
            @Override
            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                negaras=response.body();
                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                recyclerView.setAdapter(negaraAllAdapter);
                negaraAllAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Negara>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();

            }
        });
        final Spinner pilihan = (Spinner)findViewById(R.id.spin_benua);
        Button pilih = (Button)findViewById(R.id.btn_cari_benua);
        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String benuanya=pilihan.getSelectedItem().toString();
                switch (benuanya){
                    case "Asia":
                        Call<List<Negara>> call1=apiInterface.getNegaraBenua("Asia");
                        call1.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Eropa":
                        Call<List<Negara>> call2=apiInterface.getNegaraBenua("Europe");
                        call2.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Afrika":
                        Call<List<Negara>> call3=apiInterface.getNegaraBenua("Africa");
                        call3.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Amerika":
                        Call<List<Negara>> call4=apiInterface.getNegaraBenua("Americas");
                        call4.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Australia":
                        Call<List<Negara>> call5=apiInterface.getNegaraBenua("Oceania");
                        call5.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "SEMUA BENUA":
                        Call<List<Negara>> call6=apiInterface.getNegara();
                        call6.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
                                recyclerView.setAdapter(negaraAllAdapter);
                                negaraAllAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<List<Negara>> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                }
            }
        });
    }
}
