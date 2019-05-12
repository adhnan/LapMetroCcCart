package com.example.metrocccart;

public class CartProduct {
    private int cartProductImage  ;
    private String cartProductId,cartProductDesc,stockCount,gst,offAmount;
    private double price;
    private boolean offerValid ;

    public CartProduct(boolean offerValid,int cartProductImage, String cartProductId, String cartProductDesc, String stockCount, String gst, String offAmount, double price) {
        this.cartProductImage = cartProductImage;
        this.cartProductId = cartProductId;
        this.cartProductDesc = cartProductDesc;
        this.stockCount = stockCount;
        this.gst = gst;
        this.offAmount = offAmount;
        this.price = price;
        this.offerValid=offerValid;
    }

    public boolean getOfferValid() {
        return offerValid;
    }

    public int getCartProductImage() {
        return cartProductImage;
    }

    public String getCartProductId() {
        return cartProductId;
    }

    public String getCartProductDesc() {
        return cartProductDesc;
    }

    public String getStockCount() {
        return stockCount;
    }


    public String getGst() {
        return gst;
    }

    public String getOffAmount() {
        return offAmount;
    }

    public double getPrice() {
        return price;
    }
}

