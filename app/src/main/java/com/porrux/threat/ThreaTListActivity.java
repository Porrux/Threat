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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.porrux.threat.api.ApiClient;
import com.porrux.threat.models.Event;
import com.porrux.threat.models.Type;

import java.util.ArrayList;
import java.util.HashMap;
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

    HashMap<String, Event> eventsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threatlist);

        listLocal = (ListView) findViewById(R.id.listLocal);
        listInternantional = (ListView) findViewById(R.id.listInternational);

        final ApiClient apiClient = new ApiClient(this);

        apiClient.listEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Response<List<Event>> response, Retrofit retrofit) {

                liste = new ArrayList<String>();
                events = response.body();
                for (int i = 0; i < events.size(); i++) {
                    liste.add(events.get(i).getTitle());
                    eventsMap.put(events.get(i).getTitle(), events.get(i));
                }
                adapter = new ArrayAdapter<String>(ThreaTListActivity.this, android.R.layout.simple_list_item_1, liste);
                listLocal.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        listLocal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = listLocal.getItemAtPosition(position);

                Intent details_event = new Intent(ThreaTListActivity.this, ThreatDetailsActivity.class);
                details_event.putExtra("Event", eventsMap.get(item.toString()));
                startActivity(details_event);
            }
        });

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

        //Hello
        TextView emptyText1 = (TextView)findViewById(R.id.empty_inter);
        TextView emptyText2 = (TextView)findViewById(R.id.empty_local);
        listLocal.setEmptyView(emptyText1);
        listInternantional.setEmptyView(emptyText2);

    }
}
