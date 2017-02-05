package com.tokenizer.tokenizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Tokenizer");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarToggle toggle = new ActionBarToggle(
                this,                             /* host Activity */
                drawer,                           /* DrawerLayout object */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        setUpNavigationView();

        Intent intent = new Intent(MainActivity.this, GenerateQR.class);
        startActivity(intent);
        //setUpCardView();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Class that sets up a dynamic toolbar for the layout
    private class ActionBarToggle extends ActionBarDrawerToggle {

        ActionBarToggle(Activity activity, DrawerLayout drawer, int open, int close) {
            super(activity, drawer, open, close);
        }

        // Changes the title of the layout if the drawer is opened.
        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            toolbar.setTitle("Options");
        }

        // Change the title of the layout back to what it was when it is closed.
        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            toolbar.setTitle("Tokenizer");
        }
    }

    // This method is here to set up the functionality of the navigation view layout.
    private void setUpNavigationView(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        // The programs gets the ID of the item selected by the user
                        // and then decides what to do for item clicked.
                        int id = item.getItemId();
                        if (id == R.id.settings_tab) {
                            Intent openSettings = new Intent(MainActivity.this, SettingsActivity.class);
                            startActivity(openSettings);
                        } else if (id == R.id.about_tab) {
                            Intent openAbout = new Intent(MainActivity.this, AboutPage.class);
                            startActivity(openAbout);
                        }

                        // After the item in the navigation drawer is clicked, the drawer is
                        // closed for the new activity/action to take place.
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }
}
