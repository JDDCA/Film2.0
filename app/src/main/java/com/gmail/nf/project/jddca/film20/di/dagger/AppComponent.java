package com.gmail.nf.project.jddca.film20.di.dagger;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.data.net.NetworkModule;
import com.gmail.nf.project.jddca.film20.model.loader.dagger.DataModule;
import com.gmail.nf.project.jddca.film20.ui.detail.dagger.DetailModule;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingModule;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        DataModule.class,
        BuildersModule.class,
        UpcomingModule.class,
        GenerateModule.class,
        DetailModule.class
})
@AppScope
public interface AppComponent {

    void inject(App app);

}
