package com.gmail.nf.project.jddca.film20.ui.upcoming;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.nf.project.jddca.film20.App;
import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.gmail.nf.project.jddca.film20.ui.upcoming.dagger.UpcomingModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment_MembersInjector;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment implements Upcoming.View{

    @Inject
    UpcomingPresenter presenter;

    Unbinder unbinder;

    RecyclerView recyclerView;

    UpcomingAdapter upcomingAdapter;

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
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
//        App.getApp(getActivity()).getComponentsHolder().getUpcomingComponent(this).inject(this);
        unbinder = ButterKnife.bind(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.upcoming_rv);
        upcomingAdapter = new UpcomingAdapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(upcomingAdapter);
        presenter.onLoad();
        return view;
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
//        App.getApp(getActivity()).getComponentsHolder().releaseUpcomingComponent();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showFilms(List<Film> films) {
        upcomingAdapter.setFilms(films);
        upcomingAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
