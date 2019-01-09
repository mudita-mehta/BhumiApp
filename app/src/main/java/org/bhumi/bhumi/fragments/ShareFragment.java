package org.bhumi.bhumi.fragments;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import org.bhumi.bhumi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment implements View.OnClickListener {

    private ImageButton facebookView, messengerView, whatsappView, shareView, twitterView;
    private PackageManager packageManager;
    private final String message = "Hey, join Bhumi at https://www.bhumi.ngo/volunteer and make this world better";
    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_share, container, false);
        packageManager = getActivity().getPackageManager();
        facebookView = view.findViewById(R.id.facebook);
        messengerView = view.findViewById(R.id.messenger);
        whatsappView = view.findViewById(R.id.whatsapp);
        shareView = view.findViewById(R.id.others);
        twitterView = view.findViewById(R.id.twitter);
        facebookView.setOnClickListener(this);
        messengerView.setOnClickListener(this);
        whatsappView.setOnClickListener(this);
        shareView.setOnClickListener(this);
        twitterView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.whatsapp:
                shareWith("whatsapp");
                break;
            case R.id.messenger:
                shareWith("messenger");
                break;
            case R.id.twitter:
                shareWith( "twitter");
                break;
            case R.id.facebook:
                shareWith("facebook");
                break;
            case R.id.others:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("text/plain");
                startActivity(intent);
        }
    }

    public void shareWith(String app) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            PackageInfo info = packageManager.getPackageInfo("com."+app,PackageManager.GET_META_DATA);
            intent.setPackage("com."+app);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "Share with"));
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(getContext(), app+" doen't exist on this phone, please select other", Toast.LENGTH_LONG).show();
        }
    }
}
