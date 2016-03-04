package com.porrux.threat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.porrux.threat.api.ApiClient;
import com.porrux.threat.models.Type;

import java.io.Console;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ThreaTFormActivity extends AppCompatActivity {

    public List<Type> types;
    public RadioGroup radioGroupType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threa_tform);

        radioGroupType = (RadioGroup) findViewById(R.id.radioGroupTypes);

        ApiClient apiClient = new ApiClient(this);

        apiClient.listTypes().enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(Response<List<Type>> response, Retrofit retrofit) {
                Log.d("types", response.body().toString());
                types = response.body();
                final RadioButton[] rb = new RadioButton[types.size()];
                for (int i = 0; i < types.size(); i++) {
                    rb[i]  = new RadioButton(ThreaTFormActivity.this);
                    rb[i].setText(types.get(i).getLabel());
                    rb[i].setId(i + 100);
                    radioGroupType.addView(rb[i]);
                }

                System.out.print(types.get(1).getLabel());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
