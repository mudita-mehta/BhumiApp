package org.bhumi.bhumi.api;

import android.content.Context;
import android.util.Log;

import org.bhumi.bhumi.models.Event;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ServiceProvider {

    public static final String TAG = "Service Provider";

    private static ServiceProvider mServiceProvider = null ;

    private Context mContext;

    private static  String mEndPoint;

    private static Retrofit retrofit;

    private ServiceProvider(Context context) {

        mContext = context;

        mEndPoint = Endpoint.getInstance(mContext).getEndpoint();

        retrofit = new Retrofit.Builder()
                .baseUrl(mEndPoint)
                .build();

    }

    public static ServiceProvider getInstance(Context context) {

        if (mServiceProvider == null) {
            mServiceProvider = new ServiceProvider(context);
        }

        return mServiceProvider;
    }

    public ArrayList<Event> fetchAllEvents() {

        try {

            EventService eventService = retrofit.create(EventService.class);

            Call<List<Event>> eventsListCall = eventService.getAllEvents();

            Log.d(TAG, "called before");

            List<Event> events = eventsListCall.execute().body();

            Log.d(TAG, "called");

            return (ArrayList<Event>) events;

        } catch(Exception e) {

            Log.d(TAG, "Exception calling fetchallevents");

        }

        return null ;
    }

}
