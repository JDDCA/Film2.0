package com.gmail.nf.project.jddca.film20.domain.loader.dagger;

import android.content.Context;

import com.gmail.nf.project.jddca.film20.di.dagger.AppScope;
import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;
import com.gmail.nf.project.jddca.film20.domain.rest.RestService;

import dagger.Module;
import dagger.Provides;

@Module
public class LoaderModule {

    @Provides @AppScope
    RestLoader provideRestLoader (RestService restService, Context context){
        return new RestLoader(restService, context);
    }
}
