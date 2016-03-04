package com.porrux.threat;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.porrux.threat.models.Event;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class ThreatDetailsActivity extends AppCompatActivity {

    public TextView textViewAddress;
    public Geocoder geocoder;
    public List<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threat_details);

        Event event = (Event) getIntent().getSerializableExtra("Event");

        textViewAddress = (TextView) findViewById(R.id.details_adress);

        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(event.getLocation().getX(), event.getLocation().getY(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
