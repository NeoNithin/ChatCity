package com.appsterden.chatcity.retrofit;

import com.appsterden.chatcity.model.AiResponseData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Nithin on 5/21/2016.
 */
public interface ApiServices {
    @GET(EndPointsConfig.AI_URL)
    void askAi(@Query("q") String query, Callback<AiResponseData> aiResponseDataCallback);

}
