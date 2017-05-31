package com.gmail.nf.project.jddca.film20.ui.utils.adapter;


import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.model.Genre;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Setter;

public class GenreAdapter extends RecyclerView.Adapter <GenreAdapter.ViewHolder>{

    @Setter
    List <Genre> genres;


    public GenreAdapter() {
        genres = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.item_genre, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.genreTextView.setText(genres.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.genreTextView) TextView genreTextView;
        @BindView(R.id.genreChoose) AppCompatCheckBox appCompatCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
