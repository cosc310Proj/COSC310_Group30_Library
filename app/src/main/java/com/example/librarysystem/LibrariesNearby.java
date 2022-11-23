package com.example.librarysystem;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.librarysystem.databinding.ActivityLibrariesNearbyBinding;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

public class LibrariesNearby extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLibrariesNearbyBinding binding;
    private LatLng[] markers;
    private String[] libraries;
    int currentLib = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLibrariesNearbyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button button = (Button) findViewById(R.id.buttonMaps);
        button.setOnClickListener(v -> changeLibraries());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        markers = new LatLng[]{
                new LatLng(49.940090, -119.395460),
                new LatLng(49.888470, -119.389780),
                new LatLng(49.889591, -119.494087),
                new LatLng(49.890610, -119.495950),
                new LatLng(50.020530, -119.400110),
                new LatLng(49.836060,-119.479050),
                new LatLng(50.030480,-119.402610),
                new LatLng(49.861650,-119.468920),
                new LatLng(49.890610,-119.495950),
                new LatLng(49.829740,-119.630310)
        };
        libraries = new String[]{
            "Okanagan Library", "Kelowna Rutland Library | ORL Branch", "Kelowna Downtown Library | ORL Branch",
                "Courthouse Libraries BC - Kelowna", "Western Library Services", "Kelowna Mission Library | ORL Branch",
                "Lake Country Library | ORL Branch", "Trout Lake Reading Ctr", "British Columbia Law Library",
                "Westside Learning Lab | ORL"
        };

        for(int x = 0; x < markers.length; x++){
            mMap.addMarker(new MarkerOptions().position(markers[x]).title("Marker in " + libraries[x]));
        }

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void changeLibraries(){
            mMap.moveCamera(CameraUpdateFactory.newLatLng(markers[currentLib]));
        DynamicToast.makeWarning(this, libraries[currentLib++]).show();
        if(currentLib == markers.length)
            currentLib = 0;

    }
}