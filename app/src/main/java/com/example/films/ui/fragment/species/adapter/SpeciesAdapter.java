package com.example.films.ui.fragment.species.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.films.databinding.ItemSpeciesBinding;
import com.example.films.domain.model.species.Species;

import java.util.ArrayList;
import java.util.List;

public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder> {
    private ItemSpeciesBinding binding;
    private List<Species> list = new ArrayList<>();


    public  void setList(List<Species> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SpeciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemSpeciesBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new SpeciesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder holder, int position) {
        holder.onBind(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SpeciesViewHolder extends  RecyclerView.ViewHolder{
        ItemSpeciesBinding binding;
        public SpeciesViewHolder(@NonNull ItemSpeciesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String name) {
            binding.txtItemName.setText(name);
        }
    }
}
