package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.turorials.onetimeactivity.adapters.MyAdapterViewPager;
import com.turorials.onetimeactivity.model.Images;
import com.turorials.onetimeactivity.model.ShortCutModel;

import java.util.ArrayList;

public class ShortCutImagesActivity extends AppCompatActivity {

    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.html1, R.drawable.html2, R.drawable.html3, R.drawable.html4,
            R.drawable.html5, R.drawable.html6, R.drawable.html7, R.drawable.html8};


    ArrayList<Images> arrayList = new ArrayList<>();


    // Creating Object of ViewPagerAdapter
    MyAdapterViewPager mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut_images);



        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.view_pager);


        int photos[] = getIntent().getIntArrayExtra("image");

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new MyAdapterViewPager(ShortCutImagesActivity.this, photos);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);


    }
}