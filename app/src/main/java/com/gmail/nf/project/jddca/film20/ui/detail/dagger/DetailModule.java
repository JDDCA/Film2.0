package com.gmail.nf.project.jddca.film20.ui.detail.dagger;

import com.gmail.nf.project.jddca.film20.ui.detail.Detail;
import com.gmail.nf.project.jddca.film20.ui.detail.DetailFragment;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DetailModule {

    @Binds
    abstract Detail.View provideView(DetailFragment fragment);

}
