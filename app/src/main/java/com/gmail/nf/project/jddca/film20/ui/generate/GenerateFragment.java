package com.gmail.nf.project.jddca.film20.ui.generate;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.gmail.nf.project.jddca.film20.domain.utils.ApiService;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class GenerateFragment extends Fragment implements Generate.View {

    @Inject
    GeneratePresenter presenter;

    private Unbinder unbinder;

    @BindView(R.id.posterImageView)
    ImageView posterImageView;

    @BindView(R.id.titleFilmTextView)
    TextView titleFilmTextView;

    @BindView(R.id.yearFilmTextView)
    TextView yearFilmTextView;

    @BindView(R.id.descriptionFilmTextView)
    TextView descriptionFilmTextView;

    @BindView(R.id.generateFAB)
    FloatingActionButton generateFAB;

    @BindString(R.string.defuultDescriptionFilm)
    String defaultDescriptionFilm;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generate_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        presenter.onLoad();
        generateFAB.setOnClickListener(v -> presenter.onLoad());
        return rootView;
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showFilm(Film film) {

        Picasso.with(getContext())
                .load(ApiService.IMG_URL + film.getPosterPath())
                .resize(posterImageView.getMeasuredWidth(), posterImageView.getMeasuredHeight())
                .centerCrop()
                .into(posterImageView);

        titleFilmTextView.setText(film.getTitle());
        yearFilmTextView.setText(film.getReleaseDate());
        if (film.getOverview() != null && film.getOverview().length() > 0)
            descriptionFilmTextView.setText(film.getOverview());
        else descriptionFilmTextView.setText(defaultDescriptionFilm);
    }

    @Override
    public void showError() {

    }
}
