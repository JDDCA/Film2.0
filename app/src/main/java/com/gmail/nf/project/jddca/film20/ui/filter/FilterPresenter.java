package com.gmail.nf.project.jddca.film20.ui.filter;


import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FilterPresenter implements FilterContract.Presenter {

    private FilterContract.View view;
    private RestLoader restLoader;
    private final Set<Disposable> cacheSubscribe;

    @Inject
    public FilterPresenter(FilterContract.View view, RestLoader restLoader) {
        this.view = view;
        this.restLoader = restLoader;
        this.cacheSubscribe = new HashSet<>();

    }

    @Override
    public void onStart() {
        cacheSubscribe.add(restLoader.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showGenreFilter));
    }

    @Override
    public void onStop() {
        Observable.fromIterable(cacheSubscribe).doOnNext(Disposable::dispose).subscribe();
    }
}
