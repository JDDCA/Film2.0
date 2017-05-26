package com.gmail.nf.project.jddca.film20.ui.generate.dagger;

import android.content.Context;

import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;
import com.gmail.nf.project.jddca.film20.ui.generate.GenerateContract;
import com.gmail.nf.project.jddca.film20.ui.generate.GeneratePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class GenerateModule {

    private final GenerateContract.View view;

    public GenerateModule(GenerateContract.View view) {
        this.view = view;
    }

    @Provides
    GenerateContract.Presenter providePresenter (Context context, RestLoader loader){
        return new GeneratePresenter(view,context,loader);
    }
}
