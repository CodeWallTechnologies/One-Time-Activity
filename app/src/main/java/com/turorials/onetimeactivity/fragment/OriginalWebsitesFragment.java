package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterDailyBlogs;
import com.turorials.onetimeactivity.adapters.MyAdapterWebsites;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.model.DailyBlogsModel;
import com.turorials.onetimeactivity.model.WebsiteModel;

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

public class OriginalWebsitesFragment extends Fragment {
    MyAdapterWebsites myAdapterWebsites;
    RecyclerView recyclerView1;
    private View view;
    List<WebsiteModel> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_websites,container,false);
       recyclerView1 = view.findViewById(R.id.rv_three);

//        WebsiteModel website1 = new WebsiteModel(R.drawable.ic_lorempicsum,"Lorem Picsum",R.drawable.lorempicsum,"https://picsum.photos/");
//        WebsiteModel website2 = new WebsiteModel(R.drawable.laravel,"Laravel.com",R.drawable.laravelwebsite,"https://laravel.com/");
//        WebsiteModel website3= new WebsiteModel(R.drawable.fluttericon,"Flutter.dev",R.drawable.flutter,"https://flutter.dev/");
//        WebsiteModel website4 = new WebsiteModel(R.drawable.ic_nodejs,"Nodejs.org",R.drawable.nodejs,"https://nodejs.org/en/");
//
//
//        ArrayList<WebsiteModel> arrayList = new ArrayList<>();
//        arrayList.add(website1);
//        arrayList.add(website2);
//        arrayList.add(website3);
//        arrayList.add(website4);





        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(linearLayoutManager1);
        myAdapterWebsites = new MyAdapterWebsites(getContext(),arrayList);
        recyclerView1.setAdapter(myAdapterWebsites);
        recyclerView1.setHasFixedSize(true);
          getData();

        return view;


    }


    public void getData() {

//        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
//        progressDialog.setCancelable(false);
//        progressDialog.show();



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
        ApiInterface retrofitAPI = retrofit.create(ApiInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL1();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() ) {
//                    progressDialog.dismiss();
//                    Toast.makeText(view.getContext(), "json data", Toast.LENGTH_SHORT).show();
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
//                progressDialog.dismiss();
                // Toast.makeText(DailyBlogFragment.this, ""+t, Toast.LENGTH_SHORT).show();
            }

        });
    }


    private void parseArray(JSONArray jsonArray) {
        arrayList.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                WebsiteModel data =  new WebsiteModel();

                data.setWebsite_title(jsonObject.getString("title"));
                data.setWebsite_logo(jsonObject.getString("logo_url"));
                data.setWebsite_main_image(jsonObject.getString("image_url"));
                data.setWebsite_link(jsonObject.getString("website_url"));


//                data.setImage(jsonObject.getString("image_url"));
//                data.setName(jsonObject.getString("title"));
//                data.setBlog_url(jsonObject.getString("blog_url"));
//                data.setTime(jsonObject.getString("time"));
               arrayList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterWebsites myAdapterDailyBlogs = new MyAdapterWebsites(view.getContext(), arrayList);
            recyclerView1.setAdapter(myAdapterDailyBlogs);


        }
    }



}