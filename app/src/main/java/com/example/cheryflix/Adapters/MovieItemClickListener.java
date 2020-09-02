package com.example.cheryflix.Adapters;

import android.widget.ImageView;

import com.example.cheryflix.Models.Movie;

public interface MovieItemClickListener {

    // при клике на любой фильм в приложении, мы вызываем этот интерфейс
    void onMovieClick(Movie movie, ImageView movieImageView);
}
