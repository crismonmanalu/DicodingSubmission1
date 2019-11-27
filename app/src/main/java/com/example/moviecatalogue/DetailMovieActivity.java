package com.example.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {
    public static String EXTRA_MOVIE = "extra_movie";
    private MovieModel movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        movieModel = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (movieModel == null) return;

        ImageView poster = findViewById(R.id.img_photo);
        TextView judul = findViewById(R.id.movie_name);
        TextView detail = findViewById(R.id.movie_detail);

        poster.setImageResource(movieModel.getPhoto());
        judul.setText(movieModel.getName());
        detail.setText(movieModel.getDetail());
    }
}
