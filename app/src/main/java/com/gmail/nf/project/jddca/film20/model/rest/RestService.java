package com.gmail.nf.project.jddca.film20.model.rest;


import com.gmail.nf.project.jddca.film20.data.domain.Film;
import com.gmail.nf.project.jddca.film20.data.domain.Genres;
import com.gmail.nf.project.jddca.film20.data.domain.PageMovieForGenre;
import com.gmail.nf.project.jddca.film20.data.domain.UpcomingMovie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestService {

    int MAX_PAGES = 1000;
    String INCLUDE_ADULT = "false";


    @GET("genre/movie/list")
    Observable<Genres> getGenres(@Query("api_key") String key, @Query("language") String language);

    @GET("genre/{genre_id}/movies")
    Observable<PageMovieForGenre> getPages(@Path("genre_id") String genreId, @Query("api_key") String key, @Query("language") String language);

    @GET("genre/{genre_id}/movies")
    Observable<PageMovieForGenre> getPage(@Path("genre_id") String genreId, @Query("api_key") String key, @Query("language") String language, @Query("include_adult") String adult, @Query("page") int pageInt);

    @GET("movie/upcoming")
    Observable<UpcomingMovie> getUpcomingMovie(@Query("api_key") String key, @Query("language") String language);

    @GET("movie/{movie_id}")
    Observable<Film> getDetailedFilm(@Query("api_key") String key, @Query("language") String language, @Path("movie_id") long id);
}
