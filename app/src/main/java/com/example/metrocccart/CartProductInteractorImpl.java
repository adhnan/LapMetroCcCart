package com.example.metrocccart;


import org.json.JSONObject;


public class CartProductInteractorImpl implements CartPageContract.CartProductInteractor {

    public JSONObject customerRequestBodyJson;
    @Override
    public void getProductList(final OnFinishedListener onFinishedListener) {

//        UserPreferences mPreference = new UserPreferencesImpl();
//        String customerRequestBody=mPreference.getWsDto();
//        Map<String, Object> retMap = new Gson().fromJson(customerRequestBody, new TypeToken<HashMap<String, Object>>() {}.getType()
//        );
//        CustomerDataService service = RetrofitInstance.getRetrofitInstance().create(CustomerDataService.class);
//
//        Call<CustomerDetails> call = service.getCustomerData("application/json","Bearer "+mPreference.getAccessToken(),retMap);
//        //Call<CustomerDetails> call = service.getCustomerData(retMap);
//
//        Log.wtf("URL Called", call.request().url() + "");
//
//        call.enqueue(new Callback<CustomerDetails>() {
//            @Override
//            public void onResponse(Call<CustomerDetails> call, Response<CustomerDetails> response) {
//                if(response!=null && response.body()!=null && response.body().getB2bUnits()!=null) {
//                    onFinishedListener.onFinished((CustomerDetails) response.body());
//
//                }else {
//                    String err_message;
//                    err_message= (response!=null ? response.toString(): "Unknown network error"); //TOdo change unknown error
//                    onFinishedListener.onFailure(new Throwable(err_message));
//                }
//                Log.d("CustomerInteractorImp",response.toString());
//
//
//            }
//
//            @Override
//            public void onFailure(Call<CustomerDetails> call, Throwable t) {
//                onFinishedListener.onFailure(t);
//            }
//        });



    }

}
