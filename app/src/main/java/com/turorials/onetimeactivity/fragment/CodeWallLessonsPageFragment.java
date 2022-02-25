package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterDailyBlogs;
import com.turorials.onetimeactivity.adapters.MyAdapterNewFeeds;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.interfaces.ApiThirdInterface;
import com.turorials.onetimeactivity.model.DailyBlogsModel;
import com.turorials.onetimeactivity.model.HorizontalNavigationItemModel;
import com.turorials.onetimeactivity.model.ChildLessonModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.grpc.internal.JsonParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CodeWallLessonsPageFragment extends Fragment {

    private RecyclerView rvNewFeed;
    MyAdapterNewFeeds myAdapterNewFeeds;
    List<NewFeedModel> arrayList = new ArrayList<>();
    private  View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_page_fragment,container,false);


        LinearLayoutManager linearLayoutManagerNewFeed = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,true);
        rvNewFeed = view.findViewById(R.id.rv_new_feed);
        rvNewFeed.setLayoutManager(linearLayoutManagerNewFeed);
        myAdapterNewFeeds = new MyAdapterNewFeeds(getContext(),arrayList,getActivity());
        rvNewFeed.setAdapter(myAdapterNewFeeds);
        rvNewFeed.setHasFixedSize(true);

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
        ApiThirdInterface retrofitAPI = retrofit.create(ApiThirdInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL5();
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
        arrayList.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                NewFeedModel data =  new NewFeedModel();
                data.setName(jsonObject.getString("name"));





                JSONArray childList= jsonObject.getJSONArray("list");

                List<ChildLessonModel> newChildList;    newChildList = new ArrayList<>();

                for (int j=0; j<childList.length();j++){
                    JSONObject childObject  = childList.getJSONObject(j);
                    ChildLessonModel childLessonData = new ChildLessonModel();
                    childLessonData.setImage_url(childObject.getString("image_url"));
                    childLessonData.setVideo_url(childObject.getString("video_url"));
                    newChildList.add(childLessonData);
                }

                data.setList(newChildList);


                arrayList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterNewFeeds myAdapterNewFeeds = new MyAdapterNewFeeds(view.getContext(), arrayList,getActivity());
            rvNewFeed.setAdapter(myAdapterNewFeeds);


        }
    }

}