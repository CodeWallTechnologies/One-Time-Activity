package com.turorials.onetimeactivity.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterNewFeeds;
import com.turorials.onetimeactivity.model.ImageModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import java.util.ArrayList;
import java.util.List;


public class NewFeedFragment extends Fragment {

     RecyclerView rvNewFeed;
    MyAdapterNewFeeds myAdapterNewFeeds;
    ArrayList<NewFeedModel> arrayList = new ArrayList<>();

    Context context;
    Activity activity;

    public NewFeedFragment(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_feed, container, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}