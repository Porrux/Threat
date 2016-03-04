package com.porrux.threat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.porrux.threat.api.ApiClient;
import com.porrux.threat.models.Event;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class ThreaTListActivity extends AppCompatActivity {

    // View's component element
    ListView listLocal;
    ListView listInternantional;

    private ArrayAdapter<String> adapter;
    private List<String> liste;
    public List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threatlist);

        this.loadLocalThreat();

        // The button to add events
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ajout d'un évènement", Snackbar.LENGTH_SHORT).setAction("Action", null).show();

                Intent form_event = new Intent(ThreaTListActivity.this, ThreaTFormActivity.class);
                startActivity(form_event);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.loadLocalThreat();
    }

    private void loadLocalThreat() {
        listLocal = (ListView) findViewById(R.id.listLocal);
        listInternantional = (ListView) findViewById(R.id.listInternational);

        final TextView emptyLocalListMessage = (TextView) findViewById(R.id.empty_local);

        final ApiClient apiClient = new ApiClient(this);

        apiClient.listEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Response<List<Event>> response, Retrofit retrofit) {

                liste = new ArrayList<String>();
                events = response.body();
                for (int i = 0; i < events.size(); i++) {
                    liste.add(events.get(i).getTitle());
                }
                adapter = new ArrayAdapter<String>(ThreaTListActivity.this, android.R.layout.simple_list_item_1, liste);
                listLocal.setAdapter(adapter);

                if (events.size() > 0) {
                    emptyLocalListMessage.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
