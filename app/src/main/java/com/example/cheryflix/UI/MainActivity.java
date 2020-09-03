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
import com.example.cheryflix.utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {


    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rvMovie, rvWeekMovie;

    private SliderPagerAdapter sliderAdapter;
    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();

        setupSlider();

        setupRvMovie();

        setupRvWeekMovie();
    }

    private void setupRvWeekMovie() {

        movieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(),this);
        rvWeekMovie.setAdapter(movieAdapter);
        rvWeekMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniViews() {
        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        rvMovie = findViewById(R.id.rv_movies);
        rvWeekMovie = findViewById(R.id.rv_movies_week);
    }

    private void setupSlider() {

        sliderAdapter = new SliderPagerAdapter(this, DataSource.getSlides());
        sliderPager.setAdapter(sliderAdapter);

        //настройка таймера для слайдера
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderPager, true);
    }

    private void setupRvMovie() {
        //Настройка RecyclerView Movies и инициализация данных для него из DataSource

        movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
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
                    if (sliderPager.getCurrentItem() < DataSource.getSlides().size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}