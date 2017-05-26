package com.gmail.nf.project.jddca.film20.ui.generate;


import android.content.Context;

import com.gmail.nf.project.jddca.film20.domain.loader.RestLoader;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeneratePresenter implements GenerateContract.Presenter {

    private RestLoader restLoader;
    private GenerateContract.View view;
    private Context context;
    private final Set<Disposable> cacheSubscribe;

    @Inject
    public GeneratePresenter(GenerateContract.View view, Context context, RestLoader restLoader) {
        this.view = view;
        this.context = context;
        this.restLoader = restLoader;
        this.cacheSubscribe = new HashSet<>();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        Observable.fromIterable(cacheSubscribe).doOnNext(Disposable::dispose).subscribe();
    }

    @Override
    public void onLoad() {
        restLoader.getRandomFilm()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showFilm);
    }
}
