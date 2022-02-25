package com.turorials.onetimeactivity.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.VideoView;
import com.turorials.onetimeactivity.model.ChildLessonModel;

import java.util.List;


public class MyAdapterNewFeedsNested extends RecyclerView.Adapter<MyAdapterNewFeedsNested.MyViewHolderNewFeedNested> {

    Context context;
    Activity activity;
    List<ChildLessonModel> childLessonModelList;

    public MyAdapterNewFeedsNested(Context context, Activity activity, List<ChildLessonModel> childLessonModelList) {
        this.context = context;

        this.activity = activity;
        this.childLessonModelList = childLessonModelList;
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


        Log.d("Size", ""+childLessonModelList.size());
   ChildLessonModel childLessonModel = childLessonModelList.get(position);
//
//
           Glide
                   .with(activity)
                   .load(childLessonModel.getImage_url())
                   .centerCrop()
                   .placeholder(R.drawable.background)
                   .into(holder.imageView);

           holder.imageView.setOnClickListener(v -> {
               Intent intent = new Intent(context, VideoView.class);
               intent.putExtra("video_url",childLessonModel.getVideo_url());
               context.startActivity(intent);
           });



    }

    @Override
    public int getItemCount() {
        return childLessonModelList.size();

//        return  childLessonModelList.size() ;
    }

    class MyViewHolderNewFeedNested extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolderNewFeedNested(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_nestedNewfeed);

        }
    }
}
