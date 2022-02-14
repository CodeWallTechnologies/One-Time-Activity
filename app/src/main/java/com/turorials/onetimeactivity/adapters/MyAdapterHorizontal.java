package com.turorials.onetimeactivity.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.turorials.onetimeactivity.AboutAsActivity;
import com.turorials.onetimeactivity.First;
import com.turorials.onetimeactivity.Logout;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.Second;
import com.turorials.onetimeactivity.ShortCutActivity;
import com.turorials.onetimeactivity.WebsiteActivity;
import com.turorials.onetimeactivity.model.HorizontalNavigationItemModel;

import java.util.ArrayList;


public class MyAdapterHorizontal extends RecyclerView.Adapter<MyAdapterHorizontal.MyViewHolderHorizontal> {

    Context context;
    ArrayList<HorizontalNavigationItemModel> arrayList;

    public MyAdapterHorizontal(Context context, ArrayList<HorizontalNavigationItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolderHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context3 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context3);
        View view = layoutInflater.inflate(R.layout.horizontal_navigation_itmes,parent,false);
        MyViewHolderHorizontal myViewHolderHtml = new MyViewHolderHorizontal(view);


        return myViewHolderHtml;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolderHorizontal holder, @SuppressLint("RecyclerView") int position) {
            HorizontalNavigationItemModel currentItemPosition = arrayList.get(position);
            holder.textView.setText(currentItemPosition.getName());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                  switch (position){
                      case 1:
                          intent = new Intent(context, Second.class);
                          break;
                      case 2:
                          intent = new Intent(context, ShortCutActivity.class);
                          break;
                      case 3:
                          intent = new Intent(context, WebsiteActivity.class);
                          break;
                      case 5:
                          intent = new Intent(context, AboutAsActivity.class);
                          break;
                      case 6:
                          intent = new Intent(context,Logout.class);
                          break;
                      default:
                          intent = new Intent(context,First.class);
                  }
                  context.startActivity(intent);

                }
            });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolderHorizontal extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolderHorizontal(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_nav_items);
        }
    }
}
