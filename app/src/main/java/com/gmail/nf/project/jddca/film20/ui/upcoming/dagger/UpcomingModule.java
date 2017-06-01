package com.gmail.nf.project.jddca.film20.ui.upcoming.dagger;

import com.gmail.nf.project.jddca.film20.di.dagger.AppScope;
import com.gmail.nf.project.jddca.film20.ui.generate.Generate;
import com.gmail.nf.project.jddca.film20.ui.upcoming.Upcoming;
import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class UpcomingModule {
//
//    private final Upcoming.View view;
//
//    public UpcomingModule(Upcoming.View view) {
//        this.view = view;
//    }
//
//    @Provides
//    Upcoming.View provideView() {
//        return view;
//    }

    @Binds
    abstract Upcoming.View provideView (UpcomingFragment fragment);

}
