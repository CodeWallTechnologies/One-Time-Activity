package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.ChildImagesModel;
import com.turorials.onetimeactivity.model.Images;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyAdapterViewPager extends PagerAdapter {


    // Context object
    Context context;

    // Array of images
   String images[];
   List<ChildImagesModel> list;

    // Layout Inflater
    LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public MyAdapterViewPager(Context context, String[] images,List<ChildImagesModel> list) {
        this.context = context;
        this.images = images;
        this.list = list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.viewpager_item, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);


        Glide
                .with(itemView.getContext())
                .load(list.get(position).getImage())
                .placeholder(R.drawable.background)
                .into(imageView);

//        Picasso.get()
//                .load(images[0])
//                .placeholder(R.drawable.background)
//                .error(R.drawable.youtube)
//                .into(imageView);

        Log.d("Current", ""+list.get(position).getImage());
        Log.d("Current", "instantiateItem: "+images.getClass());
        Log.d("Current", "instantiateItem: "+ images[position]);

        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ConstraintLayout) object);
    }
}
