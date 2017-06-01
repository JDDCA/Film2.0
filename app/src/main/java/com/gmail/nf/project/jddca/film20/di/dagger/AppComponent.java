package com.gmail.nf.project.jddca.film20.di.dagger;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.data.net.NetworkModule;
import com.gmail.nf.project.jddca.film20.domain.loader.dagger.DataModule;
import com.gmail.nf.project.jddca.film20.domain.utils.NetworkService;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        DataModule.class,
        BuildersModule.class,
        UpcomingModule.class,
        GenerateModule.class
})
@AppScope
public interface AppComponent {
//
//    GenerateSubComponent createGenerateComponent (GenerateModule generateModule);
//    FilterComponent createFilterComponent (FilterModule filterModule);
//    UpcomingSubComponent createUpcomingComponent(UpcomingModule upcomingModule);

    void inject(App app);
}
