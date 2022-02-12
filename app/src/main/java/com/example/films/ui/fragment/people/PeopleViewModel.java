package com.example.films.ui.fragment.people;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.films.domain.model.people.People;
import com.example.films.domain.model.people.PeopleStorage;

import java.util.List;

public class PeopleViewModel extends ViewModel {
    private MutableLiveData<List<People>> listMutableLiveData;

    public PeopleViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    void init(){
        PeopleStorage.getPeopleGyId(new PeopleStorage.Result() {
            @Override
            public void onSuccess(List<People> list) {
                listMutableLiveData.setValue(list);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public MutableLiveData<List<People>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
