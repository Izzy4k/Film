package com.example.films.ui.fragment.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.films.domain.model.location.Location;
import com.example.films.domain.model.location.LocationStorage;

import java.util.List;

public class LocationViewModel extends ViewModel {
    private MutableLiveData<List<Location>> listMutableLiveData;

    public LocationViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public void init(){
        LocationStorage.getLocationGyId(new LocationStorage.Result() {
            @Override
            public void onSuccess(List<Location> list) {
                listMutableLiveData.setValue(list);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public MutableLiveData<List<Location>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
