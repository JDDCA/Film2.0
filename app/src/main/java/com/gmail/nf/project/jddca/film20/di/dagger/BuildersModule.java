package com.gmail.nf.project.jddca.film20.di.dagger;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.gmail.nf.project.jddca.film20.ui.generate.GenerateFragment;
import com.gmail.nf.project.jddca.film20.ui.generate.dagger.GenerateSubComponent;
import com.gmail.nf.project.jddca.film20.ui.main.MainActivity;
import com.gmail.nf.project.jddca.film20.ui.main.MainActivitySubComponent;
import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingFragment;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingSubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module (subcomponents = {MainActivitySubComponent.class, UpcomingSubComponent.class, GenerateSubComponent.class})
public abstract class BuildersModule {

    // TODO : Прописать в аргумент компонент MainActivity
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

    // TODO : Прописать в аргумент компонент GenerateFragment
    @Binds
    @IntoMap
    @FragmentKey(GenerateFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindGenerateFragmentInjectorFactory(GenerateSubComponent.Builder builder);

    // TODO : Прописать в аргумент компонент UpcomingFragment
    @Binds
    @IntoMap
    @FragmentKey(UpcomingFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindUpcomingFragmentInjectorFactory(UpcomingSubComponent.Builder builder);

}
