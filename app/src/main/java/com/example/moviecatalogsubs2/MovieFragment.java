package com.example.moviecatalogsubs2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private String[] arrayTitle;
    private String[] arrayDesc;
    private TypedArray posterMovie;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> listMovie;


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);

        movieAdapter = new MovieAdapter(getContext());
        recyclerView.setAdapter(movieAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        prepare();
        addItem();

        return view;
    }

    private void addItem() {
        listMovie = new ArrayList<>();

        for (int i = 0; i < arrayTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitleMovie(arrayTitle[i]);
            movie.setDescMovie(arrayDesc[i]);
            movie.setPosterMovie(posterMovie.getResourceId(i, -1));
            listMovie.add(movie);
        }
        movieAdapter.setListMovie(listMovie);
    }

    private void prepare() {
        arrayTitle = getResources().getStringArray(R.array.title_array_movies);
        arrayDesc = getResources().getStringArray(R.array.desc_movies_array);
        posterMovie = getResources().obtainTypedArray(R.array.poster_movie_array);
    }
}
