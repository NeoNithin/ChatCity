package com.appsterden.chatcity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String addr = "";
    private Boolean isReq = true;
    private EditText slots;
    private TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent intent = getIntent();
        addr = intent.getStringExtra("addr");
        isReq = intent.getBooleanExtra("isreq", true);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        slots = (EditText) findViewById(R.id.slots);
        slots.setVisibility(isReq ? View.GONE : View.VISIBLE);
        submit = (TextView) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
        int[] location = getLocationFromAddress();
        // Add a marker in Sydney and move the camera
        if (location == null) {
            finish();
        } else {
            LatLng place = new LatLng(location[0], location[1]);
            mMap.addMarker(new MarkerOptions().position(place).title(addr));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
            mMap.animateCamera(CameraUpdateFactory.zoomBy(14));
        }
    }

    public int[] getLocationFromAddress() {

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        int[] p1 = new int[2];

        try {
            address = coder.getFromLocationName(addr, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1[0] = (int) location.getLatitude();
            p1[1] = (int) location.getLongitude();

            return p1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p1;
    }
}
