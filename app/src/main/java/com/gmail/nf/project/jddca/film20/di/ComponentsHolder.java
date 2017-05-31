package com.gmail.nf.project.jddca.film20.di;

import android.content.Context;

import com.gmail.nf.project.jddca.film20.data.net.NetModule;
import com.gmail.nf.project.jddca.film20.di.dagger.AppComponent;
import com.gmail.nf.project.jddca.film20.di.dagger.AppModule;

import com.gmail.nf.project.jddca.film20.domain.loader.dagger.LoaderModule;
import com.gmail.nf.project.jddca.film20.ui.filter.FilterContract;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterComponent;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterModule;
import com.gmail.nf.project.jddca.film20.ui.generate.GenerateContract;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateComponent;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;
import com.gmail.nf.project.jddca.film20.ui.upcoming.Upcoming;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingComponent;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingModule;

public class ComponentsHolder {

    private final Context context;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private AppComponent appComponent;
    private GenerateComponent generateComponent;
    private UpcomingComponent upcomingComponent;

    private FilterComponent filterComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    public void init() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .netModule(new NetModule(BASE_URL))
                .loaderModule(new LoaderModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public GenerateComponent getGenerateComponent(GenerateContract.View view) {
        return generateComponent != null ? generateComponent : getAppComponent().createGenerateComponent(new GenerateModule(view));
    }

    public FilterComponent getFilterComponent(FilterContract.View view) {
        return filterComponent != null ? filterComponent : getAppComponent().createFilterComponent(new FilterModule(view));
    }

    public UpcomingComponent getUpcomingComponent(Upcoming.View view) {
        return upcomingComponent != null ? upcomingComponent : getAppComponent().createUpcomingComponent(new UpcomingModule(view));
    }

    public void releaseGenerateComponent() {
        generateComponent = null;
    }

    public void releaseFilterComponent() {
        filterComponent = null;
    }

    public void releaseUpcomingComponent() {
        upcomingComponent = null;
    }
}
