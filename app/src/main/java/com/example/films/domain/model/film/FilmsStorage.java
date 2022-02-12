package com.example.films.domain.model.film;

import com.example.films.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsStorage {
    public static void getFilmsGyId(Result result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }
    public interface Result {
        void onSuccess(List<Film> list);

        void onFailure(Throwable throwable);
    }
}
