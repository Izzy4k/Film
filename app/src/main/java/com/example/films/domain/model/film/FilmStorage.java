package com.example.films.domain.model.film;

import com.example.films.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {
    public static  void getFilmGyId(String id , Result result){
        RetrofitBuilder.getInstance().getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.isSuccessful() && response.body() != null){
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }
    public interface Result{
        void onSuccess(Film film);
        void onFailure(Throwable throwable);
    }
}
