package com.sauyee333.networksample.network.retrofitMethod;

import com.sauyee333.networksample.model.response.ServiceFeed;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sauyee on 19/9/16.
 */
public class RetrofitClient {
    private static final String BASE_URL = "https://ajax.googleapis.com/";
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

    public RetrofitClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    private static class SingletonHolder {
        private static final RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getServiceApi(final NetworkCallback<ServiceFeed> networkCallback, String query) {
        retrofit2.Call<ServiceFeed> call = retrofitInterface.getServiceFeed(query);
        call.enqueue(networkCallback);
    }
}
