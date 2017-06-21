package com.gmail.nf.project.jddca.film20.di.dagger;


import android.content.Context;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.ui.detail.dagger.DetailSubComponent;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateSubComponent;
import com.gmail.nf.project.jddca.film20.ui.main.MainActivitySubComponent;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingSubComponent;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {MainActivitySubComponent.class, UpcomingSubComponent.class, GenerateSubComponent.class, DetailSubComponent.class})
@AppScope
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    Context provideContext() {
        return app;
    }

    @Provides
    App provideApp() {
        return app;
    }
}
