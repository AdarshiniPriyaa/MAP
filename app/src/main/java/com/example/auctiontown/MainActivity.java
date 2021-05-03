package com.example.auctiontown;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.auctiontown.R.id.b1;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
  int c= android.R.color.white;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView i1 = (ImageView) findViewById(R.id.i1);
        i1.setImageResource(R.drawable.pic4);
        final TextView textView=(TextView)findViewById(R.id.textView);
        TextView b1 = (TextView)findViewById(R.id.b1);
        TextView b2 = (TextView)findViewById(R.id.b2);
        TextView b3 = (TextView)findViewById(R.id.b3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        textView.setOnClickListener(this);
        TimerTask t1 = new TimerTask(){
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random r= new Random();
                        if(c== android.R.color.white)
                            c= android.R.color.holo_blue_dark;
                        else {
                            c = android.R.color.holo_green_dark;
                        }
                        textView.setBackgroundColor(c);
                    }
                });

            }
        };



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //floaating actionbar
        //mail


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
        getMenuInflater().inflate(R.menu.main, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.for1) {
            Intent i1= new Intent(MainActivity.this, Register.class);
            startActivity(i1);

        } else if (id == R.id.du1) {
            Intent i2= new Intent(MainActivity.this, Registrationseller.class);
            startActivity(i2);

        } else if (id == R.id.jap) {


        } else if (id == R.id.mul1) {


        } else if (id == R.id.rev) {


        } else if (id == R.id.nav_home) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Intent i = new Intent(MainActivity.this, Bidder.class);
                startActivity(i);
                break;
            case R.id.b2:
                Intent in = new Intent(MainActivity.this, Seller.class);
                startActivity(in);
                break;
            case R.id.b3:
                Intent intent = new Intent(MainActivity.this, Admin.class);
                startActivity(intent);
                break;

        }
    }
}
