package com.example.metrocccart;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartPageActivity extends AppCompatActivity implements CartPageContract.CartProductView {

    private Toolbar homeToolbar;
    private Chronometer chronometer;
    private long pauseOffSet;
    private boolean running;
    RecyclerView recyclerView;
    CartRecyclerAdapter cartAdapter;
    private CartPageContract.CartProductPresenter presenter;
    CartProduct cartProduct ;
    List<CartProduct> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_main);

        homeToolbar = (Toolbar) findViewById(R.id.cartToolbar);
        setSupportActionBar(homeToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        ImageView ivBlueRightArrow1 = findViewById(R.id.ivBlueRightArrow1);
        ivBlueRightArrow1.setVisibility(View.VISIBLE);
        TextView cart = findViewById(R.id.tvCart);
        cart.setVisibility(View.VISIBLE);

        chronometer = findViewById(R.id.chronometer);

        recyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//      Testing purpose
        productList = new ArrayList<>();  //initializing the productlist

        cartProduct = new CartProduct(false,R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000);
        productList.add(cartProduct);
        cartProduct = new CartProduct(false,R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000);
        productList.add(cartProduct);
        cartProduct = new CartProduct(true,R.drawable.ic_launcher_background, "1234", " 500ml SunRich Refined Sunflower Oil pouch, Pack of 23",
                "600", "10+ off", "5000", 25000);



        productList.add(cartProduct);
        setDataToRecyclerView(cartProduct);
//        Testing pusrpose code Ends


        presenter = new CartProductPresenterImpl(this, new CartProductInteractorImpl());
        presenter.requestDataFromServer();


    }

    RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(CartProduct productDetails) {
            Toast.makeText(CartPageActivity.this, "Product Desc:  " + productDetails.getCartProductDesc(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void setDataToRecyclerView(CartProduct productDetails) {
        //adding some items to our list
        cartAdapter = new CartRecyclerAdapter(this, productList, recyclerItemClickListener);   //creating recyclerView adapter
        recyclerView.setAdapter(cartAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(CartPageActivity.this, "Something went wrong...Error message: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
        Log.d("CartPageActivity", throwable.getMessage());
    }
}
