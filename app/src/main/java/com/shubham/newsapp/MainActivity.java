package com.shubham.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.widget.GridView;

import com.bumptech.glide.request.RequestOptions;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.DefaultSliderView;
import com.google.android.material.slider.Slider;
import com.shubham.newsapp.adapter.GridCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SliderLayout sliderLayout;
    GridView gridView;

    GridCategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitiateViews();
        AddImagesToSlider();

    }

    private void AddImagesToSlider() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.img1);
        images.add(R.drawable.img2);
        images.add(R.drawable.img3);
        images.add(R.drawable.img4);

        for(int i=0; i<images.size();i++){

            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            defaultSliderView.setRequestOption(new RequestOptions().centerCrop());
            defaultSliderView.image(images.get(i));
            defaultSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                }
            });

            sliderLayout.addSlider(defaultSliderView);

        }
        // Setting the slider options

            sliderLayout.startAutoCycle();
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Stack);
            sliderLayout.setDuration(2000);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

    }

    private void InitiateViews() {
        sliderLayout = findViewById(R.id.slider);
        gridView = findViewById(R.id.grid_view);
        adapter = new GridCategoryAdapter(this);
        gridView.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sliderLayout.stopAutoCycle();
    }
}