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
import org.bhumi.bhumi.adapters.MyOrientationRecyclerViewAdapter;
import org.bhumi.bhumi.models.Orientation;

import java.util.ArrayList;
import java.util.Date;

public class OrientationFragment extends Fragment {


    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OrientationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orientation_list, container, false);

        ArrayList<Orientation> orientations = new ArrayList<>();
        Date date = new Date();
        orientations.add(new Orientation(1,"Bangalore",date.getDate()+1000,
                "9900858710","google.com"));
        orientations.add(new Orientation(2,"Bangalore",date.getDate()+2000,
                "9900858710","google.com"));
        orientations.add(new Orientation(3,"Bangalore",date.getDate()+3000,
                "9900858710","google.com"));
        orientations.add(new Orientation(4,"Bangalore",date.getDate()+4000,
                "9900858710","google.com"));
        orientations.add(new Orientation(5,"Bangalore",date.getDate()+5000,
                "9900858710","google.com"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyOrientationRecyclerViewAdapter(orientations, mListener));
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
        void onListFragmentInteraction(Orientation orientation);
    }
}
