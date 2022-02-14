package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.turorials.onetimeactivity.adapters.MyAdapterWebsites;
import com.turorials.onetimeactivity.model.WebsiteModel;

import java.util.ArrayList;

public class WebsiteActivity extends AppCompatActivity {
    MyAdapterWebsites myAdapterWebsites;
    RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        getSupportActionBar().hide();



       recyclerView1 = findViewById(R.id.rv_three);

        WebsiteModel website1 = new WebsiteModel(R.drawable.html1,"Lorem Picsum",R.drawable.lorempicsum,"https://picsum.photos/");
        WebsiteModel website2 = new WebsiteModel(R.drawable.check_circle,"Laravel.com",R.drawable.laravelwebsite,"https://laravel.com/");
        WebsiteModel website3= new WebsiteModel(R.drawable.check_circle,"Flutter.dev",R.drawable.flutter,"https://flutter.dev/");
        WebsiteModel website4 = new WebsiteModel(R.drawable.check_circle,"Nodejs.org",R.drawable.nodejs,"https://nodejs.org/en/");


        ArrayList<WebsiteModel> arrayList = new ArrayList<>();
        arrayList.add(website1);
        arrayList.add(website2);
        arrayList.add(website3);
        arrayList.add(website4);




        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        myAdapterWebsites = new MyAdapterWebsites(this,arrayList);
        recyclerView1.setAdapter(myAdapterWebsites);
        recyclerView1.setHasFixedSize(true);




    }
}