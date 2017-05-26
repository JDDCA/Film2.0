package com.gmail.nf.project.jddca.film20;


import android.app.Application;
import android.content.Context;

import com.gmail.nf.project.jddca.film20.di.ComponentsHolder;

public class App extends Application {

    private ComponentsHolder componentsHolder;

    public static App getApp(Context context) {
        return (App)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }

    public ComponentsHolder getComponentsHolder() {
        return componentsHolder;
    }
}
