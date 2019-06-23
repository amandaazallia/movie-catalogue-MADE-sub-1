package com.amandaazallia.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] dataTitle, dataOverview, dataGenres, dataRuntime, dataLanguage,
                    dataStatus, dataUserScore, dataYear;
    private TypedArray dataPoster;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(MainActivity.this, MovieDetailActivity.class);

                ArrayList<Movies> movies = new ArrayList<Movies>();

                Movies movie = new Movies();
                movie.setPoster(dataPoster.getResourceId(i, -1));
                movie.setTitle(dataTitle[i]);
                movie.setOverview(dataOverview[i]);
                movie.setGenres(dataGenres[i]);
                movie.setStatus(dataStatus[i]);
                movie.setRuntime(dataRuntime[i]);
                movie.setUser_score(dataUserScore[i]);
                movie.setOriginal_language(dataLanguage[i]);
                movie.setYear(dataYear[i]);

                movies.add(movie);

                moveWithObject.putParcelableArrayListExtra(MovieDetailActivity.EXTRA_MOVIE, movies);
                startActivity(moveWithObject);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //
    }

    private void addItem() {

        ArrayList<Movies> movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movies movie = new Movies();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setGenres(dataGenres[i]);
            movie.setStatus(dataStatus[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setUser_score(dataUserScore[i]);
            movie.setOriginal_language(dataLanguage[i]);
            movie.setYear(dataYear[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataGenres = getResources().getStringArray(R.array.data_genres);
        dataStatus = getResources().getStringArray(R.array.data_status);
        dataUserScore = getResources().getStringArray(R.array.data_userScore);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataYear = getResources().getStringArray(R.array.data_year);
    }

}
