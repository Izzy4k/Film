package com.example.films.ui.fragment.people.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.films.databinding.ItemPeopleBinding;
import com.example.films.domain.model.people.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private ItemPeopleBinding binding;
    private List<People> list = new ArrayList<>();


    public void setList(List<People> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new PeopleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.onBind(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
        ItemPeopleBinding binding;
        public PeopleViewHolder(@NonNull ItemPeopleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String name) {
            binding.txtNameItem.setText(name);
        }
    }
}
