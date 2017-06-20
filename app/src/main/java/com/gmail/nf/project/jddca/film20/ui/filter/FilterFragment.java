package com.gmail.nf.project.jddca.film20.ui.filter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.domain.Genre;
import com.gmail.nf.project.jddca.film20.ui.utils.adapter.GenreAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FilterFragment extends Fragment implements FilterContract.View {

    @Inject FilterContract.Presenter presenter;
            private Unbinder unbinder;
    private GenreAdapter genreAdapter = new GenreAdapter();

    @BindView(R.id.genreRecycleListView) RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.filter_fragment, container, false);
//        App.getApp(getActivity()).getComponentsHolder().getFilterComponent(this).inject(this);
        unbinder = ButterKnife.bind(this,rootView);
        initRecyclerView();
        presenter.onStart();
        return rootView;
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(genreAdapter);
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        unbinder.unbind();
//        App.getApp(getActivity()).getComponentsHolder().releaseFilterComponent();
        super.onDestroyView();
    }


    @Override
    public void showGenreFilter(List<Genre> genres) {
        genreAdapter.setGenres(genres);
        genreAdapter.notifyDataSetChanged();
    }
}
