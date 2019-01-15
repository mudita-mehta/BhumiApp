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
import org.bhumi.bhumi.models.Event;
import org.bhumi.bhumi.models.Update;

import java.util.ArrayList;
import java.util.Date;

public class EventFragment extends Fragment{

    private Update.OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {
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

        ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(1,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+1000, "7848948784","https://google.com",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));
        events.add(new Event(2,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+2000, "7848948784","https://google.com",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));
        events.add(new Event(3,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+3000, "7848948784","https://google.com",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));
        events.add(new Event(4,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+4000, "7848948784","https://google.com",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));
        events.add(new Event(5,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+5000, "7848948784","https://google.com",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));
        events.add(new Event(6,"Cyclation", "Bhumi launched its first edition of \"Cyclation " +
                "-Cycling for Education\" this year to present an opportunity for cycling enthusiasts to " +
                "support Bhumi in providing education for the under previleged children.", "Bangalore",
                date.getTime()+6000, "7848948784","https://bhumi.ngo",
                "https://www.bhumi.ngo/wp-content/uploads/2018/02/Cyclation-graphic-main-e1533093975191.png"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(events, mListener,getContext()));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Update.OnListFragmentInteractionListener) {
            mListener = (Update.OnListFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}


