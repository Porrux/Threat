package com.porrux.threat;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;

public class ThreaTFormActivity extends AppCompatActivity {


    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;
    private LocationRequest locationRequest;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threa_tform);
    }
}
