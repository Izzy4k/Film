package com.example.films.data;

import com.example.films.domain.model.film.Film;
import com.example.films.domain.model.location.Location;
import com.example.films.domain.model.people.People;
import com.example.films.domain.model.species.Species;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("films")
    Call<List<Film>> getFilms();

    @GET("films/{id}")
    Call<Film> getFilm(@Path("id") String id);

    @GET("people")
    Call<List<People>> getPeople();

    @GET("species")
    Call<List<Species>> getSpecies();
    @GET("locations")
    Call<List<Location>> getLocations();
}
