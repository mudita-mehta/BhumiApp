package org.bhumi.bhumi.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.bhumi.bhumi.R;
import org.bhumi.bhumi.api.Endpoint;
import org.bhumi.bhumi.api.User;
import org.bhumi.bhumi.api.Validator;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment implements View.OnClickListener {

    EditText feedbackTextView;
    Button buttonView;
    ProgressBar progressView;
    View feedbackFormView;

    String endpoint;
    User user;
    Validator validator;
    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_feedback, container, false);
        feedbackTextView = view.findViewById(R.id.feedback_edittext);
        buttonView = view.findViewById(R.id.feedback_submit_button);
        progressView = view.findViewById(R.id.progress);
        feedbackFormView = view.findViewById(R.id.feedback_form);


        endpoint = Endpoint.getInstance(getContext()).getEndpoint();
        user = User.getCurrentUser(getContext());
        validator = Validator.getInstance(getContext());

        buttonView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v){
        final String feedbackText = feedbackTextView.getText().toString();
        validator.reset();
        validator.validateText(feedbackText, feedbackTextView);
        if (validator.isOkay()) {
            showProgress(true);
            String email = user.getEmail();
            final Context context = getContext();
            try {
                OkHttpClient client = new OkHttpClient();
                String mEmail = validator.encode(email);
                String mFeedback = validator.encode(feedbackText);
                Request request = new Request.Builder()
                        .url(endpoint + "/getFeedback/" + mEmail + "/" + mFeedback)
                        .get().addHeader("Content-Type", "application/json")
                        .addHeader("cache-control", "no-cache")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Unable to send feedback, try again!", Toast.LENGTH_LONG).show();
                                showProgress(false);
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            final String msg = jsonObject.getString("msg");
                            if (jsonObject.getBoolean("success")) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                                        feedbackTextView.setText("");
                                        showProgress(false);
                                    }
                                });
                            } else {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                                        showProgress(false);
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            Toast.makeText(context, "Unable to send feedback, try again!", Toast.LENGTH_LONG).show();
                            showProgress(false);
                        }
                    }
                });


            } catch (Exception e) {
                Toast.makeText(context, "Unable to send feedback, try again!", Toast.LENGTH_LONG).show();
                showProgress(false);
            }
        }
        else {
            Toast.makeText(getContext(), "Please fix the errors and try again", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            feedbackFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            feedbackFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    feedbackFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            feedbackFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
