package com.example.films.ui.fragment.home;

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

import com.example.films.R;
import com.example.films.databinding.FragmentHomeBinding;
import com.example.films.domain.model.film.Film;
import com.example.films.domain.model.film.FilmsStorage;
import com.example.films.ui.fragment.home.adapter.HomeAdapter;

import java.util.List;


public class HomeFragment extends Fragment implements HomeAdapter.Click {
    private FragmentHomeBinding binding;
    private HomeAdapter homeAdapter;
    private NavController controller;
    private HomeViewModel homeViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeAdapter = new HomeAdapter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        homeViewModel.init();
        initListener();
    }

    private void initListener() {
        binding.rvHome.setAdapter(homeAdapter);
        if (homeViewModel.getListMutableLiveData() != null) {
            homeViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Film>>() {
                @Override
                public void onChanged(List<Film> list) {
                    homeAdapter.setList(list);
                }
            });
        }
    }

    @Override
    public void click(Film film) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", film);
        controller.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
    }
}