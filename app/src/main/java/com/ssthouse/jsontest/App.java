package com.ssthouse.jsontest;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
