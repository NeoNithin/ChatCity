package com.appsterden.chatcity.retrofit;

import com.appsterden.chatcity.MyApp;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Nithin on 5/21/2016.
 */
public class RestClient {
    private ApiServices mApiServices;

    OkHttpClient okHttpClient = new OkHttpClient();

    public RestClient() {
        RestAdapter restAdapter;
        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(EndPointsConfig.SERVER_ADDRESS)
                .setClient(new OkClient(okHttpClient))
                .build();
        mApiServices = restAdapter.create(ApiServices.class);
    }

    public ApiServices getApiServices() {
        return mApiServices;
    }
}
