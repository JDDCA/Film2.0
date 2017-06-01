package com.gmail.nf.project.jddca.film20.domain.loader;


import android.content.Context;

import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.gmail.nf.project.jddca.film20.data.model.Genre;
import com.gmail.nf.project.jddca.film20.data.model.Genres;
import com.gmail.nf.project.jddca.film20.data.model.UpcomingMovie;
import com.gmail.nf.project.jddca.film20.domain.rest.RestService;
import com.gmail.nf.project.jddca.film20.domain.utils.ApiService;

import java.util.List;
import java.util.Random;

import io.reactivex.Observable;

public class RestLoader {

    private final RestService restService;
    private String apiKey;
    private String locale;

    private static final int PAGE = 1;

    public RestLoader(RestService restService, Context context) {
        this.restService = restService;
        apiKey = ApiService.getApiKey(context);
        locale = ApiService.getLocales(context);
    }

    public Observable<List<Genre>> getGenres (){
        return restService.getGenres(apiKey,locale)
                .map(Genres::getGenres);
    }

    public Observable<Film> getRandomFilm() {
        return restService.getGenres(apiKey, locale)
                .map(genres -> genres.getGenres().get(new Random(System.currentTimeMillis()).nextInt(genres.getGenres().size())))
                .flatMap(genre -> restService.getPages(Integer.toString(genre.getId()), apiKey, locale))
                .flatMap(totalPage -> {
                    Random r = new Random(System.currentTimeMillis());
                    int page = totalPage.getTotalPages() > RestService.MAX_PAGES ? r.nextInt(RestService.MAX_PAGES) + 1 : r.nextInt(totalPage.getTotalPages()) + 1;
                    return restService.getPage(Integer.toString(totalPage.getId()), apiKey, locale, RestService.INCLUDE_ADULT, page);
                })
                .map(pageMovieForGenre -> pageMovieForGenre.getResults().get(new Random(System.currentTimeMillis()).nextInt(pageMovieForGenre.getResults().size())));
    }

    public Observable<List<Film>> getUpcomingFilms() {
        return restService.getUpcomingMovie(apiKey, locale)
                .map(UpcomingMovie::getResults);
    }
}
