package com.example.films.domain.model.species;

import com.example.films.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpeciesStorage {
    public static void getSpeciesGyId(Result result) {
        RetrofitBuilder.getInstance().getSpecies().enqueue(new Callback<List<Species>>() {
            @Override
            public void onResponse(Call<List<Species>> call, Response<List<Species>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Species>> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }

    public interface Result {
        void onSuccess(List<Species> list);

        void onFailure(Throwable throwable);
    }
}
