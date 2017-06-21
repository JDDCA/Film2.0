package com.gmail.nf.project.jddca.film20.ui.detail;

import com.gmail.nf.project.jddca.film20.data.domain.Film;

/**
 * Created by wrong on 21.06.17.
 */

public interface Detail {

    interface View {
        void showFilm(Film film);

        void showError(Throwable throwable);
    }

    interface Presenter {
        void onLoad(long id);

        void onStop();
    }
}
