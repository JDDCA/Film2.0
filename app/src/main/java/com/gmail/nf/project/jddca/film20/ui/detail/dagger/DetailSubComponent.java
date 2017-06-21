package com.gmail.nf.project.jddca.film20.ui.detail.dagger;

import com.gmail.nf.project.jddca.film20.ui.detail.DetailFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface DetailSubComponent extends AndroidInjector<DetailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailFragment> {
    }

}
