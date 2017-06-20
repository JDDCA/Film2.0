package com.gmail.nf.project.jddca.film20.data.net;

import com.gmail.nf.project.jddca.film20.di.dagger.AppScope;
import com.gmail.nf.project.jddca.film20.model.rest.RestService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public NetworkModule() {
    }

    @Provides @AppScope
    Retrofit provideRetrofit (){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides @AppScope
    RestService provideRestService (Retrofit retrofit){
        return retrofit.create(RestService.class);
    }


}
