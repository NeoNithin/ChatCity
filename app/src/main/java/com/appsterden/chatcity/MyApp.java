package com.appsterden.chatcity;

import android.app.Application;

/**
 * Created by Nithin on 5/21/2016.
 */
public class MyApp extends Application {

    private static MyApp mAppInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppInstance = this;

    }



    public static MyApp getInstance() {
        return mAppInstance;
    }
}