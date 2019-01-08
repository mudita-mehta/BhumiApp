package org.bhumi.bhumi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bhumi.bhumi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutBhumiFragment extends Fragment {


    public AboutBhumiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_bhumi, container, false);
    }

}
