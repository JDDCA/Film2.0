package com.gmail.nf.project.jddca.film20.ui.generate;


import android.graphics.Movie;

public interface GenerateContract {

    interface View {

        void showFilm (Movie movie);

        void showError ();
    }

    interface Presenter {

        void onStart ();

        void onStop ();

        void onLoad ();
    }
}
