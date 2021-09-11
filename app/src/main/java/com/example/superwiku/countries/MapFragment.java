package com.example.superwiku.countries;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap gMap;
    private NegaraFull negaraFull;
    private MapView mapView;
    private View mView;
    private List<Float> latlng;
    private Float lat;
    private Float lng;
    private String country;

    public static String KEY_ACTIVITY_4="msg_activity";

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_map, container, false);
        negaraFull=(NegaraFull)this.getArguments().getSerializable(KEY_ACTIVITY_4);
        latlng=negaraFull.getLatlng();
        lat=latlng.get(0);
        lng=latlng.get(1);
        country=negaraFull.getName();
        //SupportMapFragment supportMapFragment=(SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.mapnya);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView=(MapView)view.findViewById(R.id.map);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        gMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title(country));
        CameraPosition negara=CameraPosition.builder().target(new LatLng(lat,lng)).zoom(5).bearing(0).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(negara));

    }
}
