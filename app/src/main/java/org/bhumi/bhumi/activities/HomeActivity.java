package org.bhumi.bhumi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.bhumi.bhumi.api.User;
import org.bhumi.bhumi.R;
import org.bhumi.bhumi.fragments.AboutBhumiFragment;
import org.bhumi.bhumi.fragments.CreditsFragment;
import org.bhumi.bhumi.fragments.FollowFragment;
import org.bhumi.bhumi.fragments.ShareFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_container);

        switch (item.getItemId()) {
            case R.id.nav_home:break;
            case R.id.nav_upcoming_orientations:break;
            case R.id.nav_about_bhumi:
                if (!(fragment instanceof AboutBhumiFragment))
                    fragment = new AboutBhumiFragment();
                break;
            case R.id.nav_credits:
                if (!(fragment instanceof CreditsFragment))
                    fragment = new CreditsFragment();
                break;
            case R.id.nav_share:
                if (!(fragment instanceof ShareFragment))
                    fragment = new ShareFragment();
                break;
            case R.id.nav_follow:
                if (!(fragment instanceof FollowFragment))
                    fragment = new FollowFragment();
                break;
            case R.id.nav_register_with_bhumi:
                startActivity(new Intent(getApplicationContext(), BhumiRegisterActivity.class));
                break;
        }

       

        fragmentTransaction.replace(R.id.frame_container, fragment);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
