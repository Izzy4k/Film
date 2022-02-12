package com.example.films.ui.fragment.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.films.R;
import com.example.films.databinding.FragmentDetailBinding;
import com.example.films.domain.model.film.Film;


public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private DetailViewModel detailViewModel;
    private NavController controller;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        initListener();
        initBtn();
    }

    private void initBtn() {
        binding.btnPeople.setOnClickListener(view -> {
            controller.navigate(R.id.action_detailFragment_to_peopleFragment);
        });
        binding.btnSpecies.setOnClickListener(view -> {
            controller.navigate(R.id.action_detailFragment_to_speciesFragment);
        });
        binding.btnLocation.setOnClickListener(v->{
            controller.navigate(R.id.action_detailFragment_to_locationFragment);
        });
    }

    private void initListener() {
        if (getArguments() != null) {
            Film film = (Film) getArguments().getSerializable("model");
            detailViewModel.init(film.getId());
            if(detailViewModel.getFilmMutableLiveData() != null){
                detailViewModel.getFilmMutableLiveData().observe(getViewLifecycleOwner(),
                        this::iniView);
            }
        }
    }

    private void iniView(Film film1) {
        Glide.with(binding.imageMain).load(film1.getImage()).into(binding.imageMain);
        binding.txtTitle.setText(film1.getTitle());
        binding.txtTitleOriginal.setText(film1.getOriginalTitle());
        binding.txtTitleOriginalRomanised.setText(film1.getOriginalTitleRomanised());
        binding.txtDescription.setText(film1.getDescription());
    }
}