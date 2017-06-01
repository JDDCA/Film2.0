package com.gmail.nf.project.jddca.film20.ui.upcoming.dagger;

import com.gmail.nf.project.jddca.film20.ui.upcoming.Upcoming;
import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingFragment;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UpcomingModule {

    @Binds
    abstract Upcoming.View provideView (UpcomingFragment fragment);

}
