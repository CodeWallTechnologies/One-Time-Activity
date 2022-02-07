package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.R;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {



    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.post_items,parent,false);
        PostViewHolder postViewHolder = new PostViewHolder(view);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
//        Model4 objectPosition = arrayList.get(position);
//        holder.textView.setText(objectPosition.getTitle());
//        holder.textView1.setText(objectPosition.getId());
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class PostViewHolder extends  RecyclerView.ViewHolder{

        TextView textView,textView1;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            textView1 = itemView.findViewById(R.id.tv_trip);
        }
    }
}
