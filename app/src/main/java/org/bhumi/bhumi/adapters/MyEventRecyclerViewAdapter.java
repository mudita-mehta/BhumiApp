package org.bhumi.bhumi.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.bhumi.bhumi.R;

import org.bhumi.bhumi.fragments.EventFragment;
import org.bhumi.bhumi.fragments.OrientationFragment;
import org.bhumi.bhumi.models.Event;
import org.bhumi.bhumi.models.Meetup;
import org.bhumi.bhumi.models.Update;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder> {

    private final List<Meetup> events;
    private final Meetup.OnListFragmentInteractionListener listener;
    private final Context context;

    public MyEventRecyclerViewAdapter(List<Meetup> mEvents, Meetup.OnListFragmentInteractionListener mListener, Context mContext) {
        events = mEvents;
        listener = mListener;
        context = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.meetup = events.get(position);
        long epochTime = Calendar.getInstance().getTimeInMillis();
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat time = new SimpleDateFormat("HH:mm");
        holder.titleView.setText(holder.meetup.getName());
        holder.contentView.setText(holder.meetup.getInfo());
        holder.cityView.setText(holder.meetup.getCity());

        holder.dateView.setText(date.format(epochTime));
        holder.timeView.setText(time.format(epochTime));
        Glide.with(this.context).load(holder.meetup.getImageUrl()).into(holder.imageView);

        holder.registerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRegisterFragmentInteraction(holder.meetup);
            }
        });


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onListFragmentInteraction(holder.meetup);
                }
            }
        });

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onShareButtonClickedFragmentInteracton(holder.meetup);
            }
        });

        holder.contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactButtonClickedFragmentInteraction(holder.meetup);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titleView;
        public final TextView contentView;
        public final TextView dateView;
        public final TextView cityView;
        public final Button contactButton;
        public final Button registerView;
        public final TextView timeView;
        public final ImageView imageView;
        public final Button shareButton;
        public  Meetup meetup;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = view.findViewById(R.id.title);
            contentView = view.findViewById(R.id.content);
            dateView = view.findViewById(R.id.date);
            cityView = view.findViewById(R.id.city);
            contactButton = view.findViewById(R.id.contact);
            timeView = view.findViewById(R.id.time);
            registerView = view.findViewById(R.id.register);
            imageView = view.findViewById(R.id.eventImageView);
            shareButton = view.findViewById(R.id.share);
        }
    }
}
