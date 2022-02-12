package com.example.films.ui.fragment.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.films.domain.model.film.Film;
import com.example.films.domain.model.film.FilmStorage;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<Film> filmMutableLiveData ;

    public DetailViewModel() {
        filmMutableLiveData = new MutableLiveData<>();
    }
    public void init(String id){
        FilmStorage.getFilmGyId(id, new FilmStorage.Result() {
            @Override
            public void onSuccess(Film film) {
                filmMutableLiveData.setValue(film);
            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        });
    }

    public MutableLiveData<Film> getFilmMutableLiveData() {
        return filmMutableLiveData;
    }
}
