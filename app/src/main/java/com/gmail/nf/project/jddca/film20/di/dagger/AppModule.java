package com.gmail.nf.project.jddca.film20.di.dagger;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides @AppScope
    Context provideContext (){
        return context;
    }
}
