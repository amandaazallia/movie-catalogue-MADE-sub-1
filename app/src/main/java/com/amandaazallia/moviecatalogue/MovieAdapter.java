package com.amandaazallia.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movies> movies;

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movies movie = (Movies) getItem(i);
        viewHolder.bind(movie);
        return view;

    }

    private class ViewHolder {
        private TextView txtTitle, txtOverview, txtRuntime, txtDateTime, txtUserScore;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtOverview = view.findViewById(R.id.txt_overview);
            imgPoster = view.findViewById(R.id.img_poster);
            txtRuntime = view.findViewById(R.id.runtime);
            txtDateTime = view.findViewById(R.id.date_released);
            txtUserScore = view.findViewById(R.id.user_score);
        }

        void bind(Movies movie) {
            txtTitle.setText(movie.getTitle());
            txtOverview.setText(movie.getOverview());
            imgPoster.setImageResource(movie.getPoster());
            txtRuntime.setText(movie.getRuntime());
            txtDateTime.setText(movie.getYear());
            txtUserScore.setText(movie.getUser_score());
        }
    }
}
