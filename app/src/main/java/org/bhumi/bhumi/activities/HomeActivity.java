package org.bhumi.bhumi.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.bhumi.bhumi.api.User;
import org.bhumi.bhumi.R;
import org.bhumi.bhumi.fragments.AboutBhumiFragment;
import org.bhumi.bhumi.fragments.CreditsFragment;
import org.bhumi.bhumi.fragments.EventFragment;
import org.bhumi.bhumi.fragments.FeedbackFragment;
import org.bhumi.bhumi.fragments.FollowFragment;
import org.bhumi.bhumi.fragments.OrientationFragment;
import org.bhumi.bhumi.fragments.RegisterFragment;
import org.bhumi.bhumi.fragments.ShareFragment;
import org.bhumi.bhumi.models.Event;
import org.bhumi.bhumi.models.Orientation;
import org.bhumi.bhumi.models.Update;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Update.OnListFragmentInteractionListener {

    private User user;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = User.getCurrentUser(getApplicationContext());
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, new EventFragment()).commit();



        if (!user.isLoggedIn()) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_container);
        switch (item.getItemId()) {
            case R.id.nav_home:
                if (!(fragment instanceof EventFragment)) {
                    fragment = new EventFragment();
                }
                break;
            case R.id.nav_upcoming_orientations:
                if (!(fragment instanceof OrientationFragment)) {
                    fragment = new OrientationFragment();
                }

                break;
            case R.id.nav_about_bhumi:
                if (!(fragment instanceof AboutBhumiFragment)) {
                    fragment = new AboutBhumiFragment();
                }
                break;
            case R.id.nav_credits:
                if (!(fragment instanceof CreditsFragment)) {
                    fragment = new CreditsFragment();
                }
                break;
            case R.id.nav_share:
                if (!(fragment instanceof ShareFragment)) {
                    fragment = new ShareFragment();
                }
                break;
            case R.id.nav_follow:
                if (!(fragment instanceof FollowFragment)) {
                    fragment = new FollowFragment();
                }
                break;
            case R.id.nav_feedback:
                if (!(fragment instanceof FeedbackFragment)) {
                    fragment = new FeedbackFragment();
                }
                break;
            case R.id.nav_register:
                if (!(fragment instanceof RegisterFragment)) {
                    fragment = new RegisterFragment();
                }
                break;
            case R.id.nav_logout:
                user.logout();
                overridePendingTransition(0,0);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0,0);
                startActivity(intent);
        }
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onListFragmentInteraction(Update update) {
        // Future enhacement
    }

    @Override
    public void onRegisterFragmentInteraction(Update update) {
        Uri register_link = Uri.parse(update.getRegister_url());
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(register_link);
        startActivity(i);
    }

    @Override
    public void onContactButtonClickedFragmentInteraction(Update update) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+update.getContact()));
        startActivity(i);
    }

    @Override
    public void onShareButtonClickedFragmentInteracton(Update update) {
        String message = "Check out this cool event by Bhumi NGO by visiting "+update.getRegister_url();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
