package com.example.cheryflix.UI;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cheryflix.Models.Movie;
import com.example.cheryflix.Adapters.MovieAdapter;
import com.example.cheryflix.Adapters.MovieItemClickListener;
import com.example.cheryflix.R;
import com.example.cheryflix.Models.Slide;
import com.example.cheryflix.Adapters.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    List<Slide> lstSlides;
    List<Movie> lstMovie;

    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rvMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        rvMovie = findViewById(R.id.rv_movies);

        // данные для слайдера
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slidemononoke, "Princess Mononoke"));
        lstSlides.add(new Slide(R.drawable.slideporko, "Porko Rosso"));
        lstSlides.add(new Slide(R.drawable.slidedtenet, "Tenet"));
        lstSlides.add(new Slide(R.drawable.slideavengers, "Avengers: Final"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderPager.setAdapter(adapter);

        //настройка таймера для слайдера
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderPager, true);


        //Настройка RecyclerView Movies и данных для него
        lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Arch of Triumph", R.drawable.moviearch, R.drawable.john));
        lstMovie.add(new Movie("Up", R.drawable.movieup, R.drawable.john));
        lstMovie.add(new Movie("Shawshank Redemption", R.drawable.movieshawshank, R.drawable.john));
        lstMovie.add(new Movie("Yesman", R.drawable.movieyesman, R.drawable.john));

        MovieAdapter movieAdapter = new MovieAdapter(this, lstMovie, this);
        rvMovie.setAdapter(movieAdapter);
        rvMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //передаем информацию на Detail активити
        //+ используем анимацию перехода (окно открывается вверх), вместо перехода слайдом

        Intent detailActivityIntent = new Intent(this, MovieDetailActivity.class);
        detailActivityIntent.putExtra("title", movie.getTitle());
        detailActivityIntent.putExtra("imgUrl", movie.getThumbnail());
        detailActivityIntent.putExtra("imgCover", movie.getCoverImg());

        //Toast.makeText(this, "click performed", Toast.LENGTH_SHORT).show();

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                MainActivity.this, movieImageView, "sharedName");

        startActivity(detailActivityIntent, options.toBundle());
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}