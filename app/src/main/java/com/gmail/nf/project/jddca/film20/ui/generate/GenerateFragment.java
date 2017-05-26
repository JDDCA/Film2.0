package com.gmail.nf.project.jddca.film20.ui.generate;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.model.Film;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GenerateFragment extends Fragment implements GenerateContract.View{

    @Inject GenerateContract.Presenter presenter;
            private Unbinder unbinder;

    @BindView(R.id.posterImageView) ImageView posterImageView;
    @BindView(R.id.titleFilmTextView) TextView titleFilmTextView;
    @BindView(R.id.yearFilmTextView) TextView yearFilmTextView;
    @BindView(R.id.descriptionFilmTextView) TextView descriptionFilmTextView;

    @BindString(R.string.defuultDescriptionFilm) String defaultDescriptionFilm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generate_fragment, container, false);
        App.getApp(getActivity()).getComponentsHolder().generateComponent(this).inject(this);
        unbinder = ButterKnife.bind(this,rootView);
        presenter.onLoad();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        App.getApp(getActivity()).getComponentsHolder().releaseGenerateComponent();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showFilm(Film film) {
        titleFilmTextView.setText(film.getTitle());
        yearFilmTextView.setText(film.getReleaseDate());
        if (film.getOverview()!=null && film.getOverview().length()>0)
            descriptionFilmTextView.setText(film.getOverview());
        else descriptionFilmTextView.setText(defaultDescriptionFilm);
    }

    @Override
    public void showError() {

    }
}
