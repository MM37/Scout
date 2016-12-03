package com.ftcscouting.kandarp.ftcscouting;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by kanda on 11/26/2016.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
