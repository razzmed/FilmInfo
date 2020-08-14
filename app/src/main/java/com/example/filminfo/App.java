package com.example.filminfo;

import android.app.Application;

import com.example.filminfo.data.GhibliService;

public class App extends Application {

    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
    }
}
