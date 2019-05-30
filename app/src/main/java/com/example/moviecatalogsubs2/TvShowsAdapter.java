package com.example.moviecatalogsubs2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.CategoryViewHolder> {
    Context context;
    private ArrayList<TvShows> listTvShow;

    public TvShowsAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShows> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShows> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);

        final CategoryViewHolder holderTv = new CategoryViewHolder(itemRow);

        holderTv.itemTvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, getListTvShow().get(holderTv.getAdapterPosition()).getTitleTvShow(), Toast.LENGTH_SHORT).show();
            }
        });

        return holderTv;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitleTvShow.setText(getListTvShow().get(i).getTitleTvShow());
        categoryViewHolder.tvDescTvShow.setText(getListTvShow().get(i).getDescTvShow());
        categoryViewHolder.posterTvShow.setImageResource(getListTvShow().get(i).getPosterTvShow());
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleTvShow;
        TextView tvDescTvShow;
        CircleImageView posterTvShow;
        ConstraintLayout itemTvShow;

        CategoryViewHolder(View view) {
            super(view);
            tvTitleTvShow = view.findViewById(R.id.title_item_tv_show);
            tvDescTvShow = view.findViewById(R.id.desc_item_tv_show);
            posterTvShow = view.findViewById(R.id.poster_item_tv_show);
            itemTvShow = view.findViewById(R.id.block_item_tv_show);
        }

    }
}
