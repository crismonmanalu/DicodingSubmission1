package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataGenre;
    private String[] dataDetail;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<MovieModel> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(i));
                startActivity(intent);
            }
        });
    }
    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0;i< dataName.length; i++){
            MovieModel movie = new MovieModel();
            movie.setPhoto((dataPhoto.getResourceId(i, -1)));
            movie.setName(dataName[i]);
            movie.setGenre(dataGenre[i]);
            movie.setDetail(dataDetail[i]);
            movies.add(movie);
        }
        adapter.setMovie(movies);
    }

    private  void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataGenre = getResources().getStringArray(R.array.genre);
        dataPhoto = getResources().obtainTypedArray(R.array.photo);
        dataDetail = getResources().getStringArray(R.array.detail);
    }
}
