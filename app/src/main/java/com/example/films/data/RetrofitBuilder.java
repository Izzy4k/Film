package com.example.films.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static Api instance;

    private RetrofitBuilder() {
    }

    public static Api getInstance() {
        if (instance == null) {
            instance = buildRetrofit();
        }
        return instance;
    }

    private static Api buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api.class);
    }
}
