package com.example.films.ui.fragment.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.films.domain.model.film.Film;
import com.example.films.domain.model.film.FilmsStorage;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Film>> listMutableLiveData;

    public HomeViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public void init(){
        FilmsStorage.getFilmsGyId(new FilmsStorage.Result() {
            @Override
            public void onSuccess(List<Film> list) {
                listMutableLiveData.setValue(list);
            }

            @Override
            public void onFailure(Throwable throwable) {
                listMutableLiveData.setValue(null);
            }
        });
    }

    public MutableLiveData<List<Film>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
