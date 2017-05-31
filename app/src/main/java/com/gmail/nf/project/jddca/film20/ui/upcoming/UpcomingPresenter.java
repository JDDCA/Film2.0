package com.gmail.nf.project.jddca.film20.ui.upcoming;

import android.content.Context;
import android.widget.ProgressBar;

import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;

import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UpcomingPresenter implements Upcoming.Presenter {

    private Upcoming.View view;
    private RestLoader restLoader;
    private Set<Disposable> disposables;
    private ProgressBar progressBar;

    @Inject
    public UpcomingPresenter(Upcoming.View view, RestLoader restLoader) {
        this.view = view;
        this.restLoader = restLoader;
    }

    @Override
    public void onLoad() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        disposables.add(restLoader.getUpcomingFilms()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::showFilms, view::showError));
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void onStop() {
        Observable.fromIterable(disposables).doOnNext(Disposable::dispose).subscribe();
    }


}
