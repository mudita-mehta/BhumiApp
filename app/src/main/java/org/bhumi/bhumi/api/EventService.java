package org.bhumi.bhumi.api;

import org.bhumi.bhumi.models.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventService {
    @GET("/get-meetups")
    Call<List<Event>> getAllEvents();
}
