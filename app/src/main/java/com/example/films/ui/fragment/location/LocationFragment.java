package com.example.films.ui.fragment.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.films.R;
import com.example.films.databinding.FragmentLocationBinding;
import com.example.films.domain.model.location.Location;
import com.example.films.ui.fragment.location.adapter.LocationAdapter;

import java.util.List;


public class LocationFragment extends Fragment {
    private FragmentLocationBinding binding;
    private LocationViewModel locationViewModel;
    private LocationAdapter locationAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationAdapter = new LocationAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        locationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        binding = FragmentLocationBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.rvLocation.setAdapter(locationAdapter);
        locationViewModel.init();
        locationViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), list ->
                locationAdapter.setList(list));
    }
}