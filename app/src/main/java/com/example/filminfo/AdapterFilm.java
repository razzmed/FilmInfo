package com.example.filminfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filminfo.model.Film;

import java.util.List;

public class AdapterFilm extends RecyclerView.Adapter <AdapterFilm.ViewHolder> {

    private OnItemFilmClickListener onItemClickListener;

    private List<Film> list;
    public AdapterFilm(List<Film> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film_name, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemFilmClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textFilmName;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));
                    textFilmName = itemView.findViewById(R.id.tw_film_name);
                }

        private void bind(Film film) {
            textFilmName.setText(film.getTitle());
        }
    }
}
