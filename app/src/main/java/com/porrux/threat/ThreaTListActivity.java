package com.porrux.threat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class ThreaTListActivity extends AppCompatActivity {

    // View's component element
    ListView listLocal;
    ListView listInternantional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threatlist);

        listLocal = (ListView) findViewById(R.id.listLocal);
        listInternantional = (ListView) findViewById(R.id.listInternational);

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

        listLocal.setOnItemClickListener(listItemListener);
    }

     AdapterView.OnItemClickListener listItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

        }
    };
}
