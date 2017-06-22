package com.gmail.nf.project.jddca.film20.ui.upcoming;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.domain.Film;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment implements Upcoming.View {

    private Integer page = 1;

    @Inject
    UpcomingPresenter presenter;

    private Unbinder unbinder;

    @BindView(R.id.upcoming_rv)
    RecyclerView mRecyclerView;

    private UpcomingAdapter mUpcomingAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public UpcomingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_upcoming, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mUpcomingAdapter = new UpcomingAdapter(getContext());
        mRecyclerView.setAdapter(mUpcomingAdapter);

        presenter.onLoad();

        // TODO : Реализовать нажатие на текст для открытия Фрагмента с Детальной информацией по фильму
//        learnMore.setOnClickListener(view -> );

        return rootView;
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showFilms(List<Film> films) {
        mUpcomingAdapter.setFilms(films);
        mUpcomingAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable throwable) {
        Snackbar.make(getView(), R.string.error, Snackbar.LENGTH_LONG).show();
        throwable.printStackTrace();
    }
}
