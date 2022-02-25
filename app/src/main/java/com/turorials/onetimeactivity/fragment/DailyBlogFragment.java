package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterDailyBlogs;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.model.DailyBlogsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DailyBlogFragment extends Fragment {

    RecyclerView recyclerView;
    MyAdapterDailyBlogs myAdapterDailyBlogs;
    List<DailyBlogsModel> dailyBlogsModels = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_daily_blog,container,false);


        recyclerView = view.findViewById(R.id.rv_two);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            getData();
            myAdapterDailyBlogs.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);
        });

        StaggeredGridLayoutManager linearLayoutManager1 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager1.setReverseLayout(true);
        //       GridLayoutManager linearLayoutManager1 = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,true);
        recyclerView.setLayoutManager(linearLayoutManager1);
        myAdapterDailyBlogs = new MyAdapterDailyBlogs(view.getContext(), dailyBlogsModels );
        recyclerView.setAdapter(myAdapterDailyBlogs);
        recyclerView.setHasFixedSize(true);


       getData();

        return view;
    }




    private void getData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://codewalltechnologies.com/")
                // on below line we are calling add Converter
                // factory as GSON converter factory.
                .addConverterFactory(ScalarsConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        ApiInterface retrofitAPI = retrofit.create(ApiInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() ) {


                    try {
                        JSONArray jsonArray = new JSONArray(response.body());

                        parseArray(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }



            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

        });
    }



    private void parseArray(JSONArray jsonArray) {
        dailyBlogsModels.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                DailyBlogsModel data =  new DailyBlogsModel();
                data.setImage(jsonObject.getString("image_url"));
                data.setName(jsonObject.getString("title"));
                data.setBlog_url(jsonObject.getString("blog_url"));
                data.setTime(jsonObject.getString("time"));
                dailyBlogsModels.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterDailyBlogs myAdapterDailyBlogs = new MyAdapterDailyBlogs(view.getContext(), dailyBlogsModels);
            recyclerView.setAdapter(myAdapterDailyBlogs);


        }
    }




}

