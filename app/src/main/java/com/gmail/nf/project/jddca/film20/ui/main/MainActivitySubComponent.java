package com.gmail.nf.project.jddca.film20.ui.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}


}
