package com.example.cheryflix;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Slide> lstSlides;

    private ViewPager sliderPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderPager = findViewById(R.id.slider_pager);


        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slidemononoke, "Princess Mononoke"));
        lstSlides.add(new Slide(R.drawable.slideporko, "Porko Rosso"));
        lstSlides.add(new Slide(R.drawable.slidedtenet, "Tenet"));
        lstSlides.add(new Slide(R.drawable.slideavengers, "Avengers: Final"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderPager.setAdapter(adapter);

    }
}