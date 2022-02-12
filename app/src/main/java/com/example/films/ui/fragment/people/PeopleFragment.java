package com.example.films.ui.fragment.people;

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
import com.example.films.databinding.FragmentPeopleBinding;
import com.example.films.domain.model.people.People;
import com.example.films.ui.fragment.people.adapter.PeopleAdapter;

import java.util.List;


public class PeopleFragment extends Fragment {
    private FragmentPeopleBinding binding;
    private PeopleViewModel peopleViewModel;
    private PeopleAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PeopleAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        peopleViewModel = new ViewModelProvider(this).get(PeopleViewModel.class);
        binding = FragmentPeopleBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.rvPeople.setAdapter(adapter);
        peopleViewModel.init();
        peopleViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), list -> {
            adapter.setList(list);
        });
    }
}