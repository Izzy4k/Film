package com.example.films.ui.fragment.species;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.films.domain.model.species.Species;
import com.example.films.domain.model.species.SpeciesStorage;

import java.util.List;

public class SpeciesViewModel extends ViewModel {
    private MutableLiveData<List<Species>> listLiveData;

    public SpeciesViewModel(){
        listLiveData = new MutableLiveData<>();
    }

    void init(){
        SpeciesStorage.getSpeciesGyId(new SpeciesStorage.Result() {
            @Override
            public void onSuccess(List<Species> list) {
                listLiveData.setValue(list);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public MutableLiveData<List<Species>> getListLiveData() {
        return listLiveData;
    }
}
