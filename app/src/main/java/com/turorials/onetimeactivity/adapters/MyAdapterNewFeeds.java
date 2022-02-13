package com.turorials.onetimeactivity.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.interfaces.MainInterface;
import com.turorials.onetimeactivity.model.ImageModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MyAdapterNewFeeds extends RecyclerView.Adapter<MyAdapterNewFeeds.MyViewHolderNewFeed> {

    Context context;
    MyAdapterNewFeedsNested myAdapterNewFeedsNested;
    ArrayList<NewFeedModel> newFeedModels;
    Activity activity;

    NewFeedModel obj;






    public MyAdapterNewFeeds(Context context, ArrayList<NewFeedModel> newFeedModels, Activity activity) {
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
        myAdapterNewFeedsNested = new MyAdapterNewFeedsNested(context,newFeedModels,activity,newFeedModels.get(position).getList());
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
