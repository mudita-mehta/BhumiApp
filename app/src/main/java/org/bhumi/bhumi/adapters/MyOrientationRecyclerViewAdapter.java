package org.bhumi.bhumi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.bhumi.bhumi.R;
import org.bhumi.bhumi.fragments.OrientationFragment.OnListFragmentInteractionListener;
import org.bhumi.bhumi.models.Orientation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class MyOrientationRecyclerViewAdapter extends RecyclerView.Adapter<MyOrientationRecyclerViewAdapter.ViewHolder> {

    private final List<Orientation> orientations;
    private final OnListFragmentInteractionListener mListener;

    public MyOrientationRecyclerViewAdapter(List<Orientation> mOrientations, OnListFragmentInteractionListener listener) {
        orientations = mOrientations;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_orientation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.orientation = orientations.get(position);
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat time = new SimpleDateFormat("HH:mm");
        long epochTime = holder.orientation.getDate();
        holder.cityView.setText(holder.orientation.getCity());
        holder.contactView.setText(holder.orientation.getContact());
        holder.dateView.setText(date.format(epochTime));
        holder.timeView.setText(time.format(epochTime));

        holder.registerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRegisterFragmentInteraction(holder.orientation);
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.orientation);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return orientations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView cityView;
        public final TextView timeView;
        public final TextView dateView;
        public final TextView contactView;
        public final Button registerView;
        public Orientation orientation;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            cityView = view.findViewById(R.id.city);
            timeView = view.findViewById(R.id.time);
            dateView = view.findViewById(R.id.date);
            contactView = view.findViewById(R.id.contact);
            registerView = view.findViewById(R.id.register);
        }

    }
}
