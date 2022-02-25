package com.turorials.onetimeactivity;

import static com.google.firebase.firestore.core.UserData.Source.Set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.google.gson.Gson;
import com.turorials.onetimeactivity.adapters.MyAdapterViewPager;
import com.turorials.onetimeactivity.model.ChildImagesModel;
import com.turorials.onetimeactivity.model.Images;
import com.turorials.onetimeactivity.model.ShortCutModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortCutImagesActivity extends AppCompatActivity {

    ViewPager mViewPager;



    // images array
    int[] image = {R.drawable.html1, R.drawable.html2, R.drawable.html3, R.drawable.html4,
            R.drawable.html5, R.drawable.html6, R.drawable.html7, R.drawable.html8};


List<ChildImagesModel> list;
    String imageLinks[];

    // Creating Object of ViewPagerAdapter
    MyAdapterViewPager mViewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut_images);
        getSupportActionBar().hide();

        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        String arrayAsString = getIntent().getExtras().getString("images");
         list = Arrays.asList(new Gson().fromJson(arrayAsString, ChildImagesModel[].class));

         for(int i = 0; i<list.size();i++){
             imageLinks = new String[list.size()];
             imageLinks[i] = list.get(i).getImage();
             Log.d("Images", "onCreate: "+i);
             Log.d("Images", "onCreate: "+imageLinks[i]);
         }

        Log.d("Images", "onCreate: "+list.get(0));

//        ChildImagesModel customerObjInToClass = getIntent().getExtras().getParcelable("myCustomerObj");


//        String photos[] = getIntent().getIntArrayExtra("images");

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new MyAdapterViewPager(ShortCutImagesActivity.this, imageLinks , list);

//        SharedPreferences sharedPreferences = getSharedPreferences("images",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);


    }
}