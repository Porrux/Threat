package com.porrux.threat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.Marker;
import com.porrux.threat.api.ApiClient;
import com.porrux.threat.models.Event;
import com.porrux.threat.models.Location;
import com.porrux.threat.models.Type;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ThreaTFormActivity extends AppCompatActivity implements MapFragment.onMarkerAdd {

    public List<Type> types;
    public Button buttonCreate;

    public Spinner spinnerTypes;
    public EditText editTextTitle;
    public EditText editTextDescription;
    HashMap<String, Type> spinnerMap;
    public FrameLayout mapView;
    public Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threa_tform);

        spinnerTypes = (Spinner) findViewById(R.id.spinnerTypes);
        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        mapView = (FrameLayout) findViewById(R.id.map);

        final ApiClient apiClient = new ApiClient(this);

        apiClient.listTypes().enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(Response<List<Type>> response, Retrofit retrofit) {

                types = response.body();

                String[] spinnerArray = new String[types.size()];
                spinnerMap = new HashMap<String, Type>();
                for (int i = 0; i < types.size(); i++)
                {
                    spinnerMap.put(types.get(i).getLabel(), types.get(i));
                    spinnerArray[i] = types.get(i).getLabel();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThreaTFormActivity.this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
                spinnerTypes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("types", "Types not loaded");
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = spinnerTypes.getSelectedItem().toString();
                Type currentType = spinnerMap.get(name);


                Event event = new Event();
                event.setTitle(editTextTitle.getText().toString());
                event.setDescription(editTextDescription.getText().toString());
                event.setType(currentType);
                event.setLocation(location);
                event.setEffectArea(0);
                event.setLevel(0);
                event.setRating(0);

                apiClient.createEvent(event).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {


                        Log.d("new event uuid", response.raw().message());

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }
        });


    }


    @Override
    public void onMarkerAddCallback(Marker marker) {
        Log.d("marker", marker.getPosition().toString());

        location = new Location();
        location.setX(marker.getPosition().latitude);
        location.setY(marker.getPosition().longitude);
    }
}
