package com.example.superwiku.countries;

import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavDetailActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    ApiInterface apiInterface;
    List<NegaraFull> negaraFulls;
    NegaraFull negaraFull;
    ImageView navHeader;
    TextView navHeaderNama;
    TextView navHeaderBenua;
    static String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Intent intent=getIntent();
        a=intent.getStringExtra("namanya");
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<NegaraFull>>call=apiInterface.getSatuNegara(a);
        call.enqueue(new Callback<List<NegaraFull>>() {
            @Override
            public void onResponse(Call<List<NegaraFull>> call, Response<List<NegaraFull>> response) {
                negaraFulls=response.body();
                negaraFull=negaraFulls.get(0);
                NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
                View headerView=navigationView.getHeaderView(0);
                navHeader=(ImageView)headerView.findViewById(R.id.img_nav_flag_header);
                navHeaderNama=(TextView)headerView.findViewById(R.id.txt_nav_nama_header);
                navHeaderBenua=(TextView)headerView.findViewById(R.id.txt_nav_benua_header);
                navHeaderNama.setText(negaraFull.getName());
                navHeaderBenua.setText(negaraFull.getRegion());
                SvgLoader.pluck().with(NavDetailActivity.this).load(negaraFull.getFlag(),navHeader);
                DetailUmumFragment detailUmumFragment=new DetailUmumFragment();
                Bundle umum=new Bundle();
                umum.putSerializable(DetailUmumFragment.KEY_ACTIVITY,negaraFull);
                detailUmumFragment.setArguments(umum);
                android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fnav_detail,detailUmumFragment);
                ft.commit();
            }

            @Override
            public void onFailure(Call<List<NegaraFull>> call, Throwable t) {

            }
        });

        fragmentManager =getSupportFragmentManager();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_detail_umum) {
            DetailUmumFragment detailUmumFragment=new DetailUmumFragment();
            Bundle umum=new Bundle();
            umum.putSerializable(DetailUmumFragment.KEY_ACTIVITY,negaraFull);
            detailUmumFragment.setArguments(umum);
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fnav_detail,detailUmumFragment);
            ft.commit();
        } else if (id == R.id.nav_bahasa) {
            LanguageFragment languageFragment=new LanguageFragment();
            Bundle bahasa=new Bundle();
            bahasa.putSerializable(LanguageFragment.KEY_ACTIVITY_2,negaraFull);
            languageFragment.setArguments(bahasa);
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fnav_detail,languageFragment);
            ft.commit();
        } else if (id == R.id.nav_currency) {
            CurrencyFragment currencyFragment=new CurrencyFragment();
            Bundle uang=new Bundle();
            uang.putSerializable(CurrencyFragment.KEY_ACTIVITY_3,negaraFull);
            currencyFragment.setArguments(uang);
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fnav_detail,currencyFragment);
            ft.commit();
        } else if (id == R.id.nav_map) {
            MapFragment mapFragment=new MapFragment();
            Bundle peta=new Bundle();
            peta.putSerializable(MapFragment.KEY_ACTIVITY_4,negaraFull);
            mapFragment.setArguments(peta);
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fnav_detail,mapFragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
