package com.gmail.nf.project.jddca.film20.domain.loader;


import android.content.Context;

import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.gmail.nf.project.jddca.film20.data.model.Genres;
import com.gmail.nf.project.jddca.film20.domain.rest.RestService;
import com.gmail.nf.project.jddca.film20.domain.utils.KeyService;
import com.gmail.nf.project.jddca.film20.domain.utils.LocalService;

import java.util.Random;

import io.reactivex.Observable;

public class RestLoader {

    private final RestService restService;
    private final Context context;

    public RestLoader(RestService restService, Context context) {
        this.restService = restService;
        this.context = context;
    }

    public Observable<Film> getRandomFilm() {
        String apiKey = KeyService.getApiKey(context);
        String locale = LocalService.getLocales(context);
        return restService.getGenres(apiKey, locale)
                .map(genres -> genres.getGenres().get(new Random(System.currentTimeMillis()).nextInt(genres.getGenres().size())))
                .flatMap(genre -> restService.getPages(Integer.toString(genre.getId()), apiKey, locale))
                .flatMap(totalPage -> {
                    Random r = new Random(System.currentTimeMillis());
                    int page = totalPage.getTotalPages() > RestService.MAX_PAGES ? r.nextInt(RestService.MAX_PAGES) + 1 : r.nextInt(totalPage.getTotalPages()) + 1;
                    return restService.getPage(Integer.toString(totalPage.getId()), apiKey, locale, RestService.INCLUDE_ABULT, page);
                })
                .map(pageMovieForGenre -> pageMovieForGenre.getResults().get(new Random(System.currentTimeMillis()).nextInt(pageMovieForGenre.getResults().size())));
    }
}
