package com.gmail.nf.project.jddca.film20.ui.generate;


import com.gmail.nf.project.jddca.film20.data.domain.Film;

public interface Generate {

    interface View {

        void showFilm (Film film);

        void showError (Throwable throwable);
    }

    interface Presenter {

        void onStart ();

        void onStop ();

        void onLoad ();
    }
}
