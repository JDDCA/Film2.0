package com.gmail.nf.project.jddca.film20.ui.upcoming;

import android.util.Log;

import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class UpcomingPresenter implements Upcoming.Presenter {

    private static final String TAG = "Upc";

    private Upcoming.View view;
    private RestLoader restLoader;
    private Set<Disposable> disposables;

    @Inject
    public UpcomingPresenter(Upcoming.View view, RestLoader restLoader) {
        this.view = view;
        this.restLoader = restLoader;
        disposables = new HashSet<>();
    }

    @Override
    public void onLoad() {
        Log.d(TAG, "onLoad: before OnLoad invoke Rx");
        restLoader.getUpcomingFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showFilms, view::showError);
        Log.d(TAG, "onLoad: after onLoad invoke Rx");
    }

    @Override
    public void onStop() {
        Observable.fromIterable(disposables).doOnNext(Disposable::dispose).subscribe();
    }


}
