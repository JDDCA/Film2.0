package com.gmail.nf.project.jddca.film20.ui.upcoming;

import com.gmail.nf.project.jddca.film20.data.model.Film;

import java.util.List;

public interface Upcoming {

    interface View {
        void showFilms(List<Film> films);

        void showError(Throwable throwable);
    }

    interface Presenter {
        void onLoad(Integer page);

        void onStop();
    }

}
