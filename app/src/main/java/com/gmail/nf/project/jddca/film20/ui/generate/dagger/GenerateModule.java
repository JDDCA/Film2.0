package com.gmail.nf.project.jddca.film20.ui.generate.dagger;

import com.gmail.nf.project.jddca.film20.ui.generate.Generate;
import com.gmail.nf.project.jddca.film20.ui.generate.GenerateFragment;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class GenerateModule {
//
//    private final Generate.View view;
//
//    public GenerateModule(Generate.View view) {
//        this.view = view;
//    }
//
//    @Provides
//    Generate.View provideView() {
//        return view;
//    }

    @Binds
    abstract Generate.View provideView(GenerateFragment fragment);
}
