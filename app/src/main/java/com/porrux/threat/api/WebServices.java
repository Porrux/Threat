package com.porrux.threat.api;

import com.porrux.threat.models.Event;
import com.porrux.threat.models.Type;
import com.squareup.okhttp.ResponseBody;

import java.util.List;
import java.util.UUID;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by tperroin on 04/03/2016.
 */
public interface WebServices {

    @GET("/api/event")
    Call<List<Event>> listEvents();

    @POST("/api/event")
    Call<ResponseBody> createEvent(@Body Event event);

    @GET("/api/event/{id}")
    Call<Event> getEvent(@Path("id") String id);

    @POST("/api/event/{id}/vote")
    Call<ResponseBody> vote(@Body Integer vote);

    @GET("/api/type")
    Call<List<Type>> listTypes();

}
