package com.porrux.threat.api;

/**
 * Created by Thibault on 29/10/2015.
 */

import android.content.Context;

import com.porrux.threat.models.Type;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

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


}