package org.bhumi.bhumi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.bhumi.bhumi.R;
import org.bhumi.bhumi.fragments.OrientationFragment.OnListFragmentInteractionListener;
import org.bhumi.bhumi.models.Orientation;

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
        holder.mIdView.setText(orientations.get(position).getId()+"");
        holder.mContentView.setText(orientations.get(position).getCity());

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
        public final TextView mIdView;
        public final TextView mContentView;
        public Orientation orientation;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
