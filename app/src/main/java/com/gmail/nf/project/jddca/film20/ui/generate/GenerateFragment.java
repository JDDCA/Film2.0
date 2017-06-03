package com.gmail.nf.project.jddca.film20.ui.generate;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
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

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.posterImageView)
    ImageView posterImageView;

    @BindView(R.id.titleFilmTextView)
    TextView titleFilmTextView;

    @BindView(R.id.yearFilmTextView)
    TextView yearFilmTextView;

    @BindView(R.id.descriptionFilmTextView)
    TextView descriptionFilmTextView;

  /*  @BindView(R.id.generateFAB)
    FloatingActionButton generateFAB;
*/
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
        // TODO : Разобраться как работает Swipe Refresh Layout

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            presenter.onLoad();
        });
//        generateFAB.setOnClickListener(v -> presenter.onLoad());
        return rootView;
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            swipeRefreshLayout.setOnRefreshListener(() -> {
                swipeRefreshLayout.setRefreshing(false);
                presenter.onLoad();
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showFilm(Film film) {

        if (film.getPosterPath() != null) {
            Picasso.with(getContext())
                    .load(ApiService.IMG_URL + film.getPosterPath())
//                    .resize(posterImageView.getMeasuredWidthAndState(), posterImageView.getHeight())
//                    .centerCrop()
                    .into(posterImageView);
        } else {
            posterImageView.setImageResource(R.drawable.img_not_available);
        }

        titleFilmTextView.setText(film.getTitle());
        String formatDate = film.getReleaseDate().substring(0, 4);
        yearFilmTextView.setText(formatDate);
        if (film.getOverview() != null && film.getOverview().length() > 0)
            descriptionFilmTextView.setText(film.getOverview());
        else descriptionFilmTextView.setText(defaultDescriptionFilm);
    }

    @Override
    public void showError() {

    }
}
