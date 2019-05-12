package com.example.metrocccart;

public interface CartPageContract {

    interface CartProductPresenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    interface CartProductView {


        void setDataToRecyclerView(CartProduct productDetails);

        void onResponseFailure(Throwable throwable);

    }

    interface CartProductInteractor {

        interface OnFinishedListener {
            void onFinished(CartProduct ProductDetails);
            void onFailure(Throwable t);
        }

        void getProductList(OnFinishedListener onFinishedListener);
    }
}
