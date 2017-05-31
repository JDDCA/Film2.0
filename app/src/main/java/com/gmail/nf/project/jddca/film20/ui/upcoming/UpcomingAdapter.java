package com.gmail.nf.project.jddca.film20.ui.upcoming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Setter;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    @Setter
    private List<Film> films;

    @Inject
    public UpcomingAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film = films.get(position);

        Picasso.with(holder.context)
                .load(film.getPosterPath())
                .resize(holder.poster.getMeasuredWidth(), holder.poster.getMeasuredHeight())
                .centerCrop()
                .into(holder.poster);

        holder.title.setText(film.getTitle());

        if (film.getOverview() == null && film.getOverview().length() < 0) {
            holder.description.setText(holder.defaultDescruptionFilm);
        } else {
            holder.description.setText(film.getOverview());
        }

        holder.releaseDate.setText(film.getReleaseDate());
        holder.voteAverage.setText(String.valueOf(film.getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        Context context;

        @BindString(R.string.defuultDescriptionFilm)
        String defaultDescruptionFilm;

        @BindView(R.id.upc_title)
        TextView title;

        @BindView(R.id.upc_description)
        TextView description;

        @BindView(R.id.upc_vote_average)
        TextView voteAverage;

        @BindView(R.id.upc_poster)
        ImageView poster;

        @BindView(R.id.upc_release_date)
        TextView releaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
