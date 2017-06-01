package com.gmail.nf.project.jddca.film20.ui.upcoming.dagger;

import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface UpcomingSubComponent extends AndroidInjector<UpcomingFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UpcomingFragment> {}

//    void inject(UpcomingFragment fragment);
}
