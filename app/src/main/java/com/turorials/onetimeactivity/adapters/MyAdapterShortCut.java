package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.ShortCutImagesActivity;
import com.turorials.onetimeactivity.model.ShortCutModel;

import java.util.ArrayList;

public class MyAdapterShortCut extends RecyclerView.Adapter<MyAdapterShortCut.MyViewHolderShortCut> {

    ArrayList<ShortCutModel> arrayList;
    Context context;

    public MyAdapterShortCut(ArrayList<ShortCutModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderShortCut onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.short_cut_items,parent,false);
        MyViewHolderShortCut myViewHolderShortCut = new MyViewHolderShortCut(view);
        return myViewHolderShortCut;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderShortCut holder, int position) {
        ShortCutModel positionObj = arrayList.get(position);
        holder.textView.setText(positionObj.getTitle());
        holder.imageView.setImageResource(positionObj.getImgResource());
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShortCutImagesActivity.class);
            intent.putExtra("image",positionObj.getImg());
           context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolderShortCut extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
//        Button btn_view_images;

        public MyViewHolderShortCut(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_short_cut_title);
            imageView = itemView.findViewById(R.id.img_short_cut);
//            btn_view_images = itemView.findViewById(R.id.btn_view_images);

        }
    }
}
