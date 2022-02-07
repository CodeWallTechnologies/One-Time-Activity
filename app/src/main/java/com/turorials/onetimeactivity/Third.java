package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.turorials.onetimeactivity.adapters.MyAdapter;
import com.turorials.onetimeactivity.adapters.MyAdapter1;
import com.turorials.onetimeactivity.model.Model1;
import com.turorials.onetimeactivity.model.Model2;

import java.util.ArrayList;

public class Third extends AppCompatActivity {
    MyAdapter myAdapter;
    MyAdapter1 myAdapter1;
    RecyclerView recyclerView,recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


       recyclerView = findViewById(R.id.rv_one);
       recyclerView1 = findViewById(R.id.rv_three);



        Model1 model1 = new Model1("you");
        Model1 model2 = new Model1("html");
        Model1 model3 = new Model1("css");
        Model1 model4 = new Model1("javaScript");
        Model1 model5 = new Model1("jQuery");
        Model1 model6 = new Model1("");
        Model1 model7 = new Model1("");
        Model1 model8 = new Model1("about as");
        Model1 model9 = new Model1("log out");


        Model2 model21 = new Model2("Lesson 1 \n Introduction");
        Model2 model22 = new Model2("Lesson 2 \n User Setting & blah");
        Model2 model23 = new Model2("Lesson 3 \n I love you");
        Model2 model24 = new Model2("Lesson 4 \n Wat da fck");
        Model2 model25 = new Model2("");
        Model2 model26 = new Model2("Lesson 5 \n Introduction");
        Model2 model27 = new Model2("");
        Model2 model28 = new Model2("Lesson 7 \n Wow ");
        Model2 model29 = new Model2("Lesson 8 \n OuO");


        ArrayList<Model1> arrayList = new ArrayList<>();
        arrayList.add(model1);
        arrayList.add(model2);
        arrayList.add(model3);
        arrayList.add(model4);
        arrayList.add(model5);
        arrayList.add(model6);
        arrayList.add(model7);
        arrayList.add(model8);
        arrayList.add(model9);

        ArrayList<Model2> arrayList1 = new ArrayList<>();
        arrayList1.add(model21);
        arrayList1.add(model22);
        arrayList1.add(model23);
        arrayList1.add(model24);
        arrayList1.add(model25);
        arrayList1.add(model26);
        arrayList1.add(model27);
        arrayList1.add(model28);
        arrayList1.add(model29);




            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
            recyclerView.setLayoutManager(linearLayoutManager);
            myAdapter = new MyAdapter(this, arrayList);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        myAdapter1 = new MyAdapter1(this,arrayList1);
        recyclerView1.setAdapter(myAdapter1);
        recyclerView1.setHasFixedSize(true);




    }
}