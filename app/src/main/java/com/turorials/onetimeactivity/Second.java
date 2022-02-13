package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.turorials.onetimeactivity.adapters.MyAdapter;
import com.turorials.onetimeactivity.adapters.MyAdapterHtml;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.model.Model3;

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

public class Second extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapterHtml myAdapterHtml;
    List<Model3> model3s = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setTitle("Testing");

        recyclerView  = findViewById(R.id.rv_two);



        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager1);
        myAdapterHtml = new MyAdapterHtml(this,  model3s, this);
        recyclerView.setAdapter(myAdapterHtml);
        recyclerView.setHasFixedSize(true);


       getData();

    }

    private void getData() {

        ProgressDialog progressDialog = new ProgressDialog(this);
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
        ApiInterface retrofitAPI = retrofit.create(ApiInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String>response) {
                if (response.isSuccessful() ) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "json data", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Second.this, ""+t, Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void parseArray(JSONArray jsonArray) {
        model3s.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                Model3 data =  new Model3();
                data.setImage(jsonObject.getString("image_url"));
                data.setName(jsonObject.getString("title"));
                model3s.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterHtml myAdapterHtml = new MyAdapterHtml(this,model3s,this);
            recyclerView.setAdapter(myAdapterHtml);


        }
    }
}

