package com.gmail.samuelhermosilla98.gamestoreapp.Views;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

    }

    public static Context getContext() {
        return sContext;
    }


    public static void setContext(Context sContext) {
        MyApplication.sContext = sContext;
    }
}