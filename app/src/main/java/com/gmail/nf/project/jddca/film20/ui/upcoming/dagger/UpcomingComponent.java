package com.gmail.nf.project.jddca.film20.ui.upcoming.dagger;

import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingFragment;

import dagger.Subcomponent;

@Subcomponent (modules = UpcomingModule.class)
public interface UpcomingComponent {

    void inject(UpcomingFragment fragment);
}
