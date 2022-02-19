package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.WebsiteMainPageActivity;
import com.turorials.onetimeactivity.model.WebsiteModel;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterWebsites extends RecyclerView.Adapter<MyAdapterWebsites.MyViewHolder1> {



    Context context;
    List<WebsiteModel> arrayList;

    public MyAdapterWebsites(Context context, List<WebsiteModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        View view = LayoutInflater.from(context1).inflate(R.layout.website_items,parent,false);
         MyViewHolder1 myViewHolder = new MyViewHolder1(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        WebsiteModel currentObj = arrayList.get(position);
//        holder.logo.setImageResource(currentObj.getWebsite_logo());
        holder.title.setText(currentObj.getWebsite_title());
//        holder.main_image.setImageResource(currentObj.getWebsite_main_image());
        Glide
                .with(context)
                .load(arrayList.get(position).getWebsite_main_image())
                .placeholder(R.drawable.background)
                .into(holder.main_image);

        Glide
                .with(context)
                .load(arrayList.get(position).getWebsite_logo())
                .placeholder(R.drawable.background)
                .into(holder.logo);
        holder.main_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebsiteMainPageActivity.class);
                intent.putExtra("web",currentObj.getWebsite_link());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
      ImageView logo,main_image;
      TextView title;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.website_logo);
            main_image = itemView.findViewById(R.id.website_main_image);
            title = itemView.findViewById(R.id.website_title);
        }
    }
}
