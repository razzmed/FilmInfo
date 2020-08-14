package com.example.filminfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.filminfo.data.GhibliService;
import com.example.filminfo.model.Film;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GhibliService.GhibliCallback {

    private RecyclerView recyclerView;
    private AdapterFilm adapterFilm;
    private List<Film> filmList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.ghibliService.getListFilms(this);

        recyclerView = findViewById(R.id.rw_film_name);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onSuccessFilmId(Film film) {

    }

    @Override
    public void onSuccessFilmList(List<Film> films) {
        filmList = films;
        adapterFilm = new AdapterFilm(filmList);
        recyclerView.setAdapter(adapterFilm);
        adapterFilm.setOnItemClickListener(new OnItemFilmClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("ololo", "onItemClick");
                Bundle bundle = new Bundle();
                bundle.putString("id", filmList.get(position).getId());
                FilmInfoFragment filmInfoFragment = new FilmInfoFragment();
                filmInfoFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fr_film_info, filmInfoFragment).addToBackStack(null).commit();
            }
        });
        adapterFilm.notifyDataSetChanged();
    }


    @Override
    public void onFailure(Exception exception) {

    }
}
