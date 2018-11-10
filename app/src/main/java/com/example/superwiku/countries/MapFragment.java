package com.example.superwiku.countries;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap gMap;
    private NegaraFull negaraFull;

    public static String KEY_ACTIVITY_4="msg_activity";

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_map, container, false);
        negaraFull=(NegaraFull)this.getArguments().getSerializable(KEY_ACTIVITY_4);
        SupportMapFragment supportMapFragment=(SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.mapnya);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap=googleMap;

    }
}
