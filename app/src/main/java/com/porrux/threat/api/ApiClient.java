package com.porrux.threat.api;

/**
 * Created by Thibault on 29/10/2015.
 */

import android.content.Context;

import com.porrux.threat.models.Event;
import com.porrux.threat.models.Type;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.ResponseBody;

import java.util.List;
import java.util.UUID;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Thibault on 29/10/2015.
 */
public class ApiClient {
    Context context;
    WebServices webService;

    public ApiClient(Context context) {
        if (webService == null) {
            this.context = context;
            OkHttpClient client = new OkHttpClient();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://threat.pakilow.eu")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client).build();

            webService = retrofit.create(WebServices.class);
        }
    }

    public Call<List<Type>> listTypes() {
        return webService.listTypes();
    }

    public Call<ResponseBody> createEvent(Event event) {
        return webService.createEvent(event);
    }

    public Call<List<Event>> listEvents() {
        return webService.listEvents();
    }

    public Call<ResponseBody> vote(String uuid, Integer vote) {
        return webService.vote(uuid, vote);
    }


}