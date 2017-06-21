package com.gmail.nf.project.jddca.film20.ui.detail;

import com.gmail.nf.project.jddca.film20.model.loader.RestLoader;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter implements Detail.Presenter {

    private Detail.View view;
    private RestLoader restLoader;
    private Set<Disposable> disposables;

    @Inject
    public DetailPresenter(Detail.View view, RestLoader restLoader) {
        this.view = view;
        this.restLoader = restLoader;
        disposables = new HashSet<>();
    }

    @Override
    public void onLoad(long id) {
        restLoader.getDetailedFilm(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::showFilm);
    }

    @Override
    public void onStop() {
        Observable.fromIterable(disposables).doOnNext(Disposable::dispose).subscribe();
    }
}
