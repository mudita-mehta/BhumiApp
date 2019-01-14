package org.bhumi.bhumi.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import org.bhumi.bhumi.R;

public class RegisterFragment extends Fragment {

    private String registerFormUrl = "http://www.bhumi.ngo/volunteer";

    private ProgressBar progressBar;

    WebView volunteerRegisterPageContainer;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        volunteerRegisterPageContainer = view.findViewById(R.id.bhumi_register_page_container);
        progressBar = view.findViewById(R.id.progress);
        setupWebView();
        return view;
    }

    public void setupWebView() {
        volunteerRegisterPageContainer.setWebViewClient(new CustomClient());
        volunteerRegisterPageContainer.getSettings().setLoadsImagesAutomatically(true);
        volunteerRegisterPageContainer.getSettings().setJavaScriptEnabled(true);
        volunteerRegisterPageContainer.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        volunteerRegisterPageContainer.loadUrl(registerFormUrl);
    }

    private class CustomClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

}
