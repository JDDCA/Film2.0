package com.gmail.nf.project.jddca.film20.ui.upcoming.dagger;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;
import com.gmail.nf.project.jddca.film20.ui.upcoming.Upcoming;
import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingAdapter;
import com.gmail.nf.project.jddca.film20.ui.upcoming.UpcomingPresenter;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class UpcomingModule {

    private final Upcoming.View view;

    public UpcomingModule(Upcoming.View view) {
        this.view = view;
    }

    @Provides
    Upcoming.Presenter providePresenter(RestLoader restLoader) {
        return new UpcomingPresenter(view, restLoader);
    }

    @Provides
    RecyclerView.Adapter provideAdapter(List<Film> films) {
        return new UpcomingAdapter(films);
    }
}
