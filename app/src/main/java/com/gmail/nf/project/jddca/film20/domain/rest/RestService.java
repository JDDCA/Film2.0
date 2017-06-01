package com.gmail.nf.project.jddca.film20.domain.rest;


import com.gmail.nf.project.jddca.film20.data.model.Genres;
import com.gmail.nf.project.jddca.film20.data.model.PageMovieForGenre;
import com.gmail.nf.project.jddca.film20.data.model.UpcomingMovie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestService {

    int MAX_PAGES = 1000;
    String INCLUDE_ADULT = "false";


    @GET("genre/movie/list")
    Observable<Genres> getGenres (@Query("api_key") String key, @Query("language") String language);

    @GET ("genre/{genre_id}/movies")
    Observable <PageMovieForGenre> getPages (@Path("genre_id") String genreId, @Query("api_key") String key, @Query("language") String language);

    @GET ("genre/{genre_id}/movies")
    Observable <PageMovieForGenre> getPage (@Path("genre_id") String genreId, @Query("api_key") String key, @Query("language") String language,@Query("include_adult") String adult, @Query("page") int pageInt);

    @GET("movie/upcoming")
    Observable<UpcomingMovie> getUpcomingMovie(@Query("key") String key, @Query("lang") String lang);
}
