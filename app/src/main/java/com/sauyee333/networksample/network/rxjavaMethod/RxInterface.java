package com.sauyee333.networksample.network.rxjavaMethod;

import com.sauyee333.networksample.model.response.ServiceFeed;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sauyee on 19/9/16.
 */
public interface RxInterface {
    @GET("ajax/services/feed/load?v=1.0")
    Observable<ServiceFeed> getServiceFeed(@Query("q") String query);

}
