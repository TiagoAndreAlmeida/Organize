package com.example.organize.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.organize.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        addSlide(new FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.slide1)
            .canGoBackward(false)
            .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide2)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide3)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide4)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide_intro)
                .canGoForward(false)
                .build());
    }
}