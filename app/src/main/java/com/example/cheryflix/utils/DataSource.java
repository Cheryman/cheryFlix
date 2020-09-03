package com.example.cheryflix.utils;

import com.example.cheryflix.Models.Cast;
import com.example.cheryflix.Models.Movie;
import com.example.cheryflix.Models.Slide;
import com.example.cheryflix.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Slide> getSlides(){

        List<Slide> lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slideavengers, "Avengers: Final"));
        lstSlides.add(new Slide(R.drawable.slidemononoke, "Princess Mononoke"));
        lstSlides.add(new Slide(R.drawable.slideporko, "Porko Rosso"));
        lstSlides.add(new Slide(R.drawable.slidedtenet, "Tenet"));

        return lstSlides;
    }

    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Arch of Triumph", R.drawable.moviearch, R.drawable.john));
        lstMovie.add(new Movie("Up", R.drawable.movieup, R.drawable.john));
        lstMovie.add(new Movie("Shawshank Redemption", R.drawable.movieshawshank, R.drawable.john));
        lstMovie.add(new Movie("Yesman", R.drawable.movieyesman, R.drawable.john));

        return lstMovie;
    }

    public static List<Movie> getWeekMovies(){

        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Yesman", R.drawable.movieyesman, R.drawable.john));
        lstMovie.add(new Movie("Shawshank Redemption", R.drawable.movieshawshank, R.drawable.john));
        lstMovie.add(new Movie("Up", R.drawable.movieup, R.drawable.john));
        lstMovie.add(new Movie("Arch of Triumph", R.drawable.moviearch, R.drawable.john));

        return lstMovie;
    }

    public static List<Cast> getCast(){

        List<Cast> lstCast = new ArrayList<>();
        lstCast.add(new Cast("Keanu Reeves", R.drawable.keanu));
        lstCast.add(new Cast("Halle Berry", R.drawable.halle));
        lstCast.add(new Cast("Ian McShane", R.drawable.ian));
        lstCast.add(new Cast("Laurence Fishburne", R.drawable.laurence));
        lstCast.add(new Cast("Asia Kate Dillon", R.drawable.asia));
        lstCast.add(new Cast("Mark Dacascos", R.drawable.mark));
        lstCast.add(new Cast("Lance Reddick", R.drawable.lance));

        return lstCast;
    }
}
