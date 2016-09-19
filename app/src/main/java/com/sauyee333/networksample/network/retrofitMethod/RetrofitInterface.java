package com.sauyee333.networksample.network.retrofitMethod;

import com.sauyee333.networksample.model.ServiceFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sauyee on 19/9/16.
 */
public interface RetrofitInterface {
    @GET("ajax/services/feed/load?v=1.0")
    Call<ServiceFeed> getServiceFeed(@Query("q") String query);
}
