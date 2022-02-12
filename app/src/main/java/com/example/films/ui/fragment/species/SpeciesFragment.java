package com.example.films.ui.fragment.species;

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
import com.example.films.databinding.FragmentSpeciesBinding;
import com.example.films.domain.model.species.Species;
import com.example.films.ui.fragment.species.adapter.SpeciesAdapter;

import java.util.List;


public class SpeciesFragment extends Fragment {
private FragmentSpeciesBinding binding;
private SpeciesAdapter speciesAdapter;
private SpeciesViewModel speciesViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speciesAdapter = new SpeciesAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        speciesViewModel = new ViewModelProvider(this).get(SpeciesViewModel.class);
        binding = FragmentSpeciesBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.rvSpecies.setAdapter(speciesAdapter);
        speciesViewModel.init();
        speciesViewModel.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Species>>() {
            @Override
            public void onChanged(List<Species> list) {
                speciesAdapter.setList(list);
            }
        });
    }
}