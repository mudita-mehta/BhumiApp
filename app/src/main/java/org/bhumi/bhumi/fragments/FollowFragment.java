package org.bhumi.bhumi.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.bhumi.bhumi.R;

public class FollowFragment extends Fragment implements View.OnClickListener {


    private String linkedin_link = "https://www.linkedin.com/company/bhumi_2/";
    private String facebook_link = "https://www.facebook.com/Bhumi.Org/";
    private String insta_link = "https://www.instagram.com/bhumiorg/";
    private String twitter_link = "https://twitter.com/BhumiOrg";
    private String bhumi_link = "https://bhumi.ngo/";

    ImageButton facebookView, twitterView, instagramView, linkedinView;

    public FollowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_follow, container, false);
        facebookView = view.findViewById(R.id.facebook);
        twitterView = view.findViewById(R.id.twitter);
        instagramView = view.findViewById(R.id.instagram);
        linkedinView = view.findViewById(R.id.linkedin);

        facebookView.setOnClickListener(this);
        twitterView.setOnClickListener(this);
        instagramView.setOnClickListener(this);
        linkedinView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri websiteToVisit;
        switch (v.getId()) {
            case R.id.facebook:
                websiteToVisit = Uri.parse(facebook_link); break;
            case R.id.twitter:
                websiteToVisit = Uri.parse(twitter_link); break;
            case R.id.instagram:
                websiteToVisit = Uri.parse(insta_link); break;
            case R.id.linkedin:
                websiteToVisit = Uri.parse(linkedin_link); break;
                default:
                websiteToVisit = Uri.parse(bhumi_link); break;
        }
        intent.setData(websiteToVisit);
        startActivity(intent);
    }
}
