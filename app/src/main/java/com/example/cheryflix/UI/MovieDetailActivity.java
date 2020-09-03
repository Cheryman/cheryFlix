package com.example.cheryflix.UI;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cheryflix.Adapters.CastAdapter;
import com.example.cheryflix.Models.Cast;
import com.example.cheryflix.R;
import com.example.cheryflix.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieThumbnailImg, movieCoverImg;
    private TextView tv_title, movieDescription;
    private FloatingActionButton play_fab;
    private RecyclerView rvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        iniViews();

        setupRvCast();
    }

    void setupRvCast() {

        castAdapter = new CastAdapter(this, DataSource.getCast());
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    void iniViews() {

        String movieTitle = getIntent().getExtras().getString("title"); // получаем Extras
        int imageResourceId = getIntent().getExtras().getInt("imgUrl"); // получаем Extras
        int coverResourceId = getIntent().getExtras().getInt("imgCover"); // получаем Extras

        play_fab = findViewById(R.id.fab_play);
        rvCast = findViewById(R.id.rv_cast);

        movieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(movieThumbnailImg);
        movieThumbnailImg.setImageResource(imageResourceId);

        movieCoverImg = findViewById(R.id.detail_movie_cover_img);
        Glide.with(this).load(coverResourceId).into(movieCoverImg);
        movieCoverImg.setImageResource(coverResourceId);

        tv_title = findViewById(R.id.detail_movie_title);
        movieDescription = findViewById(R.id.detail_movie_description);
        tv_title.setText(movieTitle);

        getSupportActionBar().setTitle(movieTitle);

        // анимация для кнопки и бекгрунда
        movieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));

    }
}