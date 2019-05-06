package com.example.rejsedagbogapp.Activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String longtitude=null;
    private String langtitude=null;
    private String title=null;
    private Long id=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        id=(Long)getIntent().getSerializableExtra("journalID");
        Journal journal1= Storage.getInstance().getJournal(id);
        longtitude=journal1.getLongitude();
        langtitude=journal1.getLatitude();
        title=journal1.getTitle();

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
        Double longitudeInt=Double.parseDouble(longtitude);
        Double lantitudeInt=Double.parseDouble(langtitude);

        // Add a marker in Sydney and move the camera
        LatLng marker = new LatLng(longitudeInt, lantitudeInt);
        mMap.addMarker(new MarkerOptions().position(marker).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
    }
}
