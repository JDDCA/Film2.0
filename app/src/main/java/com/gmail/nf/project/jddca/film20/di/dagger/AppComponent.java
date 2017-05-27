package com.gmail.nf.project.jddca.film20.di.dagger;

import com.gmail.nf.project.jddca.film20.data.net.NetModule;
import com.gmail.nf.project.jddca.film20.domain.loader.dagger.LoaderModule;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterComponent;
import com.gmail.nf.project.jddca.film20.ui.filter.dagger.FilterModule;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateComponent;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;

import dagger.Component;

@Component (modules = {AppModule.class, NetModule.class, LoaderModule.class}) @AppScope
public interface AppComponent {

    GenerateComponent createGenerateComponent (GenerateModule generateModule);
    FilterComponent createFilterComponent (FilterModule filterModule);
}
