package com.gmail.nf.project.jddca.film20.ui.upcoming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.data.domain.Film;
import com.gmail.nf.project.jddca.film20.model.utils.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import butterknife.BindString;
import butterknife.BindView;

import butterknife.ButterKnife;
import lombok.Setter;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder> {

    @Setter
    private List<Film> films;
    private Context context;

    public UpcomingAdapter(Context context) {
        films = new ArrayList<>();
        this.context = context;
    }

    @Override
    public UpcomingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_upcoming, parent, false);
        return new UpcomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UpcomingViewHolder holder, int position) {
        Film film = films.get(position);

        if (film.getPosterPath() != null) {
            Picasso.with(context)
                    .load(ApiService.IMG_URL + film.getPosterPath())
                    .resize(holder.poster.getMeasuredWidth(), holder.poster.getMeasuredHeight())
                    .centerCrop()
                    .into(holder.poster);
        } else {
            holder.poster.setImageResource(R.drawable.img_not_available);
        }

        holder.title.setText(film.getTitle());

        if ((film.getOverview() == null) || (film.getOverview().length() <= 0)) {
            holder.description.setText(holder.defaultDescriptionFilm);
        } else {
            holder.description.setText(film.getOverview());
        }

        holder.releaseDate.setText(R.string.release_date + film.getReleaseDate());
        holder.voteAverage.setText(String.valueOf(film.getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }


    class UpcomingViewHolder extends RecyclerView.ViewHolder {

        @BindString(R.string.defuultDescriptionFilm)
        @Nullable
        String defaultDescriptionFilm;

        @BindView(R.id.upc_title)
        @Nullable
        public TextView title;

        @BindView(R.id.upc_description)
        @Nullable
        TextView description;

        @BindView(R.id.upc_vote_average)
        @Nullable
        TextView voteAverage;

        @BindView(R.id.upc_poster)
        @Nullable
        ImageView poster;

        @BindView(R.id.upc_release_date)
        @Nullable
        TextView releaseDate;

        UpcomingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
