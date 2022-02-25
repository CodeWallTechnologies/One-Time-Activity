package com.turorials.onetimeactivity.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.ChildLessonModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import java.util.ArrayList;
import java.util.List;


public class MyAdapterNewFeeds extends RecyclerView.Adapter<MyAdapterNewFeeds.MyViewHolderNewFeed> {

    Context context;
    MyAdapterNewFeedsNested myAdapterNewFeedsNested;
    List<NewFeedModel> newFeedModels;
    Activity activity;

    NewFeedModel obj;






    public MyAdapterNewFeeds(Context context, List<NewFeedModel> newFeedModels, Activity activity) {
        this.context = context;
        this.newFeedModels = newFeedModels;
        this.activity = activity;

    }

    @NonNull
    @Override
    public MyViewHolderNewFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context3 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context3);
        View view = layoutInflater.inflate(R.layout.new_feed_item,parent,false);
        MyViewHolderNewFeed myViewHolderNewFeed = new MyViewHolderNewFeed(view);


        return myViewHolderNewFeed;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderNewFeed holder, int position) {

        obj = newFeedModels.get(position);
        holder.textView.setText(obj.getName());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, true);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        myAdapterNewFeedsNested = new MyAdapterNewFeedsNested(context,activity,newFeedModels.get(position).getList());
 //       myAdapterNewFeedsNested = new MyAdapterNewFeedsNested(context,activity,list);
        holder.recyclerView.setAdapter(myAdapterNewFeedsNested);
        holder.recyclerView.setHasFixedSize(true);

    }





    @Override
    public int getItemCount() {
        return newFeedModels.size();
    }



    class MyViewHolderNewFeed extends RecyclerView.ViewHolder{
         RecyclerView recyclerView;
         TextView textView;

        public MyViewHolderNewFeed(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv_new_feed_inner_nested);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
