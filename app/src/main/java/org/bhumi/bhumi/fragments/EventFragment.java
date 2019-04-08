package org.bhumi.bhumi.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bhumi.bhumi.R;
import org.bhumi.bhumi.adapters.MyEventRecyclerViewAdapter;
import org.bhumi.bhumi.api.ServiceProvider;
import org.bhumi.bhumi.models.Event;
import org.bhumi.bhumi.models.Meetup;
import org.bhumi.bhumi.models.Update;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Retrofit;

public class EventFragment extends Fragment{

    private Meetup.OnListFragmentInteractionListener mListener;
    private ArrayList<Meetup> mEvents = null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {

        //initialise the ArrayList for the mEvents
        mEvents = new ArrayList<Meetup>();

    }


    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);



        // Dummy content
        Date date = new Date();

        populateEvents();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(mEvents, mListener, getContext()));
        }

        return view;
    }

    private void populateEvents() {
        mEvents = ServiceProvider.getInstance(getContext()).fetchAllEvents();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Update.OnListFragmentInteractionListener) {
            mListener = (Meetup.OnListFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}


