package com.example.artem.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.artem.myapplication.fragments.AboutUsFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MyLogs";

    private AboutUsFragment aboutUs;
    private FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        aboutUs = new AboutUsFragment();
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
        getMenuInflater().inflate(R.menu.drawer, menu);
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
        Log.d(TAG, "Click on menu item");
        FragmentManager manager = getSupportFragmentManager();
        fTrans = manager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_myOffers) {
            fTrans.replace(R.id.frgmCont, aboutUs);
            Log.d(TAG, "Click on \"My offers and binds\" menu item");
        } else if (id == R.id.nav_mySigned) {
            Log.d(TAG, "Click on \"My signed contracts\" menu item");
        } else if (id == R.id.nav_close) {
            Log.d(TAG, "Click on \"Close contracts\" menu item");
        } else if (id == R.id.nav_current) {
            Log.d(TAG, "Click on \"Current offers\" menu item");
        } else if (id == R.id.nav_us) {
            Log.d(TAG, "Click on \"About us\" menu item");
        } else if (id == R.id.nav_faq) {
            Log.d(TAG, "Click on \"FAQ\" menu item");
        } else if (id == R.id.nav_account){
            Log.d(TAG, "Click on \"My account\" menu item");
           fTrans.add(R.id.frgmCont, aboutUs);
        }else if (id == R.id.nav_logout){
            Log.d(TAG, "Click on \"Logout\" menu item");
        }
        fTrans.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
