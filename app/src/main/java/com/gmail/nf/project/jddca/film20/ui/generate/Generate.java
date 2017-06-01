package com.gmail.nf.project.jddca.film20.ui.generate;


import android.graphics.Movie;

import com.gmail.nf.project.jddca.film20.data.model.Film;

public interface Generate {

    interface View {

        void showFilm (Film film);

        void showError ();
    }

    interface Presenter {

        void onStart ();

        void onStop ();

        void onLoad ();
    }
}
