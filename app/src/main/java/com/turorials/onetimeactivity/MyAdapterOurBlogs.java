package com.turorials.onetimeactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.model.OurBlogsModel;

import java.util.List;

public class MyAdapterOurBlogs extends RecyclerView.Adapter<MyAdapterOurBlogs.MyViewHolderOurBlogs> {
    Context context;
    List<OurBlogsModel> list;
    public MyAdapterOurBlogs(Context context, List<OurBlogsModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolderOurBlogs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.our_blog_items,parent,false);
        MyViewHolderOurBlogs myViewHolderOurBlogs = new MyViewHolderOurBlogs(view);
        return myViewHolderOurBlogs;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderOurBlogs holder, int position) {
         OurBlogsModel currentObject = list.get(position);
        holder.tv_upload_time.setText(currentObject.getUpload_time());
        holder.tv_title.setText(currentObject.getTitle());
        holder.tv_first_line.setText(currentObject.getFirst_line_text());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolderOurBlogs extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_title,tv_first_line,tv_upload_time;
        public MyViewHolderOurBlogs(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_our_blogs);
            tv_title = itemView.findViewById(R.id.our_blog_title);
            tv_first_line = itemView.findViewById(R.id.our_blog_first_line);
            tv_upload_time = itemView.findViewById(R.id.our_blog_time);
        }
    }
}
