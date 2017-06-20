package com.gmail.nf.project.jddca.film20;


import android.app.Activity;
import android.app.Application;

import com.gmail.nf.project.jddca.film20.data.net.NetworkModule;
import com.gmail.nf.project.jddca.film20.di.dagger.AppModule;
import com.gmail.nf.project.jddca.film20.di.dagger.DaggerAppComponent;
import com.gmail.nf.project.jddca.film20.model.loader.dagger.DataModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    public App() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .dataModule(new DataModule())
                .networkModule(new NetworkModule())
                .appModule(new AppModule(this))
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
