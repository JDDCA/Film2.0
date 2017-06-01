package com.gmail.nf.project.jddca.film20.ui.generate.dagger;

import com.gmail.nf.project.jddca.film20.ui.generate.GenerateFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface GenerateSubComponent extends AndroidInjector<GenerateFragment>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GenerateFragment> {}

//    void inject (GenerateFragment fragment);
}
