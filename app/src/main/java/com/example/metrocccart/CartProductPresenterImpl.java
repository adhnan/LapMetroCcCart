package com.example.metrocccart;


public class CartProductPresenterImpl implements CartPageContract.CartProductPresenter, CartPageContract.CartProductInteractor.OnFinishedListener {

    private CartPageContract.CartProductView productView;
    private CartPageContract.CartProductInteractor productInteractor;

    public CartProductPresenterImpl(CartPageContract.CartProductView prodcuctView, CartPageContract.CartProductInteractor productInteractor) {
        this.productView = prodcuctView;
        this.productInteractor = productInteractor;
    }

    @Override
    public void onDestroy() {

        productView = null;

    }

    @Override
    public void onRefreshButtonClick() {
        productInteractor.getProductList(this);

    }

    @Override
    public void requestDataFromServer() {
        productInteractor.getProductList(this);
    }


    @Override
    public void onFinished(CartProduct productDetails) {
        if(productView != null){
            productView.setDataToRecyclerView(productDetails);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(productView != null){
            productView.onResponseFailure(t);
        }
    }
}
