package com.gmail.nf.project.jddca.film20.ui.generate;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.data.model.Film;

import javax.inject.Inject;

public class GenerateFragment extends Fragment implements GenerateContract.View{

    @Inject GenerateContract.Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        App.getApp(getActivity()).getComponentsHolder().generateComponent(this).inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showFilm(Film film) {

    }

    @Override
    public void showError() {

    }
}
