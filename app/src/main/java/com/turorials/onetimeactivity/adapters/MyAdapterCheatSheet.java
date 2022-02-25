package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.ShortCutImagesActivity;
import com.turorials.onetimeactivity.model.ShortCutModel;
import java.util.List;

public class MyAdapterCheatSheet extends RecyclerView.Adapter<MyAdapterCheatSheet.MyViewHolderShortCut> {

    List<ShortCutModel> arrayList;
    Context context;
    ShortCutImagesActivity shortCutImagesActivity;
    public MyAdapterCheatSheet(List<ShortCutModel> arrayList, Context context) {
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

        Glide
                .with(context)
                .load(arrayList.get(position).getImage_url())
                .placeholder(R.drawable.background)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShortCutImagesActivity.class);
            String arrayAsString = new Gson().toJson(positionObj.getChildImagesModelList()   );
            intent.putExtra("images",arrayAsString);

//
            Log.d("Images", arrayAsString+"");
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

        public MyViewHolderShortCut(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_short_cut_title);
            imageView = itemView.findViewById(R.id.img_short_cut);

        }
    }
}
