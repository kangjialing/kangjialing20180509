package com.bw.rikao0509.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;



public class MyApption extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
