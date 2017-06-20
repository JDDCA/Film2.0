package com.gmail.nf.project.jddca.film20.model.loader.dagger;

import android.content.Context;

import com.gmail.nf.project.jddca.film20.di.dagger.AppScope;
import com.gmail.nf.project.jddca.film20.model.loader.RestLoader;
import com.gmail.nf.project.jddca.film20.model.rest.RestService;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides @AppScope
    RestLoader provideRestLoader (RestService restService, Context context){
        return new RestLoader(restService, context);
    }
}
