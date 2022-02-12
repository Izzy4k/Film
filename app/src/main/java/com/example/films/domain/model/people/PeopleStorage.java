package com.example.films.domain.model.people;

import com.example.films.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleStorage {
    public static  void getPeopleGyId(Result result){
        RetrofitBuilder.getInstance().getPeople().enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if(response.isSuccessful() && response.body() != null){
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
                    result.onFailure(t);
            }
        });

    }
    public interface Result{
        void onSuccess(List<People> list);
        void onFailure(Throwable throwable);
    }
}
