package com.turorials.onetimeactivity.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.Model3;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterHtml extends RecyclerView.Adapter<MyAdapterHtml.MyViewHolderHtml> {

    Context context2;
    List<Model3> arrayList;
    Activity activity;


    public MyAdapterHtml(Context context2, List<Model3> arrayList,Activity activity1) {
        this.context2 = context2;
        this.arrayList = arrayList;
        this.activity = activity1;
    }

    @NonNull
    @Override
    public MyViewHolderHtml onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context3 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context3);
        View view = layoutInflater.inflate(R.layout.html_itmes,parent,false);
        MyViewHolderHtml myViewHolderHtml = new MyViewHolderHtml(view);


        return myViewHolderHtml;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderHtml holder, int position) {


        holder.textView.setText(arrayList.get(position).getName());
                   Glide
                .with(activity)
                .load(arrayList.get(position).getImage())
                .centerCrop()
                .placeholder(R.drawable.background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  MyViewHolderHtml extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public MyViewHolderHtml(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView12);

        }
    }
}
