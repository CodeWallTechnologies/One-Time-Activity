package com.turorials.onetimeactivity.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.ExoPlayer;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.ImageModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import java.util.ArrayList;
import java.util.List;


public class MyAdapterNewFeedsNested extends RecyclerView.Adapter<MyAdapterNewFeedsNested.MyViewHolderNewFeedNested> {

    Context context;
    ArrayList<NewFeedModel> newFeedModels;
    Activity activity;
    List<ImageModel> imageModelList;

    public MyAdapterNewFeedsNested(Context context, ArrayList<NewFeedModel> newFeedModels, Activity activity, List<ImageModel> imageModelList) {
        this.context = context;
        this.newFeedModels = newFeedModels;
        this.activity = activity;
        this.imageModelList = imageModelList;
    }

    @NonNull
    @Override
    public MyViewHolderNewFeedNested onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context3 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context3);
        View view = layoutInflater.inflate(R.layout.nested_new_feed,parent,false);
        MyViewHolderNewFeedNested myViewHolderNewFeedNested = new MyViewHolderNewFeedNested(view);


        return myViewHolderNewFeedNested;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderNewFeedNested holder, int position) {

   ImageModel imageModel = imageModelList.get(position);


           Glide
                   .with(activity)
                   .load(imageModel.getImgResource())
                   .centerCrop()
                   .placeholder(R.drawable.background)
                   .into(holder.imageView);

           holder.imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context, ExoPlayer.class);
                   context.startActivity(intent);
               }
           });



    }

    @Override
    public int getItemCount() {

        return  imageModelList.size() ;
    }

    class MyViewHolderNewFeedNested extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolderNewFeedNested(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_nestedNewfeed);

        }
    }
}
