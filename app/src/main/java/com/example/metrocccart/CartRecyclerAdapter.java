package com.example.metrocccart;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartProductViewHolder> {


    private Context context;                    //this context will use to inflate the layout
    private List<CartProduct> cartProductList;          // storing all the products in a list
    private RecyclerItemClickListener recyclerItemClickListener;


    CartRecyclerAdapter(Context context, List<CartProduct> productList, RecyclerItemClickListener recyclerItemClickListener) {     //getting the context and product list with constructor
        this.context = context;
        this.cartProductList = productList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.cart_recycler_card_layout, null);
        return new CartProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder productViewHolder, @SuppressLint("RecyclerView") final int position) {
        //getting the product of the specified position

        CartProduct product = cartProductList.get(position);

        //binding the data with the viewHolder views
        productViewHolder.cartProductImage.setImageDrawable(context.getResources().getDrawable(product.getCartProductImage(), null));
        productViewHolder.cartProductId.setText(product.getCartProductId());
        productViewHolder.cartProductDesc.setText(product.getCartProductDesc());
        productViewHolder.stockCount.setText(product.getStockCount());
        productViewHolder.Gst.setText(product.getGst());
        productViewHolder.price.setText("" + product.getPrice());
        productViewHolder.offAmount.setText(product.getOffAmount());


        if (product.getOfferValid()) {
            productViewHolder.offerImage.setTextColor(Color.GREEN);
            productViewHolder.view_margin.setVisibility(View.VISIBLE);

        } else {
            productViewHolder.offerImage.setVisibility(View.GONE);
            productViewHolder.view_margin.setVisibility(View.GONE);
        }

        //productViewHolder.productCount.setText(product.getP);

        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(cartProductList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartProductList.size();
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder {       // view holder class

        TextView cartProductId, cartProductDesc, stockCount, Gst, offAmount, price, offerImage;
        Button productCount;
        ImageView cartProductImage;
        View view_margin;

        CartProductViewHolder(View itemView) {
            super(itemView);

            offerImage = itemView.findViewById(R.id.tvOfferImage);
            cartProductImage = itemView.findViewById(R.id.ivProductImage);
            cartProductId = itemView.findViewById(R.id.tvCartProductId);
            cartProductDesc = itemView.findViewById(R.id.tvProductDesc);
            stockCount = itemView.findViewById(R.id.tvInStock);
            Gst = itemView.findViewById(R.id.tvAmountAndGst);
            price = itemView.findViewById(R.id.tvPrice);
            offAmount = itemView.findViewById(R.id.tvCartOffAmount);
            productCount = itemView.findViewById(R.id.btnProductCount);
            view_margin = itemView.findViewById(R.id.view_margin);

        }
    }
}