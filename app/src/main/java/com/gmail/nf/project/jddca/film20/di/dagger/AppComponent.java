package com.gmail.nf.project.jddca.film20.di.dagger;

import com.gmail.nf.project.jddca.film20.data.net.NetModule;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateComponent;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateModule;

import dagger.Component;

@Component (modules = {AppModule.class, NetModule.class}) @AppScope
public interface AppComponent {

    GenerateComponent createGenerateComponent (GenerateModule generateModule);
}
