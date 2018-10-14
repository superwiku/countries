package com.example.superwiku.countries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
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
    private TextView jmlNegara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv_countries);
        jmlNegara=(TextView)findViewById(R.id.txt_jmlneg);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Intent i=getIntent();
        negaras=(List<Negara>)i.getSerializableExtra("datanya");
        Integer jml=negaras.size();
        jmlNegara.setText(Integer.toString(jml) + " negara");
        negaraAllAdapter=new NegaraAllAdapter(negaras,MainActivity.this);
        recyclerView.setAdapter(negaraAllAdapter);
        negaraAllAdapter.notifyDataSetChanged();
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        final Spinner pilihan = (Spinner)findViewById(R.id.spin_benua);
        pilihan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String benuanya=pilihan.getSelectedItem().toString();
                switch (benuanya){
                    case "Asia":
                        Call<List<Negara>> call1=apiInterface.getNegaraBenua("Asia");
                        call1.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                Integer jmlAsia=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlAsia) + " negara");
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
                                Integer jmlEropa=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlEropa) + " negara");
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
                                Integer jmlAfrika=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlAfrika) + " negara");
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
                                Integer jmlAmerika=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlAmerika) + " negara");
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
                    case "Australia Oceania":
                        Call<List<Negara>> call5=apiInterface.getNegaraBenua("Oceania");
                        call5.enqueue(new Callback<List<Negara>>() {
                            @Override
                            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                                negaras=response.body();
                                Integer jmlAus=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlAus) + " negara");
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
                                Integer jmlAll=negaras.size();
                                jmlNegara.setText(Integer.toString(jmlAll) + " negara");
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

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
