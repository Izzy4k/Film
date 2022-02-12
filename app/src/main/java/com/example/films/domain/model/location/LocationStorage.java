package com.example.films.domain.model.location;

import com.example.films.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationStorage {
    public static void getLocationGyId(Result result) {
        RetrofitBuilder.getInstance().getLocations().enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }

    public interface Result {
        void onSuccess(List<Location> list);

        void onFailure(Throwable throwable);
    }
}
