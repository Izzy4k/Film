package com.example.films.ui.fragment.location.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.films.databinding.ItemLocationBinding;
import com.example.films.domain.model.location.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private ItemLocationBinding binding;
    private List<Location> list = new ArrayList<>();

    public void setList(List<Location> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new LocationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {
        ItemLocationBinding binding;
        public LocationViewHolder(@NonNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String name) {
            binding.txtNameItem.setText(name);
        }
    }
}
