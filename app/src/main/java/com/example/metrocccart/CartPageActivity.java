package com.example.metrocccart;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartPageActivity extends AppCompatActivity {

    private Toolbar homeToolbar;
    private Chronometer chronometer;
    private long pauseOffSet;
    private boolean running;
    RecyclerView recyclerView;
    CartRecyclerAdapter cartAdapter;
    List<CartProduct> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_main);

        homeToolbar = (Toolbar) findViewById(R.id.cartToolbar);
        setSupportActionBar(homeToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        chronometer = findViewById(R.id.chronometer);
        startChronometer();

        recyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();  //initializing the productlist

        //adding some items to our list
        productList.add(new CartProduct(R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000));
        productList.add(new CartProduct(R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000));
        productList.add(new CartProduct(R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000));
        productList.add(new CartProduct(R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000));
        productList.add(new CartProduct(R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000));


        cartAdapter = new CartRecyclerAdapter(this, productList);   //creating recyclerView adapter
        recyclerView.setAdapter(cartAdapter);                         //setting adapter to recyclerView
    }

    public void startChronometer() {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view) {
        if (running) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = 0;
    }

}
