package com.turorials.onetimeactivity.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.MyAdapterOurBlogs;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterDailyBlogs;
import com.turorials.onetimeactivity.adapters.MyAdapterOnlineClasses;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.interfaces.ApiSecondInterface;
import com.turorials.onetimeactivity.interfaces.ApiThirdInterface;
import com.turorials.onetimeactivity.model.DailyBlogsModel;
import com.turorials.onetimeactivity.model.OurBlogsModel;

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


public class OurBlogFragment extends Fragment {

    RecyclerView recyclerView;
    View view;
    List<OurBlogsModel> list = new ArrayList<>();


    public OurBlogFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_our_blog, container, false);


         OurBlogsModel ourBlogsModel = new OurBlogsModel();
         ourBlogsModel.setBlog_url("");
         ourBlogsModel.setUpload_time("3 hours ago");
         ourBlogsModel.setFirst_line_text("This is blah blah");
         ourBlogsModel.setTitle("Ok");
         ourBlogsModel.setImage_url("Ok");
         list.add(new OurBlogsModel());

        recyclerView = view.findViewById(R.id.rv_our_blog);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapterOurBlogs myAdapterOurBlogs = new MyAdapterOurBlogs(view.getContext(),list);
        recyclerView.setAdapter(myAdapterOurBlogs);
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
        ApiThirdInterface retrofitAPI = retrofit.create(ApiThirdInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL4();
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
                OurBlogsModel data =  new OurBlogsModel();

                data.setImage_url(jsonObject.getString("image_url"));
                data.setTitle(jsonObject.getString("title"));
                data.setFirst_line_text(jsonObject.getString("first_line"));
                data.setBlog_url(jsonObject.getString("blog_url"));
                data.setUpload_time(jsonObject.getString("time"));

                list.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterOurBlogs myAdapterOurBlogs = new MyAdapterOurBlogs(view.getContext(),list);
            recyclerView.setAdapter(myAdapterOurBlogs);


        }
    }
}