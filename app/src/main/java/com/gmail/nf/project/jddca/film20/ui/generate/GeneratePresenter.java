package com.gmail.nf.project.jddca.film20.ui.generate;


import android.content.Context;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class GeneratePresenter implements GenerateContract.Presenter {

    private GenerateContract.View view;
    private Context context;
    private final Set<Disposable> cacheSubscribe;

    @Inject
    public GeneratePresenter(GenerateContract.View view, Context context) {
        this.view = view;
        this.context = context;
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

    }
}
