package com.example.cheryflix;

import android.widget.ImageView;

public interface MovieItemClickListener {


    // при клике на любой фильм в приложении, мы вызываем этот интерфейс с этом методом
    void onMovieClick(Movie movie, ImageView movieImageView);
}
