package com.example.moviecatalogue;

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
    private ArrayList<MovieModel> movie;

    public void setMovie(ArrayList<MovieModel> movie){
        this.movie = movie;
    }

    public MovieAdapter(Context context){
        this.context = context;
        movie = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movie.size();
    }

    @Override
    public Object getItem(int i) {
        return movie.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_movie,viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieModel movieModel = (MovieModel) getItem(i);
        viewHolder.bind(movieModel);
        return view;
    }

    private class ViewHolder {
        private TextView name;
        private TextView genre;
        private TextView detail;
        private ImageView imgPhoto;

        ViewHolder(View view){
            name = view.findViewById(R.id.movie_name);
            genre = view.findViewById(R.id.movie_genre);
            detail = view.findViewById(R.id.movie_detail);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(MovieModel model){
            name.setText(model.getName());
            genre.setText(model.getGenre());
            imgPhoto.setImageResource(model.getPhoto());
        }
    }
}
