package com.example.moviecatalogsubs2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private String[] arrayTitle;
    private String[] arrayDesc;
    private TypedArray posterTvShow;
    private TvShowsAdapter tvShowAdapter;
    private ArrayList<TvShows> listTvShow;

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_tv_show);
        recyclerView.setHasFixedSize(true);

        tvShowAdapter = new TvShowsAdapter(getContext());
        recyclerView.setAdapter(tvShowAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        prepare();
        addItem();

        return view;
    }

    private void addItem() {
        listTvShow = new ArrayList<>();

        for (int i = 0; i < arrayTitle.length; i++) {
            TvShows tvShows = new TvShows();
            tvShows.setTitleTvShow(arrayTitle[i]);
            tvShows.setDescTvShow(arrayDesc[i]);
            tvShows.setPosterTvShow(posterTvShow.getResourceId(i, -1));
            listTvShow.add(tvShows);
        }
        tvShowAdapter.setListTvShow(listTvShow);
    }

    private void prepare() {
        arrayTitle = getResources().getStringArray(R.array.title_array_tv_shows);
        arrayDesc = getResources().getStringArray(R.array.desc_tv_show_array);
        posterTvShow = getResources().obtainTypedArray(R.array.poster_tv_shows_array);
    }

}
