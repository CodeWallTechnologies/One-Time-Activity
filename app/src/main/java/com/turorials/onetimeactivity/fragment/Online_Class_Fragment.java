package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterOnlineClasses;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.interfaces.ApiSecondInterface;
import com.turorials.onetimeactivity.model.DailyBlogsModel;
import com.turorials.onetimeactivity.model.OnlineClassModel;

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

public class Online_Class_Fragment extends Fragment {

    RecyclerView recyclerView ;
    List<OnlineClassModel> list = new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.activity_online_class,container,false);
//        OnlineClassModel onlineClass1 = new OnlineClassModel();
//        onlineClass1.setImgOnlineClass(R.drawable.java_classes);
//
//        OnlineClassModel onlineClass2 = new OnlineClassModel();
//        onlineClass2.setImgOnlineClass(R.drawable.android_classes);



//        List<OnlineClassModel> list = new ArrayList<>();
//        list.add(onlineClass1);
//        list.add(onlineClass2);

        recyclerView = view.findViewById(R.id.rv_online_classes);
        MyAdapterOnlineClasses myAdapterOnlineClasses = new MyAdapterOnlineClasses(view.getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapterOnlineClasses);
        recyclerView.setHasFixedSize(true);

        getData();
        return view;
    }

    public void getData() {

        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        progressDialog.setMessage("Please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();



        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://codewalltechnologies.com/")
                // on below line we are calling add Converter
                // factory as GSON converter factory.
                .addConverterFactory(ScalarsConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        ApiSecondInterface retrofitAPI = retrofit.create(ApiSecondInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL3();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() ) {
                    progressDialog.dismiss();
                    Toast.makeText(view.getContext(), "json data", Toast.LENGTH_SHORT).show();
                    try {
                        JSONArray jsonArray = new JSONArray(response.body());

                        parseArray(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            //http://codewalltechnologies.com/

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                // Toast.makeText(DailyBlogFragment.this, ""+t, Toast.LENGTH_SHORT).show();
            }

        });
    }



    private void parseArray(JSONArray jsonArray) {
        list.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
               OnlineClassModel data = new OnlineClassModel();

                data.setImgOnlineClass(jsonObject.getString("image_url"));
                data.setCourseDetails(jsonObject.getString("course_url"));
//                data.setImage(jsonObject.getString("image_url"));
//                data.setName(jsonObject.getString("title"));
//                data.setBlog_url(jsonObject.getString("blog_url"));
//                data.setTime(jsonObject.getString("time"));
                list.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterOnlineClasses myAdapterOnlineClasses = new MyAdapterOnlineClasses(view.getContext(), list);
            recyclerView.setAdapter(myAdapterOnlineClasses);


        }
    }

}