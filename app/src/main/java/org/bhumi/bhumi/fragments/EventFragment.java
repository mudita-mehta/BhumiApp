package org.bhumi.bhumi.fragments;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.Date;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EventFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EventFragment newInstance(int columnCount) {
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
        events.add(new Event(1,"Running", "Run for cause", "Bangalore",
                date.getTime()+1000, "7848948784","google.com"));
        events.add(new Event(2,"Running", "Run for cause", "Bangalore",
                date.getTime()+2000, "7848948784","google.com"));
        events.add(new Event(3,"Running", "Run for cause", "Bangalore",
                date.getTime()+3000, "7848948784","google.com"));
        events.add(new Event(4,"Running", "Run for cause", "Bangalore",
                date.getTime()+4000, "7848948784","google.com"));
        events.add(new Event(5,"Running", "Run for cause", "Bangalore",
                date.getTime()+5000, "7848948784","google.com"));
        events.add(new Event(6,"Running", "Run for cause", "Bangalore",
                date.getTime()+6000, "7848948784","google.com"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(events, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Event event);
    }
}
