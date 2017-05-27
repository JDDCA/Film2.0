package com.gmail.nf.project.jddca.film20.ui.filter.dagger;

import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;
import com.gmail.nf.project.jddca.film20.ui.filter.FilterContract;
import com.gmail.nf.project.jddca.film20.ui.filter.FilterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FilterModule {

    private final FilterContract.View view;

    public FilterModule(FilterContract.View view) {
        this.view = view;
    }

    @Provides
    FilterContract.Presenter providePresenter (RestLoader restLoader){
        return new FilterPresenter (view, restLoader);
    }

    @Provides
    FilterContract.View provideView (){
        return view;
    }
}
