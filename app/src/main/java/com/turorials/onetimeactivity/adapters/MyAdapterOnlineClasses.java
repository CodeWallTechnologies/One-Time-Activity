package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.OnlineClassModel;

import java.util.List;

public class MyAdapterOnlineClasses extends RecyclerView.Adapter<MyAdapterOnlineClasses.MyViewHolderOnlineClasses> {

    Context context;
    List<OnlineClassModel> list;

    public MyAdapterOnlineClasses(Context context, List<OnlineClassModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderOnlineClasses onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.online_classes_items,parent,false);
        MyViewHolderOnlineClasses myViewHolderOnlineClasses = new MyViewHolderOnlineClasses(view);
        return myViewHolderOnlineClasses;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderOnlineClasses holder, int position) {
//        holder.imageView.setImageResource(list.get(position).getImgOnlineClass());

        Glide
                .with(context)
                .load(list.get(position).getImgOnlineClass())
                .placeholder(R.drawable.background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolderOnlineClasses extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyViewHolderOnlineClasses(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_online_classes);
        }
    }
}
