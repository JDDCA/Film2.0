package com.gmail.nf.project.jddca.film20.ui.upcoming;

import com.gmail.nf.project.jddca.film20.model.loader.RestLoader;

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
    private RestLoader mRestLoader;
    private Set<Disposable> disposables;

    @Inject
    public UpcomingPresenter(Upcoming.View view, RestLoader mRestLoader) {
        this.view = view;
        this.mRestLoader = mRestLoader;
        disposables = new HashSet<>();
    }

    @Override
    public void onLoad() {
        mRestLoader.getUpcomingFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showFilms, view::showError);
    }

    @Override
    public void onStop() {
        Observable.fromIterable(disposables).doOnNext(Disposable::dispose).subscribe();
    }


}
