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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.porrux.threat.api.ApiClient;
import com.porrux.threat.models.Event;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class ThreatDetailsActivity extends AppCompatActivity {

    public TextView textViewAddress;
    public TextView textViewDate;
    public TextView textViewDescription;
    public Geocoder geocoder;
    public List<Address> addresses;
    public TextView textViewScore;
    public Button up;
    public Button down;
    public Event event;
    public Integer rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threat_details);

        final ApiClient apiClient = new ApiClient(this);

        event = (Event) getIntent().getSerializableExtra("Event");

        textViewAddress = (TextView) findViewById(R.id.details_adress);

        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(event.getLocation().getX(), event.getLocation().getY(), 1);

            textViewAddress.setText("Address : " + addresses.get(0).getAddressLine(0) + " " + addresses.get(0).getAddressLine(1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        textViewDate = (TextView) findViewById(R.id.date_details);
        textViewDate.setText("Date : " + event.getTimestamp());

        textViewDescription = (TextView) findViewById(R.id.detailsdescription);
        textViewDescription.setText(event.getDescription());

        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewScore.setText(String.valueOf(event.getRating()));

        up = (Button) findViewById(R.id.detailsvoteup);
        down = (Button) findViewById(R.id.detailsvotedown);
        rating = event.getRating();

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating += 1;
                textViewScore.setText(String.valueOf(rating));
                apiClient.vote(event.getUuid(), 1);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating -= 1;
                textViewScore.setText(String.valueOf(rating));
                apiClient.vote(event.getUuid(),-1);
            }
        });

    }

}
