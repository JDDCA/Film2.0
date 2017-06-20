package com.gmail.nf.project.jddca.film20.ui.filter;


import com.gmail.nf.project.jddca.film20.data.domain.Genre;

import java.util.List;

public interface FilterContract {

    interface View {

        void showGenreFilter (List <Genre> genres);

    }

    interface Presenter {

        void onStart ();

        void onStop ();
    }
}
