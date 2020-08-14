package com.example.filminfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.filminfo.data.GhibliService;
import com.example.filminfo.model.Film;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmInfoFragment extends Fragment implements GhibliService.GhibliCallback {

    private TextView filmName, filmRelease, filmDesc, filmDirector, filmProducer, filmScore;

    public FilmInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String id = bundle.getString("id");
            App.ghibliService.getFilmById(id, this);
        }
        return inflater.inflate(R.layout.fragment_film_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmName = view.findViewById(R.id.tw_film);
        filmRelease = view.findViewById(R.id.tw_release);
        filmDesc = view.findViewById(R.id.tw_desc);
        filmDirector = view.findViewById(R.id.tw_director);
        filmProducer = view.findViewById(R.id.tw_producer);
        filmScore = view.findViewById(R.id.tw_score);
    }

    @Override
    public void onSuccessFilmList(List<Film> films) {

    }

    @Override
    public void onSuccessFilmId(Film film) {
        filmName.setText(film.getTitle());
        filmRelease.setText(film.getReleaseDate());
        filmDesc.setText(film.getDescription());
        filmDirector.setText(film.getDirector());
        filmProducer.setText(film.getProducer());
        filmScore.setText(film.getRtScore());
    }

    @Override
    public void onFailure(Exception exception) {

    }
}
