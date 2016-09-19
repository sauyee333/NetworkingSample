package com.sauyee333.networksample.network.rxjavaMethod;

import com.sauyee333.networksample.model.ServiceFeed;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sauyee on 19/9/16.
 */
public class RxClient {
    public static final String BASE_URL = "https://ajax.googleapis.com/";
    private Retrofit retrofit;
    private RxInterface rxInterface;

    private void getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        rxInterface = retrofit.create(RxInterface.class);
    }

    private static class SingletonHolder {
        private static final RxClient INSTANCE = new RxClient();
    }

    public static RxClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private <T> void setupSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getServiceApi(Subscriber<ServiceFeed> subscriber, String query) {
        Observable observable = rxInterface.getServiceFeed(query);
        setupSubscribe(observable, subscriber);
    }
}
