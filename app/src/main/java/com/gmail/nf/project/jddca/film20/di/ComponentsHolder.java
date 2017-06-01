package com.gmail.nf.project.jddca.film20.di;

/*
import android.content.Context;

import com.gmail.nf.project.jddca.film20.data.net.NetworkModule;
import com.gmail.nf.project.jddca.film20.di.dagger.AppComponent;
import com.gmail.nf.project.jddca.film20.di.dagger.AppModule;

import com.gmail.nf.project.jddca.film20.di.dagger.DaggerAppComponent;
import com.gmail.nf.project.jddca.film20.domain.loader.dagger.DataModule;
import com.gmail.nf.project.jddca.film20.ui.filter.FilterContract;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterComponent;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterModule;
import com.gmail.nf.project.jddca.film20.ui.generate.Generate;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateSubComponent;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;
import com.gmail.nf.project.jddca.film20.ui.upcoming.Upcoming;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingSubComponent;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingModule;
*/

public class ComponentsHolder {

//    private final Context context;
//    private static final String BASE_URL = "https://api.themoviedb.org/3/";
/*
    private AppComponent appComponent;
    private GenerateSubComponent generateSubComponent;
    private UpcomingSubComponent upcomingSubComponent;

    private FilterComponent filterComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    public void init() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .networkModule(new NetworkModule(BASE_URL))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public GenerateSubComponent getGenerateComponent(Generate.View view) {
        return generateSubComponent != null ? generateSubComponent : getAppComponent().createGenerateComponent(new GenerateModule(view));
    }

    public FilterComponent getFilterComponent(FilterContract.View view) {
        return filterComponent != null ? filterComponent : getAppComponent().createFilterComponent(new FilterModule(view));
    }

    public UpcomingSubComponent getUpcomingComponent(Upcoming.View view) {
        return upcomingSubComponent != null ? upcomingSubComponent : getAppComponent().createUpcomingComponent(new UpcomingModule(view));
    }

    public void releaseGenerateComponent() {
        generateSubComponent = null;
    }

    public void releaseFilterComponent() {
        filterComponent = null;
    }

    public void releaseUpcomingComponent() {
        upcomingSubComponent = null;
    }*/
}
