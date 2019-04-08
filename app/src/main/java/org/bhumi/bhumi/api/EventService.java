package org.bhumi.bhumi.api;

import org.bhumi.bhumi.models.Event;
import org.bhumi.bhumi.models.MeetUps;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventService {
    @GET("/get-meetups")
    Call<MeetUps> getAllEvents();
}
