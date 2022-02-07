package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import com.turorials.onetimeactivity.adapters.PostAdapter;
import com.turorials.onetimeactivity.interfaces.ApiInterface;
import com.turorials.onetimeactivity.model.Model3;
import com.turorials.onetimeactivity.model.Model4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Fourth extends AppCompatActivity {

    EditText etName,etTrip;
    Button btnSubmit;
    RecyclerView rv_post;
    ArrayList<Model4> model4ArrayList;


    String sBaseUrl ="https://api.instantwebtools.net/v1/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getSupportActionBar().setTitle("Fourth");




        etName = findViewById(R.id.et_enterName);
        etTrip = findViewById(R.id.et_enterTotalTrips);
        btnSubmit = findViewById(R.id.btn_submit);
        rv_post = findViewById(R.id.rv_post);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Fourth.this,2);
                        rv_post.setLayoutManager(gridLayoutManager);
//                        PostAdapter postAdapter = new PostAdapter(model4ArrayList);
//                        rv_post.setAdapter(postAdapter);
//                        rv_post.setHasFixedSize(true);

//                        getData();

//        getPassenger();


    }


    //ApiInterface
    private interface getInter{
        @GET("passenger")
        Call<String> STRING_CALL(
              @Query("page") String page,
              @Query("size")  String size
        );
    }
    //Api method
    private void getPassenger(){
        //Initialize progress Dialog
        ProgressDialog progressDialog = ProgressDialog.show(Fourth.this,"","Please wait",true);
        //Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(sBaseUrl)
                .build();

        //Initialize interface
        getInter inter = retrofit.create(getInter.class);
        //Pass input values
        Call<String> call = inter.STRING_CALL("756","25");
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if(response.isSuccessful() && response.body()!= null){
//                    progressDialog.dismiss();
//                    try {
//                        JSONObject jsonObject = new JSONObject(response.body());
//                        JSONArray jsonArray = jsonObject.getJSONArray("data");
//                        GridLayoutManager gridLayoutManager = new GridLayoutManager(Fourth.this,2);
//                        rv_post.setLayoutManager(gridLayoutManager);
//                        PostAdapter postAdapter = new PostAdapter();
//                        rv_post.setAdapter(postAdapter);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });

    }


    private void getData() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
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

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Fourth.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }




        });
    }

    private void parseArray(JSONArray jsonArray) {
        model4ArrayList.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
//               Model4 model42 = new Model4("Thura Linn","1");
//               Model4 model41 = new Model4("Ok","2");
//
//               ArrayList<Model4> obj = new ArrayList<>();
//               obj.add(model41);
//               obj.add(model42);


//               model4.setTitle(jsonObject.getString("name"));
//               model4.setId(String.valueOf(jsonObject.getInt("id")));

//                data.setImage(jsonObject.getString("title"));
//                data.setName(jsonObject.getString("id"));
//                model4ArrayList.add(model4);
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            PostAdapter postAdapter = new PostAdapter(model4ArrayList);
//            rv_post.setAdapter(postAdapter);


        }
    }
}