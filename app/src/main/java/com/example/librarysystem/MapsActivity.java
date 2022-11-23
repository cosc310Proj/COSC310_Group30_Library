package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//            map.setLatLngBoundsForCameraTarget(new LatLngBounds(new LatLng(49.940147, -119.396516), new LatLng(49.8880, 119.4960)));

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//
//        LatLng here = new LatLng(49.8880, -119.4960);
//        mMap.addMarker(new MarkerOptions().position(here).title("Kelowna"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(here));

//        map.setOnMyLocationButtonClickListener(this);
//        map.setOnMyLocationClickListener(this);
    }


}