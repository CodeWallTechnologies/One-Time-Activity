package com.turorials.onetimeactivity.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.BlogViewActivity;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.DailyBlogsModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyAdapterDailyBlogs extends RecyclerView.Adapter<MyAdapterDailyBlogs.MyViewHolderHtml>  {

    Context context2;
    List<DailyBlogsModel> arrayList;




    public MyAdapterDailyBlogs(Context context2, List<DailyBlogsModel> arrayList) {
        this.context2 = context2;
        this.arrayList = arrayList;


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    @NonNull
    @Override
    public MyViewHolderHtml onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context3 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context3);
        View view = layoutInflater.inflate(R.layout.html_itmes,parent,false);



        return new MyViewHolderHtml(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderHtml holder, @SuppressLint("RecyclerView") int position) {

        DailyBlogsModel currentObject = arrayList.get(position);

        holder.textView.setText(arrayList.get(position).getName());
        holder.time.setText(currentObject.getTime());
                   Glide
                .with(context2)
                .load(arrayList.get(position).getImage())
                .placeholder(R.drawable.background)
                .into(holder.imageView);

                   holder.imageView.setOnClickListener(v -> {
                       Intent intent = new Intent(context2, BlogViewActivity.class);
                       intent.putExtra("blog_url",currentObject.getBlog_url());
                       context2.startActivity(intent);
                   });

    }



    class  MyViewHolderHtml extends RecyclerView.ViewHolder{
        TextView textView,time;
        ImageView imageView;


        public MyViewHolderHtml(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.website_title);
            imageView = itemView.findViewById(R.id.imageView12);
            time = itemView.findViewById(R.id.post_update_time);

        }
    }
}
