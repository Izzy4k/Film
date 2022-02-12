package com.example.films.ui.fragment.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.films.databinding.ItemFilmBinding;
import com.example.films.domain.model.film.Film;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private ItemFilmBinding binding;
    private List<Film> list = new ArrayList<>();
    private Click click;

    public HomeAdapter(Click click) {
        this.click = click;
    }

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent, false);
        return new HomeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position).getTitle() , list.get(position).getMovieBanner());
        holder.itemView.setOnClickListener(view -> {
            click.click(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ItemFilmBinding binding;

        public HomeViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(String title , String banner) {
            binding.txtTitleItem.setText(title);
            Glide.with(binding.imageItem).load(banner).into(binding.imageItem);
        }
    }
    public interface Click{
        void click(Film film);
    }
}
