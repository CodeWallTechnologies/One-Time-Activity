package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.turorials.onetimeactivity.adapters.MyAdapterNewFeeds;
import com.turorials.onetimeactivity.adapters.MyAdapterShortCut;
import com.turorials.onetimeactivity.model.ShortCutModel;

import java.util.ArrayList;

public class ShortCut extends AppCompatActivity {

    RecyclerView rv_short_cut;
    MyAdapterShortCut myAdapterShortCut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut);

        rv_short_cut = findViewById(R.id.rv_short_cut);


        ShortCutModel shortCutModel1 = new ShortCutModel("Javascript project ideas for Beginners",R.drawable.javascriptprojectidea);
        ShortCutModel shortCutModel2 = new ShortCutModel("Responsive Design CSS tips",R.drawable.responsivedesigncsstips);
        ShortCutModel shortCutModel3 = new ShortCutModel("PYTHON INTERVIEW QUESTIONS PART 1",R.drawable.pythoninterviewquesionspartone);
        ShortCutModel shortCutModel4 = new ShortCutModel("React JS",R.drawable.weblesson9);
        ShortCutModel shortCutModel5 = new ShortCutModel("React JS",R.drawable.weblesson9);

        ArrayList<ShortCutModel> shortCutModelArrayList = new ArrayList<>();
        shortCutModelArrayList.add(shortCutModel1);
        shortCutModelArrayList.add(shortCutModel2);
        shortCutModelArrayList.add(shortCutModel3);
        shortCutModelArrayList.add(shortCutModel4);
        shortCutModelArrayList.add(shortCutModel5);

        LinearLayoutManager linearLayoutManagerNewFeed = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv_short_cut.setLayoutManager(linearLayoutManagerNewFeed);
        myAdapterShortCut = new MyAdapterShortCut(shortCutModelArrayList);
        rv_short_cut.setAdapter(myAdapterShortCut);
        rv_short_cut.setHasFixedSize(true);

    }
}