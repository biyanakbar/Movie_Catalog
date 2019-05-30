package com.example.moviecatalogsubs2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {
    private ArrayList<Movie> listMovie;
    Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemRow = LayoutInflater.from(context).inflate(R.layout.item_movies, viewGroup, false);
        final CategoryViewHolder holderMovie = new CategoryViewHolder(itemRow);

        holderMovie.itemMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailMovieActivity.class);
                v.getContext().startActivities(intent);
//                Toast.makeText(context, "" + getListMovie().get(i).getTitleMovie(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, "" + getListMovie().get(holderMovie.getAdapterPosition()).getTitleMovie(), Toast.LENGTH_SHORT).show();
            }

        });

        return holderMovie;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitleMovie.setText(getListMovie().get(i).getTitleMovie());
        categoryViewHolder.tvDescMovie.setText(getListMovie().get(i).getDescMovie());
        categoryViewHolder.posterMovie.setImageResource(getListMovie().get(i).getPosterMovie());
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleMovie;
        TextView tvDescMovie;
        CircleImageView posterMovie;
        ConstraintLayout itemMovie;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvTitleMovie = itemView.findViewById(R.id.title_item_movie);
            tvDescMovie = itemView.findViewById(R.id.desc_item_movie);
            posterMovie = itemView.findViewById(R.id.poster_item_movie);
            itemMovie = itemView.findViewById(R.id.block_item_movie);
        }
    }

}
