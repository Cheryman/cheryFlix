package com.example.cheryflix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieThumbnailImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // получаем Extras данные

        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgUrl");

        movieThumbnailImg = findViewById(R.id.detail_movie_img);
        movieThumbnailImg.setImageResource(imageResourceId);


    }
}