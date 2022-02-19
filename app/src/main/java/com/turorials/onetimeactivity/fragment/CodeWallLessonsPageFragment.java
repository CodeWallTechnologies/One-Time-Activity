package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterNewFeeds;
import com.turorials.onetimeactivity.model.HorizontalNavigationItemModel;
import com.turorials.onetimeactivity.model.ImageModel;
import com.turorials.onetimeactivity.model.NewFeedModel;

import java.util.ArrayList;
import java.util.List;

public class CodeWallLessonsPageFragment extends Fragment {

    private RecyclerView rvHorizontal,rvNewFeed;
    MyAdapterNewFeeds myAdapterNewFeeds;
    ArrayList<HorizontalNavigationItemModel> obj = new ArrayList<>();
    ArrayList<NewFeedModel> arrayList = new ArrayList<>();
    private  View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_page_fragment,container,false);



        ImageModel html1 = new ImageModel(R.drawable.html1);
        ImageModel html2 = new ImageModel(R.drawable.html2);
        ImageModel html3 = new ImageModel(R.drawable.html3);
        ImageModel html4 = new ImageModel(R.drawable.html4);
        ImageModel html5 = new ImageModel(R.drawable.html5);
        ImageModel html6 = new ImageModel(R.drawable.html6);
        ImageModel html7 = new ImageModel(R.drawable.html7);
        ImageModel html8 = new ImageModel(R.drawable.html8);
        ImageModel html9 = new ImageModel(R.drawable.html9);
        ImageModel html10 = new ImageModel(R.drawable.html10);
        ImageModel html11 = new ImageModel(R.drawable.html11);
        ImageModel html12 = new ImageModel(R.drawable.html12);



        List<ImageModel> imageModelList =new ArrayList<>();
        imageModelList.add(html1);
        imageModelList.add(html2);
        imageModelList.add(html3);
        imageModelList.add(html4);
        imageModelList.add(html5);
        imageModelList.add(html6);
        imageModelList.add(html7);
        imageModelList.add(html8);
        imageModelList.add(html9);
        imageModelList.add(html10);
        imageModelList.add(html11);
        imageModelList.add(html12);


        ImageModel java1 = new ImageModel(R.drawable.java1);
        ImageModel java2 = new ImageModel(R.drawable.java2);
        ImageModel java3 = new ImageModel(R.drawable.java3);
        ImageModel java4 = new ImageModel(R.drawable.java4);
        ImageModel java5 = new ImageModel(R.drawable.java5);
        ImageModel java6 = new ImageModel(R.drawable.java6);
        ImageModel java7 = new ImageModel(R.drawable.java7);
        ImageModel java8 = new ImageModel(R.drawable.java9);
        ImageModel java9 = new ImageModel(R.drawable.java8);



        List<ImageModel> imageModelList1 =new ArrayList<>();
        imageModelList1.add(java1);
        imageModelList1.add(java2);
        imageModelList1.add(java3);
        imageModelList1.add(java4);
        imageModelList1.add(java5);
        imageModelList1.add(java6);
        imageModelList1.add(java7);
        imageModelList1.add(java8);
        imageModelList1.add(java9);

        ImageModel webLesson1 = new ImageModel(R.drawable.weblesson1);
        ImageModel webLesson2 = new ImageModel(R.drawable.weblesson2);
        ImageModel webLesson3 = new ImageModel(R.drawable.weblesson3);
        ImageModel webLesson4 = new ImageModel(R.drawable.weblesson4);
        ImageModel webLesson5 = new ImageModel(R.drawable.weblesson5);
        ImageModel webLesson6 = new ImageModel(R.drawable.weblesson6);
        ImageModel webLesson7 = new ImageModel(R.drawable.weblesson7);
        ImageModel webLesson8 = new ImageModel(R.drawable.weblesson8);
        ImageModel webLesson9 = new ImageModel(R.drawable.weblesson9);



        List<ImageModel> imageModelList2 =new ArrayList<>();
        imageModelList2.add(webLesson1);
        imageModelList2.add(webLesson2);
        imageModelList2.add(webLesson3);
        imageModelList2.add(webLesson4);
        imageModelList2.add(webLesson5);
        imageModelList2.add(webLesson6);
        imageModelList2.add(webLesson7);
        imageModelList2.add(webLesson8);
        imageModelList2.add(webLesson9);





        NewFeedModel html_lessons = new NewFeedModel("Html Lessons (Completed)",imageModelList);
        NewFeedModel java_basic_lessons = new NewFeedModel("Java Basic Lessons",imageModelList1);
        NewFeedModel web_lessons = new NewFeedModel("Web Design Basic Old Lessons (2019)",imageModelList2);



        arrayList.add(web_lessons);
        arrayList.add(html_lessons);
        arrayList.add(java_basic_lessons);





        LinearLayoutManager linearLayoutManagerNewFeed = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,true);
        rvNewFeed = view.findViewById(R.id.rv_new_feed);
        rvNewFeed.setLayoutManager(linearLayoutManagerNewFeed);
        myAdapterNewFeeds = new MyAdapterNewFeeds(getContext(),arrayList,getActivity());
        rvNewFeed.setAdapter(myAdapterNewFeeds);
        rvNewFeed.setHasFixedSize(true);

        return view;
    }



//    private void getData() {
//
//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Please wait..");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonkeeper.com/")
//                // on below line we are calling add Converter
//                // factory as GSON converter factory.
//                .addConverterFactory(ScalarsConverterFactory.create())
//                // at last we are building our retrofit builder.
//                .build();
//        // below line is to create an instance for our retrofit api class.
//        ApiInterface retrofitAPI = retrofit.create(ApiInterface.class);
//        Call<String> call = retrofitAPI.STRING_CALL();
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful() ) {
//                    progressDialog.dismiss();
//                    Toast.makeText(getApplicationContext(), "json data", Toast.LENGTH_SHORT).show();
//                    try {
//                        JSONArray jsonArray = new JSONArray(response.body());
//
//                        parseArray(jsonArray);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Fail to get the data..", Toast.LENGTH_SHORT).show();
//            }
//
//
//
//
//        });
//    }

//    private void parseArray(JSONArray jsonArray) {
//        arrayList.clear();
//        for(int i= 0;i<jsonArray.length();i++){
//            try {
//                JSONObject jsonObject  = jsonArray.getJSONObject(i);
////                NewFeedModel data = new NewFeedModel();
////                DailyBlogsModel data =  new DailyBlogsModel();
////                data.setImage(jsonObject.getString("download_url"));
////                data.setName(jsonObject.getString("author"));
////                data.setId(jsonObject.getString("id"));
////                arrayList.add(data);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            myAdapterNewFeeds = new MyAdapterNewFeeds(this,arrayList,this);
//            rvNewFeed.setAdapter(myAdapterNewFeeds);
//
//
//        }
//    }

//
}